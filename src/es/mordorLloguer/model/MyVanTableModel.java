package es.mordorLloguer.model;

import java.util.ArrayList;
import java.util.Arrays;

public class MyVanTableModel extends MyVehicleTableModel<Furgoneta>{

	public MyVanTableModel(ArrayList<Furgoneta> data) {
		super(Arrays.asList("Matricula","Marca","Color","Motor","Cilindrada","Estado","Carnet","MMA"),data);
	}
	
	
	public Object getValueAt(int row, int col) {
		switch(col) {
		case 7: return data.get(row).getMma();
		default: return super.getValueAt(row, col);
		}
	}

}
