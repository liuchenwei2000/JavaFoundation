package io.stream.zip;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * ��ȡzip�ļ���ʾ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2009-7-20
 */
public class ZipInputDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Displayer.createAndShowGUI("Zip Input Demo", new ZipInputPanel());
	}
}

class ZipInputPanel extends JPanel {

	private static final long serialVersionUID = -6361462481092909231L;

	/** zip�����ļ�·�� */
	private static final String ZIP_FILE = "files/io.stream.zip/in.zip";

	private JComboBox entryBox;
	private JTextArea contentArea;

	public ZipInputPanel() {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(400, 400));
		this.add(getEntryBox(), BorderLayout.SOUTH);
		this.add(new JScrollPane(getContentArea()), BorderLayout.CENTER);
	}

	private JComboBox getEntryBox() {
		if (entryBox == null) {
			entryBox = new JComboBox();
			initBox();
			initListener();
		}
		return entryBox;
	}

	private void initBox() {
		try {
			getEntryBox().addItem("");
			/*
			 * ͨ����һ��FileInputStream����ZipInputStream������
			 * ������ZipInputStream���ȡһ��zip�ļ���Ȼ����Ա�������zip�ļ�ȥ�鿴���е�ÿ��������Ŀ��
			 * getNextEntry��������һ����������Ŀ��ZipEntry�������������closeEntry�Ա��ڶ�ȡ��һ��Ŀ
			 */
			ZipInputStream zin = new ZipInputStream(new FileInputStream(ZIP_FILE));
			ZipEntry entry;
			// ������һ��Ŀ��ZipEntry�������û���򷵻�null
			while ((entry = zin.getNextEntry()) != null) {
				// ZipEntry����������zip��Ŀ����Ϣ
				if (!entry.isDirectory()) {
					getEntryBox().addItem(entry.getName());
				}
				// �ر�zip�ļ��е�ǰ�򿪵�ZipEntry��Ȼ��Ϳ����ٵ���getNextEntry��
				zin.closeEntry();
			}
			zin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initListener() {
		getEntryBox().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				loadZipFile();
			}

		});
	}

	private String getSelectedZipFile() {
		return getEntryBox().getSelectedItem().toString();
	}

	private void loadZipFile() {
		try {
			ZipInputStream zin = new ZipInputStream(new FileInputStream(ZIP_FILE));
			ZipEntry entry;
			getContentArea().setText("");
			while ((entry = zin.getNextEntry()) != null) {
				if (entry.getName().equals(getSelectedZipFile())) {
					// Ҫ��ȡzip��Ŀ�����ݣ��ܿ��ܲ�̫Ը��ʹ��ԭʼ��read����
					// ͨ����ʹ�ø����˵����������ķ��������绺����
					BufferedReader in = new BufferedReader(new InputStreamReader(zin));
					String s;
					while ((s = in.readLine()) != null) {
						getContentArea().append(s + "\n");
					}
					in.close();
				}
				zin.closeEntry();
			}
			zin.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private JTextArea getContentArea() {
		if (contentArea == null) {
			contentArea = new JTextArea();
		}
		return contentArea;
	}
}