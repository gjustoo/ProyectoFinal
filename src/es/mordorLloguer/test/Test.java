package es.mordorLloguer.test;

import java.awt.EventQueue;

import com.alee.laf.WebLookAndFeel;


import es.mordorLloguer.controladores.MainController;
import es.mordorLloguer.model.AlmacenDatosDB;
import es.mordorLloguer.model.OracleDataBase;
import es.mordorLloguer.vistas.MainFrame;

public class Test {

	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WebLookAndFeel.install();
					MainFrame frame = new MainFrame();
					AlmacenDatosDB model=new OracleDataBase();
					MainController c = new MainController(frame,model);
					c.go();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
