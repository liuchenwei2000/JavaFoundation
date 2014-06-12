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
 * 读取zip文件演示类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2009-7-20
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

	/** zip输入文件路径 */
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
			 * 通过将一个FileInputStream传给ZipInputStream构造器
			 * 可以用ZipInputStream类读取一个zip文件，然后可以遍历整个zip文件去查看其中的每个独立条目。
			 * getNextEntry方法返回一个描述该条目的ZipEntry对象，最后必须调用closeEntry以便于读取下一条目
			 */
			ZipInputStream zin = new ZipInputStream(new FileInputStream(ZIP_FILE));
			ZipEntry entry;
			// 返回下一条目的ZipEntry对象，如果没有则返回null
			while ((entry = zin.getNextEntry()) != null) {
				// ZipEntry包含了描述zip条目的信息
				if (!entry.isDirectory()) {
					getEntryBox().addItem(entry.getName());
				}
				// 关闭zip文件中当前打开的ZipEntry，然后就可以再调用getNextEntry了
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
					// 要读取zip条目的内容，很可能不太愿意使用原始的read方法
					// 通常会使用更适宜的流过滤器的方法，比如缓冲流
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