/**
 * 
 */
package util;

import java.util.Random;

/**
 * Random��Ļ�������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public class RandomDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random r = new Random();
		int number = r.nextInt(100);//����0-ָ��ֵ100(����)֮��������
		System.out.println("Random integer : " + number);
		double d = r.nextDouble();//����0.0-1.0(����)֮��������
		System.out.println("Random double : " + d);
		System.out.println("Random boolean : " + r.nextBoolean());
	}
}