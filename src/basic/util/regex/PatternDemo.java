/**
 * 
 */
package util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Pattern��һ�㷽����ʾ
 * <p>
 * Pattern��ʵ����������ʽ�ı����ʾ��ʽ
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-12-18
 */
public class PatternDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ��������������ʽ���뵽ģʽ��
		Pattern p = Pattern.compile("a*b");
		// ����ƥ���������ʹ�ģʽ��ƥ����
		Matcher m = p.matcher("aaaaab");
		boolean match = m.matches();
		// �������������ʽ����������������ƥ�䣬�൱���������������ִ��Ч��
		// ���Ҫ���ʹ��һ��ģʽ������һ�κ����ô�ģʽ��ÿ�ζ����ô˷���Ч�ʸ���
		match = Pattern.matches("a*b", "aaaaab");
		if (match)
			System.out.println("match!");
		else
			System.out.println("not match!");
		// ���������б������ģʽ��������ʽ
		String regex = p.pattern();
		System.out.println(regex);
	}
}