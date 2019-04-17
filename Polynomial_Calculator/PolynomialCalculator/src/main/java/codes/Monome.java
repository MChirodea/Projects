package codes;

public class Monome {
	private int value = 0;
	private int grade = 0;
	private double valueDouble = 0.0;
	private double gradeDouble = 0.0;
	
	public Monome(int value, int grade){
		this.value = value;
		this.grade = grade;
		this.valueDouble = (double)value;
		this.gradeDouble = (double)grade;
	}
	
	public int getValue(){
		return this.value;
	}
	
	public int getGrade(){
		return this.grade;
	}
	
	public void setValue(int value){
		this.value = value;
	}
	
	public void setGrade(int grade){
		this.grade = grade;
	}
	public double getValueD(){
		return this.valueDouble;
	}
	
	public double getGradeD(){
		return this.gradeDouble;
	}
	
	public void setValueD(double value){
		this.valueDouble = value;
	}
	
	public void setGradeD(double grade){
		this.gradeDouble = grade;
	}
}
