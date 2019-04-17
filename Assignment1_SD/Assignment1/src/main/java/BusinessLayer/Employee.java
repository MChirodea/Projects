package BusinessLayer;

import PersistenceLayer.DAO;

import java.util.ArrayList;

public class Employee {
    private int id;
    private String name;
    private String pid;
    private String address;
    private String phone;
    private String username;
    private String password;
    private int type;

    public Employee(){
        this.id = -1;
        this.name = "";
        this.pid = "";
        this.address = "";
        this.phone = "";
        this.type = -1;
        this.username = "";
        this.password = "";
    }

    public static ArrayList<Employee> getE(){
        return DAO.getInstance().getEmployees();
    }

    public void addEmployee(){
        DAO.getInstance().addEmployee(this);
    }

    public static void deleteEmployee(int id){
        DAO.getInstance().deleteEmployee(id);
    }

    public void updateEmployee(){
        DAO.getInstance().updateEmployee(this);
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
