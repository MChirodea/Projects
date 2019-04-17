package accounts;

import java.io.Serializable;


public class Account implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8150919577687485208L;
	private int holderID;
	private int accType;
	private int id;
	
	public Account(int idH, int act, int id){
		this.holderID = idH;
		this.accType = act;
		this.id = id;
	}
	public int getHolder(){
		return this.holderID;
	}
	public int getAccType(){
		return this.accType;
	}
	
	public int getID(){
		return this.id;
	}
}
