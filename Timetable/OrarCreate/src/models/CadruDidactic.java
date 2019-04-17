package models;

import java.io.Serializable;

public class CadruDidactic implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3972932403786780106L;

	public CadruDidactic(String nume, String disciplina,int index,AnStudiu an) {
		super();
		this.nume = nume;
		this.disciplina = disciplina;
		this.an[index] =an;
	}

	private String nume;
	private String disciplina;
	private AnStudiu[] an = new AnStudiu[10];

	public String getNume() {
		return nume;
	}
	public void toUppr() {
		this.nume.toUpperCase();
		this.disciplina.toUpperCase();
	}
	public void setNume(String nume) {
		this.nume = nume;
	}
	public void setBoth(String nume, String disciplina) {
		this.setNume(nume);
		this.setDisciplina(disciplina);
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nume == null) ? 0 : nume.hashCode());
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
		CadruDidactic other = (CadruDidactic) obj;
		if (nume == null) {
			if (other.nume != null)
				return false;
		} else if (!nume.equals(other.nume))
			return false;
		return true;
	}

	public String getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(String disciplina) {
		this.disciplina = disciplina;
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
