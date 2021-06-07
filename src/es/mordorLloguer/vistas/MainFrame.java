package es.mordorLloguer.vistas;

import java.awt.BorderLayout;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JToolBar;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JSeparator;
import javax.swing.SwingConstants;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private JButton btnLogIn;
	private JButton btnLogOut;
	private JButton btnEmployees;
	private JDesktopPane desktopPane;
	private JMenuItem mntmExit;
	private JMenuItem mntmPreferences;
	private JButton btnCustomers;
	private JButton btnVehicles;

	

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnApp = new JMenu("App");
		menuBar.add(mnApp);
		
		mntmPreferences = new JMenuItem("Preferences");
		mntmPreferences.setHorizontalAlignment(SwingConstants.RIGHT);
		mnApp.add(mntmPreferences);
		
		JSeparator separator = new JSeparator();
		mnApp.add(separator);
		
		mntmExit = new JMenuItem("Exit");
		mntmExit.setHorizontalAlignment(SwingConstants.RIGHT);
		mnApp.add(mntmExit);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JToolBar toolBar = new JToolBar();
		contentPane.add(toolBar, BorderLayout.NORTH);
		
		btnLogIn = new JButton("LogIn");
		
		btnLogIn.setIcon(new ImageIcon(MainFrame.class.getResource("/es/mordorLloguer/resources/login.png")));
		toolBar.add(btnLogIn);
		
		btnLogOut = new JButton("LogOut");
		btnLogOut.setIcon(new ImageIcon(MainFrame.class.getResource("/es/mordorLloguer/resources/logout.png")));
		toolBar.add(btnLogOut);
		
		toolBar.addSeparator ( new Dimension ( 10, 10 ) );
		
		btnEmployees = new JButton("Employees");
		btnEmployees.setIcon(new ImageIcon(MainFrame.class.getResource("/es/mordorLloguer/resources/employe.png")));
		toolBar.add(btnEmployees);
		
		btnCustomers = new JButton("Customers");
		toolBar.add(btnCustomers);
		btnCustomers.setEnabled(false);
		
		btnVehicles = new JButton("Vehicles");
		btnVehicles.setEnabled(false);
		toolBar.add(btnVehicles);
		
		desktopPane = new JDesktopPane();
		contentPane.add(desktopPane, BorderLayout.SOUTH);
	}

	public JMenuItem getMntmPreferences() {
		return mntmPreferences;
	}

	public JPanel getContentPane() {
		return contentPane;
	}

	public JMenuItem getMntmExit() {
		return mntmExit;
	}

	public JDesktopPane getDesktopPane() {
		return desktopPane;
	}
	
	public JButton getBtnCustomers() {
		return btnCustomers;
	}

	public void setDesktopPane(JDesktopPane desktopPane) {
		this.desktopPane = desktopPane;
	}

	public JButton getBtnEmployees() {
		return btnEmployees;
	}

	public void setBtnEmployees(JButton btnEmployees) {
		this.btnEmployees = btnEmployees;
	}

	public JButton getBtnLogIn() {
		return btnLogIn;
	}

	public void setBtnLogIn(JButton btnLogIn) {
		this.btnLogIn = btnLogIn;
	}

	public JButton getBtnLogOut() {
		return btnLogOut;
	}
	public JButton getBtnVehicle() {
		return btnVehicles;
	}

	public void setBtnLogOut(JButton btnLogOut) {
		this.btnLogOut = btnLogOut;
	}
}
