package es.mordorLloguer.model;

import java.util.ArrayList;
import java.util.Arrays;

public class MyCarTableModel extends MyVehicleTableModel<Coche>{

	public MyCarTableModel(ArrayList<Coche> data) {
		super(Arrays.asList("Matricula","Marca","Color","Motor","Cilindrada","Estado","Carnet","Plazas","Puertas"),data);

	}
	public Object getValueAt(int row, int col) {
		switch(col) {
		case 7: return data.get(row).getNplazas();
		case 8: return data.get(row).getNpuertas();
		default: return super.getValueAt(row, col);
		}
	}
}
