/**
 * 
 */
package inner.use;

/**
 * 序列类
 * <p>
 * 用来演示在一个类中用内部类实现两个接口的灵活性。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2008-4-16
 */
public class Sequence {

	private Object[] items;
	private int next = 0;

	public Sequence(int size) {
		items = new Object[size];
	}

	public void add(Object x) {
		if (next < items.length)
			items[next++] = x;
	}

	public Iterator iterator() {
		return new SequenceIterator();
	}

	/**
	 * 用内部类实现了顺序遍历器
	 */
	private class SequenceIterator implements Iterator {
		
		private int i = 0;

		public Object current() {
			return items[i];
		}

		public boolean end() {
			return i == items.length;
		}

		public void next() {
			if (i < items.length)
				i++;
		}
	}

	public Iterator reverseIterator() {
		return new SequenceReverseIterator();
	}

	/**
	 * 用内部类实现了倒序遍历器
	 */
	private class SequenceReverseIterator implements Iterator {
		
		private int i = items.length;

		public Object current() {
			return items[i - 1];
		}

		public boolean end() {
			return i == 0;
		}

		public void next() {
			if (i > 0)
				i--;
		}
	}

	/**
	 * 根据遍历器打印元素
	 */
	private static void print(Iterator it) {
		while (!it.end()) {
			System.out.print(it.current() + "  ");
			it.next();
		}
		System.out.println();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Sequence s = new Sequence(5);
		s.add("1");
		s.add("2");
		s.add("3");
		s.add("4");
		s.add("5");
		print(s.iterator());
		print(s.reverseIterator());
	}
}

/**
 * 遍历器接口
 */
interface Iterator {
	
	boolean end();

	Object current();

	void next();
}
