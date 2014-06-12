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
 * GZIPѹ����ʾ��
 * <p>
 * GZIP�ʺ��ڵ���������(������һϵ�л�������)����ѹ����
 * <p>
 * ѹ�����ʹ�÷ǳ�ֱ�ۣ�ֱ�ӽ��������װ��GZIPOutputStream��ZipOutputStream��������������װ��GZIPInputStream��ZipInputStream���ɡ�
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-7-26
 */
public class GZIPCompressDemo {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// ��ѹ���ļ�·��
		String infileName = "files/io.stream.zip/infile.txt";
		// ѹ�����gz�ļ�·��
		String outfileName = "files/io.stream.zip/out.gz";
		/** ѹ���ļ� */
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
		/** ��ȡѹ���ļ� */
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