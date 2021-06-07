package es.mordorLloguer.vistas;

import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

public class JPCoche extends JPanel {
	private JSpinner puertasSpinner;
	private JSpinner plazasSpinner;

	/**
	 * Create the panel.
	 */
	public JPCoche() {
		
		JLabel lblNPuertas = new JLabel("Numero puertas");
		
		puertasSpinner = new JSpinner();
		puertasSpinner.setModel(new SpinnerNumberModel(1, 1, 6, 1));
		
		plazasSpinner = new JSpinner();
		plazasSpinner.setModel(new SpinnerNumberModel(1, 1, 7, 1));
		
		JLabel lblNPlazas = new JLabel("Numero plazas");
		GroupLayout groupLayout = new GroupLayout(this);
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNPlazas)
							.addGap(18)
							.addComponent(plazasSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(lblNPuertas)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(puertasSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(323, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(lblNPuertas)
						.addComponent(puertasSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(plazasSpinner, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNPlazas))
					.addContainerGap(231, Short.MAX_VALUE))
		);
		setLayout(groupLayout);

	}

	public JSpinner getPuertasSpinner() {
		return puertasSpinner;
	}

	public JSpinner getPlazasSpinner() {
		return plazasSpinner;
	}

	
	
	
}
