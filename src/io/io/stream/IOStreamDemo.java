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
	
	private static final String FILE_PATH_IN = "files/io.stream/infile.txt";
	private static final String FILE_PATH_OUT = "files/io.stream/outfile.txt";
	private static final String FILE_PATH_DATA = "files/io.stream/data.txt";

	/**
	 * 1�������ȡ�ļ�
	 */
	private static String readFromFile(String filePath) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader fReader = null;
		try {
			fReader = new BufferedReader(new FileReader(filePath));
			String s = null;
			// һ���ִ��ļ�ĩβ��readLine()������null��������������ֹѭ��
			while ((s = fReader.readLine()) != null) {
				sb.append(s);
				// ������ӻ��з�����ΪreadLine()�Ѿ�������ɾ��
				sb.append("\n");
			}
			return sb.toString();
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (fReader != null) {
				fReader.close();
			}
		}
	}
	
	/**
	 * 2�������ȡ����̨����
	 */
	private static void readFromConsole() throws IOException{
		BufferedReader cReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter a line:");
		System.out.println("Echo��" + cReader.readLine());
	}
	
	/**
	 * 3����ȡ�ڴ��ַ�����
	 */
	private static void readFromMemoryByChar(String content) throws IOException {
		StringReader sReader = null;
		try {
			sReader = new StringReader(content);
			int c;
			// read()ÿ�ζ�ȡһ���ַ�����int��ʽ���أ�һ������ĩβ������-1
			while ((c = sReader.read()) != -1) {
				System.out.print((char) c);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			sReader.close();
		}
	}
	
	/**
	 * 4����ȡ�ڴ��ֽ�����
	 */
	private static void readFromMemoryByByte(String content) throws IOException{
		DataInputStream din = null;
		try {
			din = new DataInputStream(new ByteArrayInputStream(content.getBytes()));
			while (true) {
				// ÿ�ζ�ֻ��ȡһ���ֽڣ�ʹ���쳣����������ĩβ
				// ����ʹ���쳣���������Ʊ���Ϊ�Ƕ��쳣���ԵĴ���ʹ��
				System.out.print((char) din.readByte());
			}
		} catch (EOFException e) {
			System.err.println("End...");
		} finally {
			din.close();
		}
	}
	
	/**
	 * 5������������ļ�
	 */
	private static void writeToFile(String content, String filePath) throws IOException {
		PrintWriter writer = null;
		try {
			// ���ȴ���һ����ָ���ļ����ӵ�FileWriter����ʹ��BufferedWriter�����װ�������Ի������롣
			// ��������������������IO���������ܣ�Ȼ��Ϊ�˸�ʽ������ת����PrintWriter��
			writer = new PrintWriter(new BufferedWriter(new FileWriter(filePath)));
			writer.println(content);
		} catch (EOFException e) {
			System.err.println("End of stream");
		} finally {
			if(writer != null) {
				// �����Ϊ���е�����ļ�����close()���򻺳������ݲ��ᱻˢ����գ���ô�ļ�Ҳ�Ͳ�������
				// ʵ�������������ݻ����ڻ������У�û�б�����ִ��д�����д���ļ���������Ҫ�ֹ�ȥˢ�»�������
				writer.close();
			}
		}
	}
	
	/**
	 * 6���洢�ͻָ�����
	 */
	private static void storeAndRetrieve(String content, String filePath) throws IOException {
		/*
		 * ��������԰�д�����ݵķ�ʽ����Ϊ���ࣺ
		 * һ��д��Ϊ��������ʹ��д������ݣ���һ����Ϊ��DataInputStream�����ٴζ�ȡ���ǡ�
		 * PrintStream���Զ����ݽ��и�ʽ�����Ա����ǵ��Ķ���
		 * ����Ϊ������ɹ���һ�����ָ������ݣ���Ҫʹ��DataOutputStreamд�����ݣ�����DataInputStream�ָ����ݡ�
		 */
		DataOutputStream out = null;
		try {
			out = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(filePath)));
			out.writeDouble(3.14159);
			// д�ַ����ķ�ʽ
			out.writeUTF("That was pi");
			out.writeDouble(2.71828);
			out.writeUTF("That was e");
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}finally {
			if(out != null) {
				out.close();
			}
		}
		
		/*
		 * Ϊ�˱�֤���еĶ��������ܹ���������������֪���������������ڵ�ȷ��λ�á�
		 * ��Ϊ���п��ܽ������double������Ϊһ���򵥵��ֽ����С�char ���������Ͷ��룬��˱��룺
		 * ҪôΪ�ļ��е����ݲ��ù̶��ĸ�ʽ��
		 * Ҫô���������Ϣ���浽�ļ��У��Ա��ܹ�������н����Ӷ�ȷ�����ݵĴ��λ�á�
		 * (�������л������Ǹ����׵Ĵ洢�Ͷ�ȡ�������ݽṹ�ķ�ʽ) 
		 */
		DataInputStream in = null;
		try {
			in = new DataInputStream(new BufferedInputStream(
					new FileInputStream(filePath)));
			System.out.println(in.readDouble());
			System.out.println(in.readUTF());
			System.out.println(in.readDouble());
			System.out.println(in.readUTF());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		} finally {
			if (in != null) {
				in.close();
			}
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			System.out.println("********************readFromFile***********************");
			String content = readFromFile(FILE_PATH_IN);
			System.out.println("********************readFromConsole***********************");
			readFromConsole();
			System.out.println("********************readFromMemoryByChar***********************");
			readFromMemoryByChar(content);
			System.out.println("********************readFromMemoryByByte***********************");
			readFromMemoryByByte(content);
			System.out.println("********************writeToFile***********************");
			writeToFile(content, FILE_PATH_OUT);
			System.out.println("********************storeAndRetrieve***********************");
			storeAndRetrieve(content, FILE_PATH_DATA);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}