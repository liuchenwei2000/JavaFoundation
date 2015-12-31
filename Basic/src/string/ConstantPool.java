/**
 * 
 */
package string;

/**
 * 常量池
 * <p>
 * 指的是在编译期被确定，并被保存在已编译的.class文件中的一些数据，
 * 它包括了关于类、方法、接口等中的常量，也包括字符串常量。
 * <p>
 * String是一个特殊包装类，其引用是存放在栈里的，而对象内容必须根据创建方式不同来定(常量池和堆)。
 * 有的是编译期就已经创建好，存放在字符串常量池中，而有的是运行时才被创建，使用new关键字，存放在堆中。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-2
 */
public class ConstantPool {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * String可以用下面两种形式来创建：
		 * 第一种形式是用new()来新建对象的，它会被存放于堆中，每调用一次就会创建一个新的对象。 
		 * 第二种形式是先在栈中创建一个对String类对象的引用变量，然后去字符串常量池里找有没有"abc"，
		 * 如果没有，则将"abc"存放进字符串常量池，并令str2指向"abc"；如果已经有"abc"则直接令str2指向"abc"。
		 */
		String str1 = new String("abc");
		String str2 = "abc";
		/*
		 * 下面这种方式创建2个"abc"字符串，在内存中其实只存在一个对象而已，这种写法有利于节省内存空间。 
		 * 同时还可以在一定程度上提高程序的运行速度，因为JVM会自动根据栈中数据的实际情况来决定是否有必要创建新对象。
		 * 但是这种方式并不能保证一定会创建对象，也可能只是指向一个先前已经创建的对象。
		 */
		str1 = "abc";
		str2 = "abc";
		System.out.println(str1 == str2);// true
		/*
		 * 下面这种方式会一概在堆中创建新对象，而不管字符串值是否相等，是否有必要创建新对象，从而加重了程序的负担。
		 */
		str1 = new String("abc");
		str2 = new String("abc");
		System.out.println(str1 == str2);// false
		/*
		 * JVM对于字符串常量的"+"号连接，在编译器就将常量字符串的"+"优化为连接后的值。
		 * 比如下面的例子"a" + 1，经编译器优化后在class文件中就已经是a1。
		 */
		String a = "a1";
		String b = "a" + 1;
		System.out.println(a == b);// true

		a = "atrue";
		b = "a" + true;
		System.out.println(a == b);// true

		a = "a3.4";
		b = "a" + 3.4;
		System.out.println(a == b);// true

		a = "ab";
		b = "a" + "b";
		System.out.println(a == b);// true
		/*
		 * 由于在字符串的"+"连接中，有字符串引用存在，而引用的值在程序编译期是无法确定的，
		 * 即"a" + bb 无法被编译器优化，只有在程序运行期来动态分配并将连接后的新地址赋给b。 
		 */
		String bb = "b";
		a = "ab";
		b = "a" + bb;
		System.out.println(a == b);// false
		/*
		 * 和上例不同的是变量bbb加了final修饰，对于final修饰的变量，
		 * 它在编译时被解析为常量值的一个本地拷贝存储到自己的常量池中，
		 * 所以此时的"a" + bbb和"a" + "b"效果是一样的。
		 */
		final String bbb = "b";
		a = "ab";
		b = "a" + bbb;
		System.out.println(a == b);// true
		/*
		 * JVM对于字符串引用bb，它的值在编译器无法确定，
		 * 只有在运行时调用方法后，将方法的返回值和"a"来动态连接并分配地址给b。
		 */
		final String bbbb = getBBBB();
		a = "ab";
		b = "a" + bbbb;
		System.out.println(a == b);// false
		/*
		 * 下面的s1/s2这两种写法是等价的 
		 */
		String s1 = "a" + "b" + "c";
		String s2 = "abc";
		/*
		 * 下面的s1/s2这两种写法是等价的
		 */
		String sa = "a";
		String sb = "b";
		String sc = "c";
		s1 = sa + sb + sc;// 如下所示：会产生大量的StringBuffer对象
		s2 = new StringBuffer().append(sa).append(sb).append(sc).toString();
		/*
		 * 字符串每做一次"+"就会产生个StringBuffer对象，然后append后就扔掉。
		 * 所以下面这个情况会产生大量的临时StringBuffer对象，效率低下。
		 * 在循环中，都应该直接使用StringBuffer或StringBuilder进行append操作。
		 */
		@SuppressWarnings("unused")
		String s = "";
		for (int i = 0; i < 100; i++) {
			s += "a";
		}
		/*
		 * Java会确保一个字符串常量只有一个拷贝 。
		 * 
		 * 因为例子中的s0和s1中的"kvill"都是字符串常量，它们在编译期就被确定了，所以s0==s1为true。
		 * 而"kv"和"ill"也都是字符串常量，当一个字符串由多个字符串常量连接而成时，它自己肯定也是字符串常量。
		 * 所以s2也同样在编译期就被解析为一个字符串常量也是常量池中"kvill"的一个引用。 
		 */
		String s0 = "kvill";
		s1 = "kvill";
		s2 = "kv" + "ill";
		System.out.println(s0 == s1);// true
		System.out.println(s0 == s2);// true
		
		/*
		 * 用new String()创建的字符串不是常量，不能在编译期就确定，
		 * 所以new String()创建的字符串不放入常量池中，它们有自己的地址空间。
		 */
		String s3 = "string";
		String s4 = new String("string");
		String s5 = "str" + new String("ing");
		System.out.println(s3 == s4);// false
		System.out.println(s3 == s5);// false
		System.out.println(s4 == s5);// false
		/*
		 * 存在于.class文件中的常量池，在运行期被JVM装载，并且可以扩充。
		 * String的intern()方法就是扩充常量池的一个方法：
		 * 当一个String实例调用intern()方法时，JVM查找常量池中是否有相同Unicode的字符串常量，
		 * 如果有则返回其引用，如果没有则在常量池中增加一个Unicode等于该实例的字符串并返回它的引用。 
		 */
		String str = "sss";
		String stra = new String("sss");
		String strb = new String("sss");
		System.out.println(str == stra);// false
		stra.intern();
		strb = strb.intern();// 把常量池中"sss"的引用赋给strb
		System.out.println(str == stra);// false
		System.out.println(str == stra.intern());// true
		System.out.println(str == strb);// true
	}
	
	private static String getBBBB(){
		return "b";
	}
}
