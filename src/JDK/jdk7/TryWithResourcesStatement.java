/**
 * 
 */
package jdk7;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 5，try-with-resources语句
 * <p>
 * Java SE 7中新增了try-with-resources语句。try-with-resources语句是一个声明了一个或多个资源的try语句。
 * 这里的一个资源指的是在使用完成后必须关闭释放的对象。try-with-resources语句可以确保在该语句执行之后关闭每个资源。
 * 所有实现了java.lang.AutoCloseable接口的对象均可以作为资源在try-with-resources语句中使用(java.io.Closeable是其子接口，因此也支持)。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年12月19日
 */
public class TryWithResourcesStatement {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		String path = "";
		doBeforeJDK1_7(path);
		doAfterJDK1_7(path);
		doAfterJDK1_7_2();
	}

	/**
	 * 在Java SE 7之前，为了确保资源被关闭，可能会编写如下代码：
	 */
	private static String doBeforeJDK1_7(String path) throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(path));
			return br.readLine();
		} finally {
			if (br != null) {
				br.close();
			}
		}
	}

	/**
	 * 在Java SE 7中，可以用下面的代码来替换上面的代码了：
	 */
	private static String doAfterJDK1_7(String path) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(path))) {
			return br.readLine();
		}
	}
	
	/**
	 * try中可以同时声明多个资源：
	 * <p>
	 * try-with-resources语句执行完毕后，系统先关闭释放bw，再关闭释放br。
	 * 也就是说，try-with-resources语句中资源的关闭释放顺序和它们创建的顺序相反。
	 */
	private static void doAfterJDK1_7_2() throws IOException {
		try (
				BufferedReader br = new BufferedReader(new FileReader("in.txt"));
				BufferedWriter bw = new BufferedWriter(new FileWriter("out.txt"))
			) 
		{
			bw.write(br.readLine());
		}
	}
}
