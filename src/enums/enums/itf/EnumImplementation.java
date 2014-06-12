/**
 * 
 */
package enums.itf;

import generic.app.Generator;

import java.util.Random;

/**
 * ��Ϊ���е�enum���̳���Enum�࣬���Բ��ܹ��ڼ̳��������࣬���ǿ���ʵ��һ�����߶���ӿڡ�
 *
 * @author ����ΰ
 *
 * ����ʱ�䣺2008-8-6
 */
public class EnumImplementation {

	/**
	 * ��ӡGenerator�е����ɵĶ���
	 */
	private static <T> void printNext(Generator<T> gen) {
		System.out.println(gen.generate());
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BeautifulGirl girl = BeautifulGirl.��ʩ;
		for (int i = 0; i < 10; i++) {
			printNext(girl);
		}
	}
}

enum BeautifulGirl implements Generator<BeautifulGirl> {

	��ʩ, ���Ѿ�, ����, ����;

	private Random ran = new Random();

	public BeautifulGirl generate() {
		return values()[ran.nextInt(values().length)];
	}
}