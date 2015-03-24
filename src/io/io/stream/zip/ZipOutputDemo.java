/**
 * 
 */
package io.stream.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * д��zip�ļ���ʾ��
 * <p>
 * ��������ļ�ѹ��Ϊzip�ļ���
 * zip�ļ���ѹ����ʽ�洢һ��������ļ���ÿ��zip�ļ������ļ�ͷ�����а����������ļ�����ʹ�õ�ѹ����������Ϣ��
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-7-20
 */
public class ZipOutputDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ��ѹ���ļ������ļ���
		String dirPath = "files/io.stream.zip";
		// ѹ�����zip�ļ���
		String zipFilePath = dirPath + "/out.zip";
		// ɾ���ϴγ������д�����zip�ļ�
		File zipFile = new File(zipFilePath);
		if (zipFile.exists()) {
			zipFile.delete();
		}

		zip(dirPath, zipFilePath);
	}
	
	private static void zip(String dirPath, String zipFilePath){
		File dir = new File(dirPath);
		String[] files = dir.list(new FilenameFilter() {

			public boolean accept(File dir, String name) {
				return !(name.endsWith(".zip")||name.endsWith(".gz"));
			}

		});
		// ִ��ѹ������
		ZipOutputStream out = null;
		try {
			// ����һ��zip�ļ���д��ʱ����Ҫ��һ���������а���FileOutputStream��ZipOutputStream�ļ���
			out = new ZipOutputStream(new FileOutputStream(zipFilePath));
			for (String file : files) {
				// ����ÿһ��ϣ������zip�ļ�����Ŀ����Ҫ����һ��ZipEntry����
				// ֻҪ���ļ�������ZipEntry���������������Զ��������������������ļ����ںͽ�ѹ������
				ZipEntry entry = new ZipEntry(file);
				// ���Ե���putNextEntry��������ʼд��һ�����ļ�
				out.putNextEntry(entry);
				// ���ļ����ݴ��ݸ�zip��������ִ����zip�ļ���д�����
				FileInputStream in = new FileInputStream(dirPath + File.separator + file);
				int b;
				while ((b = in.read()) != -1) {
					out.write(b);
				}
				in.close();
				// ��ɺ����closeEntry
				out.closeEntry();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if(out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}