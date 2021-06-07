package es.mordorLloguer.model;

import java.util.ArrayList;

public interface AlmacenDatosDB {

	int ASCENDING = 0;
	int DESCENDING = 1;
	public ArrayList<Empleado> getEmpleados();
	public ArrayList<Empleado> getEmpleadosPorCP(String cp);
	public ArrayList<Empleado> getEmpleadosPorCargo(String cargo);
	public Empleado getEmpleadoPorDNI(String dni);
	public boolean updateEmpleado(Empleado empleado);
	public boolean addEmpleado(String DNI, String Nombre, String Apellidos, String Domicilio, String cp, String email, String FechaNac, String Cargo,String password);
	public boolean authenticate(String dni,String password);
	public boolean deleteEmployee(String dni);
	public ArrayList<Empleado> getEmpleadosOrdenadosBy(String selectedItem, int num);
	public boolean updateCustomer(Customer e);
	public ArrayList<Customer> getCustomers();
	public boolean addCustomer(String[] datosCliente);
	public boolean deleteCustomer(String dni);
	public ArrayList<Coche> getCoches();
	public ArrayList<Furgoneta> getFurgonetas();
	public ArrayList<Camion> getCamiones();
	public ArrayList<MicroBus> getMicroBuses();

}