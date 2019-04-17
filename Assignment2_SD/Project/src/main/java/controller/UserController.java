package controller;

import model.Drug;
import view.IUserGUI;

import javax.swing.table.DefaultTableModel;
import java.util.List;

public class UserController {

    private final IUserGUI userView;
    private final IUserProvider userProvider;
    public UserController(IUserGUI userView){
        this.userView = userView;
        this.userProvider = new UserProvider();
    }

    public void buy(){
        String ammount = userView.getAmmount();
        if(!(ammount.equals("")) && ammount.matches("[+-]?[0-9]+") && ammount.charAt(0) != '0'){
            int flag = userProvider.buy(userView.getLog(),(Long)userView.getRowAt(0),Integer.parseInt(ammount));
            if(flag == 2){
                userView.showErrorMessage("Error: Not enough stock!");
            }else if(flag == 1){
                userView.showErrorMessage("Error: Not enough funds!");
            }else{
                userView.showErrorMessage("Notice: Transaction successful!");
                userProvider.report(userView.getLog(),(String)userView.getRowAt(1),Integer.parseInt(ammount));
            }
        }else{
            userView.showErrorMessage("Error: Invalid input!");
        }
        userView.setAmount("");
        updateTable();
    }

    public void logout(){
        //still does nothing
    }

    public void search(){
        String selectedItem = (String) userView.getSearch();
        String item = userView.getSearchField();
        List<Drug> drugs = userProvider.getDRUGS();
        DefaultTableModel model = userView.getView();
        model.setRowCount(0);
        for(Drug drug : drugs){
            switch(selectedItem){
                case "ID":
                    if (item.equals("") ||item.matches("[0-9]+") && item.charAt(0) != '0') {
                        if (item.equals("") || Long.parseLong(item) == drug.getId()){
                            model.addRow(new Object[]{drug.getId(), drug.getName(), drug.getType(),drug.getPrice(), drug.getStock()});
                        }
                    }else{
                        userView.showErrorMessage("Error: Invalid input!");
                        return;
                    }

                    break;
                case "NAME":
                    if (item.equals("") || item.equals(drug.getName())){
                        model.addRow(new Object[]{drug.getId(), drug.getName(), drug.getType(),drug.getPrice(), drug.getStock()});
                    }
                    break;
                case "TYPE":
                    if (item.equals("") || item.equals(drug.getType())){
                        model.addRow(new Object[]{drug.getId(), drug.getName(), drug.getType(),drug.getPrice(), drug.getStock()});
                    }
                    break;
                case "PRICE":
                    if(item.equals("") ||item.matches("[0-9]*\\.?[0-9]+")){
                        if (item.equals("") || Float.parseFloat(item) >= drug.getPrice()){
                            model.addRow(new Object[]{drug.getId(), drug.getName(), drug.getType(),drug.getPrice(), drug.getStock()});
                        }
                    }else{
                        userView.showErrorMessage("Error: Invalid input!");
                        return;
                    }
                    break;
                case "STOCK":
                    if(item.equals("") ||item.matches("[0-9]+") && item.charAt(0) != '0'){
                        if (item.equals("") || Integer.parseInt(item) <= drug.getStock()){
                            model.addRow(new Object[]{drug.getId(), drug.getName(), drug.getType(),drug.getPrice(), drug.getStock()});
                        }
                    }else{
                        userView.showErrorMessage("Error: Invalid input!");
                        return;
                    }
                    break;
            }
        }

    }

    public void updateTable(){
        DefaultTableModel model = userView.getView();
        model.setRowCount(0);
        List<Drug> drugs = userProvider.getDRUGS();
        for(Drug drug : drugs){
            model.addRow(new Object[]{drug.getId(), drug.getName(), drug.getType(),drug.getPrice(), drug.getStock()});
        }
    }
}
