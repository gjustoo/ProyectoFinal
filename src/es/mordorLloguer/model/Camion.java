package es.mordorLloguer.model;

import java.sql.Date;

public class Camion extends Vehicle{
	
	private int mma;
	private int nruedas;
	

	public Camion(String matricula, int preciodia, String marca, String descripcion, String color, String motor,
			int cilindrada, Date fechadq, String estado, String carnet,int mma,int nruedas) {
		super(matricula, preciodia, marca, descripcion, color, motor, cilindrada, fechadq, estado, carnet);

		this.mma = mma;
		this.nruedas=nruedas;
		
		
	
	}


	public int getMma() {
		return mma;
	}


	public void setMma(int mma) {
		this.mma = mma;
	}


	public int getNruedas() {
		return nruedas;
	}


	public void setNruedas(int nruedas) {
		this.nruedas = nruedas;
	}
	
	
	
	
}
