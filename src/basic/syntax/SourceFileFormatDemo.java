/**
 * �汾��Ϣ��
 * Copyright 2007 Beijing LCW Co.Ltd.
 * All right reserved.
 */

package syntax;// ����

import java.util.ArrayList;// ������

// ��ע��
/**
 * Դ�ļ���ʽ��ʾ����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-11-6
 */
// Դ������ļ��������빫����(public)��������ͬ
public class SourceFileFormatDemo {

	private int field;// �ֶ�
	
	/**
	 * ���췽��
	 */
	public SourceFileFormatDemo() {
		
	}

	/**
	 * clone����(�����ڹ��췽������)
	 */
	public SourceFileFormatDemo clone() {
		return this;
	}
	
	/**
	 * toString����(ÿ���඼Ӧ������д�˷���)
	 */
	public String toString() {
		return super.toString();
	}
	
	/**
	 * ʵ������
	 */
	public void test() {
		System.out.println(field);
	}
	
	/**
	 * main����(����������)
	 */
	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<Integer>();
		System.out.println(al);
	}
}