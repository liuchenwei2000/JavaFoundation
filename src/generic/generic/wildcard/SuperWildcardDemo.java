/**
 * 
 */
package generic.wildcard;

import generic.Pair;

/**
 * ͨ����������޶���ʾ��
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-8-4
 */
public class SuperWildcardDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Son[] sons = { new Son("A", 1), new Son("B", 2), new Son("C", 3),
				new Son("D", 4), new Son("E", 5) };
		minmax(sons, new Pair<Son>());
		// ���Խ�Pair<Father>��Ϊ�������������ٿ�minmax��set��������Ϊ�ͺ������
		// ����minmax������˵�����ܴ����Pair��ʲô����(ֻҪ��Son�ĳ���)
		// �����Խ�Son�Ž�ȥ����Ϊ���ǰ�ȫ�ģ�����set�����Ĳ�����Son����
		minmax(sons, new Pair<Father>());
		minmax(sons, new Pair<Object>());
	}

	private static void minmax(Son[] array,Pair<? super Son> pair){
		if(array == null || array.length == 0) return;
		Son min = array[0];
		Son max = array[0];
		for (Son son : array) {
			if(son.getAge() < min.getAge()) min = son;
			if(son.getAge() > max.getAge()) max = son;
		}
		/*
		 * ��������֪��set����������ȷ�����ͣ����ǿ���������Son����(�����Ӷ���)
		 * ��Ϊ��������������������Father������Ϊ������
		 * Ȼ���������get���������صĶ������͵ò�����֤��ֻ�ܽ�������һ��Object��
		 */
		pair.setFirst(min);
		pair.setSecond(max);
		System.out.println("first(min)=" + pair.getFirst());
		System.out.println("second(max)=" + pair.getSecond());
	}
}