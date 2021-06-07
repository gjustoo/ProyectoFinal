package es.mordorLloguer.model;

import java.sql.Date;



public class Customer {

	private int id;
	private String dni;
	private String nombre; 
	private String apellidos;
	private String domicilio;
	private String cp;
	private String email;
	private Date fechnac;
	private String carnet;
	
	
	
	public Customer(int i, String dni, String nombre, String apellidos, String domicilio, String cp,String email, Date date, String carnet) {
		super();
		this.id = i;
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.domicilio = domicilio;
		this.cp = cp;
		this.email = email;
		this.fechnac = date;
		this.carnet = carnet;
	}

	public Customer(String dni) {
		
		this.dni= dni;
	}

	public int getId() {
		return id;
	}



	public String getDni() {
		return dni;
	}



	public String getNombre() {
		return nombre;
	}



	public String getApellidos() {
		return apellidos;
	}



	public String getDomicilio() {
		return domicilio;
	}



	public String getCp() {
		return cp;
	}



	public String getEmail() {
		return email;
	}



	public Date getFechnac() {
		return fechnac;
	}



	public String getCarnet() {
		return carnet;
	}



	public void setDni(String dni) {
		this.dni = dni;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}



	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}



	public void setCp(String cp) {
		this.cp = cp;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public void setFechnac(Date fechnac) {
		this.fechnac = fechnac;
	}



	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}



	@Override
	public String toString() {
		return "Customer [id=" + id + ", dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos
				+ ", domicilio=" + domicilio + ", cp=" + cp + ", email=" + email + ", fechnac=" + fechnac + ", carnet="
				+ carnet + "]";
	}



	
	
	
	
	
	
	
}
