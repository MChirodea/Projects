package BusinessLayer;

import PersistenceLayer.DAO;

import java.util.ArrayList;

public class ClientAcc {

    private int id;
    private String name;
    private String pid;
    private String pin;
    private String address;

    public ClientAcc(){
        this.id = 0;
        this.name = "";
        this.pid = "";
        this.pin = "";
        this.address = "";
    }

    public void setId(int id){
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void clientAdd(){
        DAO.getInstance().addClient(this);
    }

    public void clientUpdate(){
        DAO.getInstance().updateClient(this);
    }

    public static void clientDelete(int id){
        DAO.getInstance().deleteClient(id);
    }

    public static ArrayList<ClientAcc> getC(){
         return DAO.getInstance().getCAccounts();
    }
}
