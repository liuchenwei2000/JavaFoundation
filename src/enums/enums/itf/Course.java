/**
 * 
 */
package enums.itf;

import java.util.Random;

/**
 * 当需要和一大堆类型打交道时，接口就不如enum好用了。
 * 如果想创建一个"枚举的枚举"，则可以创建一个新的enum，然后用其实例包装已经存在的enum类。
 *
 * @author 刘晨伟
 *
 * 创建时间：2008-8-6
 */
public enum Course {
	
	WATER(Drink.Water.class), COFFEE(Drink.Coffee.class), TEA(Drink.Tea.class), JUICE(
			Drink.Juice.class);

	private Drink[] values;

	/**
	 * 每一个Course实例都将其对应的class对象作为构造器的参数，
	 * 通过getEnumConstants()方法将获得该class对象中的所有enum实例。
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
