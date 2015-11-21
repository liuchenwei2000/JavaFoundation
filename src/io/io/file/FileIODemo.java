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
		String filePath = "files/io.file/file.txt";
		
		// 读取
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(filePath));
			String s = null;
			while ((s = br.readLine()) != null) {
				System.out.println(s);
			}
		} catch (IOException e) {
			System.out.println("Exception:" + e.getMessage());
		} finally {
			if(br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		
		// 写入
		BufferedWriter bw = null;
		String content = new Date().toString();
		try {
			bw = new BufferedWriter(new FileWriter(filePath));
			bw.write(content);
		} catch (IOException e) {
			System.out.println("Exception:" + e.getMessage());
		} finally {
			if(bw != null) {
				try {
					bw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
