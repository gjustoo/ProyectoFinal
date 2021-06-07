package es.mordorLloguer.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;

import com.alee.laf.table.editors.WebDateEditor;

import es.mordorLloguer.model.AlmacenDatosDB;
import es.mordorLloguer.model.Customer;
import es.mordorLloguer.model.SimpleDocumentListener;
import es.mordorLloguer.vistas.AddCustomer;
import es.mordorLloguer.vistas.CustomerTable;
import es.mordorLloguer.vistas.LoadingFrame;

public class CustomerController implements ActionListener, TableModelListener  {

	
	private AlmacenDatosDB almacenDatos;
	private CustomerTable vista;
	private LoadingFrame loadingFrame;
	private ArrayList<Customer> customers;
	private AddCustomer acFrame;
	
	private MyTableModel mtm;
	
	private static  CustomerController controller;
	
	
	public CustomerController(CustomerTable vista, AlmacenDatosDB almacenDatos) {
		
		this.almacenDatos=almacenDatos;
		this.vista = vista;
		this.controller = this;
		inicializar();
		
	}


	
	private void inicializar() {
		// TODO Auto-generated method stub
		
		
		
		vista.getDniTextField().getDocument().addDocumentListener((SimpleDocumentListener) e -> {

			filter();
		});
		vista.getSurnameTextField().getDocument().addDocumentListener((SimpleDocumentListener) e -> {

			filter();
		});
		vista.getNameTextField().getDocument().addDocumentListener((SimpleDocumentListener) e -> {

			filter();
		});
		vista.getCarnetBox().addActionListener(controller);
		vista.getBtnAdd().addActionListener(controller);
		vista.getBtnDelete().addActionListener(controller);
		
		// add action listeners
		vista.getCarnetBox().setActionCommand("filter");
		vista.getBtnAdd().setActionCommand("showCustomer");
		vista.getBtnDelete().setActionCommand("delete");
		
		
		
		
		
	}



	public void go() {
		
		vista.setVisible(true);
		sort();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		
		String command = e.getActionCommand();
		
		if(command.equals("filter")) {
				filter();

		}else if(command.equals("showCustomer")) {
			showAddCustomer();
		}else if(command.equals("addCustomer")) {
			addCustomer();
		}else if(command.equals("delete")) {
			
			deleteCustomer();
			
			
		}
		
		
	}
	
	
	private void deleteCustomer() {
		
		int row = vista.getTable().getSelectedRow();
		
		
		String dni = String.valueOf(vista.getTable().getValueAt(row, 0));

		if (almacenDatos.deleteCustomer(dni)) {
			mtm.removeElement((Customer)mtm.getElement(row));
			JOptionPane.showMessageDialog(vista, "Customer deleted", "Succes", JOptionPane.INFORMATION_MESSAGE);

		} else {
			JOptionPane.showMessageDialog(vista, "Could not delete Customer", "Error", JOptionPane.ERROR_MESSAGE);

		}
		
		
	}
	
	
	
	private void showAddCustomer() {
		
		
		if(!MainController.isOpen(acFrame)) {
		
			acFrame = new AddCustomer();
			MainController.addInternalFrame(acFrame);
			acFrame.setVisible(true);
			
			
			acFrame.getBtnAdd().addActionListener(controller);
			acFrame.getBtnAdd().setActionCommand("addCustomer");
			
			
		}
	}
	
	private void addCustomer() {
		
		String nombre  = acFrame.getNombreTextField().getText();
		
		String apellidos = acFrame.getApellidosTextField().getText();
		
		String dni = acFrame.getDniTextField().getText();
		
		String domicilio = acFrame.getDomicilioTextField().getText();
		
		String cp = acFrame.getCpTextField().getText();
		
		String email = acFrame.getEmailTextField().getText();
		
		String date = acFrame.getDateTextField().getDate().toString();
		
		String carnet = acFrame.getCarnetBox().getSelectedItem().toString();
		
		
		String[] datosCliente = {dni,nombre,apellidos,domicilio,cp,email,date,carnet};
		
		if(almacenDatos.addCustomer(datosCliente)) {

			
			JOptionPane.showMessageDialog(vista, "Customer Added", "Succes", JOptionPane.INFORMATION_MESSAGE);
			acFrame.doDefaultCloseAction();
			sort();

		} else {
			JOptionPane.showMessageDialog(vista, "Could not add Customer", "Error", JOptionPane.ERROR_MESSAGE);

		}
		
		
	}
	
	
	private void filter() {
		ArrayList<Customer> result;
		boolean sortcarnets = !vista.getCarnetBox().getSelectedItem().toString().equals("ALL");
			
					 result = (ArrayList<Customer>) customers.stream()
	                .filter((p) -> p.getDni().contains(vista.getDniTextField().getText()))
	                .filter((p) -> p.getApellidos().contains(vista.getSurnameTextField().getText()))
	                .filter((p) -> p.getNombre().contains(vista.getNameTextField().getText()))
	                .filter(sortcarnets? p -> p.getCarnet().contains(vista.getCarnetBox().getSelectedItem().toString()): p -> true)
	                .collect(Collectors.toList());
		

		
		result.forEach(System.out::println);
		mtm = new MyCustomerTableModel(result);
		vista.getTable().setModel(mtm);
		
	}
	
