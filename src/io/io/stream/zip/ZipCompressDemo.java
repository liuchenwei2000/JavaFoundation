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
	public static void main(String[] args) throws IOException {
		String fileName = "files/io.stream.zip/test.zip";
		// ��ѹ���ļ������ļ���
		String dirPath = "files/io.stream.zip";
		// ɾ���ϴγ������д�����zip�ļ�
		File zip = new File(fileName);
		if (zip.exists()) {
			zip.delete();
		}
		File dir = new File(dirPath);
		String[] files = dir.list(new FilenameFilter() {

			public boolean accept(File dir, String name) {
				return !(name.endsWith(".zip")||name.endsWith(".gz"));
			}

		});
		/** ѹ��zip�ļ� */
		FileOutputStream fout = new FileOutputStream(fileName);
		// ������CheckSum���������У���ļ���У��ͣ�����Adler32��CRC32��������
		CheckedOutputStream csum = new CheckedOutputStream(fout, new Adler32());
		ZipOutputStream zos = new ZipOutputStream(csum);
		BufferedOutputStream bout = new BufferedOutputStream(zos);
		zos.setComment("A test of Java Zipping");
		for (int i = 0; i < files.length; i++) {
			System.out.println("Writing file " + files[i]);
			BufferedReader in = new BufferedReader(new FileReader(dirPath
					+ File.separator + files[i]));
			zos.putNextEntry(new ZipEntry(files[i]));
			int c;
			while ((c = in.read()) != -1) {
				bout.write(c);
			}
			in.close();
		}
		bout.close();
		// ����zip�ļ�У���
		System.out.println("Checksum: " + csum.getChecksum().getValue());
		/** ��ȡzip�ļ� */
		System.out.println("Reading file");
		FileInputStream fin = new FileInputStream(fileName);
		CheckedInputStream csumi = new CheckedInputStream(fin, new Adler32());
		ZipInputStream zis = new ZipInputStream(csumi);
		BufferedInputStream bin = new BufferedInputStream(zis);
		ZipEntry ze;
		while ((ze = zis.getNextEntry()) != null) {
			System.out.println("Reading file " + ze);
			int x;
			while ((x = bin.read()) != -1) {
				System.out.write(x);
			}
		}
		System.out.println("Checksum: " + csumi.getChecksum().getValue());
		bin.close();
		// ��һ�ֶ�ȡzip�ļ��ķ���
//		ZipFile zf = new ZipFile(fileName);
//		Enumeration<?> e = zf.entries();
//		while (e.hasMoreElements()) {
//			ZipEntry ze2 = (ZipEntry) e.nextElement();
//			System.out.println("File: " + ze2);
//			// ... and extract the data as before
//		}
	}
}