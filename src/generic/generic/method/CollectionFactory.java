/**
 * 
 */
package generic.method;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/**
 * �����๤����
 * <p>
 * ʹ�������Ͳ����ƶϱ������ظ��ķ��Ͳ����б������ƶ�ֻ�Ը�ֵ������Ч������ʱ�򲢲������á�
 * �����һ�����ͷ������õĽ����Ϊ�������ݸ���һ�������������Ͳ���ִ�������ƶϡ�
 * ��Ϊ��������Ϊ�����÷��ͷ������䷵��ֵ����ֵ��һ��Object���͵ı�����
 * 
 * @author ����ΰ
 *
 * �������ڣ�2008-5-15
 */
public class CollectionFactory {
	
	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// ��ֵʱ���������Զ����������ƶϣ����Է��غͱ�������һ����map
		Map<String, String> map = CollectionFactory.map();
		// ��ͳ��ʽ����һ��Map
		map = new HashMap<String, String>();
		List<String> list = CollectionFactory.list();
		list = new ArrayList<String>();
		Set<String> set = CollectionFactory.set();
		Queue<String> queue = CollectionFactory.queue();
		// ���µĴ���������ᱨ����Ϊ���÷��ͷ���֮�󷵻�ֵ������Object���͵ı���
//		method(CollectionFactory.map());
	}
	
    @SuppressWarnings("unused")
	private static void method(Map<String, String> map) {
		// do nothing
	}
	
	/**
	 * ����һ��Map
	 */
	public static <K, V> Map<K, V> map() {
		return new HashMap<K, V>();
	}

	/**
	 * ����һ��List
	 */
	public static <T> List<T> list() {
		return new ArrayList<T>();
	}

	/**
	 * ����һ��Set
	 */
	public static <T> Set<T> set() {
		return new HashSet<T>();
	}

	/**
	 * ����һ��Queue
	 */
	public static <T> Queue<T> queue() {
		return new LinkedList<T>();
	}
}