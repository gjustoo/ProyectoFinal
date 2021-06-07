package es.mordorLloguer.vistas;

import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class JPVehiculo extends JPanel{

	
	private JTable table;
	private JTextField modelTextField;
	private JTextField registrationTextField;
	private JComboBox engineComboBox;
	private JComboBox licenseComboBox;

	/**
	 * Create the panel.
	 */
	public JPVehiculo() {
		
		JPanel panelSearch = new JPanel();
		
		JScrollPane scrollPane = new JScrollPane();
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(scrollPane, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE)
						.addComponent(panelSearch, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 426, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelSearch, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(scrollPane, GroupLayout.DEFAULT_SIZE, 233, Short.MAX_VALUE)
					.addContainerGap())
		);
		panelSearch.setLayout(new MigLayout("", "[28.00][153.00][68.00][109.00][46.00][91.00][][grow]", "[]"));
		
		JLabel lblModel = new JLabel("Model");
		panelSearch.add(lblModel, "cell 0 0,alignx trailing");
		
		modelTextField = new JTextField();
		panelSearch.add(modelTextField, "flowx,cell 1 0,growx");
		modelTextField.setColumns(10);
		
		JLabel lblRegistration = new JLabel("Registration");
		panelSearch.add(lblRegistration, "cell 2 0,alignx trailing,aligny center");
		
		registrationTextField = new JTextField();
		panelSearch.add(registrationTextField, "cell 3 0,growx");
		registrationTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Engine");
		panelSearch.add(lblNewLabel, "cell 4 0,alignx trailing");
		
		engineComboBox = new JComboBox();
		engineComboBox.addItem("ALL");
		panelSearch.add(engineComboBox, "cell 5 0,growx");
		
		JLabel lblNewLabel_1 = new JLabel("License");
		panelSearch.add(lblNewLabel_1, "cell 6 0,alignx trailing");
		
		licenseComboBox = new JComboBox();
		licenseComboBox.addItem("ALL");
		panelSearch.add(licenseComboBox, "cell 7 0,growx");
		
		table = new JTable();
		scrollPane.setViewportView(table);
		setLayout(groupLayout);

	}

	public JTable getTable() {
		return table;
	}

	public void setEngineComboBox(JComboBox combobox) {
		this.engineComboBox =combobox;
	}
	public JTextField getModelTextField() {
		return modelTextField;
	}

	public JTextField getRegistrationTextField() {
		return registrationTextField;
	}

	public JComboBox getEngineComboBox() {
		return engineComboBox;
	}

	public JComboBox getLicenseComboBox() {
		return licenseComboBox;
	}
	
	
}
