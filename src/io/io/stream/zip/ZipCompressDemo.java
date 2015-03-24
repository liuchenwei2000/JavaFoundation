/**
 * 
 */
package io.stream.zip;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.zip.Adler32;
import java.util.zip.CheckedInputStream;
import java.util.zip.CheckedOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Zipѹ����ʾ��
 * <p>
 * Zip�ʺ��ڶ���ļ���ѹ����
 * ����Zip��ʽ�ṩ����������ķ�������Java��Zip��Ⲣ���ṩ�ⷽ���֧�֡�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2009-7-26
 */
public class ZipCompressDemo {
	
	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) {
		String zipFileName = "files/io.stream.zip/test.zip";
		// ��ѹ���ļ������ļ���
		String dirPath = "files/io.stream.zip";
		// ɾ���ϴγ������д�����zip�ļ�
		File zip = new File(zipFileName);
		if (zip.exists()) {
			zip.delete();
		}
		
		try {
			/** ѹ��zip�ļ� */
			zipFiles(dirPath, zipFileName);
			
			/** ��ȡzip�ļ� */
			readZipFiles(zipFileName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * ���ļ����ڵ��ļ�ѹ����ָ��zip�ļ���
	 */
	private static void zipFiles(String dirPath, String zipFilePath) throws IOException{
		BufferedOutputStream bout = null;
		try {
			// ������ CheckSum ���������У���ļ���У��ͣ�����Adler32��CRC32��������
			CheckedOutputStream csum = new CheckedOutputStream(new FileOutputStream(zipFilePath), new Adler32());
			
			ZipOutputStream zos = new ZipOutputStream(csum);
			zos.setComment("A test of Java Zipping");
			
			bout = new BufferedOutputStream(zos);
			
			String[] files = getFiles(dirPath);
			
			for (String file : files) {
				System.out.println("Writing file " + file);
				BufferedReader in = new BufferedReader(new FileReader(dirPath + File.separator + file));
				zos.putNextEntry(new ZipEntry(file));
				
				int c;
				while ((c = in.read()) != -1) {
					bout.write(c);
				}
				in.close();
			}
			
			// ����zip�ļ�У���
			System.out.println("Checksum: " + csum.getChecksum().getValue());
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(bout != null) {
				bout.close();
			}
		}
	}
	
	/**
	 * ���ļ����ڵ��ļ�ѹ����ָ��zip�ļ���
	 */
	private static void readZipFiles(String zipFilePath) throws IOException{
		BufferedInputStream bin = null;
		try {
			CheckedInputStream csumi = new CheckedInputStream(new FileInputStream(zipFilePath), new Adler32());
			
			ZipInputStream zis = new ZipInputStream(csumi);
			
			bin = new BufferedInputStream(zis);
			
			ZipEntry ze;
			while ((ze = zis.getNextEntry()) != null) {
				System.out.println("Reading file " + ze);
				int x;
				while ((x = bin.read()) != -1) {
					System.out.print((char)x);
				}
				zis.closeEntry();
			}
			System.out.println("\nChecksum: " + csumi.getChecksum().getValue());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if(bin != null) {
				bin.close();
			}
		}
	}
	
	/**
	 * �����ļ����пɱ�ѹ�����ļ��б�
	 */
	private static String[] getFiles(String dirPath){
		File dir = new File(dirPath);
		return dir.list(new FilenameFilter() {

			public boolean accept(File dir, String name) {
				return !(name.endsWith(".zip") || name.endsWith(".gz"));
			}
		});
	}
}