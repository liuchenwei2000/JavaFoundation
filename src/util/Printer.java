/**
 * 
 */
package util;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * ��ӡ��
 * <p>
 * ��ӡ������Ԫ�غͼ������е�Ԫ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-13
 */
public final class Printer {

	private Printer() {
		// no instance
	}

	/**
	 * ��ӡint������
	 */
	public static void print(int[] array) {
		for (int item : array) {
			System.out.print(item + " ");
		}
		System.out.println();
	}

	/**
	 * ��ӡdouble������
	 */
	public static void print(double[] array) {
		for (double item : array) {
			System.out.print(item + " ");
		}
		System.out.println();
	}

	/**
	 * ��ӡchar������
	 */
	public static void print(char[] array) {
		for (char item : array) {
			System.out.print(item + " ");
		}
		System.out.println();
	}

	/**
	 * ��ӡ��������
	 */
	public static <T> void print(T[] array) {
		for (T item : array) {
			System.out.print(item.toString() + " ");
		}
		System.out.println();
	}

	/**
	 * ��ӡint�Ͷ�ά����
	 */
	public static void print(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * ��ӡdouble�Ͷ�ά����
	 */
	public static void print(double[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * ��ӡchar�Ͷ�ά����
	 */
	public static void print(char[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * ��ӡ�����ά����
	 */
	public static <T> void print(T[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j].toString() + " ");
			}
			System.out.println();
		}
	}

	/**
	 * Java��׼��ʽ��ӡCollection
	 */
	public static <T> void print(Collection<T> c) {
		System.out.println(c);
	}

	/**
	 * Java��׼��ʽ��ӡMap
	 */
	public static <K, V> void print(Map<K, V> map) {
		System.out.println(map);
	}
	
	/**
	 * ��ӡʵ��Iterator�ӿڵ��� ����List��Set��
	 */
	public static <T> void print(Iterator<T> it) {
		while (it.hasNext()) {
			System.out.print(it.next().toString() + " ");
		}
		System.out.println();
	}
	
	/**
	 * Printer�Զ��巽ʽ��ӡCollection
	 */
	public static <T> void printAll(Collection<T> c) {
		for (T t : c) {
			System.out.print(t.toString() + " ");
		}
		System.out.println();
	}
	
	/**
	 * Printer�Զ��巽ʽ��ӡMap�е�Ԫ��
	 */
	public static <K, V> void printAll(Map<K, V> map) {
		for (K key : map.keySet()) {
			System.out.print(key + " = ");
			System.out.println(map.get(key));
		}
	}
	
	/**
	 * Map�Ĵ�ͳ������ʽ��ӡMap�е�Ԫ��
	 */
	private static <K, V> void printAll2(Map<K, V> map) {
		// ӳ��Map������ͨ��ʹ���ɵ��ú���entrySet()��ü�����ͼ����ʾ����
		Iterator<Entry<K, V>> it = map.entrySet().iterator();// ������ͼ�ı�����
		// ��ʾ��ͼԪ��
		while (it.hasNext()) {
			// �ؼ��ֺ�ֵͨ��������Map.Entry��getKey()��getValue()��������
			Entry<K, V> me = (Entry<K, V>) it.next();
			System.out.print(me.getKey() + " = ");
			System.out.println(me.getValue());
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String[] values = { "a", "b", "c", "d", "e" };
		print(values);
		Collection<String> c = Arrays.asList(values);
		print(c);
		printAll(c);
		print(new HashSet<String>(c));
		printAll(new HashSet<String>(c));
		print(c.iterator());
		Map<String, String> map = new HashMap<String, String>();
		map.put("A", "1");
		map.put("B", "2");
		map.put("C", "3");
		print(map);
		printAll(map);
		printAll2(map);
	}
}