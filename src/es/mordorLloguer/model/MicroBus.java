package es.mordorLloguer.model;

import java.sql.Date;

public class MicroBus extends Vehicle{

	private int nplazas;
	private float medida;
	
	
	
	public MicroBus(String matricula, int preciodia, String marca, String descripcion, String color, String motor,	int cilindrada, Date fechadq, String estado, String carnet,int nplazas,float medida) {

		super(matricula, preciodia, marca, descripcion, color, motor, cilindrada, fechadq, estado, carnet);

		this.nplazas=nplazas;
		this.medida=medida;
	
	
	}



	public int getNplazas() {
		return nplazas;
	}



	public void setNplazas(int nplazas) {
		this.nplazas = nplazas;
	}



	public float getMedida() {
		return medida;
	}



	public void setMedida(float medida) {
		this.medida = medida;
	}
	
	
	
	
	
	
	
}
