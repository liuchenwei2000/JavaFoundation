/**
 * 
 */
package util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Matcher类一般方法演示
 * <p>
 * Matcher类实例是通过解释Pattern对字符序列执行匹配操作的引擎
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-12-18
 */
public class MatcherDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pattern p = Pattern.compile("a*b");
		Matcher m = p.matcher("aaaab");
		// 当且仅当整个输入序列匹配此匹配器的模式时才返回true
		boolean allMatch = m.matches();
		System.out.println("allMatch  " + allMatch);
		// 当且仅当输入序列的前缀匹配此匹配器的模式时才返回true
		boolean prefixMatch = m.lookingAt();
		System.out.println("prefixMatch  " + prefixMatch);
		/*
		 * 当且仅当输入序列的子序列匹配此匹配器的模式时才返回true 
		 * 尝试查找与该模式匹配的输入序列的下一个子序列，此方法从匹配器区域的开头开始，
		 * 如果该方法的前一次调用成功了并且从那时开始匹配器没有被重置，则从以前匹配操作没有匹配的第一个字符开始
		 */
		boolean subMatch = m.find();
		if(subMatch)
			m.reset("aaaab");
		System.out.println("subMatch  " + subMatch);
		// 当且仅当从给定索引开始的输入序列的子序列匹配此匹配器的模式时才返回true
		boolean subMatchWithStart = m.find(3);
		System.out.println("subMatchWithStart  " + subMatchWithStart);
	}
}