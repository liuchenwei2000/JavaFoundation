/**
 * 
 */
package object.clone;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * 浅克隆演示
 * <p>
 * 浅克隆：按比特的对象克隆，新创建的对象精确的复制了原来对象的值，如果对象的某个属性是其他对象的引用，那么只复制这个引用。
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
		ArrayList<Int> oldList = new ArrayList<Int>();
		for (int i = 0; i < 10; i++) {
			oldList.add(new Int(i));
		}
		System.out.println("oldList: " + oldList);
		
		/*
		 * ArrayList的clone()方法并不自动克隆它包含的每个对象，克隆的ArrayList只是将原ArrayList中的对象别名化。
		 */
		ArrayList<?> newList = (ArrayList<?>) oldList.clone();
		Iterator<?> e = newList.iterator();
		while (e.hasNext()) {
			((Int) e.next()).increment();
		}
		System.out.println("oldList: " + oldList);
	}
}