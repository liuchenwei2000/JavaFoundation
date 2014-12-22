/**
 * 
 */
package jdk7;

import java.util.ArrayList;
import java.util.List;

/**
 * 3����������ʵ��ʱ�Զ������ƶ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��12��19��
 */
public class TypeInference4GenericInstanceCreation {

	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// ����ǰ�İ汾��ʹ�÷������ͣ���Ҫ����������ֵ��ʱ�����඼���Ϸ������͡�
		List<String> strList = new ArrayList<String>();
		// ��Java SE 7�У����ַ�ʽ���ԸĽ������ڿ���ʹ��������������������ֵ��
		List<String> strList2 = new ArrayList<>(); // ע������"<>"
		/*
		 * ����������ݱ�������ʱ�ķ��������Զ��ƶϳ�ʵ����HashMapʱ�ķ������͡�
		 * �ٴ�����һ��Ҫע��new HashMap����ġ�<>����ֻ�м��������<>���ű�ʾ���Զ������ƶϣ�
		 * ������ǷǷ������͵�HashMap��������ʹ�ñ���������Դ����ʱ�����һ��������ʾ��
		 */
		
		/*
		 * Java SE 7�ڴ�������ʵ��ʱ�������ƶ��������Ƶģ�ֻ������ϵ�����Ŀ�����ȷȷ�����������͵�ʱ��ʹ�÷����ƶϡ�
		 * ���磺����������޷���ȷ���룺
		 */
		List<String> list = new ArrayList<>();
		list.add("A");
		// ����addAll�������Collection<? extends String>���͵Ĳ�����������������޷�ͨ������
//		list.addAll(new ArrayList<>());
	}
}
