package es.mordorLloguer.controladores;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.swing.SwingWorker;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import es.mordorLloguer.model.AlmacenDatosDB;
import es.mordorLloguer.model.Camion;
import es.mordorLloguer.model.Coche;
import es.mordorLloguer.model.Furgoneta;
import es.mordorLloguer.model.MicroBus;
import es.mordorLloguer.model.MyCarTableModel;
import es.mordorLloguer.model.MyMicroBusTableModel;
import es.mordorLloguer.model.MyTruckTableModel;
import es.mordorLloguer.model.MyVanTableModel;
import es.mordorLloguer.vistas.LoadingFrame;
import es.mordorLloguer.vistas.VehiclesFrame;
import es.mordorLloguer.model.SimpleDocumentListener;


public class VehicleController implements ActionListener, TableModelListener {

	
	//TO DO 
	//
	// ADD;DELETE;UPDATE.
	//
	//
	// Me falta el añadir y modificar,eliminar, no me ha dado tiempo, perdi mucho haciendo los combobox variables y los filtros dinamicos;
	//
	//
	
	
	private AlmacenDatosDB almacenDatos;
	private VehiclesFrame vFrame;
	private LoadingFrame loadingFrame;
	
	private ArrayList<Coche> coches;
	private ArrayList<Camion> camiones;
	private ArrayList<Furgoneta> furgonetas;
	private ArrayList<MicroBus> microbuses;
	
	private VehicleController controller ;
	
	private MyVanTableModel mvtm;
	private MyTruckTableModel mttm;
	private MyMicroBusTableModel mmtm;
	private MyCarTableModel mctm;

	
	
	public VehicleController(VehiclesFrame vFrame,AlmacenDatosDB almacenDatos) {
		this.almacenDatos = almacenDatos;
		this.vFrame=vFrame;
		controller = this;
		inicializar();
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		String command = e.getActionCommand();
		
		
		if(command.equals("filtervehicles")) {
			filter();
		}
		
	}
	
	
	public void inicializar() {
		
		vFrame.getPanelCar().getEngineComboBox().addActionListener(controller);
		vFrame.getPanelCar().getLicenseComboBox().addActionListener(controller);
		
		vFrame.getPanelVan().getEngineComboBox().addActionListener(controller);
		vFrame.getPanelVan().getLicenseComboBox().addActionListener(controller);
		
		vFrame.getPanelTruck().getEngineComboBox().addActionListener(controller);
		vFrame.getPanelTruck().getLicenseComboBox().addActionListener(controller);
		
		vFrame.getPanelMicrobus().getEngineComboBox().addActionListener(controller);
		vFrame.getPanelMicrobus().getLicenseComboBox().addActionListener(controller);
		
		
		
		vFrame.getPanelCar().getEngineComboBox().setActionCommand("filtervehicles");
		vFrame.getPanelCar().getLicenseComboBox().setActionCommand("filtervehicles");
		
		vFrame.getPanelVan().getEngineComboBox().setActionCommand("filtervehicles");
		vFrame.getPanelVan().getLicenseComboBox().setActionCommand("filtervehicles");
		
		vFrame.getPanelTruck().getEngineComboBox().setActionCommand("filtervehicles");
		vFrame.getPanelTruck().getLicenseComboBox().setActionCommand("filtervehicles");
		
		vFrame.getPanelMicrobus().getEngineComboBox().setActionCommand("filtervehicles");
		vFrame.getPanelMicrobus().getLicenseComboBox().setActionCommand("filtervehicles");
		
		
		vFrame.getPanelCar().getModelTextField().getDocument().addDocumentListener((SimpleDocumentListener) e->{
			filter();
		});
		vFrame.getPanelCar().getRegistrationTextField().getDocument().addDocumentListener((SimpleDocumentListener) e->{
			filter();
		});
		
		vFrame.getPanelVan().getModelTextField().getDocument().addDocumentListener((SimpleDocumentListener) e->{
			filter();
		});
		vFrame.getPanelVan().getRegistrationTextField().getDocument().addDocumentListener((SimpleDocumentListener) e->{
			filter();
		});
		
		vFrame.getPanelTruck().getModelTextField().getDocument().addDocumentListener((SimpleDocumentListener) e->{
			filter();
		});
		vFrame.getPanelTruck().getRegistrationTextField().getDocument().addDocumentListener((SimpleDocumentListener) e->{
			filter();
		});
		
		vFrame.getPanelMicrobus().getModelTextField().getDocument().addDocumentListener((SimpleDocumentListener) e->{
			filter();
		});
		vFrame.getPanelMicrobus().getRegistrationTextField().getDocument().addDocumentListener((SimpleDocumentListener) e->{
			filter();
		});
		
//		sort();
		
	}
	
