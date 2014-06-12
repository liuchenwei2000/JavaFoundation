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
 * Coffee����������
 * 
 * @author ����ΰ
 *
 * �������ڣ�2008-5-14
 */
public class CoffeeGenerator implements Generator<Coffee> {
	
	// ����Coffee����������泣������
	private Class<?>[] types = { Latte.class, Mocha.class, Cappuccino.class,
			Americano.class, Breve.class };
	
	private static Random random = new Random();
	
	/**
	 * ����һ��Coffee����
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