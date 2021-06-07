package es.mordorLloguer.vistas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class AddVehicle extends JInternalFrame {
	private JTextField matriculaTextField;
	private JTextField marcaTextField;
	private JTextField colorTextField;
	private JTextField motorTextField;
	private JTextField cilindradaTextField;
	private JTextField descTextField;
	private DatePicker dateField;
	private JPanel specificPanel;
	private JButton btnAddVehicle;

	
	
	
	/**
	 * Create the frame.
	 */
	public AddVehicle() {
		setBounds(100, 100, 673, 456);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		specificPanel = new JPanel();
		
		JPanel panel_2 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 319, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)
								.addComponent(specificPanel, GroupLayout.PREFERRED_SIZE, 317, GroupLayout.PREFERRED_SIZE)))
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 59, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(specificPanel, GroupLayout.PREFERRED_SIZE, 244, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		
		btnAddVehicle = new JButton("Add Vehicle");
		panel_2.add(btnAddVehicle);
		
		JLabel lblNewLabel = new JLabel("Matricula");
		
		matriculaTextField = new JTextField();
		matriculaTextField.setColumns(10);
		
		marcaTextField = new JTextField();
		marcaTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Marca");
		
		colorTextField = new JTextField();
		colorTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Color");
		
		motorTextField = new JTextField();
		motorTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Motor");
		
		cilindradaTextField = new JTextField();
		cilindradaTextField.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Cilindrada");
		
		JLabel lblNewLabel_5 = new JLabel("Estado");
		
		JComboBox estadoComboBox = new JComboBox();
		estadoComboBox.setModel(new DefaultComboBoxModel(new String[] {"Preparado", "Alquilado"}));
		
		descTextField = new JTextField();
		descTextField.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Descripcion");
		
		JComboBox carnetComboBox = new JComboBox();
		carnetComboBox.setModel(new DefaultComboBoxModel(new String[] {"A", "B", "C", "D", "E", "Z"}));
		
		JLabel lblNewLabel_7 = new JLabel("Carnet");
		
		dateField = new DatePicker();
		dateField.getComponentDateTextField().setEditable(false);
		JLabel lblNewLabel_8 = new JLabel("Fecha Adquisicion");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(lblNewLabel_8)
						.addComponent(lblNewLabel)
						.addComponent(lblNewLabel_1)
						.addComponent(lblNewLabel_6)
						.addComponent(lblNewLabel_7)
						.addComponent(lblNewLabel_5)
						.addComponent(lblNewLabel_4)
						.addComponent(lblNewLabel_3)
						.addComponent(lblNewLabel_2))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING, false)
						.addComponent(dateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(carnetComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(estadoComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(colorTextField, GroupLayout.DEFAULT_SIZE, 158, Short.MAX_VALUE)
						.addComponent(motorTextField)
						.addComponent(cilindradaTextField)
						.addComponent(marcaTextField)
						.addComponent(matriculaTextField)
						.addComponent(descTextField))
					.addContainerGap(56, Short.MAX_VALUE))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(matriculaTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(marcaTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(colorTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_2))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(motorTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(cilindradaTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(estadoComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(carnetComboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_7))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(descTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_6))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(dateField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_8))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		FlowLayout fl_panel = new FlowLayout(FlowLayout.LEFT, 5, 20);
		panel.setLayout(fl_panel);
		
		JLabel lblAddVehicle = new JLabel("Add Vechile");
		lblAddVehicle.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 24));
		panel.add(lblAddVehicle);
		getContentPane().setLayout(groupLayout);

	}




	public JPanel getSpecificPanel() {
		return specificPanel;
	}




	public void setSpecificPanel(JPanel specificPanel) {
		this.specificPanel = specificPanel;
	}




	public JTextField getMatriculaTextField() {
		return matriculaTextField;
	}




	public JTextField getMarcaTextField() {
		return marcaTextField;
	}




	public JTextField getColorTextField() {
		return colorTextField;
	}




	public JTextField getMotorTextField() {
		return motorTextField;
	}




	public JTextField getCilindradaTextField() {
		return cilindradaTextField;
	}




	public JTextField getDescTextField() {
		return descTextField;
	}




	public DatePicker getDateField() {
		return dateField;
	}
	
	
}
