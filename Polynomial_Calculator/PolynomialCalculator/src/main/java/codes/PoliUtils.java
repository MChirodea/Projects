 package codes;

import java.util.Iterator;

public class PoliUtils {
	private int flag1;
	private int flag2;

	public PoliUtils(int flag1, int flag2) {
		this.flag1 = flag1;
		this.flag2 = flag2;
	}
	
	public int getFlag1(){
		return this.flag1;
	}
	public int getFlag2(){
		return this.flag2;
	}

	public void setFlag1(int set){
		this.flag1 = set;
	}
	
	public void setFlag2(int set) {
		// TODO Auto-generated method stub
		this.flag2 = set;
	}
	
	public Polinome readPoli(String inp){
		Polinome polinome1 = new Polinome();
		String poli1 =inp;
		String[] parts1 = null;
		Monome mon = new Monome(1, 0);
		int count = 0;
		if (poli1.contains("x") && poli1.contains("X")) {
			parts1 = poli1.split("X\\^\\d +\\+?|x\\^\\d+\\+?");
		} else {
			if (poli1.contains("x")) {
				parts1 = poli1.split("x\\^\\d+\\+?");
			} else {
				parts1 = poli1.split("X\\^\\d+\\+?");
			}
		}
		String[] exp1 = null;
		String[] terms1 = poli1.split("(\\+)");
		for (String term : terms1) {
			exp1 = term.split("\\^");
			if (exp1.length > 1) {
				mon.setGrade(Integer.parseInt(exp1[1]));
				mon.setGradeD(Double.parseDouble(exp1[1]));
			} else {
				mon.setGrade(0);
				mon.setGradeD(0);
			}
			if(parts1[count].contains("(")){
				String[] temp = parts1[count++].split("\\("); 
				String[] temp2 = temp[1].split("\\)");
				mon.setValue((int)Double.parseDouble(temp2[0]));
				mon.setValueD(Double.parseDouble(temp2[0]));
			}
			else{
				mon.setValue((int)Double.parseDouble(parts1[count]));
				mon.setValueD(Double.parseDouble(parts1[count]));
				count++;
			}
			polinome1.addMon(mon);
			mon = new Monome(1, 0);

		}
		return polinome1;
	}
	
	
	public Polinome addPoliUtilBoth(Polinome newPol,Monome mon, Monome mon1,Iterator<Monome>itm, Iterator<Monome>itm2) {
		if (mon.getGrade() == mon1.getGrade()) {
				newPol.addMon(new Monome(mon.getValue() + mon1.getValue(), mon.getGrade()));
			} else {
				if (mon.getGrade() > mon1.getGrade()) {
					if (itm2.hasNext() || itm.hasNext()) {
						newPol.addMon(new Monome(mon.getValue(), mon.getGrade()));
						this.flag2 = 1;
					} else {
						newPol.addMon(new Monome(mon.getValue(), mon.getGrade()));
						newPol.addMon(new Monome(mon1.getValue(), mon1.getGrade()));
					}
				} else {
					if (itm.hasNext() || itm2.hasNext()) {
						newPol.addMon(new Monome(mon1.getValue(), mon1.getGrade()));
						this.flag1 = 1;
					} else {
						newPol.addMon(new Monome(mon1.getValue(), mon1.getGrade()));
						newPol.addMon(new Monome(mon.getValue(), mon.getGrade()));
					}
				}
			}
		
		return newPol;
	}

	public Polinome addPoliUtil1(Polinome newPol,Monome mon, Monome mon1,Iterator<Monome>itm, Iterator<Monome>itm2) {
		if (mon1.getGrade() == mon.getGrade()) {
			newPol.addMon(new Monome(mon.getValue() + mon1.getValue(), mon.getGrade()));
			this.flag2 = 0;
		} else {
			if (mon1.getGrade() > mon.getGrade()) {
				if (itm.hasNext()) {
					newPol.addMon(new Monome(mon1.getValue(), mon1.getGrade()));
					this.flag2 = 0;
				} else {
					newPol.addMon(new Monome(mon1.getValue(), mon1.getGrade()));
					newPol.addMon(new Monome(mon.getValue(), mon.getGrade()));
				}
			} else {
				if (itm.hasNext()) {
					newPol.addMon(new Monome(mon.getValue(), mon.getGrade()));
					this.flag2 = 0;
				} else {
					newPol.addMon(new Monome(mon.getValue(), mon.getGrade()));
					newPol.addMon(new Monome(mon1.getValue(), mon1.getGrade()));
				}
			}
		}
	return newPol;
	}
	
