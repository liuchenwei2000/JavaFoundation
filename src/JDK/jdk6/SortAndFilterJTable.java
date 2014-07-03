/**
 * 
 */
package jdk6;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 * 13，JTable的排序和过滤功能示例
 * <p>
 * 原来的JTable基本上是只能显示数据，在JDK6新增了对JTable的排序和过滤功能。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-7-3
 */
public class SortAndFilterJTable {

	static String[][] data = { { "China", "Beijing", "Chinese" },
			{ "America", "Washington", "English" },
			{ "Korea", "Seoul", "Korean" }, { "Japan", "Tokyo", "Japanese" },
			{ "France", "Paris", "French" },
			{ "England", "London", "English" },
			{ "Germany", "Berlin", "German" }, };
	
	static String[] titles = { "Country", "Capital", "Language" };
	
    /**
     * @param args
     */
	public static void main(String[] args) {
		DefaultTableModel tableModel = new DefaultTableModel(data, titles);
		JTable table = new JTable(tableModel);
		// RowSorter 的一个实现，它使用 TableModel 提供排序和过滤操作。
		final TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(tableModel);
		table.setRowSorter(tableRowSorter); // 为JTable设置排序器

		JScrollPane srollPane = new JScrollPane();
		srollPane.setViewportView(table);

		final JTextField textField = new JTextField();
		JButton button = new JButton("Do Filter");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().length() == 0) {
					tableRowSorter.setRowFilter(null);
				} else {
					// 为JTable设置基于正则表达式的过滤条件
					tableRowSorter.setRowFilter(RowFilter.regexFilter(textField.getText()));
				}
			}
		});

		JPanel filterPanel = new JPanel();
		filterPanel.setLayout(new BoxLayout(filterPanel, BoxLayout.X_AXIS));
		filterPanel.add(new JLabel("Criteria:"));
		filterPanel.add(textField);
		filterPanel.add(button);
		
		show(srollPane, filterPanel);
	}
	
	private static void show(JScrollPane scrollPane, JPanel panel) {
		JFrame f = new JFrame("JTable Sorting and Filtering");
		f.getContentPane().add(scrollPane, BorderLayout.CENTER);
		f.getContentPane().add(panel, BorderLayout.SOUTH);
		f.setSize(400, 300);
		f.setVisible(true);
	}
}
