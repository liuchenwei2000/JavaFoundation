/**
 * 
 */
package io.file;

import java.io.*;
import java.util.Date;

/**
 * 文件读写演示类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public class FileIODemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 读取
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
		// 写入
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