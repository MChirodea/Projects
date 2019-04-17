package controller;
import com.itextpdf.text.DocumentException;
import creator.FileFactory;
import creator.PDFCreator;
import creator.TXTCreator;
import model.Drug;
import model.User;
import view.IAdminGUI;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class AdminController {
    private final IAdminGUI adminView;
    private final IAdminProvider adminProvider;
    private final IReportProvider reporter;
    public AdminController(IAdminGUI adminView) {
        this.adminProvider = new AdminProvider();
        this.adminView= adminView;
        this.reporter = new ReportProvider();
    }

    public void showInfo(){
        DefaultTableModel model = adminView.getView(1);
        model.setRowCount(0);
        List<Drug> drugs = adminProvider.getDrugs();
        for(Drug drug : drugs){
            model.addRow(new Object[]{drug.getId(), drug.getName(), drug.getType(),drug.getPrice(), drug.getStock()});
        }
        adminView.showDrugView();
    }

    public void showAccount(){
        DefaultTableModel model = adminView.getView(2);
        model.setRowCount(0);
        List<User> users = adminProvider.getUsers();
        for(User user : users){
            model.addRow(new Object[]{user.getId(), user.getWallet(), user.getType(), user.getUsername(), user.getPassword()});
        }
        adminView.showUserView();
    }

    public void tableClick(int selection){
        if(selection == 1){
            adminView.setWalletName((String)adminView.getRowAt(1));
            adminView.setDrugAccType((String)adminView.getRowAt(2));
            adminView.setUsernamePrice(Float.toString((Float)(adminView.getRowAt(3))));
            adminView.setPasswordStock(Integer.toString((Integer)(adminView.getRowAt(4))));
        }else{
            adminView.setWalletName(Float.toString((Float)(adminView.getRowAt(1))));
            adminView.setDrugAccType((String)adminView.getRowAt(2));
            adminView.setUsernamePrice((String)adminView.getRowAt(3));
            adminView.setPasswordStock((String)adminView.getRowAt(4));
        }

    }

    public void addCreate(boolean selected){
        String walletName = adminView.getWalletName();
        String usernamePrice = adminView.getUsernamePrice();
        String passwordStock = adminView.getPasswordStock();
        if(selected){
            if(usernamePrice.matches("[0-9]*\\.?[0-9]+")){
                if(passwordStock.matches("[0-9]+") && passwordStock.charAt(0) != '0'){
                    adminProvider.create(new Drug(adminView.getWalletName(), adminView.getDrugAccType(),Float.parseFloat(usernamePrice), Integer.parseInt(passwordStock)));
                }else{
                    adminView.showErrorMessage("Error: Invalid stock!");
                    return;
                }
            }else {
                adminView.showErrorMessage("Error: Invalid price!");
                return;
            }
            this.showInfo();
        }else{
            if(walletName.matches("[0-9]*\\.?[0-9]+")){
                if(adminView.getDrugAccType().toLowerCase().equals("normal") || adminView.getDrugAccType().toLowerCase().equals("admin")){
                    adminProvider.create(new User(Float.parseFloat(adminView.getWalletName()), adminView.getDrugAccType(),usernamePrice, passwordStock));
                }else{
                    adminView.showErrorMessage("Error: Invalid type!");
                    return;
                }
            }else{
                adminView.showErrorMessage("Error: Invalid wallet!");
                return;
            }

            this.showAccount();
        }
    }

    public void update(boolean selected){
        String walletName = adminView.getWalletName();
        String usernamePrice = adminView.getUsernamePrice();
        String passwordStock = adminView.getPasswordStock();
        if(selected){
            if(usernamePrice.matches("[0-9]*\\.?[0-9]+")){
                if(passwordStock.matches("[0-9]+") && passwordStock.charAt(0) != '0'){
                    Drug drug = new Drug(adminView.getWalletName(), adminView.getDrugAccType(),Float.parseFloat(usernamePrice), Integer.parseInt(passwordStock));
                    drug.setId((Long)adminView.getRowAt(0));
                    adminProvider.update(drug);
                }else{
                    adminView.showErrorMessage("Error: Invalid stock!");
                    return;
                }
            }else {
                adminView.showErrorMessage("Error: Invalid price!");
                return;
            }
            this.showInfo();
        }else{
            if(adminView.getDrugAccType().toLowerCase().equals("normal") || adminView.getDrugAccType().toLowerCase().equals("admin")){
                if(walletName.matches("[0-9]*\\.?[0-9]+")){
                    User user = new User(Float.parseFloat(adminView.getWalletName()), adminView.getDrugAccType(),usernamePrice, passwordStock);
                    user.setId((Long)adminView.getRowAt(0));
                    adminProvider.update(user);
                }else{
                    adminView.showErrorMessage("Error: Invalid wallet!");
                    return;
                }
            }else{
                adminView.showErrorMessage("Error: Invalid type!");
                return;
            }

            this.showAccount();
        }
    }

    public void delete (boolean selected){
        String walletName = adminView.getWalletName();
        String usernamePrice = adminView.getUsernamePrice();
        String passwordStock = adminView.getPasswordStock();
        if(selected){
            if(usernamePrice.matches("[0-9]*\\.?[0-9]+")){
                if(passwordStock.matches("[0-9]+") && passwordStock.charAt(0) != '0'){
                    Drug drug = new Drug(adminView.getWalletName(), adminView.getDrugAccType(),Float.parseFloat(usernamePrice), Integer.parseInt(passwordStock));
                    drug.setId((Long)adminView.getRowAt(0));
                    adminProvider.delete(drug);
                }else{
                    adminView.showErrorMessage("Error: Invalid stock!");
                    return;
                }
            }else {
                adminView.showErrorMessage("Error: Invalid price!");
                return;
            }
            this.showInfo();
        }else{
            if(adminView.getDrugAccType().toLowerCase().equals("normal") || adminView.getDrugAccType().toLowerCase().equals("admin")){
                if(walletName.matches("[0-9]*\\.?[0-9]+")){
                    User user = new User(Float.parseFloat(adminView.getWalletName()), adminView.getDrugAccType(),usernamePrice, passwordStock);
                    user.setId((Long)adminView.getRowAt(0));
                    adminProvider.delete(user);
                }else{
                    adminView.showErrorMessage("Error: Invalid wallet!");
                    return;
                }
            }else{
                adminView.showErrorMessage("Error: Invalid type!");
                return;
            }

            this.showAccount();
        }
    }

    public void search(boolean selected){
        String selectedItem = (String) adminView.getSearch();
        String item = adminView.getSearchField();
        if(selected){
            List<Drug> drugs = adminProvider.getDrugs();
            DefaultTableModel model = adminView.getView(1);
            model.setRowCount(0);
            for(Drug drug : drugs){
                switch(selectedItem){
                    case "ID":
                        if (item.equals("") ||item.matches("[0-9]+") && item.charAt(0) != '0') {
                            if (item.equals("") || Long.parseLong(item) == drug.getId()){
                                model.addRow(new Object[]{drug.getId(), drug.getName(), drug.getType(),drug.getPrice(), drug.getStock()});
                            }
                        }else{
                            adminView.showErrorMessage("Error: Invalid input!");
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
                            adminView.showErrorMessage("Error: Invalid input!");
                            return;
                        }
                        break;
                    case "STOCK":
                        if(item.equals("") ||item.matches("[0-9]+") && item.charAt(0) != '0'){
                            if (item.equals("") || Integer.parseInt(item) <= drug.getStock()){
                                model.addRow(new Object[]{drug.getId(), drug.getName(), drug.getType(),drug.getPrice(), drug.getStock()});
                            }
                        }else{
                            adminView.showErrorMessage("Error: Invalid input!");
                            return;
                        }
                        break;
                }
            }

        }else{
            List<User> drugs = adminProvider.getUsers();
            DefaultTableModel model = adminView.getView(2);
            model.setRowCount(0);
            for(User drug : drugs){
                switch(selectedItem) {
                    case "ID":
                        if (item.equals("") || item.matches("[0-9]+") && item.charAt(0) != '0') {
                            if ( item.equals("") || Long.parseLong(item) == drug.getId()) {
                                model.addRow(new Object[]{drug.getId(), drug.getWallet(), drug.getType(), drug.getUsername(), drug.getPassword()});
                            }
                        } else {
                            adminView.showErrorMessage("Error: Invalid input!");
                            return;
                        }
                        break;
                    case "WALLET":
                        if (item.equals("") ||item.matches("[0-9]*\\.?[0-9]+")) {
                            if (item.equals("") || Float.parseFloat(item) >= drug.getWallet()) {
                                model.addRow(new Object[]{drug.getId(), drug.getWallet(), drug.getType(), drug.getUsername(), drug.getPassword()});
                            }
                        } else {
                            adminView.showErrorMessage("Error: Invalid input!");
                            return;
                        }
                        break;
                    case "TYPE":
                        if (item.equals("") || item.toLowerCase().equals(drug.getType().toLowerCase())) {
                            model.addRow(new Object[]{drug.getId(), drug.getWallet(), drug.getType(), drug.getUsername(), drug.getPassword()});
                        }
                        break;
                    case "USERNAME":
                        if (item.equals("") || item.equals(drug.getUsername())) {
                            model.addRow(new Object[]{drug.getId(), drug.getWallet(), drug.getType(), drug.getUsername(), drug.getPassword()});
                        }
                        break;
                    case "PASSWORD":
                        if (item.equals("") || item.equals(drug.getPassword())) {
                            model.addRow(new Object[]{drug.getId(), drug.getWallet(), drug.getType(), drug.getUsername(), drug.getPassword()});
                        }
                        break;
                }
            }
        }
    }

    public void report(){
        JFileChooser chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser .addChoosableFileFilter(new FileNameExtensionFilter("PDF Type", "pdf"));
        chooser .addChoosableFileFilter(new FileNameExtensionFilter("TXT Type", "txt"));
        chooser.setAcceptAllFileFilterUsed(false);
        int returnVal = chooser.showOpenDialog(new JFrame());
        if(returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                FileFactory.getCreator(chooser.getFileFilter().getDescription()).createFile(chooser.getSelectedFile().toString(),reporter.getReports());
            } catch (DocumentException e) {
                e.printStackTrace();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

    }
}

