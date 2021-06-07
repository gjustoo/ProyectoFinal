package es.mordorLloguer.vistas;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;

import java.awt.Font;
import javax.swing.JProgressBar;
import java.awt.Color;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class LoadingFrame extends JInternalFrame{
	private JButton btnCancel;
	private SwingWorker<?,?> task;
	private JLabel lblTask;
	
	
	public LoadingFrame() {
		setBounds(100, 100, 470, 166);
		
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(Color.GRAY);
		progressBar.setIndeterminate(true);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
						.addComponent(progressBar, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 377, Short.MAX_VALUE))
					.addGap(9))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, groupLayout.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 70, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 46, Short.MAX_VALUE)
					.addComponent(progressBar, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		panel.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("Loading, please wait...");
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblNewLabel, BorderLayout.SOUTH);
		
		lblTask = new JLabel("");
		lblTask.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 24));
		lblTask.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblTask, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnCancel = new JButton("CANCEL");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				task.cancel(true);
				dispose();
			}
		});
		panel_1.add(btnCancel);
		getContentPane().setLayout(groupLayout);
		
		
	}
	
	
	public JButton getBtnCancel() {
		return btnCancel;
	}


	public SwingWorker<?, ?> getTask() {
		return task;
	}


	public JLabel getLblTask() {
		return lblTask;
	}


	public LoadingFrame(SwingWorker<?, ?> task) {
		this();
		this.task = task;
	}
	
	
}
