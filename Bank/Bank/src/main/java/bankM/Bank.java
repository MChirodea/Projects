package bankM;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map.Entry;

import accounts.Account;
import clients.Person;

public class Bank implements BankProc {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3994963430011546312L;
	private LinkedHashMap<Person, LinkedHashSet<Object>> accounts;
	private LinkedHashSet<Person> clients;
	private int autoINCP = 1;
	private int autoINCA = 1;

	public Bank() {
		accounts = new LinkedHashMap<Person, LinkedHashSet<Object>>();

		clients = new LinkedHashSet<Person>();
	}

	public void addPerson(Person p) {
		// TODO Auto-generated method stub
		clients.add(p);

	}

	public void incA() {
		this.autoINCA++;
	}

	public void incP() {
		this.autoINCP++;
	}

	public void removePerson(int id) {
		// TODO Auto-generated method stub
		Iterator<Person> itp = clients.iterator();
		Person temp;
		while (itp.hasNext()) {
			temp = itp.next();
			if (temp.getId() == id) {
				itp.remove();
			}
		}
		for (Entry<Person, LinkedHashSet<Object>> entry : accounts.entrySet()) {
			Person pa = entry.getKey();
			assert (pa != null):"Invalid Person";
			if (pa.getId() == id) {
				accounts.remove(pa);
				return;
			}
		}
	}

	public void addHolderAccount(Object ac, Person p) {
		// TODO Auto-generated method stub
		int flag = 0;
		LinkedHashSet<Object> temp = this.readAcc(p.getId());
		if (temp != null) {
			temp.add(ac);
		} else {
			temp = new LinkedHashSet<Object>();
			temp.add(ac);
		}
		for (Entry<Person, LinkedHashSet<Object>> entry : accounts.entrySet()) {
			Person pa = entry.getKey();
			assert (pa != null):"Invalid Person";
			if (pa.getId() == p.getId()) {
				accounts.put(pa, temp);
				flag = 1;
			}
		}
		if (flag == 0) {
			accounts.put(p, temp);
		}

	}

	public LinkedHashSet<Object> searchByPerson(Person p) {

		return accounts.get(p);
	}

	public void remHolderAccount(int accID, int cID) {
		// TODO Auto-generated method stub
		LinkedHashSet<Object> temp = this.readAcc(cID);
		if (temp != null) {
			Iterator<Object> ito = temp.iterator();
			while (ito.hasNext()) {
				Account temp2 = (Account) ito.next();
				assert (temp2 != null):"Invalid Account";
				if (temp2.getID() == accID) {
					ito.remove();
				}
			}
		}
		for (Entry<Person, LinkedHashSet<Object>> entry : accounts.entrySet()) {
			Person pa = entry.getKey();
			if (pa.getId() == cID) {
				assert (pa != null):"Invalid Person";
				accounts.put(pa, temp);
			}
		}

	}

	// to be tested
	public LinkedHashSet<Object> readAcc(int cID) {
		// TODO Auto-generated method stub
		for (Entry<Person, LinkedHashSet<Object>> entry : accounts.entrySet()) {
			Person pa = entry.getKey();
			LinkedHashSet<Object> temp = entry.getValue();
			assert (pa != null):"Invalid Person";
			if (pa.getId() == cID) {
				return temp;
			}
		}
		return null;
	}

	// To be tested
	public void writeAcc(int cID, Object ac) {
		// TODO Auto-generated method stub
		for (Entry<Person, LinkedHashSet<Object>> entry : accounts.entrySet()) {
			Person pa = entry.getKey();
			LinkedHashSet<Object> temp = entry.getValue();
			assert (pa != null):"Invalid Person";
			if (pa.getId() == cID) {
				Iterator<Object> ito = temp.iterator();
				while (ito.hasNext()) {
					Account t = (Account) ito.next();
					Account t2 = (Account) ac;
					assert (t != null):"Invalid Account";
					if (t.getID() == t2.getID()) {
						ito.remove();
						temp.add(ac);
						this.accounts.put(pa, temp);
						return;
					}
				}

			}
		}
	}

	public LinkedHashMap<Person, LinkedHashSet<Object>> getAccounts() {
		return accounts;
	}

	public void setAccounts(LinkedHashMap<Person, LinkedHashSet<Object>> accounts) {
		this.accounts = accounts;
	}

	public LinkedHashSet<Person> getClients() {
		return clients;
	}

	public void setClients(LinkedHashSet<Person> clients) {
		this.clients = clients;
	}

	public int getAutoINCP() {
		int temp = this.autoINCP;
		this.incP();
		return temp;
	}

	public void setAutoINCP(int autoINCP) {
		this.autoINCP = autoINCP;
	}

	public int getAutoINCA() {
		int temp = this.autoINCA;
		this.incA();
		return temp;
	}

	public void setAutoINCA(int autoINCA) {
		this.autoINCA = autoINCA;
	}

	public void editClient(Person ed, Person cur) {
		Iterator<Person> itp = this.clients.iterator();
		while (itp.hasNext()) {
			Person temp = itp.next();
			assert (temp != null):"Invalid Person";
			if (temp.getId() == cur.getId()) {
				itp.remove();
				break;
			}
		}
		this.clients.add(ed);
		for (Entry<Person, LinkedHashSet<Object>> entry : accounts.entrySet()) {
			Person pa = entry.getKey();
			LinkedHashSet<Object> temp = entry.getValue();
			assert (pa != null):"Invalid Person";
			if (pa.getId() == ed.getId()) {
				this.accounts.remove(pa);
				this.accounts.put(ed, temp);
				return;
			}
		}

	}
}
