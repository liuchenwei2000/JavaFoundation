/**
 * 
 */
package jdk5;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import static java.lang.Math.*;

/**
 * JDK5����������
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-9-11
 */
public class Others {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * ����
		 * 
		 * ����ָ��������Ԫ�ص����ͣ�����ʹ���ڱ���ʱ�̽������ͼ�顣
		 */
		Collection<String> c = new ArrayList<String>();
		c.add("string");
		c.add("collection");
		
		/*
		 * for-eachѭ��
		 * 
		 * ��������ͼ��ϵı��� �����ұ�����ǿ������ת����
		 */
		// for-each�������Ԫ��
		int a[] = { 1, 2, 3, 4, 5 };
		for (int item : a)
			System.out.print(item + " ");
		System.out.println();

		// ��ͳ�������Ԫ��
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();

		// for-each�������Ԫ��
		for (String item : c)
			System.out.print(item + " ");
		System.out.println();

		// ��ͳ�������Ԫ��
		Iterator<String> it = c.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		System.out.println();

		/*
		 * �Զ�װ��/���
		 * 
		 * ʹ�û����������ݺ����ǰ�װ���ܹ��Զ�ת��������˼����಻�ܴ洢�������͵����⡣
		 * �����Զ���װ���Ʋ���Ӧ�������顣
		 */
		int b = 2;
		Collection<Integer> c2 = new ArrayList<Integer>();
		c2.add(b + 2);// ��ִ�мӷ�Ȼ��ת����Integer����
		
		/*
		 * ��̬�����
		 * 
		 * import static java.lang.Math.*;
		 * 
		 * ʹ�ò�������Math.sin();�ķ�ʽ�������ľ�̬��������ֱ�ӿ���sin();�ķ�ʽ����Math���о�̬������
		 * ����ͬʱҲ�����˳���Ŀɶ��ԡ�
		 */
		double d = sin(0.5);
		System.out.println("sin(0) = " + d);
	}
}