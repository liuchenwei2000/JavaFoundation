/**
 * 
 */
package io.stream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;

/**
 * IO stream��ʾ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2009-7-19
 */
public class IOStreamDemo {

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		/** 1�������ȡ�ļ� */
		BufferedReader fReader = new BufferedReader(new FileReader(
				"files/io.stream/infile.txt"));
		String s = null;
		// һ���ִ��ļ�ĩβ��readLine()������null��������������ֹѭ��
		while ((s = fReader.readLine()) != null) {
			sb.append(s);
			// ������ӻ��з�����ΪreadLine()�Ѿ�������ɾ��
			sb.append("\n");
		}
		fReader.close();

		/** 2�������ȡ����̨���� */
		BufferedReader cReader = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.print("Enter a line:");
		System.out.println("Echo��" + cReader.readLine());

		/** 3����ȡ�ڴ����� */
		StringReader sReader = new StringReader(sb.toString());
		int c;
		// read()ÿ�ζ�ȡһ���ַ�����int��ʽ���أ�һ������ĩβ������-1
		while ((c = sReader.read()) != -1) {
			System.out.print((char) c);
		}

		/** 4����ȡ��ʽ���ڴ����� */
		try {
			DataInputStream din = new DataInputStream(new ByteArrayInputStream(
					sb.toString().getBytes()));
			while (true) {
				// ÿ�ζ�ֻ��ȡһ���ֽڣ�ʹ���쳣����������ĩβ
				// ����ʹ���쳣���������Ʊ���Ϊ�Ƕ��쳣���ԵĴ���ʹ��
				System.out.print((char) din.readByte());
			}
		} catch (EOFException e) {
			System.err.println("End...");
		}

		/** 5���ļ���� */
		try {
			BufferedReader reader = new BufferedReader(new StringReader(sb
					.toString()));
			// ���ȴ���һ����ָ���ļ����ӵ�FileWriter����ʹ��BufferedWriter�����װ�������Ի�������
			// ��������������������IO���������ܣ�Ȼ��Ϊ�˸�ʽ������ת����PrintWriter
			PrintWriter writer = new PrintWriter(new BufferedWriter(
					new FileWriter("files/io.stream/outfile.txt")));
			int lineCount = 1;
			while ((s = reader.readLine()) != null) {
				writer.println(lineCount++ + ": " + s);
			}
			// �����Ϊ���е�����ļ�����close()���򻺳������ݲ��ᱻˢ����գ���ô�ļ�Ҳ�Ͳ�����
			// ʵ�������������ݻ����ڻ������У�û�б�����ִ��д�����д���ļ���������Ҫ�ֹ�ȥˢ�»�����
			writer.close();
		} catch (EOFException e) {
			System.err.println("End of stream");
		}
		
		/** 5���洢�ͻָ����� */
		/*
		 * ��������԰�д�����ݵķ�ʽ����Ϊ���ࣺ
		 * һ��д��Ϊ��������ʹ��д������ݣ���һ����Ϊ��DataInputStream�����ٴζ�ȡ����
		 * PrintStream���Զ����ݽ��и�ʽ�����Ա����ǵ��Ķ�
		 * ����Ϊ������ɹ���һ�����ָ������ݣ���Ҫʹ��DataOutputStreamд�����ݣ�����DataInputStream�ָ�����
		 */
		try {
			String filePath = "files/io.stream/data.txt";
			DataOutputStream out = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(filePath)));
			out.writeDouble(3.14159);
			// д�ַ����ķ�ʽ
			out.writeUTF("That was pi");
			out.writeDouble(2.71828);
			out.writeUTF("That was e");
			out.close();
			/*
			 * Ϊ�˱�֤���еĶ��������ܹ���������������֪���������������ڵ�ȷ��λ��
			 * ��Ϊ���п��ܽ������double������Ϊһ���򵥵��ֽ����С�char ���������Ͷ���
			 * ��˱��룺
			 * ҪôΪ�ļ��е����ݲ��ù̶��ĸ�ʽ
			 * Ҫô���������Ϣ���浽�ļ��У��Ա��ܹ�������н����Ӷ�ȷ�����ݵĴ��λ��
			 * (�������л������Ǹ����׵Ĵ洢�Ͷ�ȡ�������ݽṹ�ķ�ʽ) 
			 */
			DataInputStream in = new DataInputStream(new BufferedInputStream(
					new FileInputStream(filePath)));
			System.out.println(in.readDouble());
			System.out.println(in.readUTF());
			System.out.println(in.readDouble());
			System.out.println(in.readUTF());
			in.close();
		} catch (Exception e) {
			System.err.println("End of stream");
		}
	}
}