	private void sort() {

		SwingWorker<Void, Void> task = new SwingWorker<Void, Void>() {


			@Override
			protected Void doInBackground() throws Exception {

				loadingFrame.setVisible(true);

				try {

					if (!isCancelled())
						customers = almacenDatos.getCustomers();

				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return null;
			}

			@Override
			protected void done() {
				if (!isCancelled()) {
					try {

						mtm = new MyCustomerTableModel(customers);
						vista.getTable().setModel(mtm);

						vista.getTable().setDefaultEditor(Date.class, new WebDateEditor());

						JComboBox<String> comboBox = new JComboBox<String>();
						comboBox.addItem("A");
						comboBox.addItem("B");
						comboBox.addItem("C");
						comboBox.addItem("D");

						TableColumn column = vista.getTable().getColumn("Carnet");
						column.setCellEditor(new DefaultCellEditor(comboBox));

						mtm.addTableModelListener(controller);

						vista.getTable().addMouseListener(new MouseAdapter() {
							@Override
							public void mouseReleased(MouseEvent e) {
								if (e.getButton() == MouseEvent.BUTTON3) {

									int row = vista.getTable().rowAtPoint(e.getPoint());

									if (vista.getTable().getSelectedRowCount() <= 1) {
										vista.getTable().setSelectedRow(row);
//										vista.getPopupMenu().show(vista.getTable(), e.getX(), e.getY());

									} else if (vista.getTable().getSelectedRowCount() > 1) {
//										vista.getPopupMenu().show(vista.getTable(), e.getX(), e.getY());
									}

								}
							}
						});

						loadingFrame.doDefaultCloseAction();
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				} else {
					vista.dispose();
				}

			}

		};

		loadingFrame = new LoadingFrame(task);
		MainController.addInternalFrame(loadingFrame);

		loadingFrame.getLblTask().setText("Cargando Tabla de Empleados");

		task.execute();

	}
	
	
	
	private class MyCustomerTableModel extends MyTableModel<Customer> {

		public MyCustomerTableModel(List<Customer> data) {
			super(Arrays.asList( "DNI", "Nombre", "Apellidos", "Domicilio", "CP", "Email", "FechaNac", "Carnet" ), data);

		}

		@Override
		public Class<?> getColumnClass(int colIndex) {
			switch (colIndex) {
			case 6:
				return Date.class;
			default:
				return String.class;
			}

		}

		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			switch (columnIndex) {
			case 1:
				data.get(rowIndex).setNombre(aValue.toString());
				break;

			case 2:
				data.get(rowIndex).setApellidos(aValue.toString());
				break;
			case 3:
				data.get(rowIndex).setDomicilio(aValue.toString());
				break;
			case 4:
				data.get(rowIndex).setCp(aValue.toString());
				break;
			case 5:
				data.get(rowIndex).setEmail(aValue.toString());
				break;
			case 6:
				java.util.Date fecha = (java.util.Date) aValue;
				data.get(rowIndex).setFechnac(new java.sql.Date(fecha.getTime()));
				break;
			case 7:
				data.get(rowIndex).setCarnet(aValue.toString());
				break;

			}
			fireTableCellUpdated(rowIndex, columnIndex);

		}

		@Override
		public Object getValueAt(int row, int col) {
			switch (col) {
			case 0:
				return data.get(row).getDni();
			case 1:
				return data.get(row).getNombre();
			case 2:
				return data.get(row).getApellidos();
			case 3:
				return data.get(row).getDomicilio();
			case 4:
				return data.get(row).getCp();
			case 5:
				return data.get(row).getEmail();
			case 6:
				return data.get(row).getFechnac();
			case 7:
				return data.get(row).getCarnet();
			}
			return null;
		}

		
	}

	@Override
	public void tableChanged(TableModelEvent arg0) {

		if (arg0.getType() == TableModelEvent.UPDATE) {
			MyCustomerTableModel mtm = (MyCustomerTableModel) vista.getTable().getModel();
			Customer e = mtm.getElement(arg0.getFirstRow());

			SwingWorker<Void, Void> task = new SwingWorker<Void, Void>() {

				@Override
				protected Void doInBackground() throws Exception {

					loadingFrame.setVisible(true);

					try {

						if (!isCancelled())
							almacenDatos.updateCustomer(e);

					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
				}

				@Override
				protected void done() {
					if (!isCancelled()) {
						try {

							loadingFrame.doDefaultCloseAction();
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					} else {
						vista.dispose();
					}

				}

			};

			loadingFrame = new LoadingFrame(task);
			MainController.addInternalFrame(loadingFrame);

			loadingFrame.getLblTask().setText("Updating DataBase");

			task.execute();

		}

	}
	
	
	
}
