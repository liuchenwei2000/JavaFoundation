package io.stream.zip;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * 读取zip文件演示类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2009-7-20
 */
public class ZipInputDemo {
	
	/** zip输入文件路径 */
	private static final String ZIP_FILE = "files/io.stream.zip/in.zip";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			List<String> files = readZipFiles(ZIP_FILE);
			System.out.println(files);
			System.out.println();
			System.out.println(readZipFileContent(ZIP_FILE, files.get(0)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 读取zip文件并返回其内文件列表
	 */
	private static List<String> readZipFiles(String zipFilePath) throws IOException{
		List<String> files = new ArrayList<String>();
		
		ZipInputStream zin = null;
		try {
			/*
			 * 通过将一个FileInputStream传给ZipInputStream构造器
			 * 可以用ZipInputStream类读取一个zip文件，然后可以遍历整个zip文件去查看其中的每个独立条目。
			 * getNextEntry方法返回一个描述该条目的ZipEntry对象，最后必须调用closeEntry以便于读取下一条目。
			 */
			zin = new ZipInputStream(new FileInputStream(zipFilePath));
			ZipEntry entry;
			// 返回下一条目的ZipEntry对象，如果没有则返回null
			while ((entry = zin.getNextEntry()) != null) {
				// ZipEntry包含了描述zip条目的信息
				if (!entry.isDirectory()) {
					files.add(entry.getName());
				}
				// 关闭zip文件中当前打开的ZipEntry，然后就可以再调用getNextEntry了
				zin.closeEntry();
			}
			return files;
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (zin != null) {
				zin.close();
			}
		}
	}
	
	/**
	 * 读取zip文件内指定文件的内容
	 */
	private static String readZipFileContent(String zipFilePath, String fileName) throws IOException{
		StringBuilder content = new StringBuilder();
		ZipInputStream zin = null;
		try {
			zin = new ZipInputStream(new FileInputStream(zipFilePath));
			ZipEntry entry;
			while ((entry = zin.getNextEntry()) != null) {
				if (entry.getName().equals(fileName)) {
					// 要读取zip条目的内容，很可能不太愿意使用原始的read方法
					// 通常会使用更适宜的流过滤器的方法，比如缓冲流
					BufferedReader in = new BufferedReader(new InputStreamReader(zin));
					String s;
					while ((s = in.readLine()) != null) {
						content.append(s + "\n");
					}
					in.close();
					break;
				}
				zin.closeEntry();
			}
			return content.toString();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			zin.close();
		}
	}
}
