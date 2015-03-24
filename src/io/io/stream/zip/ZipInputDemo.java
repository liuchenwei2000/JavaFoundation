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
 * ��ȡzip�ļ���ʾ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2009-7-20
 */
public class ZipInputDemo {
	
	/** zip�����ļ�·�� */
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
	 * ��ȡzip�ļ������������ļ��б�
	 */
	private static List<String> readZipFiles(String zipFilePath) throws IOException{
		List<String> files = new ArrayList<String>();
		
		ZipInputStream zin = null;
		try {
			/*
			 * ͨ����һ��FileInputStream����ZipInputStream������
			 * ������ZipInputStream���ȡһ��zip�ļ���Ȼ����Ա�������zip�ļ�ȥ�鿴���е�ÿ��������Ŀ��
			 * getNextEntry��������һ����������Ŀ��ZipEntry�������������closeEntry�Ա��ڶ�ȡ��һ��Ŀ��
			 */
			zin = new ZipInputStream(new FileInputStream(zipFilePath));
			ZipEntry entry;
			// ������һ��Ŀ��ZipEntry�������û���򷵻�null
			while ((entry = zin.getNextEntry()) != null) {
				// ZipEntry����������zip��Ŀ����Ϣ
				if (!entry.isDirectory()) {
					files.add(entry.getName());
				}
				// �ر�zip�ļ��е�ǰ�򿪵�ZipEntry��Ȼ��Ϳ����ٵ���getNextEntry��
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
	 * ��ȡzip�ļ���ָ���ļ�������
	 */
	private static String readZipFileContent(String zipFilePath, String fileName) throws IOException{
		StringBuilder content = new StringBuilder();
		ZipInputStream zin = null;
		try {
			zin = new ZipInputStream(new FileInputStream(zipFilePath));
			ZipEntry entry;
			while ((entry = zin.getNextEntry()) != null) {
				if (entry.getName().equals(fileName)) {
					// Ҫ��ȡzip��Ŀ�����ݣ��ܿ��ܲ�̫Ը��ʹ��ԭʼ��read����
					// ͨ����ʹ�ø����˵����������ķ��������绺����
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
