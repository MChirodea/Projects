package models;

import java.io.Serializable;

public class Sala implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -8023805239502972204L;
	private String numeSala;
	private AnStudiu[] an = new AnStudiu[10];
	
	public Sala(String nume,int index, AnStudiu an) {
		this.numeSala = nume;
		this.an[index] = an;
	}
	public void toUppr() {
		numeSala.toUpperCase();
	}
	public String getNumeSala() {
		return numeSala;
	}

	public void setNumeSala(String numeSala) {
		this.numeSala = numeSala;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numeSala == null) ? 0 : numeSala.hashCode());
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
		Sala other = (Sala) obj;
		if (numeSala == null) {
			if (other.numeSala != null)
				return false;
		} else if (!numeSala.equals(other.numeSala))
			return false;
		return true;
	}

	public AnStudiu getAn(int index) {
		return an[index];
	}
	
	public AnStudiu[] getAn() {
		return an;
	}
	public void setAn(AnStudiu[] temp) {
		this.an = temp;
	}
	public void addAn(AnStudiu an, int index) {
		this.an[index] = an;
	}
}
