/**
 * 
 */
package enums.other;

import java.util.EnumMap;
import java.util.Map;

/**
 * EnumMap演示
 * <p>
 * EnumMap是一种特殊的Map，要求其中的键(key)必须来自一个enum。
 * 由于enum本身的限制，所以EnumMap在内部可由数组实现，因此速度更快。
 * 与EnumSet一样，enum实例定义时的次序决定了其在EnumMap中的顺序。
 *
 * @author 刘晨伟
 *
 * 创建时间：2008-8-7
 */
public class EnumMapDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		EnumMap<SignalNumber, Command> map = new EnumMap<SignalNumber, Command>(SignalNumber.class);
		
		map.put(SignalNumber.ONE, new Command() {

			public void action() {
				System.out.println("this is 1");
			}

		});
		
		map.put(SignalNumber.ZERO, new Command() {

			public void action() {
				System.out.println("this is 0");
			}

		});
		
		for (Map.Entry<SignalNumber, Command> e : map.entrySet()) {
			System.out.print(e.getKey() + " : ");
			e.getValue().action();
		}
		
		try {
			// 如果不存在就会抛空指针异常
			map.get(SignalNumber.NEGATIVEONE).action();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

interface Command {
	public void action();
}