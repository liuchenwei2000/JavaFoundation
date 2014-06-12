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
 * 集合类工厂类
 * <p>
 * 使用了类型参数推断避免了重复的泛型参数列表，类型推断只对赋值操作有效，其他时候并不起作用。
 * 如果将一个泛型方法调用的结果作为参数传递给另一个方法编译器就不会执行类型推断。
 * 因为编译器认为：调用泛型方法后，其返回值被赋值给一个Object类型的变量。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2008-5-15
 */
public class CollectionFactory {
	
	/**
	 * @param args
	 */
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// 赋值时编译器会自动进行类型推断，所以返回和变量类型一样的map
		Map<String, String> map = CollectionFactory.map();
		// 传统方式创建一个Map
		map = new HashMap<String, String>();
		List<String> list = CollectionFactory.list();
		list = new ArrayList<String>();
		Set<String> set = CollectionFactory.set();
		Queue<String> queue = CollectionFactory.queue();
		// 以下的代码编译器会报错：因为调用泛型方法之后返回值被赋给Object类型的变量
//		method(CollectionFactory.map());
	}
	
    @SuppressWarnings("unused")
	private static void method(Map<String, String> map) {
		// do nothing
	}
	
	/**
	 * 返回一个Map
	 */
	public static <K, V> Map<K, V> map() {
		return new HashMap<K, V>();
	}

	/**
	 * 返回一个List
	 */
	public static <T> List<T> list() {
		return new ArrayList<T>();
	}

	/**
	 * 返回一个Set
	 */
	public static <T> Set<T> set() {
		return new HashSet<T>();
	}

	/**
	 * 返回一个Queue
	 */
	public static <T> Queue<T> queue() {
		return new LinkedList<T>();
	}
}