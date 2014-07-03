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
 * 13��JTable������͹��˹���ʾ��
 * <p>
 * ԭ����JTable��������ֻ����ʾ���ݣ���JDK6�����˶�JTable������͹��˹��ܡ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-7-3
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
		// RowSorter ��һ��ʵ�֣���ʹ�� TableModel �ṩ����͹��˲�����
		final TableRowSorter<DefaultTableModel> tableRowSorter = new TableRowSorter<DefaultTableModel>(tableModel);
		table.setRowSorter(tableRowSorter); // ΪJTable����������

		JScrollPane srollPane = new JScrollPane();
		srollPane.setViewportView(table);

		final JTextField textField = new JTextField();
		JButton button = new JButton("Do Filter");
		button.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				if (textField.getText().length() == 0) {
					tableRowSorter.setRowFilter(null);
				} else {
					// ΪJTable���û���������ʽ�Ĺ�������
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
