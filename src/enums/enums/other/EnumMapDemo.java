/**
 * 
 */
package enums.other;

import java.util.EnumMap;
import java.util.Map;

/**
 * EnumMap��ʾ
 * <p>
 * EnumMap��һ�������Map��Ҫ�����еļ�(key)��������һ��enum��
 * ����enum��������ƣ�����EnumMap���ڲ���������ʵ�֣�����ٶȸ��졣
 * ��EnumSetһ����enumʵ������ʱ�Ĵ������������EnumMap�е�˳��
 *
 * @author ����ΰ
 *
 * ����ʱ�䣺2008-8-7
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
			// ��������ھͻ��׿�ָ���쳣
			map.get(SignalNumber.NEGATIVEONE).action();
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

interface Command {
	public void action();
}