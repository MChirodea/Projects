package clients;

import java.io.Serializable;


public class Person implements Serializable {
	
	private static final long serialVersionUID = -8986650892866647121L;
	private int id;
	private String holderName;
	private String pID;
	private String address;
	private String phoneNr;
	
	public Person(int id, String holderName, String pID, String address, String phoneNr) {
		super();
		this.id = id;
		this.holderName = holderName;
		this.pID = pID;
		this.address = address;
		this.phoneNr = phoneNr;
	}

	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getHolderName() {
		return holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	public String getpID() {
		return pID;
	}

	public void setpID(String pID) {
		this.pID = pID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNr() {
		return phoneNr;
	}

	public void setPhoneNr(String phoneNr) {
		this.phoneNr = phoneNr;
	}

}
