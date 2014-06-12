/**
 * 
 */
package primitive;

/**
 * 字面量演示类
 * <p>
 * 基本数据类型是Java语言的内置类型，它们并不是由类创建的对象。
 * 字面量(literal)是一个定值的源码表达方式，它能在代码中直接表示而不需要计算。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-8-14
 */
public class LiteralDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 下面的 true、c、1都是字面量
		boolean b = true;
		System.out.println(b);
		char c = 'c';
		System.out.println(c);
		int i = 1;
		System.out.println(i);
		// 整数类型(byte, short, int, long)可以由十进制、八进制、十六进制的字面量表示
		// 字面量中的前缀"0"表示它是八进制，"0x"表示它是十六进制
		int dec = 26; // 十进制表示 26
		System.out.println(dec);
		int oct = 032; // 八进制表示 26
		System.out.println(oct);
		int hex = 0x1a; // 十六进制表示 26
		System.out.println(hex);
		// 浮点数类型(float, double)可以使用E或者e(科学计数法)，
		double d1 = 123.4;
		System.out.println(d1);
		double d2 = 1.234e2;// 科学计数法表示123.4
		System.out.println(d2);
		// F或者f后缀表示32位浮点数字面量(即真正的float类型)，
		float f1 = 123.4f;
		System.out.println(f1);
		// D或者d后缀表示64位浮点数字面量(即真正的double类型，Java会默认省略)
		double d3 = 123.4D;
		System.out.println(d3);
		/*
		 * char类型和String类型的字面量可以包含Unicode(UTF-16)字符
		 * 如果编辑器和文件系统允许这么做，那就可以在代码中直接使用这些字符
		 * 否则，就必须使用Unicode转义(Unicode escape：用'反斜线u'前缀标识)
		 * 比如'\u0144'(升调小写n)，或者"S\u0144 se\u0144"
		 * char类型字面量使用单引号('')括起来，String类型字面量使用双引号("")括起来 
		 * Unicode转义序列可以在程序中的任何地方使用，比如变量名等等，不仅仅是char或String的字面量
		 */
		char ch = '\u0144';
		System.out.println(ch);
		String s = "S\u0144 se\u0144";
		System.out.println(s);
	}
}