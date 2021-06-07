package es.mordorLloguer.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.stream.Collectors;

import javax.sql.DataSource;

public class OracleDataBase implements AlmacenDatosDB {

	
	
	// TO DO
	//
	//
	// CAMBIAR LAS QUERIES POR  CALLS NO LO HE IMPLEMENTADO 
	// POR QUE EN LA PARTE DE BBDD VOY MAS ATRASADO Y 
	// LO QUE TENGO ES TEMPORAL PARA PODER CONTINUAR HACIENDO LA PARTE PROGRAMACION
	
	private static final int CAR = 0;
	private static final int VAN = 1;
	private static final int TRUCK = 2;
	private static final int MICROBUS = 3;
	
	public ArrayList<Empleado> getCustomEmpleados(String where) {

		ArrayList<Empleado> empleados = new ArrayList<Empleado>();

		DataSource ds = MyDataSource.getOracleDataSource();

		String query = "SELECT * FROM EMPLEADO";

		if (where != null)
			query += " WHERE " + where;

		try (Connection con = ds.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {

			Empleado empleado;

			while (rs.next()) {
				empleado = new Empleado(rs.getInt("idEmpleado"), rs.getString("DNI"), rs.getString("nombre"),
						rs.getString("apellidos"), rs.getString("CP"), rs.getString("email"), rs.getDate("fechaNac"),
						rs.getString("cargo"), rs.getString("domicilio"),rs.getString("password"));

				empleados.add(empleado);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return empleados;
	}
	
	public  ArrayList<Empleado> getEmpleadosOrdenadosBy(String field,int sort){
		String sorted="";
		if(sort==AlmacenDatosDB.ASCENDING) {
			sorted="asc";
		}else if(sort==AlmacenDatosDB.DESCENDING) {
			sorted="desc";
		}
				
		return getCustomEmpleadosOrder(field+" "+sorted);
	}

	
	
	public ArrayList<Empleado> getCustomEmpleadosOrder(String orderby) {

		ArrayList<Empleado> empleados = new ArrayList<Empleado>();

		DataSource ds = MyDataSource.getOracleDataSource();

		String query = "SELECT * FROM EMPLEADO";

		if (orderby != null)
			query += " ORDER BY " + orderby;

		try (Connection con = ds.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {

			Empleado empleado;

			while (rs.next()) {
				empleado = new Empleado(rs.getInt("idEmpleado"), rs.getString("DNI"), rs.getString("nombre"),
						rs.getString("apellidos"), rs.getString("CP"), rs.getString("email"), rs.getDate("fechaNac"),
						rs.getString("cargo"), rs.getString("domicilio"),rs.getString("password"));

				empleados.add(empleado);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return empleados;
	}

	@Override
	public ArrayList<Empleado> getEmpleadosPorCP(String cp) {
		// TODO Auto-generated method stub
		return getCustomEmpleados("CP='" + cp + "'");
	}

	@Override
	public ArrayList<Empleado> getEmpleadosPorCargo(String cargo) {
		return getCustomEmpleados("cargo='" + cargo + "'");
	}

	@Override
	public ArrayList<Empleado> getEmpleados() {
		return getCustomEmpleados(null);

	}

	@Override
	public Empleado getEmpleadoPorDNI(String dni) {
		ArrayList<Empleado> empleados = getCustomEmpleados("DNI='" + dni + "'");
		if (empleados.size() == 0)
			return null;
		else
			return empleados.get(0);
	}
	
	

	public boolean addEmpleado(String DNI, String Nombre, String Apellidos, String Domicilio, String cp, String email, String FechaNac, String Cargo,String password) {
		
		
		DataSource ds = MyDataSource.getOracleDataSource();
		
		try(Connection con = ds.getConnection();
				Statement stmt = con.createStatement();){
			
			String query = "insert into empleado(DNI, nombre, apellidos, domicilio, CP, email, fechaNac, cargo, password) VALUES"
					+ "('"+DNI+"','"+Nombre+"', '"+Apellidos+"', '"+Domicilio+"', '"+cp+"', '"+email+"', TO_DATE('"+FechaNac+"','yyyy-mm-dd'), '"+Cargo+"',ENCRYPT_PASWD.encrypt_val('"+password+"'))";
			System.out.println(query);
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		}
		
		return true;
		
	}
	
	
	@Override
	public boolean updateEmpleado(Empleado empleado) {

		boolean actualizado = false;

		DataSource ds = MyDataSource.getOracleDataSource();

		try (Connection con = ds.getConnection();
				Statement stmt = con.createStatement();) {

			String query = "UPDATE EMPLEADO SET nombre='" + empleado.getNombre() + "', " +
												"apellidos='" + empleado.getApellidos() + "'," + 
												((empleado.getDomicilio()!=null)?"domicilio='" + empleado.getDomicilio() + "',":"") + 
												((empleado.getCP()!=null)?"CP='"	+ empleado.getCP() + "',":"") + 
												"email='" + empleado.getEmail() + "'," + 
												"fechaNac=TO_DATE('" + empleado.getFechaNac() + "','yyyy-mm-dd')," + 
												"cargo='" + empleado.getCargo() + "' " + 
												"WHERE DNI='" + empleado.getDNI() + "'";

			System.out.println(query);
			if(stmt.executeUpdate(query)==1)
				actualizado=true;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return actualizado;

	}
	public boolean deleteEmployee(String dni) {

		boolean borrado = false;
		String query = "DELETE FROM EMPLEADO WHERE DNI='" + dni + "'";
		DataSource ds = MyDataSource.getOracleDataSource();

		try (Connection con = ds.getConnection();
				Statement stmt = con.createStatement();
				) {


			if(stmt.executeUpdate(query)==1)
				borrado=true;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return borrado;

	}
	public boolean authenticate (String login,String password) {
		boolean registrado=false;
		System.out.println(login+ " " + password);
		DataSource ds = MyDataSource.getOracleDataSource();
		String query = "SELECT COUNT(*) FROM EMPLEADO WHERE DNI=? AND PASSWORD=ENCRYPT_PASWD.encrypt_val(?)";
		try (Connection con = ds.getConnection();
				PreparedStatement pstmt = con.prepareStatement(query);
				){
			pstmt.setString(1, login);
			pstmt.setString(2, password);
			
			ResultSet rs=pstmt.executeQuery();
			
			rs.next();
			System.out.println(rs.getInt(1));
			if(rs.getInt(1)==1)
				registrado=true;
			

		} catch (SQLException e) {

			e.printStackTrace();

		}
		
		
		return registrado;
	}
	
	
	public boolean deleteCustomer(String dni) {
		
		boolean borrado = false;
		String query = "DELETE FROM cliente WHERE DNI='" + dni + "'";
		DataSource ds = MyDataSource.getOracleDataSource();

		try (Connection con = ds.getConnection();
				Statement stmt = con.createStatement();
				) {


			if(stmt.executeUpdate(query)==1)
				borrado=true;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return borrado;
		
		
	}

	
	public ArrayList<Customer> getCustomers() {
		ArrayList<Customer> customers = new ArrayList<Customer>();

		DataSource ds = MyDataSource.getOracleDataSource();

		String query = "select * from cliente order by cliente.apellidos";


		try (Connection con = ds.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query)) {

			Customer customer;

			while (rs.next()) {
				customer = new Customer(rs.getInt("idcliente"), rs.getString("DNI"), rs.getString("nombre"),
						rs.getString("apellidos"), rs.getString("domicilio"), rs.getString("CP"),rs.getString("email"), rs.getDate("fechaNac"),rs.getString("carnet") );

				customers.add(customer);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return customers;
	}
	
	
	
	public boolean addCustomer(String[] dc) {
		
		DataSource ds = MyDataSource.getOracleDataSource();
		
		try(Connection con = ds.getConnection();
				Statement stmt = con.createStatement();){
			
			String query = "Insert into CLIENTE (DNI,NOMBRE,APELLIDOS,DOMICILIO,CP,EMAIL,FECHANAC,CARNET) VALUES"
					+ "('"+dc[0]+"','"+dc[1]+"', '"+dc[2]+"', '"+dc[3]+"', '"+dc[4]+"', '"+dc[5]+"', TO_DATE('"+dc[6]+"','yyyy-mm-dd'), '"+dc[7]+"')";
			

			System.out.println(query);
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;

		}
		
		return true;
		
		
	}
	
	@Override
	public boolean updateCustomer(Customer c) {


		boolean actualizado = false;

		DataSource ds = MyDataSource.getOracleDataSource();

		try (Connection con = ds.getConnection();
				Statement stmt = con.createStatement();) {

			String query = "UPDATE CLIENTE SET nombre='" + c.getNombre() + "', " +
												"apellidos='" + c.getApellidos() + "'," + 
												((c.getDomicilio()!=null)?"domicilio='" + c.getDomicilio() + "',":"") + 
												((c.getCp()!=null)?"CP='"	+ c.getCp() + "',":"") + 
												"email='" + c.getEmail() + "'," + 
												"fechaNac=TO_DATE('" + c.getFechnac() + "','yyyy-mm-dd')," + 
												"carnet='" + c.getCarnet() + "' " + 
												"WHERE DNI='" + c.getDni() + "'";

			System.out.println(query);
			if(stmt.executeUpdate(query)==1)
				actualizado=true;

		} catch (SQLException e) {

			e.printStackTrace();

		}

		return actualizado;
		
		
	}

	
	private ArrayList<Vehicle> getVehicles(int type){
		
		ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
		
		
		DataSource ds = MyDataSource.getOracleDataSource();

		String cocheQuery = "select * from vehiculo,coche where coche.matricula = vehiculo.matricula";
		String camionQuery = "select * from vehiculo,camion where camion.matricula = vehiculo.matricula";
		String furgonetaQuery = "select * from vehiculo,furgoneta where furgoneta.matricula = vehiculo.matricula";
		String microBusQuery = "select * from vehiculo,microbus where microbus.matricula = vehiculo.matricula";


		if(type == CAR) {
		
			try (Connection con = ds.getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(cocheQuery)) {
	
				Coche coche;
	
				while (rs.next()) {
					coche = new Coche(rs.getString("matricula"), rs.getInt("preciodia"), rs.getString("marca"),
							rs.getString("descripcion"), rs.getString("color"), rs.getString("motor"),rs.getInt("cilindrada"), rs.getDate("fechaadq"),rs.getString("estado"),rs.getString("carnet"),rs.getInt("numplazas"),rs.getInt("numpuertas") );
	
					vehicles.add(coche);
				}
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			}
		else if(type == TRUCK) {
			try (Connection con = ds.getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(camionQuery)) {
	
				Camion coche;
	
				while (rs.next()) {
					coche = new Camion(rs.getString("matricula"), rs.getInt("preciodia"), rs.getString("marca"),
							rs.getString("descripcion"), rs.getString("color"), rs.getString("motor"),rs.getInt("cilindrada"), rs.getDate("fechaadq"),rs.getString("estado"),rs.getString("carnet"),rs.getInt("numruedas"),rs.getInt("MMA") );
	
					vehicles.add(coche);
				}
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(type == VAN) {
			
			try (Connection con = ds.getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(furgonetaQuery)) {
	
				Furgoneta coche;
	
				while (rs.next()) {
					coche = new Furgoneta(rs.getString("matricula"), rs.getInt("preciodia"), rs.getString("marca"),
							rs.getString("descripcion"), rs.getString("color"), rs.getString("motor"),rs.getInt("cilindrada"), rs.getDate("fechaadq"),rs.getString("estado"),rs.getString("carnet"),rs.getInt("MMA") );
	
					vehicles.add(coche);
				}
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else if(type == MICROBUS) {
			try (Connection con = ds.getConnection();
					Statement stmt = con.createStatement();
					ResultSet rs = stmt.executeQuery(microBusQuery)) {
	
				MicroBus coche;
	
				while (rs.next()) {
					coche = new MicroBus(rs.getString("matricula"), rs.getInt("preciodia"), rs.getString("marca"),
							rs.getString("descripcion"), rs.getString("color"), rs.getString("motor"),rs.getInt("cilindrada"), rs.getDate("fechaadq"),rs.getString("estado"),rs.getString("carnet"),rs.getInt("numplazas"),rs.getInt("medida") );
	
					vehicles.add(coche);
				}
	
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return vehicles;
	}
	
	
	@Override
	public ArrayList<Coche> getCoches() {
		
		
		return (ArrayList<Coche>)  getVehicles(CAR).stream().map((p) -> (Coche)p).collect(Collectors.toList());
		
		
	}

	@Override
	public ArrayList<Furgoneta> getFurgonetas() {
		// TODO Auto-generated method stub
		return (ArrayList<Furgoneta>)  getVehicles(VAN).stream().map((p) -> (Furgoneta)p).collect(Collectors.toList());

	}

	@Override
	public ArrayList<Camion> getCamiones() {
		// TODO Auto-generated method stub
		 		return (ArrayList<Camion>)  getVehicles(TRUCK).stream().map((p) -> (Camion)p).collect(Collectors.toList());

	}

	@Override
	public ArrayList<MicroBus> getMicroBuses() {
		// TODO Auto-generated method stub
		return  (ArrayList<MicroBus>)  getVehicles(MICROBUS).stream().map((p) -> (MicroBus)p).collect(Collectors.toList());

	}




	
}