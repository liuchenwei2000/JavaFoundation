/**
 * 
 */
package enums.other;

import java.util.EnumSet;
import static enums.other.SignalNumber.*;

/**
 * EnumSet演示
 * <p>
 * EnumSet是与枚举类型一起使用的专用Set实现，枚举set中所有键都必须来自单个枚举类型，
 * 该枚举类型在创建set时显式或隐式地指定。</br>
 * 它的优点是：速度快，性能好。
 *
 * @author 刘晨伟
 *
 * 创建时间：2008-8-6
 */
public class EnumSetDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 创建一个具有指定元素类型的空枚举set
		EnumSet<SignalNumber> set = EnumSet.noneOf(SignalNumber.class);
		set.add(ONE);
		System.out.println(set);
		// 创建一个最初包含指定元素的枚举set
		set.addAll(EnumSet.of(ONE, ZERO));
		System.out.println(set);
		// 创建一个包含指定元素类型的所有元素的枚举set
		set = EnumSet.allOf(SignalNumber.class);
		System.out.println(set);
		set.removeAll(EnumSet.of(ONE, ZERO));
		System.out.println(set);
		// 创建一个其元素类型与指定枚举set相同的枚举set，最初包含指定 set 中所不包含的此类型的所有元素(补集)
		set = EnumSet.complementOf(set);
		System.out.println(set);
	}
}

/**
 * 符号数枚举
 */
enum SignalNumber {
	ONE, ZERO, NEGATIVEONE
}
