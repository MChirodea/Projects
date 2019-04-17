package codes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Polinome {
	private Set<Monome> monList;
	private ComparatorMon comparator = new ComparatorMon();

	public Polinome() {
		monList = new LinkedHashSet<Monome>();
	}

	public void addMon(Monome mon) {
		monList.add(mon);
		List<Monome> list = new ArrayList<Monome>(monList);
		Collections.sort(list, Collections.reverseOrder(comparator));
		monList = new LinkedHashSet<Monome>(list);
	}

	public Set<Monome> getPoli() {
		return this.monList;
	}

	public int getSize() {
		return this.monList.size();
	}

	public Polinome addPoli(Polinome poli) {
		Iterator<Monome> itm = monList.iterator();
		Set<Monome> mon2 = poli.getPoli();
		Iterator<Monome> itm2 = mon2.iterator();
		Polinome newPol = new Polinome();
		Monome mon = null;
		Monome mon1 = null;
		PoliUtils utils = new PoliUtils(0, 0);
		while (itm.hasNext() && itm2.hasNext()) {
			if (utils.getFlag1() == 0) {
				mon = itm.next();
			} else {
				utils.setFlag1(0);
			}
			if (utils.getFlag2() == 0) {
				mon1 = itm2.next();
			} else {
				utils.setFlag2(0);
			}
			newPol = utils.addPoliUtilBoth(newPol, mon, mon1, itm, itm2);
		}
		while (itm.hasNext()) {
			if (utils.getFlag2() == 1) {
				mon = itm.next();
				newPol = utils.addPoliUtil1(newPol, mon, mon1, itm, itm2);
			} else {
				if (utils.getFlag1() == 1) {
					newPol.addMon(new Monome(mon.getValue(), mon.getGrade()));
					utils.setFlag1(0);
				} else {
					mon = itm.next();
					newPol.addMon(new Monome(mon.getValue(), mon.getGrade()));
				}
			}
		}
		while (itm2.hasNext()) {
			if (utils.getFlag1() == 1) {
				mon1 = itm2.next();
				newPol = utils.addPoliUtil2(newPol, mon, mon1, itm, itm2);
			} else {
				if (utils.getFlag2() == 1) {
					newPol.addMon(new Monome(mon1.getValue(), mon1.getGrade()));
					utils.setFlag2(0);
				} else {
					mon1 = itm2.next();
					newPol.addMon(new Monome(mon1.getValue(), mon1.getGrade()));
				}
			}
		}
		return newPol;
	}

	public Polinome subPoli(Polinome poli) {
		Iterator<Monome> itm = monList.iterator();
		Set<Monome> mon2 = poli.getPoli();
		Iterator<Monome> itm2 = mon2.iterator();
		Polinome newPol = new Polinome();
		Monome mon = null;
		Monome mon1 = null;
		PoliUtils utils = new PoliUtils(0, 0);
		while (itm.hasNext() && itm2.hasNext()) {
			if (utils.getFlag1() == 0) {
				mon = itm.next();
			} else {
				utils.setFlag1(0);
			}
			if (utils.getFlag2() == 0) {
				mon1 = itm2.next();
			} else {
				utils.setFlag2(0);
			}
			newPol = utils.subPoliUtilBoth(newPol, mon, mon1, itm, itm2);
		}
		while (itm.hasNext()) {
			if (utils.getFlag2() == 1) {
				mon = itm.next();
				newPol = utils.subPoliUtil1(newPol, mon, mon1, itm, itm2);
			} else {
				if (utils.getFlag1() == 1) {
					newPol.addMon(new Monome(mon.getValue(), mon.getGrade()));
					utils.setFlag1(0);
				} else {
					mon = itm.next();
					newPol.addMon(new Monome(mon.getValue(), mon.getGrade()));
				}
			}
		}
		while (itm2.hasNext()) {
			if (utils.getFlag1() == 1) {
				mon1 = itm2.next();
				newPol = utils.subPoliUtil2(newPol, mon, mon1, itm, itm2);
			} else {
				if (utils.getFlag2() == 1) {
					newPol.addMon(new Monome(-(mon1.getValue()), mon1.getGrade()));
					utils.setFlag2(0);
				} else {
					mon1 = itm2.next();
					newPol.addMon(new Monome(-(mon1.getValue()), mon1.getGrade()));
				}
			}
		}
		return newPol;
	}

	public Polinome mulPoli(Polinome poli) {
		Iterator<Monome> itm = monList.iterator();
		Set<Monome> mon2 = poli.getPoli();
		Iterator<Monome> itm2 = mon2.iterator();
		Polinome newPol = new Polinome();
		Monome mon = null;
		Monome mon1 = null;
		while (itm.hasNext()) {
			mon = itm.next();
			while (itm2.hasNext()) {
				mon1 = itm2.next();
				newPol.addMon(new Monome(mon.getValue() * mon1.getValue(), mon.getGrade() + mon1.getGrade()));
			}
			itm2 = mon2.iterator();
		}
		return newPol;
	}

	public Polinome derPoli() {
		Iterator<Monome> itm = monList.iterator();
		Polinome newPol = new Polinome();
		Monome mon = null;
		while (itm.hasNext()) {
			mon = itm.next();
			newPol.addMon(new Monome(mon.getGrade() * mon.getValue(), mon.getGrade() - 1));
		}
		return newPol;
	}

	public Polinome interPoli() {
		Iterator<Monome> itm = monList.iterator();
		Polinome newPol = new Polinome();
		Monome mon = null;
		while (itm.hasNext()) {
			mon = itm.next();
			Monome mon1 = new Monome(0, 0);
			mon1.setValueD(mon.getValueD() / (mon.getGradeD() + 1.0));
			mon1.setGradeD(mon.getGradeD() + 1.0);
			mon1.setValue(mon.getValue() / (mon.getGrade() + 1));
			mon1.setGrade(mon.getGrade() + 1);
			newPol.addMon(mon1);
		}
		return newPol;
	}
}
