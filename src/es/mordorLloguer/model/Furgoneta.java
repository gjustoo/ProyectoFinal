package es.mordorLloguer.model;

import java.sql.Date;

public class Furgoneta extends Vehicle{

	private int mma;

		public Furgoneta(String matricula, int preciodia, String marca, String descripcion, String color, String motor,
			int cilindrada, Date fechadq, String estado, String carnet,int mma) {
		super(matricula, preciodia, marca, descripcion, color, motor, cilindrada, fechadq, estado, carnet);
		// TODO Auto-generated constructor stub
		
		
		
		this.mma = mma;
		
	}

		public int getMma() {
			return mma;
		}

		public void setMma(int mma) {
			this.mma = mma;
		}

		
		
		
		
	
	
	
}
