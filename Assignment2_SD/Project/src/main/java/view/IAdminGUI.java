package view;


import javax.swing.table.DefaultTableModel;

interface  AdminProvider{
    String getWalletName();
    String getDrugAccType();
    String getUsernamePrice();
    String getPasswordStock();
    Long getLog();
    Object getSearch();
    String getSearchField();
    Object getRowAt(int ind);
    void setWalletName(String moneyUsr);
    void setDrugAccType(String accDrug);
    void setUsernamePrice(String priceUsr);
    void setPasswordStock(String stockPass);

}

interface tableViewProvider{
    void showDrugView();
    void showUserView();
    DefaultTableModel getView(int sel);
}

interface viewAdminProvider{
    void showErrorMessage(String message);
}
public interface IAdminGUI extends AdminProvider, tableViewProvider, viewAdminProvider   {
}