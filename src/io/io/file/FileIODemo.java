/**
 * 
 */
package io.file;

import java.io.*;
import java.util.Date;

/**
 * �ļ���д��ʾ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public class FileIODemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ��ȡ
		String filePath = "files/io.file/file.txt";
		try {
			BufferedReader br = new BufferedReader(new FileReader(filePath));
			String s = null;
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}
			br.close();
		} catch (IOException e) {
			System.out.println("Exception:" + e.getMessage());
		}
		// д��
		String content = new Date().toString();
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(filePath));
			bw.write(content);
			bw.close();
		} catch (IOException e) {
			System.out.println("Exception:" + e.getMessage());
		}
	}
}