package entelgyPracticasBack.model;

import java.io.Serializable;
import java.sql.Date;

public class Empleado implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nDIEmp;
	private String nomEmp;
	private char sexEmp;
	private Date fecNac;
	private Date fecIncorporacion;
	private float salEmp;
	private float comisionE;
	private String cargoE;
	private String jefeID;
	private String codDepto;

	public String getnDIEmp() {
		return nDIEmp;
	}

	public void setnDIEmp(String nDIEmp) {
		this.nDIEmp = nDIEmp;
	}

	public String getNomEmp() {
		return nomEmp;
	}

	public void setNomEmp(String nomEmp) {
		this.nomEmp = nomEmp;
	}

	public char getSexEmp() {
		return sexEmp;
	}

	public void setSexEmp(char sexEmp) {
		this.sexEmp = sexEmp;
	}

	public Date getFecNac() {
		return fecNac;
	}

	public void setFecNac(Date fecNac) {
		this.fecNac = fecNac;
	}

	public Date getFecIncorporacion() {
		return fecIncorporacion;
	}

	public void setFecIncorporacion(Date fecIncorporacion) {
		this.fecIncorporacion = fecIncorporacion;
	}

	public float getSalEmp() {
		return salEmp;
	}

	public void setSalEmp(float salEmp) {
		this.salEmp = salEmp;
	}

	public float getComisionE() {
		return comisionE;
	}

	public void setComisionE(float comisionE) {
		this.comisionE = comisionE;
	}

	public String getCargoE() {
		return cargoE;
	}

	public void setCargoE(String cargoE) {
		this.cargoE = cargoE;
	}

	public String getJefeID() {
		return jefeID;
	}

	public void setJefeID(String jefeID) {
		this.jefeID = jefeID;
	}

	public String getCodDepto() {
		return codDepto;
	}

	public void setCodDepto(String codDepto) {
		this.codDepto = codDepto;
	}

	@Override
	public String toString() {
		return "Empleado [nDIEmp=" + nDIEmp + ", nomEmp=" + nomEmp + ", sexEmp=" + sexEmp + ", fecNac=" + fecNac
				+ ", fecIncorporacion=" + fecIncorporacion + ", salEmp=" + salEmp + ", comisionE=" + comisionE
				+ ", cargoE=" + cargoE + ", jefeID=" + jefeID + ", codDepto=" + codDepto + "]";
	}
	
	

}
