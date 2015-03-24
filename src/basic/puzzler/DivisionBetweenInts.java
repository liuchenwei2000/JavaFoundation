/**
 * 
 */
package puzzler;

/**
 * int型整数间的除法(和乘法)
 * <p>
 * 在操作过程中会造成数据丢失。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-11-6
 */
public class DivisionBetweenInts {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a = 8;
		int b = 5;
		double result = a/b;
		/*
		 * 输出：8/5 = 1.0 
		 * 因为在运算a/b时是两个int型整数做除法，最后的结果还是int型整数。
		 * 当这个int型整数在赋值给result时会被提升到double型，但是数据已经不准确了。
		 */
		System.out.println(a + "/" + b + " = " + result);
		
		/** 解决方法 */
		/*
		 * 在除法运算之前提升int型整数为double型，这样除法的结果就是准确的double型值。
		 */
		result = (double)a/b;
		System.out.println(a + "/" + b + " = " + result);
		
		/*********同理还有int型数据溢出的问题************/
		long la = 24 * 60 * 60 * 1000 * 1000;
		/*
		 * 输出：la = 500654080
		 * 同样是因为在做乘法运算时都是int型的整数，最后的结果86400000000已经超过int型表示的上限。
		 * 所以数据溢出了，最后得到不正确的结果。
		 */
		System.out.println("la = " + la);
		
		/** 解决方法 */
		/*
		 *在乘法运算之前将int型整数提升到long型
		 */
		la = 24L * 60 * 60 * 1000 * 1000;
		System.out.println("la = " + la);
	}
}