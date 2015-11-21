/**
 * 
 */
package io.stream;

import java.util.Scanner;

/**
 * Scanner 类示例
 * <p>
 * JavaSE5新增了 Scanner 类，可以大大减轻扫描输入的工作负担。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2015年4月6日
 */
public class ScannerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Scanner 构造器可以接受任何类型的输入对象，比如File、InputStream、String等。
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your name:");
		/*
		 * 所有的输入、分词以及翻译的操作都隐藏在不同类型的next方法中。
		 * 所有的基本类型都有对应的next方法，包括BigInteger和BigDecimal。
		 * 所有的next方法，只有在找到一个完整的分词之后才会返回。 
		 */
		String name = scanner.next();
		System.out.printf("Hello %s! %n", name);
		
		System.out.println("Please enter your age:");
		int age = scanner.nextInt();
		System.out.printf("Wow! Your age is %d. %n", age);
		
		scanner.close();
	}
}
