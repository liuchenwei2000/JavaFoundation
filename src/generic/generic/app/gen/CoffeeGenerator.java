/**
 * 
 */
package generic.app.gen;

import java.util.Random;

import generic.app.Generator;
import generic.app.coffee.Americano;
import generic.app.coffee.Breve;
import generic.app.coffee.Cappuccino;
import generic.app.coffee.Coffee;
import generic.app.coffee.Latte;
import generic.app.coffee.Mocha;

/**
 * Coffee对象生成器
 * 
 * @author 刘晨伟
 *
 * 创建日期：2008-5-14
 */
public class CoffeeGenerator implements Generator<Coffee> {
	
	// 所有Coffee类的子类字面常量数组
	private Class<?>[] types = { Latte.class, Mocha.class, Cappuccino.class,
			Americano.class, Breve.class };
	
	private static Random random = new Random();
	
	/**
	 * 生成一个Coffee对象
	 *
	 * @see generic.app.Generator#generate()
	 */
	public Coffee generate() {
		try {
			return (Coffee) types[random.nextInt(types.length)].newInstance();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CoffeeGenerator generator = new CoffeeGenerator();
		for (int i = 0; i < 5; i++) {
			System.out.println(generator.generate());
		}
	}
}