/**
 * 
 */
package io.stream.standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * ��׼IO��ʾ��
 * <p>
 * "��׼I/O"�������ο�����Unix��"������ʹ�õĵ�һ��Ϣ��"������(��Windows������������ϵͳ�У�Ҳ��������ʽ��ʵ��)
 * ������������붼����������"��׼����"������������������Է��͵�"��׼���"���Լ����еĴ�����Ϣ�����Է��͵�"��׼����"��
 * <p> 
 * ��׼I/O���������ڣ�
 * ���Ժ����׵ذѳ�����������һ������ı�׼������Գ�Ϊ��һ����ı�׼����
 *  <p>
 * ���ձ�׼I/Oģ�ͣ�Java�ṩ��System.in��System.out �� System.err������Ĭ�϶�Ӧ�ڿ���̨���롢����̨����Ϳ���̨����
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-7-19
 */
public class StandardIODemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		/** ��׼������System.in */
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.print("Enter��");
		String s;
		while ((s = reader.readLine()) != null && s.length() != 0) {
			System.out.println("Echo��" + s);
			System.out.print("Enter:");
		}
		
		/** ��׼�����System.out */
		/*
		 * System.out��һ��PrintStream����PrintStream��һ�� OutputStream
		 * PrintWriter��һ�����Խ���OutputStreamSystem��Ϊ�����Ĺ�����
		 * ��ˣ�ֻҪ��Ҫ���Ϳ���ʹ���Ǹ���������System.outת����PrintWriter
		 */
		PrintWriter writer = new PrintWriter(System.out, true);
		writer.println("Hello world!");
	}
}