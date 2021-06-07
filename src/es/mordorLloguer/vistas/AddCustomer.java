package es.mordorLloguer.vistas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.github.lgooddatepicker.components.DatePicker;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JComboBox;

public class AddCustomer extends JInternalFrame {
	
	private JTextField DniTextField;
	private JTextField nombreTextField;
	private JTextField apellidosTextField;
	private JTextField domicilioTextField;
	private JTextField cpTextField;
	private JTextField emailTextField;
	private DatePicker dateTextField;
	private JButton btnAdd;
	private JButton btnCancel;
	private JComboBox carnetBox;


	/**
	 * Create the frame.
	 */
	public AddCustomer() {
		setClosable(true);
		setBounds(100, 100, 610, 453);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 579, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addGap(14)
							.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 563, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(21, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(22, Short.MAX_VALUE))
		);
		FlowLayout fl_panel_2 = new FlowLayout(FlowLayout.RIGHT, 5, 5);
		fl_panel_2.setAlignOnBaseline(true);
		panel_2.setLayout(fl_panel_2);
		
		btnAdd = new JButton("Add");
		panel_2.add(btnAdd);
		
		btnCancel = new JButton("Cancel");
		panel_2.add(btnCancel);
		
		JLabel lblDni = new JLabel("DNI");
		
		DniTextField = new JTextField();
		DniTextField.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre");
		
		nombreTextField = new JTextField();
		nombreTextField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Apellidos");
		
		apellidosTextField = new JTextField();
		apellidosTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Domicilio");
		
		domicilioTextField = new JTextField();
		domicilioTextField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CP");
		
		cpTextField = new JTextField();
		cpTextField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Email");
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		
		
		
		
		dateTextField = new DatePicker();
		dateTextField.getComponentDateTextField().setEditable(false);
		
		JLabel lblNewLabel_4 = new JLabel("Fecha De Nacimiento");
		lblNewLabel_4.setToolTipText("Introduce tu fecha de nacimiento");
		
		JLabel lblPhoto = new JLabel("Photo");
		lblPhoto.setForeground(Color.BLACK);
		lblPhoto.setBackground(new Color(0, 255, 0));
		lblPhoto.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel lblNewLabel_5 = new JLabel("Carnet");
		
		carnetBox = new JComboBox();
		carnetBox.addItem("A");
		carnetBox.addItem("B");
		carnetBox.addItem("C");
		carnetBox.addItem("D");
		carnetBox.addItem("E");
		carnetBox.addItem("Z");
		carnetBox.setSelectedIndex(0);
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_1.createSequentialGroup()
									.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(lblNewLabel_4)
											.addGap(10)
											.addComponent(dateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(lblNewLabel_3)
											.addGap(18)
											.addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
											.addPreferredGap(ComponentPlacement.RELATED))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(lblNewLabel_2)
											.addGap(18)
											.addComponent(cpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addComponent(lblNewLabel_1)
											.addGap(18)
											.addComponent(domicilioTextField, 158, 158, 158))
										.addGroup(gl_panel_1.createSequentialGroup()
											.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(lblNewLabel)
												.addComponent(lblNombre)
												.addComponent(lblDni))
											.addGap(18)
											.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
												.addComponent(DniTextField, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
												.addComponent(nombreTextField, GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
												.addComponent(apellidosTextField, 156, 156, 156))))
									.addGap(49))
								.addGroup(gl_panel_1.createSequentialGroup()
									.addComponent(lblNewLabel_5)
									.addGap(10)
									.addComponent(carnetBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED)))
							.addGap(255))
						.addComponent(lblPhoto, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)))
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDni)
						.addComponent(DniTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNombre)
						.addComponent(nombreTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(12)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel)
						.addComponent(apellidosTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_1)
						.addComponent(domicilioTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNewLabel_2)
						.addComponent(cpTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(8)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_3))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(dateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_4))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.TRAILING)
						.addComponent(carnetBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_5))
					.addContainerGap(16, Short.MAX_VALUE))
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(lblPhoto, GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
					.addGap(22))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblAddCustomer = new JLabel("Add Customer");
		lblAddCustomer.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 24));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAddCustomer)
					.addContainerGap(523, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addComponent(lblAddCustomer)
					.addContainerGap(37, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		getContentPane().setLayout(groupLayout);

	}


	public JTextField getDniTextField() {
		return DniTextField;
	}


	public JTextField getNombreTextField() {
		return nombreTextField;
	}


	public JTextField getApellidosTextField() {
		return apellidosTextField;
	}


	public JTextField getDomicilioTextField() {
		return domicilioTextField;
	}


	public JTextField getCpTextField() {
		return cpTextField;
	}


	public JTextField getEmailTextField() {
		return emailTextField;
	}


	public DatePicker getDateTextField() {
		return dateTextField;
	}


	public JComboBox getCarnetBox() {
		return carnetBox;
	}


	public JButton getBtnAdd() {
		return btnAdd;
	}


	public JButton getBtnCancel() {
		return btnCancel;
	}
}
