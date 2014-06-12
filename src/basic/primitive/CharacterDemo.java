/**
 * 
 */
package primitive;

/**
 * char包装类的演示
 * <p>
 * Character类提供了常用的字符特性判断方法
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-11-13
 */
public class CharacterDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Character.isDigit(char)用来判断一个字符是否是数字
		 * Character.isLetter(char)用来判断一个字符是否是字母
		 * Character.isLetterOrDigit(char)用来判断一个字符是否为字母或数字
		 */
		char ch = 'a';// 可以是'1'、'%'、'猫'、','、'π'等
		System.out.println(ch
				+ (Character.isDigit(ch) ? " is digit" : " is not digit"));
		System.out.println(ch
				+ (Character.isLetter(ch) ? " is letter" : " is not letter"));
		System.out.println(ch
				+ (Character.isLetterOrDigit(ch) ? " is letter or digit"
						: " is not letter or digit"));
		/*
		 * Character.isLowerCase(char)判断参数字符是否是大写形式
		 * Character.isLowerCase(char)判断参数字符是否是小写形式
		 * Character.toUpperCase(char)返回参数字符的大写形式的字符
		 * Character.toLowerCase(char)返回参数字符的小写形式的字符
		 */
		if (Character.isLowerCase(ch))
			System.out.println(ch + " is LowerCase");
		ch = Character.toUpperCase(ch);
		System.out.println("UpperCase : " + ch);
		if (Character.isUpperCase(ch))
			System.out.println(ch + " is UpperCase");
		ch = Character.toLowerCase(ch);
		System.out.println("LowerCase : " + ch);
	}
}