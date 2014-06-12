/**
 * 
 */
package string;

/**
 * String和StringBuffer的区别
 * <p>
 * String: 
 * 包含在类型String对象中的字符串的不可改变 ， 意味着String实例一旦被创建 它的内容将不能被改变，
 * 然而被定义为String引用的变量可以被改变，以指向的另外的字符串对象。
 * <p>
 * StringBuffer: 
 * 表示可变长的和可写的字符串序列。
 * <p>
 * 使用区别: 
 * 当对字符串的修改比较频繁的时候(比如在for循环中)， 使用StringBuffer比String效率要高。
 * <p>
 * StringBuffer和StringBuilder的方法一般都是相似的， 类基本方法示例可以参考StringBuilderDemo类。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public class StringBufferDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// a这个字符串对象被创建且分配内存,以后不可改变.s是指向a的一个引用.
		String s = "a";
		// b这个字符串对象被创建且分配内存,以后不可改变.s现在指向b
		s = "b";
		StringBuffer sb = new StringBuffer();
		sb.append("a");// 创建一个StingBuffer对象并分配内存,把a追加到该内存中
		sb.append("b");// 把b追加到该内存中
		System.out.println("String = " + s);
		System.out.println("StringBuffer = " + sb);
	}
}