/**
 * 
 */
package io.stream.standard;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * ��׼IO�ض���
 * <p>
 * Java��System���ṩһЩ�򵥵ľ�̬�������ã�����Ա�׼���롢����ʹ���I/O�������ض��� 
 * <li>setIn(InputStream)  
 * <li>setOut(PrintStream) 
 * <li>setErr(PrintStream) 
 * <p>
 * ���ͻȻ��ʼ����ʾ���ϴ����������������Щ������������֮���������޷��Ķ�ʱ���ض���������Եü�Ϊ���á�
 * �������ظ������ض��û����������е������г�����˵���ض�������ͺ��м�ֵ��
 * <p>
 * ������򽫱�׼���븽�����ļ��ϣ�������׼����ͱ�׼�����ض�����һ���ļ���
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-7-19
 */
public class Redirecting {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String infile = "files/io.stream.standard/infile.txt";
		String outfile = "files/io.stream.standard/outfile.txt";
		
		BufferedInputStream in = new BufferedInputStream(new FileInputStream(
				infile));
		PrintStream out = new PrintStream(new BufferedOutputStream(
				new FileOutputStream(outfile)));
		System.setIn(in);
		System.setOut(out);
		System.setErr(out);
		// ��ʱSystem.in����infile.txt�ļ��н��ж�ȡ
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String s;
		while ((s = reader.readLine()) != null) {
			// ��ʱSystem.out����string���뵽outfile.txt��
			System.out.println(s);
		}
		out.close();
		// �����趨��׼���������̨
		System.setOut(System.out);
	}
}