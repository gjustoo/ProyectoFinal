package es.mordorLloguer.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableColumn;

import com.alee.laf.table.editors.WebDateEditor;

import es.mordorLloguer.model.Empleado;
import es.mordorLloguer.model.AlmacenDatosDB;
import es.mordorLloguer.vistas.EmployeeTable;
import es.mordorLloguer.vistas.AddEmployee;
import es.mordorLloguer.vistas.LoadingFrame;

public class EmployeeController implements ActionListener, TableModelListener {

	private EmployeeTable vista;
	private LoadingFrame loadingFrame;
	private AlmacenDatosDB almacenDatos;
	private AddEmployee aeframe;

	private MyTableModel mtm;

	private static EmployeeController controller;

	public EmployeeController(EmployeeTable employeeTable, AlmacenDatosDB almacenDatos) {

		this.almacenDatos = almacenDatos;
		this.vista = employeeTable;
		controller = this;
		inicializar();

	}

	private void inicializar() {
		// TODO Auto-generated method stub

		vista.getBtnAdd().addActionListener(this);
		vista.getBtnDelete().addActionListener(this);
		vista.getOrdersBox().addActionListener(this);
		vista.getSortBox().addActionListener(this);
		vista.getMntmAddRow().addActionListener(this);
		vista.getMntmDeleteRow().addActionListener(this);

		vista.getOrdersBox().setActionCommand("Ordenar por campos");
		vista.getSortBox().setActionCommand("Ordenar por sort");
		vista.getBtnAdd().setActionCommand("addEmployee");
		vista.getBtnDelete().setActionCommand("deleteEmployee");
		vista.getMntmAddRow().setActionCommand("addEmployee");
		vista.getMntmDeleteRow().setActionCommand("deleteEmployee");

	}

	public void go() {
		MainController.addInternalFrame(vista);
		sort();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		String command = e.getActionCommand();
		if (command.equals("Ordenar por campos")) {
			sort();
		} else if (command.equals("Ordenar por sort")) {
			sort();
		} else if (command.equals("addEmployee")) {
			addEmployee();
			sort();
		} else if (command.equals("deleteEmployee")) {
			deleteEmployee();
		} else if (command.equals("Añadir Empleado por mntm")) {
			sort();
		} else if (command.equals("Ordenar por sort")) {
			sort();
		} else if (command.equals("submitEmpleado")) {
			addEmpleado();
		}

	}

	private void deleteEmployee() {

		int row = vista.getTable().getSelectedRow();

		String dni = String.valueOf(vista.getTable().getValueAt(row, 0));

		if (almacenDatos.deleteEmployee(dni)) {
			mtm.removeElement(new Empleado(dni));
			JOptionPane.showMessageDialog(vista, "Employee deleted", "Succes", JOptionPane.INFORMATION_MESSAGE);

		} else {
			JOptionPane.showMessageDialog(vista, "Could not delete Employee", "Error", JOptionPane.ERROR_MESSAGE);

		}

	}

	private void addEmpleado() {
		// TODO Auto-generated method stub

		String dni, name, surnames, birthday, email, domicilio, cp, role, password;

		dni = aeframe.getDniTextField().getText();
		name = aeframe.getNameTextField().getText();
		surnames = aeframe.getSurnameTextField().getText();
		birthday = aeframe.getDatetextField().getDate().toString();
		email = aeframe.getEmailTextField().getText();
		domicilio = aeframe.getAdressTextField().getText();
		cp = aeframe.getPostalCodeTextField().getText();
		role = String.valueOf(aeframe.getComboBox().getSelectedItem());
		password = String.valueOf(aeframe.getPasswordField().getPassword());
		if (almacenDatos.addEmpleado(dni, name, surnames, domicilio, cp, email, birthday, role, password)) {
			JOptionPane.showMessageDialog(vista, "Employee Added", "Succes", JOptionPane.INFORMATION_MESSAGE);
			aeframe.doDefaultCloseAction();
			sort();
		} else {
			JOptionPane.showMessageDialog(vista, "Could not add Employee", "Error", JOptionPane.ERROR_MESSAGE);

		}
	}

