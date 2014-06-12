/**
 * 
 */
package generic.wildcard;

import generic.Pair;

/**
 * ͨ�����ʾ��
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-8-3
 */
public class WildcardDemo {

	/**
	 * @param args
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static void main(String[] args) {
		Pair<?> pair = new Pair<String>("first", "second");
		System.out.println("has null:" + hasNull(pair));
		System.out.println("has null2:" + hasNull2(pair));
		/*
		 * ���޶�ͨ��� ? ����������ʹ�ã�Pair<?> 
		 * �������ԭʼ��Pair����һ����ʵ�����кܴ�Ĳ�ͬ�� 
		 * ����Pair<?>�з����磺
		 * ? getFirst(); void setFirst(?);
		 */
		// getFirst�ķ���ֵֻ�ܸ���һ��Object
		Object object = pair.getFirst();
		System.out.println(object);
		// setFirst�������ܱ����ã�ʹ��Object��Ϊ����Ҳ����
		// ����������б����
//		pair.setFirst(first);
		// Pair<?>��Pair�ı��ʲ�ͬ���ڣ� 
		// Pair����������Object����Ϊ��������setFirst����
		Pair pair2 = new Pair<String>("first", "second");
		pair2.setFirst(new String());
	}

	/**
	 * ΪʲôҪʹ�� ? �������������ͣ����������򵥵Ĳ����ǳ����á�</br>
	 * �磺</br>
	 * Ϊ�˲���һ��Pair�Ƿ������ָ���Ķ���������Ҫʵ�ʵĶ���
	 */
	private static boolean hasNull(Pair<?> pair) {
		return pair.getFirst() == null || pair.getSecond() == null;
	}

	/**
	 * ͨ���� ? ת���ɷ��ͷ��������Ա���ʹ��ͨ������ͣ����Ǵ���ͨ������͵İ汾�ɶ��Ը�ǿ��
	 */
	private static <T> boolean hasNull2(Pair<T> pair) {
		return pair.getFirst() == null || pair.getSecond() == null;
	}
}