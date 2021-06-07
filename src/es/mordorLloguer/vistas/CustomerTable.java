package es.mordorLloguer.vistas;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.alee.laf.table.WebTable;

import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class CustomerTable extends JInternalFrame {
	private JTextField dniTextField;
	private JTextField nameTextField;
	private JTextField surnameTextField;
	private JButton btnAdd;
	private JButton btnDelete;
	private JButton btnEdit;
	private JButton btnCancel;
	private JComboBox comboBox;
	private JButton btnPrint;
	private WebTable table;







	/**
	 * Create the frame.
	 */
	public CustomerTable() {
		setClosable(true);
		setBounds(100, 100, 867, 588);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JPanel panel_2 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 833, Short.MAX_VALUE))
						.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 834, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 420, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 38, GroupLayout.PREFERRED_SIZE))
		);
		
		JLabel lblDNI = new JLabel("DNI :");
		
		dniTextField = new JTextField();
		dniTextField.setColumns(10);
		
		JLabel lblName = new JLabel("Name :");
		
		nameTextField = new JTextField();
		nameTextField.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname");
		
		surnameTextField = new JTextField();
		surnameTextField.setColumns(10);
		
		JLabel lblDriversLicense = new JLabel("Drivers License:");
		
		comboBox = new JComboBox();
		comboBox.addItem("ALL");
		comboBox.addItem("A");
		comboBox.addItem("B");
		comboBox.addItem("C");
		comboBox.addItem("D");
		comboBox.addItem("E");
		comboBox.addItem("Z");
		comboBox.setSelectedIndex(0);
		
		btnPrint = new JButton("Print");
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25)
					.addComponent(lblDNI)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(dniTextField, GroupLayout.PREFERRED_SIZE, 124, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblName)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblSurname)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(surnameTextField, GroupLayout.PREFERRED_SIZE, 141, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(lblDriversLicense)
					.addGap(18)
					.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(btnPrint)
					.addGap(53))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap(19, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDriversLicense)
						.addComponent(surnameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSurname)
						.addComponent(nameTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblName)
						.addComponent(dniTextField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDNI)
						.addComponent(btnPrint))
					.addGap(22))
		);
		panel.setLayout(gl_panel);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);
		panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));
		table = new WebTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.setVisibleRowCount(5);
		table.optimizeColumnWidths(true);
		table.setOptimizeRowHeight(true);
		table.setEditable(true);
		scrollPane.setViewportView(table);
		
		btnAdd = new JButton("Add");
		panel_2.add(btnAdd);
		
		btnDelete = new JButton("Delete");
		panel_2.add(btnDelete);
		
		btnEdit = new JButton("Edit");
		panel_2.add(btnEdit);
		
		btnCancel = new JButton("Cancel");
		panel_2.add(btnCancel);
		getContentPane().setLayout(groupLayout);

	}
	
	public JTextField getDniTextField() {
		return dniTextField;
	}

	public JTextField getNameTextField() {
		return nameTextField;
	}

	public JTextField getSurnameTextField() {
		return surnameTextField;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public JButton getBtnEdit() {
		return btnEdit;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public JComboBox getCarnetBox() {
		return comboBox;
	}

	public JButton getBtnPrint() {
		return btnPrint;
	}

	public WebTable getTable() {
		return table;
	}


	
}
