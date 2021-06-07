package es.mordorLloguer.model;

import java.util.ArrayList;
import java.util.Arrays;

public class MyMicroBusTableModel extends MyVehicleTableModel<MicroBus>{

	public MyMicroBusTableModel(ArrayList<MicroBus> data) {
		super(Arrays.asList("Matricula","Marca","Color","Motor","Cilindrada","Estado","Carnet","Medida","NumPlazas"),data);
		// TODO Auto-generated constructor stub
	}

	
	
	public Object getValueAt(int row, int col) {
		switch(col) {
		case 7: return data.get(row).getMedida();
		case 8: return data.get(row).getNplazas();
		default: return super.getValueAt(row, col);
		}
	}
	
}
