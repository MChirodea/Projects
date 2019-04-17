package models;

import java.io.Serializable;

public class AnStudiu implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 441612336295230852L;
	private String anStudiu;
	private String facultate;

	public AnStudiu(String anStudiu) {
		this.anStudiu = anStudiu;
	}
	public void toUpr() {
		////Does not work
	}
	public String getAnStudiu() {
		return anStudiu;
	}

	public void setAnStudiu(String anStudiu) {
		this.anStudiu = anStudiu;
	}

	public String getFacultate() {
		return facultate;
	}

	public void setFacultate(String facultate) {
		this.facultate = facultate;
	}
}
