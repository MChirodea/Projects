package BusinessLayer;

import PersistenceLayer.DAO;

public class Login {
    private String user;
    private String password;
    private int type;
    private int logId;
    public Login(){
        this.user = "";
        this.password = "";
        this.type = -1;
    }

    public int login(){
        int flag = DAO.getInstance().login(this);
        this.logId = this.getLogged();
        return flag;
    }

    private int getLogged(){
        return DAO.getInstance().getLogged(user, password);
    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
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

    public static void initialiseDB(){
        DAO.getInstance().initializeDB();
    }

    public int getLogId() {
    return logId;
    }
}


