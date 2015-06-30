package com.manning.spock.warehouse.gui;

import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import com.manning.spock.warehouse.product.Product;

public class ProductTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	static final String[] COLUMN_NAMES = { "Product Name", "Price", "Weight",
			"Stock level" };

	private List<Product> products = new ArrayList<>();

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

	@Override
	public String getColumnName(int column) {
		return COLUMN_NAMES[column];
	}

	public Product getProductFromRow(int row) {
		return products.get(row);
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		Product affectedProduct = products.get(rowIndex);
		try {
			switch (columnIndex) {
			case 1:
				affectedProduct.setPrice(Integer.parseInt(aValue.toString()));
				break;
			case 2:
				affectedProduct.setWeight(Integer.parseInt(aValue.toString()));
				break;
			case 3:
				affectedProduct.setStock(Integer.parseInt(aValue.toString()));
				break;
			default:
				affectedProduct.setName(aValue.toString());
			}
		} catch (NumberFormatException e) {
			return;
		}
		fireTableCellUpdated(rowIndex, columnIndex);
	}

}
