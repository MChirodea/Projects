package accounts;


public class SavingAccount extends Account{

	private static final long serialVersionUID = -1589759704510371100L;
	private int savings;
	private boolean limit;
	private int interest;
	private boolean limitDep;

	public SavingAccount(int p, int id, int interest, int savings) {
		super(p,1,id);
		this.savings = savings;
		this.interest = interest;
		this.limit = true;
		if(savings == 0){
			this.limitDep = true;
		}else{
			this.limitDep = false;
		}
		
		// TODO Auto-generated constructor stub
	}
	
	public int getSavings(){
		return this.savings;
	}
	
	public int getInterest(){
		return this.interest;
	}
	
	public void deposit(int sav){
		this.savings = sav;
	}
	
	public boolean withdraw(){
		if(this.limit){
			this.savings = 0;
			this.limit = false;
			return true;
		}
		else 
			return false;
	}
	
	public void setInterest(int inter){
	 this.interest = inter;
	}

	public boolean getlimit() {
		return limit;
	}

	public void setLimit(boolean limit) {
		this.limit = limit;
	}
	
	public boolean getlimitDeposit() {
		return limitDep;
	}

	public void setLimitDeposit(boolean limit) {
		this.limitDep = limit;
	}
	public void setSavings(int sum){
		this.savings = sum;
	}

}
