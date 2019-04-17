package dataAccessLayer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import connection.ConnectionFactory;
import model.Client;
/**
 * Method that Deals with sql queries to insert, extract, update or edit.
 * @author mchir
 *
 */
public class ClientDAO {

	protected static final Logger LOGGER = Logger.getLogger(ClientDAO.class.getName());
	private static final String insertStatementString = "INSERT INTO client (Name,Email,PhoneNumber, Adress)"
			+ " VALUES (?,?,?,?)";
	private static final String deleteStatementString = "DELETE FROM client WHERE idClient = ?";
	private final static String findStatementString = "SELECT * FROM client where id = ?";
	private final static String updateStatementString = "UPDATE client SET Name = ?,Email = ?, PhoneNumber = ?, Adress = ? WHERE idClient = ?";
	/**
	 * Method that finds a client by id.
	 * @param clientId
	 * @return
	 */
	public static Client findById(int clientId) {
		Client toReturn = null;
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement findStatement = null;
		ResultSet rs = null;
		try {
			findStatement = dbConnection.prepareStatement(findStatementString);
			findStatement.setLong(1, clientId);
			rs = findStatement.executeQuery();
			rs.next();
			String name = rs.getString("Name");
			String email = rs.getString("Email");
			String phone = rs.getString("PhoneNumber");
			String address = rs.getString("Adress");
			
			toReturn = new Client(clientId, name, email, phone, address);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"ClientDAO:findById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(findStatement);
			ConnectionFactory.close(dbConnection);
		}
		return toReturn;
	}
	/**
	 * Method taht updates a row in the client table.
	 * @param client
	 * @return
	 */
	public static int update(Client client) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement updateStatement = null;
		int insertedId = -1;
		try {
			updateStatement = dbConnection.prepareStatement(updateStatementString);
			updateStatement.setString(1, client.getName());
			updateStatement.setString(2, client.getEmail());	
			updateStatement.setString(3, client.getPhone());	
			updateStatement.setString(4, client.getAddress());	
			updateStatement.setInt(5, client.getId());	
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
	 * Method that deletes a row from Client table.
	 * @param client
	 * @return
	 */
	public static int delete(Client client) {
		Connection dbConnection = ConnectionFactory.getConnection();
		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(deleteStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setInt(1, client.getId());	
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
	 * Method that insert a new row in Client List.
	 * @param client
	 * @return
	 */
	public static int insert(Client client) {
		Connection dbConnection = ConnectionFactory.getConnection();

		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			insertStatement = dbConnection.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			insertStatement.setString(1, client.getName());	
			insertStatement.setString(2, client.getEmail());
			insertStatement.setString(3, client.getPhone());
			insertStatement.setString(4, client.getAddress());
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "ClientDAO:insert " + e.getMessage());
		} finally {
			ConnectionFactory.close(insertStatement);
			ConnectionFactory.close(dbConnection);
		}
		return insertedId;
	}
}
