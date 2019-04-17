package data;

import org.joda.time.DateTime;

public class MonitoredData {
	private DateTime startTime;
	private DateTime endTime;
	private String activity;
	
	public MonitoredData(DateTime startTime, DateTime endTime, String activity) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.activity = activity;
	}

	public DateTime getStartTime() {
		return startTime;
	}

	public void setStartTime(DateTime startTime) {
		this.startTime = startTime;
	}

	public DateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(DateTime endTime) {
		this.endTime = endTime;
	}

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}
	
	public boolean checkDay(int prevDay){
		int currDayS = this.startTime.getDayOfMonth();
		if (currDayS != prevDay) {
			return true;
		}
		else{
			return false;
		}
	}
	
	public boolean checkEachDay(int day){
		if(this.getEndTime().getDayOfMonth() == day && this.getStartTime().getDayOfMonth() == day){
			return true;
		}
		else{
			return false;
		}
	}
	
	
}
