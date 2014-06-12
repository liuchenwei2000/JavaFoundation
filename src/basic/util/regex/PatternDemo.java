/**
 * 
 */
package util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Pattern类一般方法演示
 * <p>
 * Pattern类实例是正则表达式的编译表示形式
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-12-18
 */
public class PatternDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 将给定的正则表达式编译到模式中
		Pattern p = Pattern.compile("a*b");
		// 创建匹配给定输入和此模式的匹配器
		Matcher m = p.matcher("aaaaab");
		boolean match = m.matches();
		// 编译给定正则表达式并将给定输入与其匹配，相当于上面的三条语句的执行效果
		// 如果要多次使用一种模式，编译一次后重用此模式比每次都调用此方法效率更高
		match = Pattern.matches("a*b", "aaaaab");
		if (match)
			System.out.println("match!");
		else
			System.out.println("not match!");
		// 返回在其中编译过此模式的正则表达式
		String regex = p.pattern();
		System.out.println(regex);
	}
}