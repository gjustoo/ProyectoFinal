package es.mordorLloguer.vistas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.alee.laf.text.WebPasswordField;
import com.alee.laf.text.WebTextField;

import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class PreferencesFrame extends JInternalFrame {
	private WebTextField DriverTextField;
	private WebTextField URLTextField;
	private WebTextField UserTextField;
	private WebPasswordField PsswrdTextField;
	private JButton btnSave;

	
	/**
	 * Create the frame.
	 */
	public PreferencesFrame() {
		setBounds(100, 100, 395, 424);
		setClosable(true);
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 360, GroupLayout.PREFERRED_SIZE)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 361, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 278, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(12, Short.MAX_VALUE))
		);
		
		JLabel lblDriver = new JLabel("Driver :");
		
		JLabel lblURL = new JLabel("URL : ");
		
		JLabel lblDBUser = new JLabel("DB User :");
		
		JLabel lblDBPsswd = new JLabel("DB Password : ");
		
		DriverTextField = new WebTextField();
		DriverTextField.setColumns(10);
		
		URLTextField = new WebTextField();
		URLTextField.setColumns(10);
		
		UserTextField = new WebTextField();
		UserTextField.setColumns(10);
		
		PsswrdTextField = new WebPasswordField();
		PsswrdTextField.setColumns(10);
		
		btnSave = new JButton("Save");
		
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel_1.createSequentialGroup()
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(lblDBPsswd)
								.addComponent(lblDBUser)
								.addComponent(lblURL)
								.addComponent(lblDriver))
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
								.addComponent(DriverTextField, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
								.addComponent(PsswrdTextField, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
								.addComponent(UserTextField, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
								.addComponent(URLTextField, GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)))
						.addGroup(Alignment.TRAILING, gl_panel_1.createSequentialGroup()
							.addContainerGap(262, Short.MAX_VALUE)
							.addComponent(btnSave)))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addGap(23)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDriver)
						.addComponent(DriverTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblURL)
						.addComponent(PsswrdTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDBUser)
						.addComponent(UserTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblDBPsswd)
						.addComponent(URLTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED, 87, Short.MAX_VALUE)
					.addComponent(btnSave)
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTitle = new JLabel("DB LogIn Preferences");
		lblTitle.setFont(new Font("Yu Gothic Light", Font.PLAIN, 21));
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTitle, BorderLayout.CENTER);
		getContentPane().setLayout(groupLayout);

	}


	public WebTextField getDriverTextField() {
		return DriverTextField;
	}


	public WebTextField getURLTextField() {
		return URLTextField;
	}


	public WebTextField getUserTextField() {
		return UserTextField;
	}


	public WebPasswordField getPsswrdTextField() {
		return PsswrdTextField;
	}


	public JButton getBtnSave() {
		return btnSave;
	}
	
	
	
	
	
	
}