	public Polinome addPoliUtil2(Polinome newPol, Monome mon, Monome mon1,Iterator<Monome>itm, Iterator<Monome>itm2) {
		if (mon.getGrade() == mon1.getGrade()) {
			newPol.addMon(new Monome(mon.getValue() + mon1.getValue(), mon.getGrade()));
			this.flag1 = 0;
		} else {
			if (mon.getGrade() > mon1.getGrade()) {
				if (itm.hasNext()) {
					newPol.addMon(new Monome(mon.getValue(), mon.getGrade()));
					this.flag1 = 0;
				} else {
					newPol.addMon(new Monome(mon.getValue(), mon.getGrade()));
					newPol.addMon(new Monome(mon1.getValue(), mon1.getGrade()));
				}
			} else {
				if (itm.hasNext()) {
					newPol.addMon(new Monome(mon1.getValue(), mon1.getGrade()));
					this.flag2 = 0;
				} else {
					newPol.addMon(new Monome(mon1.getValue(), mon1.getGrade()));
					newPol.addMon(new Monome(mon.getValue(), mon.getGrade()));
				}
			}
		}
		return newPol;
	}
	
	public Polinome subPoliUtilBoth(Polinome newPol, Monome mon, Monome mon1,Iterator<Monome>itm, Iterator<Monome>itm2) {
		if (mon.getGrade() == mon1.getGrade()) {
			newPol.addMon(new Monome(mon.getValue() - mon1.getValue(), mon.getGrade()));
			} else {
				if (mon.getGrade() > mon1.getGrade()) {
					if (itm2.hasNext() || itm.hasNext()) {
						newPol.addMon(new Monome(mon.getValue(), mon.getGrade()));
						this.flag2 = 1;
					} else {
						newPol.addMon(new Monome(mon.getValue(), mon.getGrade()));
						newPol.addMon(new Monome(-(mon1.getValue()), mon1.getGrade()));
					}
				} else {
					if (itm.hasNext() || itm2.hasNext()) {
						newPol.addMon(new Monome(-(mon1.getValue()), mon1.getGrade()));
						this.flag1 = 1;
					} else {
						newPol.addMon(new Monome(-(mon1.getValue()), mon1.getGrade()));
						newPol.addMon(new Monome(mon.getValue(), mon.getGrade()));
					}
				}
			}
		
		return newPol;
	}

	public Polinome subPoliUtil1(Polinome newPol, Monome mon, Monome mon1,Iterator<Monome>itm, Iterator<Monome>itm2) {
		if (mon1.getGrade() == mon.getGrade()) {
			newPol.addMon(new Monome(mon.getValue() - mon1.getValue(), mon.getGrade()));
			this.flag2 = 0;
		} else {
			if (mon1.getGrade() > mon.getGrade()) {
				if (itm.hasNext()) {
					newPol.addMon(new Monome(-(mon1.getValue()), mon1.getGrade()));
					this.flag2 = 0;
				} else {
					newPol.addMon(new Monome(-(mon1.getValue()), mon1.getGrade()));
					newPol.addMon(new Monome(mon.getValue(), mon.getGrade()));
				}
			} else {
				if (itm.hasNext()) {
					newPol.addMon(new Monome(mon.getValue(), mon.getGrade()));
					this.flag2 = 0;
				} else {
					newPol.addMon(new Monome(mon.getValue(), mon.getGrade()));
					newPol.addMon(new Monome(-(mon1.getValue()), mon1.getGrade()));
				}
			}
		}
	return newPol;
	}
	
	public Polinome subPoliUtil2(Polinome newPol, Monome mon, Monome mon1,Iterator<Monome>itm, Iterator<Monome>itm2) {
		if (mon.getGrade() == mon1.getGrade()) {
			newPol.addMon(new Monome(mon.getValue() - mon1.getValue(), mon.getGrade()));
			this.flag1 = 0;
		} else {
			if (mon.getGrade() > mon1.getGrade()) {
				if (itm.hasNext()) {
					newPol.addMon(new Monome(mon.getValue(), mon.getGrade()));
					this.flag1 = 0;
				} else {
					newPol.addMon(new Monome(mon.getValue(), mon.getGrade()));
					newPol.addMon(new Monome(-(mon1.getValue()), mon1.getGrade()));
				}
			} else {
				if (itm.hasNext()) {
					newPol.addMon(new Monome(-(mon1.getValue()), mon1.getGrade()));
					this.flag2 = 0;
				} else {
					newPol.addMon(new Monome(-(mon1.getValue()), mon1.getGrade()));
					newPol.addMon(new Monome(mon.getValue(), mon.getGrade()));
				}
			}
		}
		return newPol;
	}
}
