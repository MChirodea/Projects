package dataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Product;
/**
 * Class that deals with sql queries insert, update, delete, find.
 * @author mchir
 *
 */
public class ProductDAO {
	
	protected static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO product (price, name)"
			+ " VALUES (?,?)";
	private final static String findStatementString = "SELECT * FROM product where id = ?";
	private static final String deleteStatementString = "DELETE FROM product WHERE idproduct = ?";
	private final static String updateStatementString = "UPDATE product SET price = ?,name = ? WHERE idproduct = ?";
	/**
	 * Method that find the id.
	 * @param prId
	 * @return
	 */
	public static Product findById(int prId) {
		Product toReturn = null;

		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement findStatement = null;

		ResultSet rs = null;

		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, prId);
			rs = findStatement.executeQuery();
			rs.next();	
			String name = rs.getString("name");
			int price = rs.getInt("price");
			toReturn = new Product(prId, price, name, 0);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"ProductDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}
	/**
	 * Method that updates a row from Product.
	 * @param pr
	 * @return
	 */
	public static int update(Product pr) {
		StockDAO.update(pr);
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement updateStatement = null;
		int insertedId = -1;
		try {
			updateStatement = dbConnection.prepareStatement(updateStatementString);
			updateStatement.setInt(1, pr.getPrice());
			updateStatement.setString(2, pr.getName());	
			updateStatement.setInt(3, pr.getId());	
			updateStatement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:delete " + e.getMessage());
		} finally {
			ConnectionFactory.close(updateStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
	}
	/**
	 * Method that delets a row from Product Table.
	 * @param pr
	 * @return
	 */
	public static int delete(Product pr) {
		StockDAO.delete(pr);
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, pr.getId());	
			insertStatement.executeUpdate();

		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:delete " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
	}
	/**
	 * Method that inserts a row from Product Table.
	 * @param pr
	 * @return
	 */
	public static int insert(Product pr) {
		StockDAO.insert(pr);
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, pr.getPrice());	
			insertStatement.setString(2, pr.getName());
			insertStatement.executeUpdate();
			
			
			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProductDAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
	}
}
