package control;

public class Person {
	private int ID=0;
	private int timeS=0;
	private int arrTime=0;
	
	public Person(int id, int sT, int aT){
		this.ID = id;
		this.timeS = sT;
		this.arrTime = aT;
		
	}
	
	public void setID(int val){
		this.ID = val;
	}
	
	public void setArrivalTime(int val){
		this.arrTime = val;
	}
	
	public void setServiceTime(int val){
		this.timeS = val;
	}
	
	public int getID(){
		return this.ID;
	}
	
	public int getArrivalTime(){
		return this.arrTime;
	}
	
	public int getServiceTime(){
		return this.timeS;
	}
	
	
}
