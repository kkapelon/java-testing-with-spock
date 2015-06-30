package com.manning.spock.warehouse.gui;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;

public class MainWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MainWindow() {
		super("Warehouse Management");
		add(new JLabel("Sample spring"));
		createGUI();
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
	}

	private void createGUI() {
		String[] columnNames = { "Product Name", "Price", "Weight",
				"Stock level" };

		Object[][] data = {
				{ "Kathy", "Smith", "Snowboarding", new Integer(5)},
				{ "John", "Doe", "Rowing", new Integer(3)},
				{ "Sue", "Black", "Knitting", new Integer(2) },
				{ "Jane", "White", "Speed reading", new Integer(20) },
				{ "Joe", "Brown", "Pool", new Integer(10)} };
		
		setLayout(new BorderLayout());
		
		JLabel info = new JLabel("Double click a cell to start editing"); 
		info.setBorder( new EmptyBorder( 5, 5, 5, 5 ) );
		add(info,BorderLayout.NORTH);
		
		final JTable table = new JTable(data, columnNames);
		table.setFillsViewportHeight(true);
		add(new JScrollPane(table),BorderLayout.CENTER);
		
		JPanel buttons = new JPanel();
		JButton newProduct = new JButton("New Product");
		JButton deleteProduct = new JButton("Delete product");
		buttons.add(newProduct);
		buttons.add(deleteProduct);
		
		add(buttons,BorderLayout.SOUTH);
		
		
		table.getModel().addTableModelListener(new TableModelListener() {
			
			@Override
			public void tableChanged(TableModelEvent e) {
				System.out.println(e.getColumn());
				System.out.println(e.getFirstRow());
				System.out.println(e.getLastRow());
				
				System.out.println("New value is "+table.getValueAt(e.getFirstRow(), e.getColumn()));
				
			}
		});
	}
}
