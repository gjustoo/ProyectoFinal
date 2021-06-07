package es.mordorLloguer.controladores;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.ExecutionException;

import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import es.mordorLloguer.config.MyConfig;
import es.mordorLloguer.model.AlmacenDatosDB;
import es.mordorLloguer.vistas.CustomerTable;
import es.mordorLloguer.vistas.EmployeeTable;
import es.mordorLloguer.vistas.LogInFrame;
import es.mordorLloguer.vistas.MainFrame;
import es.mordorLloguer.vistas.PreferencesFrame;
import es.mordorLloguer.vistas.VehiclesFrame;

public class MainController implements ActionListener {

	private static MainFrame vista;
	private AlmacenDatosDB almacenDatos;
	private EmployeeTable employeeTable;
	private EmployeeController employeeController;
	private LogInFrame vistaLogin;
	private PreferencesFrame preferencesFrame;
	private CustomerTable customerTable;
	private VehiclesFrame vFrame;
	private VehicleController vController;
	
	
	private CustomerController customerController;
	
	public MainController(MainFrame vista, AlmacenDatosDB almacenDatos) {
		super();
		this.vista = vista;
		this.almacenDatos = almacenDatos;
		inicializar();
	}

	private void inicializar() {

		vista.getBtnLogOut().setEnabled(true);
		vista.getBtnEmployees().setEnabled(true);
		vista.getBtnVehicle().setEnabled(true);
		vista.getBtnCustomers().setEnabled(true);
		// add action listeners
		vista.getBtnLogIn().addActionListener(this);
		vista.getBtnLogOut().addActionListener(this);
		vista.getMntmExit().addActionListener(this);
		vista.getMntmPreferences().addActionListener(this);
		vista.getBtnEmployees().addActionListener(this);
		vista.getBtnCustomers().addActionListener(this);
		vista.getBtnVehicle().addActionListener(this);
		// add action commands
		vista.getBtnLogIn().setActionCommand("Login");
		vista.getBtnLogOut().setActionCommand("Logout");
		vista.getMntmExit().setActionCommand("Exit");
		vista.getMntmPreferences().setActionCommand("Preferences");
		vista.getBtnEmployees().setActionCommand("Employees");
		vista.getBtnCustomers().setActionCommand("customers");
		vista.getBtnVehicle().setActionCommand("vehicles");

	}

	public void go() {
		vista.setVisible(true);
		System.out.println(vista);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String command = e.getActionCommand();
		if (command.equals("Login")) {
			showLogIn();
		} else if (command.equals("Exit")) {
			vista.dispose();
		} else if (command.equals("Preferences")) {
			openPreferences();
		} else if (command.equals("saveDBdata")) {
			savePreferences();
		} else if (command.equals("Employees")) {
			openEmployees();
		} else if (command.equals("LoadLogin")) {
			loadLogin();
		} else if (command.equals("Logout")) {
			userLogout();
		} else if (command.equals("customers")) {
			openCustomers();
		}else if(command.equals("vehicles")) {
			openVehicles();
		}

	}

	
	private void openVehicles() {
		
		
		if(!isOpen(vFrame)) {
			vFrame = new VehiclesFrame();
			addInternalFrame(vFrame);
			vController = new VehicleController(vFrame,almacenDatos);
			vController.go();
			
		}
		
	}
	
	
	
	private void openCustomers() {
		// TODO Auto-generated method stub

		if (!isOpen(customerTable)) {

			customerTable = new CustomerTable();
			addInternalFrame(customerTable);

			customerController = new CustomerController(customerTable, almacenDatos);
			customerController.go();
		}

	}

	private void userLogout() {
		vista.getBtnEmployees().setEnabled(false);
		vista.getBtnLogIn().setEnabled(true);
		vista.getBtnLogOut().setEnabled(false);
		if (isOpen(employeeTable))
			employeeTable.doDefaultCloseAction();

	}

