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
 * ѹ�����ʹ�÷ǳ�ֱ�ۣ�ֱ�ӽ��������װ��GZIPOutputStream��ZipOutputStream��
 * ������������װ��GZIPInputStream��ZipInputStream���ɡ�
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
		System.out.println("Writing file");
		gzipFile(infileName, outfileName);
		
		/** ��ȡѹ���ļ� */
		System.out.println("Reading file");
		readGzipFile(outfileName);
	}
	
	/**
	 * ��ָ���ļ�filePathͨ��GZip�ķ�ʽѹ����zipFilePath��
	 */
	private static void gzipFile(String filePath, String zipFilePath) throws IOException {
		BufferedReader reader = null;
		BufferedOutputStream out = null;

		try {
			reader = new BufferedReader(new FileReader(filePath));
			// �����ʱ��ʹ�� GZIPOutputStream
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
	 * ��ָ���ļ�filePathͨ��GZip�ķ�ʽѹ����zipFilePath��
	 */
	private static void readGzipFile(String zipFilePath) throws IOException {
		BufferedReader reader = null;
		try {
			// ��ȡ��ʱ��ʹ�� GZIPInputStream
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