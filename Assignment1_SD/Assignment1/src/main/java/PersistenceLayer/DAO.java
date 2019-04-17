package PersistenceLayer;

import BusinessLayer.*;
import DatabaseLayer.DBConnection;

import java.sql.*;
import java.time.*;
import java.util.ArrayList;

public class DAO {

        private static final DAO INSTANCE = new DAO();
        private Connection con;
        private DAO() {
            try {
                this.con = DBConnection.getConnection();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    public Connection getCon(){
            return this.con;
    }

    public int getLogged(String user, String pass){
        String stringu = "select * from users where user = " +"?";
        PreparedStatement st = null;
        try {
            st = con.prepareStatement(stringu);
            st.setString(1,user);
            ResultSet rs = st.executeQuery();
            if(pass.equals(rs.getString("password"))){
               return rs.getInt("id");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    public int login(Login credentials){
        try {
            String stringu = "select * from users where user = " +"?";
            PreparedStatement st = con.prepareStatement(stringu);
            st.setString(1,credentials.getUser());
            ResultSet rs = st.executeQuery();
            if(!(rs.next())){
                System.out.println("Invalid User");
            }else{

                if(credentials.getPassword().equals(rs.getString("password"))){
                    credentials.setType(rs.getInt("type"));
                    return 1;
                }

            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
            return 0;
        }
        System.out.println("Invalid Password");
        return 0;
    }
    public int transferMoney(int id1, int id2, float money){

        try {
            float newMoney1 = 0;
            float newMoney2 = 0;
            Statement sti = con.createStatement();
            ResultSet rs = sti.executeQuery("select * from accounts");
            while(rs.next()){
               if(id1 == rs.getInt("id")){
                   if(rs.getFloat("money") - money < 0){
                       return 1;
                   }else {
                       newMoney1 = rs.getFloat("money") - money;
                   }
               }else if(id2 == rs.getInt("id")){
                   newMoney2 = rs.getFloat("money") + money;
               }
            }

            String statement = "update accounts set money = " +"?" +" where id = " +"?";
            PreparedStatement st = con.prepareStatement(statement);
            st.setFloat(1, newMoney1);
            st.setInt(2,id1);
            st.executeUpdate();
            st.close();
            st = con.prepareStatement(statement);
            st.setFloat(1, newMoney2);
            st.setInt(2,id2);
            st.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void addClient(ClientAcc client){
        try {
            String prepSt = "insert into clients(name, pid, pin, address) values"+"(?,?,?,?)";
            PreparedStatement st1 = con.prepareStatement(prepSt);
            st1.setString(1,client.getName());
            st1.setString(2,client.getPid());
            st1.setString(3,client.getPin());
            st1.setString(4,client.getAddress());
            st1.executeUpdate();
            st1.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addEmployee(Employee emp){
        try {
            String prepSt = "insert into users(name,pid,address,phone,user,password,type) values"+"(?,?,?,?,?,?,?)";
            PreparedStatement st = con.prepareStatement(prepSt);
            st.setString(1,emp.getName());
            st.setString(2,emp.getPid());
            st.setString(3,emp.getAddress());
            st.setString(4,emp.getPhone());
            st.setString(5,emp.getUsername());
            st.setString(6,emp.getPassword());
            st.setInt(7,emp.getType());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addAccount(AccountType client){
        try {
            String prepSt = "insert into accounts(idn, type, money, doc) values"+"(?,?,?,?)";
            PreparedStatement st = con.prepareStatement(prepSt);
            st.setInt(1,client.getIdn());
            st.setString(2,client.getType());
            st.setFloat(3,client.getMoney());
            st.setString(4,client.getCreationD());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void addReport(Report rep){
        try {
            String prepSt = "insert into reports(userid, action, dater) values"+"(?,?,?)";
            PreparedStatement st = con.prepareStatement(prepSt);
            st.setInt(1,rep.getUserid());
            st.setString(2,rep.getAction());
            st.setString(3,rep.getDate().toString());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateClient(ClientAcc client){
        try {
            String statement = "update clients set name = " +"?" +", pid = " +"?" +", pin = " +"?" + ", address = " +"?" +" where id = " +"?";
            PreparedStatement st = con.prepareStatement(statement);
            st.setString(1,client.getName());
            st.setString(2,client.getPid());
            st.setString(3,client.getPin());
            st.setString(4,client.getAddress());
            st.setInt(5,client.getId());
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateAccount(AccountType client){
        try {
            String statement = "update accounts set idn = " +"?" +", type = " +"?" +", money = " +"?" + ", doc = " +"?" +" where id = " +"?";
            PreparedStatement st = con.prepareStatement(statement);
            st.setInt(1,client.getIdn());
            st.setString(2,client.getType());
            st.setFloat(3,client.getMoney());
            st.setString(4,client.getCreationD());
            st.setInt(5,client.getId());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void updateEmployee(Employee emp){
        try {
            String statement = "update users set name = " +"?" +", pid = " +"?" +", address = " +"?" + ", phone = " +"?"+ ", user = " +"?" + ", password = " +"?"+ ", type = " +"?"+" where id = " +"?";
            PreparedStatement st = con.prepareStatement(statement);
            st.setString(1,emp.getName());
            st.setString(2,emp.getPid());
            st.setString(3,emp.getAddress());
            st.setString(4,emp.getPhone());
            st.setString(5,emp.getUsername());
            st.setString(6,emp.getPassword());
            st.setInt(7,emp.getType());
            st.setInt(8,emp.getId());
            st.executeUpdate();
            st.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteClient(int id){
        try {
            String statement = "delete from clients where id = " + "?";
            PreparedStatement st = con.prepareStatement(statement);
            st.setInt(1,id);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteAccount(int id){
        try {
            String statement = "delete from accounts where id = " + "?";
            PreparedStatement st = con.prepareStatement(statement);
            st.setInt(1,id);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteEmployee(int id){
        try {
            String statement = "delete from users where id = " + "?";
            PreparedStatement st = con.prepareStatement(statement);
            st.setInt(1,id);
            st.executeUpdate();
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<ClientAcc> getCAccounts(){
        ArrayList<ClientAcc> rez = new ArrayList<ClientAcc>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from clients");
            while (rs.next()) {
                // read the result set
                ClientAcc client = new ClientAcc();
                client.setId(rs.getInt("id"));
                client.setName(rs.getString("name"));
                client.setPid(rs.getString("pid"));
                client.setPin(rs.getString("pin"));
                client.setAddress(rs.getString("address"));
                rez.add(client);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rez;
    }


    public ArrayList<AccountType> getAccountsT(){
        ArrayList<AccountType> rez = new ArrayList<AccountType>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from accounts");
            while (rs.next()) {
                // read the result set
                AccountType client = new AccountType();
                client.setId(rs.getInt("id"));
                client.setIdn(rs.getInt("idn"));
                client.setMoney(rs.getFloat("money"));
                client.setType(rs.getString("type"));
                client.setCreationD(rs.getString("doc"));
                rez.add(client);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rez;
    }
    public ArrayList<Employee> getEmployees() {
        ArrayList<Employee> rez = new ArrayList<Employee>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from users");
            while (rs.next()) {
                // read the result set
                Employee emp = new Employee();
                emp.setId(rs.getInt("id"));
                emp.setName(rs.getString("name"));
                emp.setPid(rs.getString("pid"));
                emp.setAddress(rs.getString("address"));
                emp.setPhone(rs.getString("phone"));
                emp.setUsername(rs.getString("user"));
                emp.setPassword(rs.getString("password"));
                emp.setType(rs.getInt("type"));
                rez.add(emp);
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rez;
    }

    public ArrayList<Report> getReport(LocalDate std, LocalDate end, int id) {
        ArrayList<Report> rez = new ArrayList<Report>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from reports where userid = " +id);
            while (rs.next()) {
                // read the result set
                Report rep = new Report();
                LocalDate tableStDate = LocalDate.parse(rs.getString("dater"));
                if(tableStDate.isAfter(std) && tableStDate.isBefore(end)){
                    rep.setUserid(id);
                    rep.setAction(rs.getString("action"));
                    rep.setDate(rs.getString("dater"));
                    rez.add(rep);
                }

            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rez;
    }
        public void initializeDB(){
            try {
                Statement st = con.createStatement();
                st.executeUpdate("drop table if exists clients");
                st.executeUpdate("create table clients (id integer not null, name string, pid string, pin string, address string,primary key(id))");
                st.executeUpdate("insert into clients(name,pid,pin,address) values ('Stefan Condrea','197063705598','1009','Str. M. Roma')");
                st.executeUpdate("drop table if exists accounts");
                st.executeUpdate("create table accounts (id integer not null, idn integer not null, type string, money float, doc string, primary key(id), foreign key(idn) references clients)");
                st.executeUpdate("insert into accounts(idn,type,money,doc) values (1,'Normal',900.0,'2006-03-04')");
                st.executeUpdate("drop table if exists users");
                st.executeUpdate("create table users (id integer not null,name string,pid string, address string,phone string, user string, password string, type integer, primary key(id))");
                st.executeUpdate("insert into users(name,pid,address,phone,user,password,type) values('Chirodea Mihai', '1090627055098','Str.Doina, Nr. 30','0740429211','Mijai', '123',1)");
                st.executeUpdate("insert into users(name,pid,address,phone,user,password,type) values('Chirodea Mihai', '1090627055098','Str.Doina, Nr. 30','0740429211','MijaiAdmin', '123',0)");
                st.executeUpdate("drop table if exists reports");
                st.executeUpdate("create table reports (id integer not null, userid integer not null ,action string, dater string, primary key(id), foreign key(userid) references users)");
                st.executeUpdate("insert into reports(userid,action,dater) values(1,'Delete','2007-09-03')");
                st.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        public static DAO getInstance() {
            return INSTANCE;
        }


}

