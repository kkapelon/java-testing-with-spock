package com.manning.spock.warehouse.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

import com.manning.spock.warehouse.product.Product;
import com.manning.spock.warehouse.product.ProductLoader;

public class MainWindow extends JFrame implements ActionListener,TableModelListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private static final String NEW_PRODUCT = "newProduct";
	private static final String DELETE_PRODUCT = "deleteProduct";
	
	private ProductLoader productLoader;
	
	private JTable table;
	private ProductTableModel tableModel;

	public MainWindow(ProductLoader productLoader) {
		super("Warehouse Management");
		add(new JLabel("Sample spring"));
		
		this.productLoader = productLoader;
		
		createGUI();
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	private void createGUI() {
		

		Object[][] data = {};
		
		setLayout(new BorderLayout());
		
		JLabel info = new JLabel("Double click a cell to start editing"); 
		info.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		add(info,BorderLayout.NORTH);
		
		table = new JTable(data, ProductTableModel.COLUMN_NAMES);
		table.setFillsViewportHeight(true);
		add(new JScrollPane(table),BorderLayout.CENTER);
		
		JPanel buttons = new JPanel();
		JButton newProduct = new JButton("New Product");
		newProduct.setActionCommand(NEW_PRODUCT);
		newProduct.addActionListener(this);
		
		JButton deleteProduct = new JButton("Delete product");
		deleteProduct.setActionCommand(DELETE_PRODUCT);
		deleteProduct.addActionListener(this);
		
		buttons.add(newProduct);
		buttons.add(deleteProduct);
		
		add(buttons,BorderLayout.SOUTH);
		
		
		
		reloadTable();
	}
	
	private void reloadTable()
	{
		List<Product> allProducts = productLoader.getAllProducts();
		tableModel = new ProductTableModel();
		tableModel.setProducts(allProducts);
		table.setModel(tableModel);
		table.getModel().addTableModelListener(this);
	}
	
	

	

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals(DELETE_PRODUCT))
		{
			System.out.println("Removing product");
		}
		else
		{
			Product product = new Product();
			product.setName("A product");
			product.setPrice(0);
			product.setStock(0);
			product.setWeight(0);
			
			System.out.println("Adding new product");
			productLoader.save(product);
			reloadTable();
		}
		
	}

	@Override
	public void tableChanged(TableModelEvent e) {
		Product affectedProduct = tableModel.getProductFromRow(e.getFirstRow());
		productLoader.update(affectedProduct);
		System.out.println("New value is "+table.getValueAt(e.getFirstRow(), e.getColumn()));
		
	}
}
