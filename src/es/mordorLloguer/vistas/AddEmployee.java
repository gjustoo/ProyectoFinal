package es.mordorLloguer.vistas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.alee.laf.text.WebPasswordField;
import com.github.lgooddatepicker.components.DatePicker;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.FlowLayout;

@SuppressWarnings("serial")
public class AddEmployee extends JInternalFrame {
	private JTextField AdressTextField;
	private JTextField PostalCodeTextField;
	private JButton btnAdd;
	private JComboBox<String> comboBox;
	private WebPasswordField passwordtextField;
	private JTextField dniTextField;
	private JTextField nameTextField;
	private JTextField emailTextField;
	private JTextField SurnameTextField;
	private DatePicker DateTextField;


	/**
	 * Create the frame.
	 */
	public AddEmployee() {
		setClosable(true);
		setBounds(100, 100, 596, 386);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_4 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 570, GroupLayout.PREFERRED_SIZE)
								.addGap(1080))
							.addComponent(panel_4, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 573, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(panel, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 52, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 45, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		panel_4.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		
		btnAdd = new JButton("Add");
		btnAdd.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_4.add(btnAdd);
		
		JPanel panel_2 = new JPanel();
		
		JPanel panel_3 = new JPanel();
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 284, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 286, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 231, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 229, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		
		JLabel lblNewLabel = new JLabel("Address");
		
		AdressTextField = new JTextField();
		AdressTextField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Postal Code");
		
		JLabel lblNewLabel_2 = new JLabel("Role");
		
		comboBox = new JComboBox();
		comboBox.addItem("mecanico");
		comboBox.addItem("administrativo");
		comboBox.addItem("comercial");
		comboBox.addItem("gerente");
		
		PostalCodeTextField = new JTextField();
		PostalCodeTextField.setColumns(10);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel_3.createSequentialGroup()
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(lblNewLabel)
							.addGap(18)
							.addComponent(AdressTextField, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(lblNewLabel_1)
							.addGap(4)
							.addComponent(PostalCodeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel_3.createSequentialGroup()
							.addComponent(lblNewLabel_2)
							.addGap(40)
							.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, 86, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGap(4)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel))
						.addComponent(AdressTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(3)
							.addComponent(lblNewLabel_1))
						.addComponent(PostalCodeTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_3.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_3.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel_2))
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(120, Short.MAX_VALUE))
		);
		panel_3.setLayout(gl_panel_3);
		
		JLabel lblSurname = new JLabel("Surnames");
		
		JLabel lblBirthDay = new JLabel("Birthday");
		
		JLabel lblName = new JLabel("Name");
		
		JLabel lbldni = new JLabel("DNI");
		
		JLabel lblEmail = new JLabel("Email");
		
		dniTextField = new JTextField();
		dniTextField.setColumns(10);
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		
		emailTextField = new JTextField();
		emailTextField.setColumns(10);
		
		SurnameTextField = new JTextField();
		SurnameTextField.setColumns(10);
		
		DateTextField = new DatePicker();
		DateTextField.getComponentDateTextField().setEditable(false);
		
		JLabel lblPassword = new JLabel("Password");
		
		passwordtextField = new WebPasswordField();
		passwordtextField.setColumns(10);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_2.createSequentialGroup()
							.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
								.addGroup(gl_panel_2.createSequentialGroup()
									.addComponent(lbldni)
									.addPreferredGap(ComponentPlacement.RELATED, 185, GroupLayout.PREFERRED_SIZE))
								.addGroup(gl_panel_2.createSequentialGroup()
									.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
										.addGroup(gl_panel_2.createSequentialGroup()
											.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
												.addComponent(lblBirthDay)
												.addComponent(lblEmail)
												.addComponent(lblPassword))
											.addGap(18)
											.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
												.addComponent(passwordtextField, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
												.addComponent(DateTextField, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(emailTextField, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)
												.addComponent(dniTextField, GroupLayout.DEFAULT_SIZE, 139, Short.MAX_VALUE)))
										.addGroup(gl_panel_2.createSequentialGroup()
											.addComponent(lblSurname)
											.addGap(18)
											.addGroup(gl_panel_2.createParallelGroup(Alignment.LEADING)
												.addComponent(nameTextField, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
												.addComponent(SurnameTextField, GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE))))
									.addGap(27)))
							.addGap(71))
						.addGroup(gl_panel_2.createSequentialGroup()
							.addComponent(lblName)
							.addContainerGap(247, Short.MAX_VALUE))))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addGap(9)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblName)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblSurname)
						.addComponent(SurnameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(emailTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmail))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
						.addComponent(DateTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblBirthDay))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(lbldni)
						.addComponent(dniTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_panel_2.createParallelGroup(Alignment.TRAILING)
						.addComponent(passwordtextField, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblPassword))
					.addGap(48))
		);
		panel_2.setLayout(gl_panel_2);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblAddEmployee = new JLabel("Add employee");
		lblAddEmployee.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 24));
		lblAddEmployee.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblAddEmployee);
		getContentPane().setLayout(groupLayout);

	}


	public JTextField getDniTextField() {
		return dniTextField;
	}


	public JTextField getNameTextField() {
		return nameTextField;
	}


	public JTextField getSurnameTextField() {
		return SurnameTextField;
	}


	public DatePicker getDatetextField() {
		return DateTextField;
	}


	public JTextField getAdressTextField() {
		return AdressTextField;
	}


	public JTextField getPostalCodeTextField() {
		return PostalCodeTextField;
	}


	public JTextField getEmailTextField() {
		return emailTextField;
	}

	public WebPasswordField getPasswordField() {
		return passwordtextField;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}


	public JComboBox getComboBox() {
		return comboBox;
	}
}
