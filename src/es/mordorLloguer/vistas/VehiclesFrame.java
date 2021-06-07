package es.mordorLloguer.vistas;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import es.mordorLloguer.model.Camion;
import es.mordorLloguer.model.Coche;
import es.mordorLloguer.model.Furgoneta;
import es.mordorLloguer.model.MicroBus;
import es.mordorLloguer.model.MyCarTableModel;
import es.mordorLloguer.model.MyMicroBusTableModel;
import es.mordorLloguer.model.MyTruckTableModel;
import es.mordorLloguer.model.MyVanTableModel;

import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JButton;
import java.awt.FlowLayout;

public class VehiclesFrame extends JInternalFrame {


	private JTabbedPane tabbedPane;
	private JPVehiculo panelCar ;
	private JPVehiculo panelVan ;
	private JPVehiculo panelTruck ;
	private JPVehiculo panelMicrobus;
	private JButton btnDeleteVehicle;
	private JButton btnAdd;
	
	
	
	/**
	 * Create the frame.
	 */
	public VehiclesFrame() {
		setClosable(true);
		setBounds(100, 100, 783, 520);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);

		 tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());

		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 747, GroupLayout.PREFERRED_SIZE)
						.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 742, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(tabbedPane, GroupLayout.PREFERRED_SIZE, 412, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 13, Short.MAX_VALUE)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		
		btnAdd = new JButton("Add");
		panel_1.add(btnAdd);
		
		btnDeleteVehicle = new JButton("Delete");
		panel_1.add(btnDeleteVehicle);
		
		
		 panelCar = new JPVehiculo();
		 panelVan = new JPVehiculo();
		 panelTruck = new JPVehiculo();
		 panelMicrobus = new JPVehiculo();
		
		
		
		 
		
		
		tabbedPane.addTab("Car", null, panelCar, null);
		tabbedPane.addTab("Van", null, panelVan, null);
		tabbedPane.addTab("Truck", null, panelTruck, null);		
		tabbedPane.addTab("Microbus", null, panelMicrobus, null);
		
		getContentPane().setLayout(groupLayout);

	}



	
	



	public JButton getBtnDeleteVehicle() {
		return btnDeleteVehicle;
	}








	public JButton getBtnAdd() {
		return btnAdd;
	}








	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}



	public JPVehiculo getPanelCar() {
		return panelCar;
	}



	public JPVehiculo getPanelVan() {
		return panelVan;
	}



	public JPVehiculo getPanelTruck() {
		return panelTruck;
	}



	public JPVehiculo getPanelMicrobus() {
		return panelMicrobus;
	}
}
