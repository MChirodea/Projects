package businessLayer;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import businessLayer.validators.EmailValidator;
import businessLayer.validators.ClientPhoneValidator;
import businessLayer.validators.Validator;
import dataAccessLayer.ClientDAO;
//import dao.StudentDAO;
import model.Client;

/**
 * Class that Validates the client using the validators.
 * @author mchir
 *
 */
public class ClientValidator {

	private List<Validator<Client>> validators;
	
	public ClientValidator() {
		validators = new ArrayList<Validator<Client>>();
		validators.add(new EmailValidator());
		validators.add(new ClientPhoneValidator());
	}
	/**
	 * Method that finds client by id.
	 * @param id
	 * @return
	 */
	public Client findClientById(int id) {
		Client st = ClientDAO.findById(id);
		if (st == null) {
			throw new NoSuchElementException("The client with id =" + id + " was not found!");
		}
		return st;
	}
	/**
	 * method that validates before inserting into client.
	 * @param client
	 * @return
	 */
	public int insertClient(Client client) {
		for (Validator<Client> v : validators) {
			v.validate(client);
		}
		return ClientDAO.insert(client);
	}
	/**
	 * Method that validates before editing.
	 * @param client
	 * @return
	 */
	public int editClient(Client client) {
		for (Validator<Client> v : validators) {
			v.validate(client);
		}
		return ClientDAO.update(client);
	}
}
