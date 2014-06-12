/**
 * 
 */
package enums.itf;

import generic.app.Generator;

import java.util.Random;

/**
 * 因为所有的enum都继承自Enum类，所以不能够在继承其他的类，但是可以实现一个或者多个接口。
 *
 * @author 刘晨伟
 *
 * 创建时间：2008-8-6
 */
public class EnumImplementation {

	/**
	 * 打印Generator中的生成的对象
	 */
	private static <T> void printNext(Generator<T> gen) {
		System.out.println(gen.generate());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BeautifulGirl girl = BeautifulGirl.西施;
		for (int i = 0; i < 10; i++) {
			printNext(girl);
		}
	}
}

enum BeautifulGirl implements Generator<BeautifulGirl> {

	西施, 王昭君, 貂蝉, 杨玉环;

	private Random ran = new Random();

	public BeautifulGirl generate() {
		return values()[ran.nextInt(values().length)];
	}
}