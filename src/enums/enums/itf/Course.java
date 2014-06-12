/**
 * 
 */
package enums.itf;

import java.util.Random;

/**
 * ����Ҫ��һ������ʹ򽻵�ʱ���ӿھͲ���enum�����ˡ�
 * ����봴��һ��"ö�ٵ�ö��"������Դ���һ���µ�enum��Ȼ������ʵ����װ�Ѿ����ڵ�enum�ࡣ
 *
 * @author ����ΰ
 *
 * ����ʱ�䣺2008-8-6
 */
public enum Course {
	
	WATER(Drink.Water.class), COFFEE(Drink.Coffee.class), TEA(Drink.Tea.class), JUICE(
			Drink.Juice.class);

	private Drink[] values;

	/**
	 * ÿһ��Courseʵ���������Ӧ��class������Ϊ�������Ĳ�����
	 * ͨ��getEnumConstants()��������ø�class�����е�����enumʵ����
	 */
	private Course(Class<? extends Drink> kind) {
		values = kind.getEnumConstants();
	}

	public Drink randomSelection() {
		return values[new Random().nextInt(values.length)];
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for (int i = 0; i < 5; i++) {
			for (Course course : Course.values()) {
				Drink drink = course.randomSelection();
				System.out.println(drink);
			}
			System.out.println("---------------------------");
		}
	}
}