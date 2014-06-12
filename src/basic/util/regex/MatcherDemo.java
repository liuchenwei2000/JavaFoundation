/**
 * 
 */
package util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Matcher��һ�㷽����ʾ
 * <p>
 * Matcher��ʵ����ͨ������Pattern���ַ�����ִ��ƥ�����������
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-12-18
 */
public class MatcherDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Pattern p = Pattern.compile("a*b");
		Matcher m = p.matcher("aaaab");
		// ���ҽ���������������ƥ���ƥ������ģʽʱ�ŷ���true
		boolean allMatch = m.matches();
		System.out.println("allMatch  " + allMatch);
		// ���ҽ����������е�ǰ׺ƥ���ƥ������ģʽʱ�ŷ���true
		boolean prefixMatch = m.lookingAt();
		System.out.println("prefixMatch  " + prefixMatch);
		/*
		 * ���ҽ����������е�������ƥ���ƥ������ģʽʱ�ŷ���true 
		 * ���Բ������ģʽƥ����������е���һ�������У��˷�����ƥ��������Ŀ�ͷ��ʼ��
		 * ����÷�����ǰһ�ε��óɹ��˲��Ҵ���ʱ��ʼƥ����û�б����ã������ǰƥ�����û��ƥ��ĵ�һ���ַ���ʼ
		 */
		boolean subMatch = m.find();
		if(subMatch)
			m.reset("aaaab");
		System.out.println("subMatch  " + subMatch);
		// ���ҽ����Ӹ���������ʼ���������е�������ƥ���ƥ������ģʽʱ�ŷ���true
		boolean subMatchWithStart = m.find(3);
		System.out.println("subMatchWithStart  " + subMatchWithStart);
	}
}