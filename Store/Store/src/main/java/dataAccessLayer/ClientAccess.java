package dataAccessLayer;


import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import connection.ConnectionFactory;
import model.Client;

/**
 * Class that deals with the sql syntax in order to get the info.
 * @author mchir
 *
 */
public class ClientAccess {
	/**
	 * Method that gets the client list from the table.
	 * @return ArrayList<Object>
	 */
	public ArrayList<Object> getClientList(){
    	ArrayList<Object> clList = new ArrayList<Object>();
    	Connection connection = ConnectionFactory.getConnection();
    	
    	
    	String query = "Select * FROM `client` ";
    	Statement st;
    	ResultSet rs;
    	
    	try {
			st = connection.createStatement();
			rs = st.executeQuery(query);
			Client cl;
			while(rs.next()){
				cl = new Client(rs.getInt("idClient"), rs.getString("Name"), rs.getString("Email"), rs.getString("PhoneNumber"), rs.getString("Adress"));
				clList.add(cl);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	ConnectionFactory.close(connection);
    	return clList;
    }
	 
}
