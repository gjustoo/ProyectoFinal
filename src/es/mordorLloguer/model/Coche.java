package es.mordorLloguer.model;

import java.sql.Date;

public class Coche extends Vehicle{

	
	private int nplazas;
	private int npuertas;
	
	
	public Coche(String matricula, int preciodia, String marca, String descripcion, String color, String motor,int cilindrada, Date fechadq, String estado, String carnet,int nplazas,int npuertas) {
		
		super(matricula, preciodia, marca, descripcion, color, motor, cilindrada, fechadq, estado, carnet);
		
		this.nplazas=nplazas;
		this.npuertas=npuertas;
		
	}


	public void setNplazas(int nplazas) {
		this.nplazas = nplazas;
	}


	public void setNpuertas(int npuertas) {
		this.npuertas = npuertas;
	}


	public int getNplazas() {
		return nplazas;
	}


	public int getNpuertas() {
		return npuertas;
	}

}
