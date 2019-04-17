package bankM;

import java.io.Serializable;
import java.util.LinkedHashSet;


import clients.Person;

public interface BankProc extends Serializable {
	/**
	 * @pre Verifies that p is not null.
	 * @param p
	 * @post The person is added to the table.
	 */
	public void addPerson(Person p);
	/**
	 * @pre Verifies if the id is valid.
	 * @param id
	 * @post The person with the coresponding id is removed.
	 */
	public void removePerson(int id);
	/**
	 * @pre Verifies if ac is not null and person is not null
	 * @param ac
	 * @param p
	 * @post The account is added to the holder p
	 */
	public void addHolderAccount(Object ac, Person p);
	/**
	 * @pre Verifies if the id's are valid.
	 * @param accID
	 * @param cID
	 * @post The account is removed from the holder.
	 */
	public void remHolderAccount(int accID, int cID);
	/**
	 * @pre Verifies if the id is valid
	 * @param cID
	 * @return
	 * @post Returns the list of Accounts
	 */
	public LinkedHashSet<Object> readAcc(int cID);
	
	/**
	 * @pre Verifies that the id and ac are valid
	 * @param cID
	 * @param ac
	 * @post The given account will be overridden.
	 */
	public void writeAcc(int cID, Object ac);//placeholder
	//Report Generator?
	
}
