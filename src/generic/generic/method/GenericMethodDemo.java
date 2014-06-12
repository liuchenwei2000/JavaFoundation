/**
 * 
 */
package generic.method;

import generic.Pair;

import java.io.Serializable;

/**
 * ���ͷ�����ʾ
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-8-2
 */
public class GenericMethodDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] ss = { "this", "Hello", "is", "world", "Java" };
		Pair<String> minmax = minmax(ss);
		System.out.println("min=" + minmax.getFirst());
		System.out.println("max=" + minmax.getSecond());
	}
	
	/**
	 * ���ͷ�����������ͨ���ж��壬����ֻ���ڷ������ж��塣
	 * ���ͱ����������η�(public��static��)�ĺ��棬��������(Object���ͼ����������void)��ǰ�棬
	 * ����ʹ��һ�Լ�����(<>)��ס���ͱ�����
	 */
	public static <T> void genericMethod(T t) {
		// ...
	}
	
	/**
	 * ���ͱ������޶�
	 * <p>
	 * ����������ͱ����޶�Ϊĳ���ض����ͣ�������ķ������ͱ���ָ��������͡�
	 * <p>
	 * <T extends BoundingType>��ʾTӦ���ǰ����͵�������(subtype)��
	 * �����Ϳ������࣬Ҳ�����ǽӿڡ�ѡ�ùؼ���extends����Ϊ�����ӽ�����ĸ��
	 * ���Լ�ʹ��ʵ�ֽӿ�Ҳ��ʹ��extends��û����implements��
	 */
	public static <T extends Comparable<T>> Pair<T> minmax(T[] array){
		if(array == null || array.length == 0) return null;
		T min = array[0];
		T max = array[0];
		for (T s : array) {
			if(s.compareTo(min)<0) min = s;
			if(s.compareTo(max)>0) max = s;
		}
		return new Pair<T>(min,max);
	}
	
	/**
	 *  һ�����ͱ�����ͨ��������ж���޶���������ķ�����
	 *  <p>
	 *  �޶����ͼ���"&"�ָ���������Ϊ���������ָ����ͱ�����
	 *  �������б��������һ���࣬�����ж���ӿڡ�
	 *  ������ڰ������б��У��������ǵ�һ����
	 */
	public static <T extends Comparable<T> & Serializable> void genericMethod(T t) {
		// ...
	}
}