package view;

import javax.swing.table.DefaultTableModel;


interface  UserProvider{
    String getAmmount();
    Object getSearch();
    String getSearchField();
    Object getRowAt(int ind);
    Long getLog();
    void setAmount(String amount);



}

interface tableUserProvider{
    DefaultTableModel getView();

}

interface viewUserProvider{
    void showErrorMessage(String message);
}
public interface IUserGUI extends UserProvider, tableUserProvider, viewUserProvider   {
}