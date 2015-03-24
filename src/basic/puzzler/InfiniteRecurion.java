/**
 * 
 */
package puzzler;

import java.util.ArrayList;
import java.util.List;

/**
 * 无意识的无限递归
 * 
 * @author 刘晨伟
 *
 * 创建日期：2008-5-7
 */
public class InfiniteRecurion {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		List<InfiniteRecurion> list = new ArrayList<InfiniteRecurion>();
		for (int i = 0; i < 10; i++) {
			list.add(new InfiniteRecurion());
		}
		System.out.println(list);
	}

	/**
	 * 这里发生了自动类型转换，由InfiniteRecurion类型转换成了String类型。
	 * 因为编译器看到一个String对象后面跟着一个"+"，而后面的对象不是String，编译器试着将this转换成一个String，于是调用了它的toString方法。
	 * 如果真的想打印对象的内存地址应该调用Object类中的toString方法，即不使用this而使用super来调用父类的toString方法。
	 *
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return "InfiniteRecursion address: " + this + "\n";
	}
}