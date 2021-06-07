package es.mordorLloguer.controladores;


import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.swing.event.TableModelEvent;
import javax.swing.table.AbstractTableModel;


public abstract class MyTableModel<T> extends AbstractTableModel{
	
	protected List<String> header;
	
	protected List<T> data;
	
	public MyTableModel(List<String> header,List<T> data) {
		this.data=data;
		this.header=header;
	}

	@Override
	public int getColumnCount() {
		return header.size();
	}

	@Override
	public int getRowCount() {
		return data.size();
	}
	@Override
	public String getColumnName(int column) {
		return header.get(column);
	}

	
	public List<Object> getColumnItems(int col){
		ArrayList list = new ArrayList();
		for(int i = 0;i<header.size();i++)
		{
		    list.add(getValueAt(i,0));
		}
		return list;
	}
	
	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if(columnIndex==0)
			return false;
		else
			return true;
	}
	

	
	
	@Override
	public abstract Object getValueAt(int row, int col);
	
	
	
	
	public void addElementAtRow(T element) {
		data.add(element);
		fireTableRowsInserted(data.size()-1,data.size()-1);
	}
	
	public T getElement(int row) {
		return data.get(row);
	}
	public ArrayList<T> getElements(int[] rows) {
		ArrayList<T> elements=new ArrayList<T>();
		for(int row:rows){
			elements.add(getElement(row));
		}
		return elements;
	}
	
	public void removeElement(T element) {
		int index=data.indexOf(element);
		data.remove(element);
		fireTableRowsDeleted(index,index);
	}
	
}			