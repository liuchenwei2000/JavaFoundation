/**
 * 
 */
package string;

/**
 * StringBuilder表示一个可变的字符序列(默认增幅16)
 * <p>
 * 此类提供一个与StringBuffer兼容的API，但不保证同步。
 * 该类被设计用作StringBuffer的一个简易替换， 用在字符串缓冲区被单个线程使用的时候。
 * 建议优先采用该类，因为在大多数实现中，它比StringBuffer要快。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-9-13
 */
public class StringBuilderDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();
		/*
		 * 在StringBuilder上的主要操作是append和insert方法，可重载这些方法，以接受任意类型的数据，
		 * 每个方法都能有效地将给定的数据转换成字符串，然后将该字符串的字符追加或插入到字符串生成器中。
		 * append方法始终将这些字符添加到生成器的末端，而insert方法则在指定的点添加字符。
		 * */
		sb.append("this a sb");
		sb.insert(4, " is");
		System.out.println(sb);
		/*
		 * delete(int start,int end)移除此序列的子字符串中的字符，
		 * 该子字符串从指定的 start 处开始，一直到索引 end - 1处的字符，如果不存在这种字符，则一直到序列尾部。
		 * 如果start等于end，则不发生任何更改。
		 * 
		 * deleteCharAt(int index)移除此序列指定位置上的char。
		 */
		System.out.println("after deleting " + sb.substring(4, 7) + " : "
				+ sb.delete(4, 7));
		System.out.println("after deleting char " + sb.charAt(sb.length() - 1)
				+ " : " + sb.deleteCharAt(sb.length() - 1));
		// setCharAt(int index,char ch)将给定索引处的字符设置为ch
		sb.setCharAt(0, 'T');
		System.out.println(sb);
		// length()返回它所包含的字符个数
		System.out.println("length of sb : " + sb.length());
		// capacity()返回它的当前容量(默认16，当需要更多时自动增加)
		System.out.println("capacity of sb : " + sb.capacity());
		// 将此字符序列用其反转形式取代
		System.out.println("reverse : " + sb.reverse());
		System.out.println("after revercing sb : " + sb);
	}
}