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
 * 压缩类的使用非常直观：直接将输出流封装成GZIPOutputStream或ZipOutputStream，并将输入流封装成GZIPInputStream或ZipInputStream即可。
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
		BufferedReader inreader = new BufferedReader(new FileReader(infileName));
		BufferedOutputStream out = new BufferedOutputStream(
				new GZIPOutputStream(new FileOutputStream(outfileName)));
		System.out.println("Writing file");
		int c;
		while ((c = inreader.read()) != -1) {
			out.write(c);
		}
		inreader.close();
		out.close();
		/** 读取压缩文件 */
		System.out.println("Reading file");
		BufferedReader reader2 = new BufferedReader(new InputStreamReader(
				new GZIPInputStream(new FileInputStream(outfileName))));
		String s;
		while ((s = reader2.readLine()) != null) {
			System.out.println(s);
		}
		reader2.close();
	}
}