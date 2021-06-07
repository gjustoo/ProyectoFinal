package es.mordorLloguer.model;

import java.util.ArrayList;
import java.util.Arrays;

public class MyTruckTableModel extends MyVehicleTableModel<Camion>{

	public MyTruckTableModel(ArrayList<Camion> data) {
		super(Arrays.asList("Matricula","Marca","Color","Motor","Cilindrada","Estado","Carnet","MMA","NumRuedas"),data);
		// TODO Auto-generated constructor stub
	}
	
	public Object getValueAt(int row, int col) {
		switch(col) {
		case 7: return data.get(row).getMma();
		case 8: return data.get(row).getNruedas();
		default: return super.getValueAt(row, col);
		}
	}

}
