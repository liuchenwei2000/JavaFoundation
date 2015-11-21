/**
 * 
 */
package enums.itf;

import enums.itf.Drink.*;

/**
 * Drink接口演示
 * 
 * @author 刘晨伟
 * 
 * 创建时间：2008-8-6
 */
public class DrinkDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Drink drink = Water.HOTWATER;
		System.out.println(drink);
		drink = Coffee.NEST;
		System.out.println(drink);
		drink = Tea.BLACKTEA;
		System.out.println(drink);
		drink = Juice.PEACH;
		System.out.println(drink);
	}
}
