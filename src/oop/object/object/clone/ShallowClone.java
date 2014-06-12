/**
 * 
 */
package object.clone;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 浅克隆演示
 * <p>
 * 使用Java标准库的ArrayList作为例子。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2009-6-5
 */
public class ShallowClone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ArrayList<Int> v = new ArrayList<Int>();
		for (int i = 0; i < 10; i++) {
			v.add(new Int(i));
		}
		System.out.println("v: " + v);
		/*
		 * ArrayList的clone()方法，它并不自动克隆 ArrayList中包含的每个对象，
		 * 克隆的ArrayList只是将原ArrayList中的对象别名化，这通常称为浅层拷贝(shallow copy)。
		 * 因为它只复制对象"表面"的部分。实际的对象由以下几部分组成：
		 * 对象的"表面"，由对象包含的所有引用指向的对象，再加上这些对象又指向的对象，等等。
		 * 通常称之为"对象网"。将这些全部复制即为深层拷贝(deep copy)。
		 */
		ArrayList<?> v2 = (ArrayList<?>) v.clone();
		Iterator<?> e = v2.iterator();
		while (e.hasNext()) {
			((Int) e.next()).increment();
		}
		System.out.println("v: " + v);
	}
}

class Int {
	
	private int i;

	public Int(int i) {
		this.i = i;
	}

	public void increment() {
		i++;
	}

	public String toString() {
		return Integer.toString(i);
	}
}