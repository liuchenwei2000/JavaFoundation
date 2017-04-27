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
 * IO stream演示
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2009-7-19
 */
public class IOStreamDemo {
	
	private static final String FILE_PATH_IN = "files/io.stream/infile.txt";
	private static final String FILE_PATH_OUT = "files/io.stream/outfile.txt";
	private static final String FILE_PATH_DATA = "files/io.stream/data.txt";

	/**
	 * 1，缓冲读取文件
	 */
	private static String readFromFile(String filePath) throws IOException {
		StringBuilder sb = new StringBuilder();
		BufferedReader fReader = null;
		try {
			fReader = new BufferedReader(new FileReader(filePath));
			String s;
			// 一旦抵达文件末尾，readLine()将返回null，所以用它来终止循环
			while ((s = fReader.readLine()) != null) {
				sb.append(s);
				// 必须添加换行符，因为readLine()已经将它们删除
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
	 * 2，缓冲读取控制台输入
	 */
	private static void readFromConsole() throws IOException{
		BufferedReader cReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter a line:");
		System.out.println("Echo：" + cReader.readLine());
	}
	
	/**
	 * 3，读取内存字符输入
	 */
	private static void readFromMemoryByChar(String content) throws IOException {
		StringReader sReader = null;
		try {
			sReader = new StringReader(content);
			int c;
			// read() 每次读取一个字符，以 int 形式返回，一旦到达末尾将返回-1
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
	 * 4，读取内存字节输入
	 */
	private static void readFromMemoryByByte(String content) throws IOException{
		DataInputStream din = null;
		try {
			din = new DataInputStream(new ByteArrayInputStream(content.getBytes()));
			while (true) {
				// 每次都只读取一个字节，使用异常来检测输入的末尾
				// 但是使用异常进行流控制被认为是对异常特性的错误使用
				System.out.print((char) din.readByte());
			}
		} catch (EOFException e) {
			System.err.println("End...");
		} finally {
			din.close();
		}
	}
	
	/**
	 * 5，缓冲输出到文件
	 */
	private static void writeToFile(String content, String filePath) throws IOException {
		PrintWriter writer = null;
		try {
			// 首先创建一个与指定文件连接的 FileWriter，并使用 BufferedWriter 将其包装起来用以缓冲输入。
			// 缓冲往往能显著地增加 IO 操作的性能，然后为了格式化把它转换成 PrintWriter。
			writer = new PrintWriter(new BufferedWriter(new FileWriter(filePath)));
			writer.println(content);
		} catch (EOFException e) {
			System.err.println("End of stream");
		} finally {
			if(writer != null) {
				// 如果不为所有的输出文件调用 close()，则缓冲区内容不会被刷新清空，那么文件也就不完整。
				// 实际上是最后的内容还被在缓冲区中，没有被真正执行写入操作写入文件，所以需要手工去刷新缓冲区。
				writer.close();
			}
		}
	}
	
	/**
	 * 6，存储和恢复数据
	 */
	private static void storeAndRetrieve(String content, String filePath) throws IOException {
		/*
		 * 输出流可以按写入数据的方式划分为两类：
		 * 一种写是为了让人们使用写入的数据，另一种是为了DataInputStream可以再次读取它们。
		 * PrintStream 可以对数据进行格式化，以便人们的阅读。
		 * 但是为了输出可供另一个流恢复的数据，需要使用 DataOutputStream 写入数据，并用 DataInputStream 恢复数据。
		 */
		DataOutputStream out = null;
		try {
			out = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(filePath)));
			out.writeDouble(3.14159);
			// 写字符串的方式
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
		 * 为了保证所有的读方法都能够正常工作，必须知道流中数据项所在的确切位置。
		 * 因为极有可能将保存的 double 数据作为一个简单的字节序列、char 或其他类型读入，因此必须：
		 * 要么为文件中的数据采用固定的格式；要么将额外的信息保存到文件中，
		 * 以便能够对其进行解析从而确定数据的存放位置。(对象序列化可能是更容易的存储和读取复杂数据结构的方式)
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
