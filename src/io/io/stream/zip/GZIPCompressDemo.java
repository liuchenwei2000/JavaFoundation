/**
 * 
 */
package io.stream.zip;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

/**
 * GZIP压缩演示类
 * <p>
 * GZIP适合于单个数据流(而不是一系列互异数据)进行压缩。
 * <p>
 * 压缩类的使用非常直观：直接将输出流封装成GZIPOutputStream或ZipOutputStream，
 * 并将输入流封装成GZIPInputStream或ZipInputStream即可。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-7-26
 */
public class GZIPCompressDemo {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// 待压缩文件路径
		String infileName = "files/io.stream.zip/infile.txt";
		// 压缩后的gz文件路径
		String outfileName = "files/io.stream.zip/out.gz";
		
		/** 压缩文件 */
		System.out.println("Writing file");
		gzipFile(infileName, outfileName);
		
		/** 读取压缩文件 */
		System.out.println("Reading file");
		readGzipFile(outfileName);
	}
	
	/**
	 * 将指定文件filePath通过GZip的方式压缩到zipFilePath中
	 */
	private static void gzipFile(String filePath, String zipFilePath) throws IOException {
		BufferedReader reader = null;
		BufferedOutputStream out = null;

		try {
			reader = new BufferedReader(new FileReader(filePath));
			// 输出的时候使用 GZIPOutputStream
			out = new BufferedOutputStream(new GZIPOutputStream(
					new FileOutputStream(zipFilePath)));

			int c;
			while ((c = reader.read()) != -1) {
				out.write(c);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (reader != null) {
				reader.close();
			}
			if (out != null) {
				out.close();
			}
		}
	}
	
	/**
	 * 将指定文件filePath通过GZip的方式压缩到zipFilePath中
	 */
	private static void readGzipFile(String zipFilePath) throws IOException {
		BufferedReader reader = null;
		try {
			// 读取的时候使用 GZIPInputStream
			reader = new BufferedReader(new InputStreamReader(
					new GZIPInputStream(new FileInputStream(zipFilePath))));
			String s;
			while ((s = reader.readLine()) != null) {
				System.out.println(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (reader != null) {
				reader.close();
			}
		}
	}
}