/**
 * 
 */
package util;

import java.util.Random;

/**
 * Random类的基本方法
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public class RandomDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Random r = new Random();
		int number = r.nextInt(100);//返回0-指定值100(不含)之间的随机数
		System.out.println("Random integer : " + number);
		double d = r.nextDouble();//返回0.0-1.0(不含)之间的随机数
		System.out.println("Random double : " + d);
		System.out.println("Random boolean : " + r.nextBoolean());
	}
}
