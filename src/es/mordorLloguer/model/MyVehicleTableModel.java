package es.mordorLloguer.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import es.mordorLloguer.controladores.MyTableModel;

public abstract class MyVehicleTableModel<T extends Vehicle> extends MyTableModel<T> {

	public MyVehicleTableModel(List<String> header,ArrayList<T> data) {
		super(header,data);
		// TODO Auto-generated constructor stubS
	}
	
	public Object getValueAt(int row, int col) {
		switch(col) {
		case 0: return data.get(row).getMatricula();
		case 1: return data.get(row).getMarca();
		case 2: return data.get(row).getColor();
		case 3 : return data.get(row).getMotor();
		case 4 : return data.get(row).getCilindrada();
		case 5 : return data.get(row).getEstado();
		case 6 : return data.get(row).getCarnet();
		default: return null;
		}
	}
	
	
	
}
