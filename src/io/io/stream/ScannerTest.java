/**
 * 
 */
package io.stream;

import java.util.Scanner;

/**
 * Scanner ��ʾ��
 * <p>
 * JavaSE5������ Scanner �࣬���Դ�����ɨ������Ĺ���������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2015��4��6��
 */
public class ScannerTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// Scanner ���������Խ����κ����͵�������󣬱���File��InputStream��String�ȡ�
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please enter your name:");
		/*
		 * ���е����롢�ִ��Լ�����Ĳ����������ڲ�ͬ���͵�next�����С�
		 * ���еĻ������Ͷ��ж�Ӧ��next����������BigInteger��BigDecimal��
		 * ���е�next������ֻ�����ҵ�һ�������ķִ�֮��Ż᷵�ء� 
		 */
		String name = scanner.next();
		System.out.printf("Hello %s! %n", name);
		
		System.out.println("Please enter your age:");
		int age = scanner.nextInt();
		System.out.printf("Wow! Your age is %d. %n", age);
		
		scanner.close();
	}
}
