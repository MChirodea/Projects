package BusinessLayer;

import PersistenceLayer.DAO;

import java.util.ArrayList;

public class AccountType {

    private int id;
    private int idn;
    private String type;
    private float money;
    private String CreationD;

    public AccountType(){
        this.id = 0;
        this.idn = 0;
        this.type ="";
        this.money = 0.0f;
        this.CreationD = "";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdn() {
        return idn;
    }

    public void setIdn(int idn) {
        this.idn = idn;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

    public String getCreationD() {
        return CreationD;
    }

    public void setCreationD(String creationD) {
        CreationD = creationD;
    }

    public void accountAdd(){
        DAO.getInstance().addAccount(this);
    }

    public void accountUpdate(){
        DAO.getInstance().updateAccount(this);
    }

    public static void accountDelete(int id){
        DAO.getInstance().deleteAccount(id);
    }

    public static ArrayList<AccountType> getA(){
        return DAO.getInstance().getAccountsT();
    }

    public static int transfer(int id1, int id2, float money) {
        return DAO.getInstance().transferMoney(id1,id2,money);
    }
}
