package es.mordorLloguer.vistas;


import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.alee.laf.text.WebPasswordField;
import com.alee.laf.text.WebTextField;

import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JProgressBar;
import javax.swing.JButton;

public class LogInFrame extends JInternalFrame {
	
	
	private WebTextField usernameField;
	private WebPasswordField passwordField;
	private JButton btnLogIn;
	private JProgressBar progressBar;


	public JTextField getUsernameField() {
		return usernameField;
	}


	public void setUsernameField(WebTextField usernameField) {
		this.usernameField = usernameField;
	}


	/**
	 * Create the frame.
	 */
	public LogInFrame() {
		setClosable(true);
		setBounds(100, 100, 431, 302);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 395, Short.MAX_VALUE)
						.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 337, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 56, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		btnLogIn = new JButton("LOGIN");
		btnLogIn.setFont(new Font("Dialog", Font.BOLD, 24));
		panel_2.add(btnLogIn, BorderLayout.CENTER);
		

		progressBar = new JProgressBar();
		progressBar.setForeground(Color.GREEN);
		progressBar.setIndeterminate(true);
		progressBar.setVisible(false);
		panel_2.add(progressBar, BorderLayout.NORTH);
		
		
		usernameField = new WebTextField();
		usernameField.setColumns(10);
		usernameField.setInputPrompt("Enter UserName");
		
		passwordField = new WebPasswordField();
		passwordField.setInputPrompt("Enter Password");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.LEADING)
						.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 315, Short.MAX_VALUE))
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(17)
					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		panel_1.setLayout(gl_panel_1);
		
		JLabel lblTitle = new JLabel("LOGIN");
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 32));
		panel.add(lblTitle);
		getContentPane().setLayout(groupLayout);

	}


	public WebTextField getTextField() {
		return usernameField;
	}


	public void setTextField(WebTextField textField) {
		this.usernameField = textField;
	}


	public WebPasswordField getPasswordField() {
		return passwordField;
	}


	public void setPasswordField(WebPasswordField passwordField) {
		this.passwordField = passwordField;
	}


	public JButton getBtnLogIn() {
		return btnLogIn;
	}


	public void setBtnLogIn(JButton btnLogIn) {
		this.btnLogIn = btnLogIn;
	}


	public JProgressBar getProgressBar() {
		return progressBar;
	}


	public void setProgressBar(JProgressBar progressBar) {
		this.progressBar = progressBar;
	}
	
	
	
	
}