	@SuppressWarnings("unchecked")
	private void setComboBoxes() {
		
		List<String> c_motores =  coches.stream().map((p)-> p.getMotor()).distinct().collect(Collectors.toList());
				
		for( String a : c_motores) {
			vFrame.getPanelCar().getEngineComboBox().addItem(a);
		}
		
		List<String> camion_motores =  camiones.stream().map((p)-> p.getMotor()).distinct().collect(Collectors.toList());
		
		for( String a : camion_motores) {
			vFrame.getPanelTruck().getEngineComboBox().addItem(a);
		}
		List<String> micro_motores =  microbuses.stream().map((p)-> p.getMotor()).distinct().collect(Collectors.toList());
		
		for( String a : micro_motores) {
			vFrame.getPanelMicrobus().getEngineComboBox().addItem(a);
		}
		List<String> furgoneta_motores =  furgonetas.stream().map((p)-> p.getMotor()).distinct().collect(Collectors.toList());
		
		for( String a : furgoneta_motores) {
			vFrame.getPanelVan().getEngineComboBox().addItem(a);
		}
		
		
		
	}
	
	
@SuppressWarnings("unchecked")
private void setCarnets() {
		

//		mctm.getColumnItems(6).forEach(System.out::println);
	
	
		List<String> c_carnets =  coches.stream().map((p)-> p.getCarnet()).distinct().collect(Collectors.toList());
				
		for( String a : c_carnets) {
			vFrame.getPanelCar().getLicenseComboBox().addItem(a);
		}
		
		List<String> ca_carnets =  camiones.stream().map((p)-> p.getCarnet()).distinct().collect(Collectors.toList());
		
		for( String a : ca_carnets) {
			vFrame.getPanelTruck().getLicenseComboBox().addItem(a);
		}
		List<String> m_carnets =  microbuses.stream().map((p)-> p.getCarnet()).distinct().collect(Collectors.toList());
		
		for( String a : m_carnets) {
			vFrame.getPanelMicrobus().getLicenseComboBox().addItem(a);
		}
		List<String> f_carnets =  furgonetas.stream().map((p)-> p.getCarnet()).distinct().collect(Collectors.toList());
		
		for( String a : f_carnets) {
			vFrame.getPanelVan().getLicenseComboBox().addItem(a);
		}
		
		
		
	}
	
	
	
	
private void filter() {
	
	int selectedIndex = vFrame.getTabbedPane().getSelectedIndex();
	
	System.out.println("Filtering");
	if(selectedIndex == 0) {
		System.out.println("Filtering cars");

		ArrayList<Coche> result;
		boolean sortcarnets = !vFrame.getPanelCar().getLicenseComboBox().getSelectedItem().toString().equals("ALL");
		boolean sortengines = !vFrame.getPanelCar().getEngineComboBox().getSelectedItem().toString().equals("ALL");

	
		result = (ArrayList<Coche>) coches.stream()
	    .filter(p -> p.getMarca().contains(vFrame.getPanelCar().getModelTextField().getText()))
	    .filter(p -> p.getMatricula().contains(vFrame.getPanelCar().getRegistrationTextField().getText()))
	    .filter(sortcarnets? p-> p.getCarnet().equals(vFrame.getPanelCar().getLicenseComboBox().getSelectedItem().toString()): p-> true)
	    .filter(sortengines? p-> p.getMotor().equals(vFrame.getPanelCar().getEngineComboBox().getSelectedItem().toString()): p-> true)
	    .collect(Collectors.toList());
	
		mctm = new MyCarTableModel(result);
		vFrame.getPanelCar().getTable().setModel(mctm);
		
		
	}else if(selectedIndex == 1) {
		System.out.println("Filtering van");

		ArrayList<Furgoneta> result;
		boolean sortcarnets = !vFrame.getPanelVan().getLicenseComboBox().getSelectedItem().toString().equals("ALL");
		boolean sortengines = !vFrame.getPanelVan().getEngineComboBox().getSelectedItem().toString().equals("ALL");

	
		result = (ArrayList<Furgoneta>) furgonetas.stream()
	    .filter(p -> p.getMarca().contains(vFrame.getPanelVan().getModelTextField().getText()))
	    .filter(p -> p.getMatricula().contains(vFrame.getPanelVan().getRegistrationTextField().getText()))
	    .filter(sortcarnets? p-> p.getCarnet().equals(vFrame.getPanelVan().getLicenseComboBox().getSelectedItem().toString()): p-> true)
	    .filter(sortengines? p-> p.getMotor().equals(vFrame.getPanelVan().getEngineComboBox().getSelectedItem().toString()): p-> true)
	    .collect(Collectors.toList());
	
		mvtm = new MyVanTableModel(result);
		vFrame.getPanelVan().getTable().setModel(mvtm);
		
	}else if(selectedIndex == 2) {
		System.out.println("Filtering caamionrs");

		ArrayList<Camion> result;
		boolean sortcarnets = !vFrame.getPanelTruck().getLicenseComboBox().getSelectedItem().toString().equals("ALL");
		boolean sortengines = !vFrame.getPanelTruck().getEngineComboBox().getSelectedItem().toString().equals("ALL");

	
		result = (ArrayList<Camion>) camiones.stream()
	    .filter(p -> p.getMarca().contains(vFrame.getPanelTruck().getModelTextField().getText()))
	    .filter(p -> p.getMatricula().contains(vFrame.getPanelTruck().getRegistrationTextField().getText()))
	    .filter( sortcarnets? p-> p.getCarnet().equals(vFrame.getPanelTruck().getLicenseComboBox().getSelectedItem().toString()): p-> true)
	    .filter( sortengines? p-> p.getMotor().equals(vFrame.getPanelTruck().getEngineComboBox().getSelectedItem().toString()): p-> true)
	    .collect(Collectors.toList());
	
		mttm = new MyTruckTableModel(result);
		vFrame.getPanelTruck().getTable().setModel(mttm);
		
	}else if(selectedIndex == 3) {
		System.out.println("Filtering Mircro");

		ArrayList<MicroBus> result;
		boolean sortcarnets = !vFrame.getPanelMicrobus().getLicenseComboBox().getSelectedItem().toString().equals("ALL");
		boolean sortengines = !vFrame.getPanelMicrobus().getEngineComboBox().getSelectedItem().toString().equals("ALL");
	
		result = (ArrayList<MicroBus>) microbuses.stream()
	    .filter(p -> p.getMarca().contains(vFrame.getPanelMicrobus().getModelTextField().getText()))
	    .filter(p -> p.getMatricula().contains(vFrame.getPanelMicrobus().getRegistrationTextField().getText()))
	    .filter(sortcarnets? p-> p.getCarnet().equals(vFrame.getPanelMicrobus().getLicenseComboBox().getSelectedItem().toString()): p-> true)
	    .filter(sortengines? p-> p.getMotor().equals(vFrame.getPanelMicrobus().getEngineComboBox().getSelectedItem().toString()): p-> true)
	    .collect(Collectors.toList());
	
		mmtm = new MyMicroBusTableModel(result);
		vFrame.getPanelMicrobus().getTable().setModel(mmtm);
	}
}
	
	
	
	
	private void sort() {
		
		SwingWorker<Void,Void> task = new SwingWorker<Void,Void>(){

			@Override
			protected Void doInBackground() throws Exception {

				loadingFrame.setVisible(true);
				
				if(!isCancelled()) {
					
					coches = almacenDatos.getCoches();
					furgonetas = almacenDatos.getFurgonetas();
					camiones = almacenDatos.getCamiones();
					microbuses = almacenDatos.getMicroBuses();
					

				}
				return null;
			}
			
			
			protected void done() {
				if(!isCancelled()) {
				
					try {
						mvtm = new MyVanTableModel(furgonetas);
						mttm = new MyTruckTableModel(camiones);
						mmtm = new MyMicroBusTableModel(microbuses);
						mctm = new MyCarTableModel(coches);
						
						vFrame.getPanelCar().getTable().setModel(mctm);
						vFrame.getPanelVan().getTable().setModel(mvtm);
						vFrame.getPanelTruck().getTable().setModel(mttm);
						vFrame.getPanelMicrobus().getTable().setModel(mmtm);
						
						
						mvtm.addTableModelListener(controller);
						mttm.addTableModelListener(controller);
						mmtm.addTableModelListener(controller);
						mctm.addTableModelListener(controller);
						
						
						loadingFrame.doDefaultCloseAction();
						setComboBoxes();
						setCarnets();
						System.out.println("all done");
					}catch(Exception e) {
						e.printStackTrace();
					}
					
				}else {
					vFrame.dispose();
				}
			}
			
	
		};
		loadingFrame = new LoadingFrame(task);
		MainController.addInternalFrame(loadingFrame);
		
		loadingFrame.getLblTask().setText("Cargando Vehiculos");
		
		task.execute();

}
		
public void go() {
	vFrame.setVisible(true);
}
	
		
	
	
}
