package dataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Order;
import model.Product;
/**
 * Class that deals with insert, id, delete and update queries.
 * @author mchir
 *
 */
public class StockDAO {

	protected static final Logger LOGGER = Logger.getLogger(ProductDAO.class.getName());

	private static final String insertStatementString = "INSERT INTO stock (stocknumber)" + " VALUES (?)";

	private final static String findStatementString = "SELECT * FROM stock where idstock = ?";
	private static final String deleteStatementString = "DELETE FROM stock WHERE idstock = ?";
	private final static String updateStatementString = "UPDATE stock SET stocknumber = ? WHERE idstock = ?";
	/**
	 * Method that finds product info based on id.
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
			int stock = rs.getInt("stocknumber");
			toReturn = new Product(prId, 0, "def", stock);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ProductDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}
	/**
	 * Method that updates Stock.
	 * @param pr
	 * @return
	 */
	public static int update(Product pr) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement updateStatement = null;
		int insertedId = -1;
		try {
			updateStatement = dbConnection.prepareStatement(updateStatementString);
			updateStatement.setInt(1, pr.getStock());
			updateStatement.setInt(2, pr.getId());
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
	 * Method that updates Stock based on an order.
	 * @param pr
	 * @return
	 */
	public static int updateORDER(Order pr) {
		Product pra = StockDAO.findById(pr.getIdP());

		if (pra.getStock() - pr.getQuantity() >= 0) {
			Connection dbConnection = ConnectionFactory.getConnection();
			PreparedStatement updateStatement = null;
			int insertedId = -1;
			try {
				updateStatement = dbConnection.prepareStatement(updateStatementString);
				updateStatement.setInt(1, pra.getStock()-pr.getQuantity());
				updateStatement.setInt(2, pr.getIdP());
				updateStatement.executeUpdate();

			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "ClientDAO:delete " + e.getMessage());
			} finally {
				ConnectionFactory.close(updateStatement);
				ConnectionFactory.close(dbConnection);
			}
			return insertedId;
		} else {
			return -5;
		}
	}
	/**
	 * Method that deletes a row from Stock
	 * @param pr
	 * @return
	 */
	public static int delete(Product pr) {
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
	 * Method that inserts a new row into Stock
	 * @param pr
	 * @return
	 */
	public static int insert(Product pr) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, pr.getStock());
			insertStatement.executeUpdate();
			ResultSet rs2 = insertStatement.getGeneratedKeys();
			if (rs2.next()) {
				insertedId = rs2.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "StockDAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);

		}
		return insertedId;
	}
}
