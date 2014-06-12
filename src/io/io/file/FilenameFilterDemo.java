/**
 * 
 */
package io.file;

import java.io.*;

import util.Printer;

/**
 * �ļ����������ӿ���ʾ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-10
 */
public class FilenameFilterDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		File path = new File("files/io.file"); 
		// �����ɴ˳���·��������ʾ��Ŀ¼�е��ļ�����Ŀ¼������������ַ�������
		String[] list = path.list();
		Printer.print(list);
		/*
		 * list()������Ϊ��Ŀ¼�����µ�ÿ���ļ�������accept()���жϸ��ļ��Ƿ�������ڣ��жϽ����accept()���ص�ֵ��ʾ��
		 * ������������ڲ����Ŀ�����ڰ�accept()�����ṩ��list()ʹ�ã�ʹlist()���Իص�accept()�����ֽṹ��Ϊ"�ص�"��
		 * �ص���Ŀ�ľ����ṩ�˴�����Ϊ������ԣ�ʹ�������ڲ���ʹ�ô�����롢��£��һ��(���ھ�)������ȴ�����Ķ���ά����
		 */
		list = path.list(new FilenameFilter() {

			/**
			 * �������������һ������ĳ���ض��ļ�����Ŀ¼��file���󣬸��ض��ļ����ļ���
			 * 
			 * @param dir
			 *            �ļ�����Ŀ¼
			 * @param name
			 *            �ļ���
			 */
			public boolean accept(File dir, String name) {
				return name.endsWith(".txt");
			}
		});
		Printer.print(list);
	}
}