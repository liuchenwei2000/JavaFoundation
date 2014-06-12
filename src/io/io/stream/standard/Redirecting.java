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
 * 标准IO重定向
 * <p>
 * Java的System类提供一些简单的静态方法调用，允许对标准输入、输出和错误I/O流进行重定向： 
 * <li>setIn(InputStream)  
 * <li>setOut(PrintStream) 
 * <li>setErr(PrintStream) 
 * <p>
 * 如果突然开始在显示器上创建大量输出，而这些输出滚动的如此之快以至于无法阅读时，重定向输出就显得极为有用。
 * 对于想重复测试特定用户的输入序列的命令行程序来说，重定向输入就很有价值。
 * <p>
 * 这个程序将标准输入附加在文件上，并将标准输出和标准错误重定向到另一个文件。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-7-19
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
		// 此时System.in将从infile.txt文件中进行读取
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		String s;
		while ((s = reader.readLine()) != null) {
			// 此时System.out将把string输入到outfile.txt中
			System.out.println(s);
		}
		out.close();
		// 重新设定标准输出流控制台
		System.setOut(System.out);
	}
}