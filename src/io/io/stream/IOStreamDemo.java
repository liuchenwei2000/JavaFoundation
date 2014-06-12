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

	/**
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		StringBuilder sb = new StringBuilder();
		/** 1，缓冲读取文件 */
		BufferedReader fReader = new BufferedReader(new FileReader(
				"files/io.stream/infile.txt"));
		String s = null;
		// 一旦抵达文件末尾，readLine()将返回null，所以用它来终止循环
		while ((s = fReader.readLine()) != null) {
			sb.append(s);
			// 必须添加换行符，因为readLine()已经将它们删除
			sb.append("\n");
		}
		fReader.close();

		/** 2，缓冲读取控制台输入 */
		BufferedReader cReader = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.print("Enter a line:");
		System.out.println("Echo：" + cReader.readLine());

		/** 3，读取内存输入 */
		StringReader sReader = new StringReader(sb.toString());
		int c;
		// read()每次读取一个字符，以int形式返回，一旦到达末尾将返回-1
		while ((c = sReader.read()) != -1) {
			System.out.print((char) c);
		}

		/** 4，读取格式化内存输入 */
		try {
			DataInputStream din = new DataInputStream(new ByteArrayInputStream(
					sb.toString().getBytes()));
			while (true) {
				// 每次都只读取一个字节，使用异常来检测输入的末尾
				// 但是使用异常进行流控制被认为是对异常特性的错误使用
				System.out.print((char) din.readByte());
			}
		} catch (EOFException e) {
			System.err.println("End...");
		}

		/** 5，文件输出 */
		try {
			BufferedReader reader = new BufferedReader(new StringReader(sb
					.toString()));
			// 首先创建一个与指定文件连接的FileWriter，并使用BufferedWriter将其包装起来用以缓冲输入
			// 缓冲往往能显著地增加IO操作的性能，然后为了格式化把它转换成PrintWriter
			PrintWriter writer = new PrintWriter(new BufferedWriter(
					new FileWriter("files/io.stream/outfile.txt")));
			int lineCount = 1;
			while ((s = reader.readLine()) != null) {
				writer.println(lineCount++ + ": " + s);
			}
			// 如果不为所有的输出文件调用close()，则缓冲区内容不会被刷新清空，那么文件也就不完整
			// 实际上是最后的内容还被在缓冲区中，没有被真正执行写入操作写入文件，所以需要手工去刷新缓冲区
			writer.close();
		} catch (EOFException e) {
			System.err.println("End of stream");
		}
		
		/** 5，存储和恢复数据 */
		/*
		 * 输出流可以按写入数据的方式划分为两类：
		 * 一种写是为了让人们使用写入的数据，另一种是为了DataInputStream可以再次读取它们
		 * PrintStream可以对数据进行格式化，以便人们的阅读
		 * 但是为了输出可供另一个流恢复的数据，需要使用DataOutputStream写入数据，并用DataInputStream恢复数据
		 */
		try {
			String filePath = "files/io.stream/data.txt";
			DataOutputStream out = new DataOutputStream(
					new BufferedOutputStream(new FileOutputStream(filePath)));
			out.writeDouble(3.14159);
			// 写字符串的方式
			out.writeUTF("That was pi");
			out.writeDouble(2.71828);
			out.writeUTF("That was e");
			out.close();
			/*
			 * 为了保证所有的读方法都能够正常工作，必须知道流中数据项所在的确切位置
			 * 因为极有可能将保存的double数据作为一个简单的字节序列、char 或其他类型读入
			 * 因此必须：
			 * 要么为文件中的数据采用固定的格式
			 * 要么将额外的信息保存到文件中，以便能够对其进行解析从而确定数据的存放位置
			 * (对象序列化可能是更容易的存储和读取复杂数据结构的方式) 
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