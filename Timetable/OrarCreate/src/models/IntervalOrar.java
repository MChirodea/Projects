package models;

import java.io.Serializable;

public class IntervalOrar implements Serializable {

	/**
	* 
	*/
	private static final long serialVersionUID = -1907751870119496513L;
	private int oraInceput;
	private int oraSfarsit;

	public IntervalOrar(int orI, int orS) {
		this.oraInceput = orI;
		this.oraSfarsit = orS;
	}

	public boolean oraIntre(IntervalOrar obj) {
		if (obj.getOraInceput() >= this.oraInceput && obj.getOraSfarsit() <= this.oraSfarsit) {
			return true;
		} else {
			if (obj.getOraInceput() >= this.oraInceput && obj.getOraInceput() <= this.oraSfarsit) {
				return true;
			} else {
				if (obj.getOraSfarsit() >= this.oraInceput && obj.getOraSfarsit() <= this.oraSfarsit) {
					return true;
				}
			}
		}
		return false;
	}
	public String toString(){
		return this.oraInceput +".00 - " + this.oraSfarsit +".00";
	}

	public int getOraInceput() {
		return oraInceput;
	}

	public void setOraInceput(int oraInceput) {
		this.oraInceput = oraInceput;
	}

	public int getOraSfarsit() {
		return oraSfarsit;
	}

	public void setOraSfarsit(int oraSfarsit) {
		this.oraSfarsit = oraSfarsit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + oraInceput;
		result = prime * result + oraSfarsit;

		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IntervalOrar other = (IntervalOrar) obj;
		if (oraInceput != other.oraInceput)
			return false;
		if (oraSfarsit != other.oraSfarsit)
			return false;
		return true;
	}

}
