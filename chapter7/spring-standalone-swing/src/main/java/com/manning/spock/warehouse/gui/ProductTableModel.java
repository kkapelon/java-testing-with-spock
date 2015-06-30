package com.manning.spock.warehouse.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.manning.spock.warehouse.product.Product;

public class ProductTableModel extends AbstractTableModel {

	private List<Product> products = new ArrayList<>();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return true;
	}

	@Override
	public int getRowCount() {
		return products.size();
	}

	@Override
	public int getColumnCount() {
		return 4;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Product product = products.get(rowIndex);
		switch (columnIndex) {
		case 1:
			return product.getPrice();
		case 2:
			return product.getWeight();
		case 3:
			return product.getStock();
		default:
			return product.getName();
		}
	}

}
