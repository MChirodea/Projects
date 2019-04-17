package dataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Order;
/**
 * Class that deals with queries on Order table.
 * @author mchir
 *
 */
public class OrderDAO {

	protected static final Logger LOGGER = Logger.getLogger(OrderDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO orders (idproduct, idclient, idStock, quantity) VALUES (?,?,?,?)";
	private static final String deleteStatementString = "DELETE FROM orders WHERE idorder = ?";
	private final static String updateStatementString = "UPDATE orders SET idproduct = ?,idclient = ?, idStock = ?, quantity = ? WHERE idorder = ?";
	/**
	 * Method that updates a row in Order (Not used atm).
	 * @param Order
	 * @return
	 */
	public static int update(Order Order) {
		
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement updateStatement = null;
		int insertedId = -1;
		try {
			updateStatement = dbConnection.prepareStatement(updateStatementString);
			updateStatement.setInt(1, Order.getIdP());
			updateStatement.setInt(2, Order.getId());	
			updateStatement.setInt(3, Order.getIdP());	
			updateStatement.setInt(4, Order.getQuantity());	
			updateStatement.setInt(5, Order.getIdO());	
			updateStatement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "OrderDAO:delete " + e.getMessage());
		} finally {
			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
		
	}
	/**
	 * Method that deletes a row from Order. (Not used atm).
	 * @param Order
	 * @return
	 */
	public static int delete(Order Order) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, Order.getIdO());	
			insertStatement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "OrderDAO:delete " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
	}
	/**
	 * Method that inserts a new row in the table Order.
	 * @param Order
	 * @return
	 */
	public static int insert(Order Order) {
		int a = StockDAO.updateORDER(Order);
		if(a != -5){
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString);
			insertStatement.setInt(1, Order.getIdP());
			insertStatement.setInt(2, Order.getId());	
			insertStatement.setInt(3, Order.getIdP());	
			insertStatement.setInt(4, Order.getQuantity());	
			insertStatement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "OrderDAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
		}else{
			return -5;
		}
	}
}
