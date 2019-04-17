package codes;

import java.util.Comparator;

public class ComparatorMon implements Comparator<Monome> {

	public int compare(Monome mon1, Monome mon2) {
		// TODO Auto-generated method stub
		if(mon1.getGrade() > mon2.getGrade()){
			return 1;
		}
		else
			return -1;
	}

}
