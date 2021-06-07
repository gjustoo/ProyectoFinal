package es.mordorLloguer.model;

import java.sql.Date;

public abstract class Vehicle {

	private String matricula;
	private int preciodia;
	private String marca;
	private String descripcion;
	private String color;
	private String motor;
	private int cilindrada;
	private Date fechadq;
	private String estado;
	private String carnet;
	
	public Vehicle(String matricula, int preciodia, String marca, String descripcion, String color, String motor,
			int cilindrada, Date fechadq, String estado, String carnet) {
		super();
		this.matricula = matricula;
		this.preciodia = preciodia;
		this.marca = marca;
		this.descripcion = descripcion;
		this.color = color;
		this.motor = motor;
		this.cilindrada = cilindrada;
		this.fechadq = fechadq;
		this.estado = estado;
		this.carnet = carnet;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getPreciodia() {
		return preciodia;
	}

	public void setPreciodia(int preciodia) {
		this.preciodia = preciodia;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	public int getCilindrada() {
		return cilindrada;
	}

	public void setCilindrada(int cilindrada) {
		this.cilindrada = cilindrada;
	}

	public Date getFechadq() {
		return fechadq;
	}

	public void setFechadq(Date fechadq) {
		this.fechadq = fechadq;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getCarnet() {
		return carnet;
	}

	public void setCarnet(String carnet) {
		this.carnet = carnet;
	}
	
	
	
	
	
	
	
}
