package dataAccessLayer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;



import connection.ConnectionFactory;
import model.Product;

/**
 * Class that deals with getting the product list.
 * @author mchir
 *
 */
public class ProductAccess {
	
	/**
	 * Method that returns the product list from the table.
	 * @return ArrayList<Object>
	 */
	  public ArrayList<Object> getPRList(){
	    	ArrayList<Object> plList = new ArrayList<Object>();
	    	Connection connection = ConnectionFactory.getConnection();
	    	Connection connection2 = ConnectionFactory.getConnection();

	    	String query = "Select * FROM `product` ";
	    	String query2 = "Select * FROM `stock` ";
	    	Statement st;
	    	Statement st2;
	    	ResultSet rs;
	    	ResultSet rs2;
	    	
	    	try {
				st = connection.createStatement();
				st2 = connection2.createStatement();
				rs = st.executeQuery(query);
				rs2 = st2.executeQuery(query2);
				Product pl;
				while(rs.next() && rs2.next()){
					pl = new Product(rs.getInt("idproduct"), rs.getInt("price"), rs.getString("name"), rs2.getInt("stocknumber"));
					plList.add(pl);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	ConnectionFactory.close(connection);
	    	ConnectionFactory.close(connection2);

	    	return plList;
	    }
}