	private void openEmployees() {

		if (!isOpen(employeeTable)) {

			employeeTable = new EmployeeTable();

			employeeController = new EmployeeController(employeeTable, almacenDatos);
			employeeController.go();
		}

	}

	private void savePreferences() {
		// TODO Auto-generated method stub

		MyConfig.getInstancia().setOracleDriver(preferencesFrame.getDriverTextField().getText());
		MyConfig.getInstancia().setOracleURL(preferencesFrame.getURLTextField().getText());
		MyConfig.getInstancia().setOracleUsername(preferencesFrame.getUserTextField().getText());
		MyConfig.getInstancia().setOraclePassword(String.valueOf(preferencesFrame.getPsswrdTextField().getPassword()));

	}

	private void openPreferences() {
		// TODO Auto-generated method stub

		preferencesFrame = new PreferencesFrame();
		addInternalFrame(preferencesFrame);
		preferencesFrame.setVisible(true);

		preferencesFrame.getDriverTextField().setText(MyConfig.getInstancia().getOracleDriver());
		preferencesFrame.getURLTextField().setText(MyConfig.getInstancia().getOracleURL());
		preferencesFrame.getUserTextField().setText(MyConfig.getInstancia().getOracleUsername());
		preferencesFrame.getPsswrdTextField().setText(MyConfig.getInstancia().getOraclePassword());

		preferencesFrame.getBtnSave().addActionListener(this);

		preferencesFrame.getBtnSave().setActionCommand("saveDBdata");

	}

	public void showLogIn() {

		if (!isOpen(vistaLogin)) {
			
			vistaLogin = new LogInFrame();
			addInternalFrame(vistaLogin);
			vistaLogin.getBtnLogIn().addActionListener(this);
			vistaLogin.getBtnLogIn().setActionCommand("LoadLogin");
			vistaLogin.setPreferredSize(new Dimension(640,480));
			vistaLogin.setVisible(true);

		} else {
			JOptionPane.showMessageDialog(vista, "This window is already generated", "Error",
					JOptionPane.ERROR_MESSAGE);

		}
	}

	private void loadLogin() {

		SwingWorker<Boolean, Void> task = new SwingWorker<Boolean, Void>() {

			@Override
			protected Boolean doInBackground() throws Exception {

				String cadena = String.valueOf(vistaLogin.getPasswordField().getPassword());

				boolean autentificado = false;
				vistaLogin.getProgressBar().setVisible(true);
				try {

					autentificado = almacenDatos.authenticate(vistaLogin.getUsernameField().getText(), cadena);
					System.out.println(autentificado);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return autentificado;
			}

			@Override
			protected void done() {
				try {
					if (get()) {
						vista.getBtnEmployees().setEnabled(true);
						vista.getBtnLogIn().setEnabled(false);
						vista.getBtnLogOut().setEnabled(true);
						vista.getBtnCustomers().setEnabled(true);
						JOptionPane.showMessageDialog(vista, "Login succes", "Succes", JOptionPane.INFORMATION_MESSAGE);
						vistaLogin.doDefaultCloseAction();
					} else {
						JOptionPane.showMessageDialog(vista, "password or username incorrects", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				} catch (InterruptedException | ExecutionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				vistaLogin.getProgressBar().setVisible(false);

			}

		};
		task.execute();

	}

	public static boolean isOpen(JInternalFrame jif) {
		boolean existe = false;
		JInternalFrame[] frames = vista.getDesktopPane().getAllFrames();
		for (JInternalFrame frame : frames)
			if (frame.equals(jif))
				existe = true;
		return existe;
	}

	public static void addInternalFrame(JInternalFrame jif) {
		System.out.println(vista);
		vista.getDesktopPane().add(jif);
		center(jif);
		jif.setVisible(true);

	}

	public static void center(JInternalFrame jif) {
		Dimension deskSize = vista.getDesktopPane().getSize();
		Dimension ifSize = jif.getSize();
		jif.setLocation((deskSize.width - ifSize.width) / 2, (deskSize.height - ifSize.height) / 2);
	}

}