	private void addEmployee() {
		// TODO Auto-generated method stub
		aeframe = new AddEmployee();

		if (!MainController.isOpen(aeframe)) {

			MainController.addInternalFrame(aeframe);
			aeframe.setVisible(true);
			aeframe.getBtnAdd().addActionListener(this);
			aeframe.getBtnAdd().setActionCommand("submitEmpleado");

		}

	}

	private void sort() {

		SwingWorker<Void, Void> task = new SwingWorker<Void, Void>() {

			ArrayList<Empleado> empleados;

			@Override
			protected Void doInBackground() throws Exception {

				loadingFrame.setVisible(true);

				try {

					if (!isCancelled())
						empleados = almacenDatos.getEmpleadosOrdenadosBy(
								(String) vista.getOrdersBox().getSelectedItem(), vista.getSortBox().getSelectedIndex());

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

						mtm = new MyEmployeeTableModel(empleados);
						vista.getTable().setModel(mtm);

						vista.getTable().setDefaultEditor(Date.class, new WebDateEditor());

						JComboBox<String> comboBox = new JComboBox<String>();
						comboBox.addItem("mecanico");
						comboBox.addItem("administrativo");
						comboBox.addItem("comercial");
						comboBox.addItem("gerente");

						TableColumn column = vista.getTable().getColumn("Cargo");
						column.setCellEditor(new DefaultCellEditor(comboBox));

						mtm.addTableModelListener(controller);

						vista.getTable().addMouseListener(new MouseAdapter() {
							@Override
							public void mouseReleased(MouseEvent e) {
								if (e.getButton() == MouseEvent.BUTTON3) {

									int row = vista.getTable().rowAtPoint(e.getPoint());

									if (vista.getTable().getSelectedRowCount() <= 1) {
										vista.getTable().setSelectedRow(row);
										vista.getPopupMenu().show(vista.getTable(), e.getX(), e.getY());

									} else if (vista.getTable().getSelectedRowCount() > 1) {
										vista.getPopupMenu().show(vista.getTable(), e.getX(), e.getY());
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

	private class MyEmployeeTableModel extends MyTableModel<Empleado> {

		public MyEmployeeTableModel(List<Empleado> data) {
			super(Arrays.asList("DNI", "Nombre", "Apellidos", "Domicilio", "CP", "Email", "Nacimiento", "Cargo" ),
					data);

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
				data.get(rowIndex).setCP(aValue.toString());
				break;
			case 5:
				data.get(rowIndex).setEmail(aValue.toString());
				break;
			case 6:
				java.util.Date fecha = (java.util.Date) aValue;
				data.get(rowIndex).setFechaNac(new java.sql.Date(fecha.getTime()));
				break;
			case 7:
				data.get(rowIndex).setCargo(aValue.toString());
				break;

			}
			fireTableCellUpdated(rowIndex, columnIndex);

		}

		@Override
		public Object getValueAt(int row, int col) {
			switch (col) {
			case 0:
				return data.get(row).getDNI();
			case 1:
				return data.get(row).getNombre();
			case 2:
				return data.get(row).getApellidos();
			case 3:
				return data.get(row).getDomicilio();
			case 4:
				return data.get(row).getCP();
			case 5:
				return data.get(row).getEmail();
			case 6:
				return data.get(row).getFechaNac();
			case 7:
				return data.get(row).getCargo();
			}
			return null;
		}

		
	}

	@Override
	public void tableChanged(TableModelEvent arg0) {

		if (arg0.getType() == TableModelEvent.UPDATE) {
			MyEmployeeTableModel mtm = (MyEmployeeTableModel) vista.getTable().getModel();
			Empleado e = mtm.getElement(arg0.getFirstRow());

			SwingWorker<Void, Void> task = new SwingWorker<Void, Void>() {

				@Override
				protected Void doInBackground() throws Exception {

					loadingFrame.setVisible(true);

					try {

						if (!isCancelled())
							almacenDatos.updateEmpleado(e);

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
