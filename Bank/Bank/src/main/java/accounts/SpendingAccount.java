package accounts;


public class SpendingAccount extends Account {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7216332844368891708L;
	private int total;
	public SpendingAccount(int p,int id,int total) {
		super(p,2,id);
		this.total =total;
		// TODO Auto-generated constructor stub
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int sum) {
		this.total = sum;
	}
	
	public boolean withdr(int sum){
		if(this.total - sum >= 0){
			this.total = this.total - sum;
			return true;
		}
		else{
			return false;
		}
			
	}

}
