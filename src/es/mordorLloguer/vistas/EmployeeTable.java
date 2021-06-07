package es.mordorLloguer.vistas;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import java.awt.BorderLayout;

import javax.swing.AbstractButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import javax.swing.JMenuItem;

import net.miginfocom.swing.MigLayout;
import javax.swing.JComboBox;
import javax.swing.LayoutStyle.ComponentPlacement;

import com.alee.laf.table.WebTable;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.FlowLayout;
import javax.swing.JButton;

public class EmployeeTable extends JInternalFrame {

	private WebTable table;

	private JButton btnDelete;
	private JButton btnAdd;

	private JComboBox sortBox;
	private JComboBox ordersBox;

	private JPopupMenu popupMenu;
	private JMenuItem mntmAddRow;
	private JMenuItem mntmDeleteRow;

	public EmployeeTable() {
		setClosable(true);
		setBounds(100, 100, 867, 556);
		JPanel panel = new JPanel();

		JPanel panel_1 = new JPanel();

		JPanel panel_2 = new JPanel();
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(groupLayout.createParallelGroup(Alignment.TRAILING).addGroup(groupLayout
				.createSequentialGroup().addContainerGap()
				.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE)
						.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, 963, Short.MAX_VALUE)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 953, Short.MAX_VALUE))
				.addContainerGap()));
		groupLayout
				.setVerticalGroup(
						groupLayout.createParallelGroup(Alignment.LEADING)
								.addGroup(groupLayout.createSequentialGroup().addContainerGap()
										.addComponent(panel, GroupLayout.PREFERRED_SIZE, 36, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED)
										.addComponent(panel_1, GroupLayout.DEFAULT_SIZE, 421, Short.MAX_VALUE)
										.addPreferredGap(ComponentPlacement.UNRELATED).addComponent(panel_2,
												GroupLayout.PREFERRED_SIZE, 43, GroupLayout.PREFERRED_SIZE)
										.addContainerGap()));
		panel_2.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 5));

		btnAdd = new JButton("Add");
		panel_2.add(btnAdd);

		btnDelete = new JButton("Delete");
		panel_2.add(btnDelete);
		panel_1.setLayout(new BorderLayout(0, 0));
		popupMenu = new JPopupMenu();

		mntmAddRow = new JMenuItem("Add row");
		popupMenu.add(mntmAddRow);

		mntmDeleteRow = new JMenuItem("Delete row");
		popupMenu.add(mntmDeleteRow);
		JScrollPane scrollPane = new JScrollPane();
		panel_1.add(scrollPane, BorderLayout.CENTER);

		table = new WebTable();
		table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
		table.setVisibleRowCount(5);
		table.optimizeColumnWidths(true);
		table.setOptimizeRowHeight(true);
		table.setEditable(true);
		scrollPane.setViewportView(table);
		panel.setLayout(new MigLayout("", "[][80.00][][][][][100.00]", "[]"));

		JLabel lblOrderBy = new JLabel("Order by :");
		panel.add(lblOrderBy, "cell 0 0,alignx trailing");

		ordersBox = new JComboBox();
		panel.add(ordersBox, "flowx,cell 1 0 2 1,growx");
		ordersBox.setModel(new DefaultComboBoxModel(new String[] { "DNI", "Nombre", "Domicilio", "CP", "Email", "FechaNac", "Cargo" }));

		JLabel lblSort = new JLabel("Sort");
		panel.add(lblSort, "cell 5 0,alignx trailing");

		sortBox = new JComboBox();
		panel.add(sortBox, "cell 6 0,growx");
		sortBox.setModel(new DefaultComboBoxModel(new String[] { "Ascendant", "Descendant" }));
		getContentPane().setLayout(groupLayout);
	}

	public JComboBox getSortBox() {return sortBox;}

	public JComboBox getOrdersBox() {return ordersBox;}

	public WebTable getTable() {return table;}

	public JButton getBtnDelete() {return btnDelete;}

	public JButton getBtnAdd() {return btnAdd;}

	public JPopupMenu getPopupMenu() {return popupMenu;}

	public JMenuItem getMntmAddRow() {return mntmAddRow;}

	public JMenuItem getMntmDeleteRow() {return mntmDeleteRow;}
}
