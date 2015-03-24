/**
 * 
 */
package io.stream.standard;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

/**
 * 标准IO演示类
 * <p>
 * "标准I/O"这个术语参考的是Unix中"程序所使用的单一信息流"这个概念。(在Windows和其他许多操作系统中，也有相似形式的实现)
 * 程序的所有输入都可以来自于"标准输入"，它的所有输出都可以发送到"标准输出"，以及所有的错误信息都可以发送到"标准错误"。
 * <p> 
 * 标准I/O的意义在于：
 * 可以很容易地把程序串联起来，一个程序的标准输出可以成为另一程序的标准输入
 *  <p>
 * 按照标准I/O模型，Java提供了System.in，System.out 和 System.err，它们默认对应于控制台输入、控制台输出和控制台错误。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-7-19
 */
public class StandardIODemo {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		/** 标准输入流System.in */
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		System.out.print("Enter：");
		String s;
		while ((s = reader.readLine()) != null && s.length() != 0) {
			System.out.println("Echo：" + s);
			System.out.print("Enter:");
		}
		
		/** 标准输出流System.out */
		/*
		 * System.out是一个PrintStream，而PrintStream是一个 OutputStream
		 * PrintWriter有一个可以接受OutputStreamSystem作为参数的构造器
		 * 因此，只要需要，就可以使用那个构造器把System.out转换成PrintWriter
		 */
		PrintWriter writer = new PrintWriter(System.out, true);
		writer.println("Hello world!");
	}
}