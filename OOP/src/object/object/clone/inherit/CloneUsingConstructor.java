/**
 * 
 */
package object.clone.inherit;

import java.lang.reflect.Constructor;

/**
 * 通过构造器实现克隆演示
 * <p>
 * 结论：在Java中使用拷贝构造器创建对象的局部拷贝是不可行的。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2009-6-8
 */
public class CloneUsingConstructor {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Tomato tomato = new Tomato();
		cloneByTomatoConstructor(tomato);
		cloneByFruitConstructor(tomato);
		cloneByReflectionTomato(tomato);
		cloneByReflectionFruit(tomato);
		
		GreenZebra g = new GreenZebra();
		cloneByTomatoConstructor(g);
		cloneByFruitConstructor(g);
		cloneByReflectionTomato(g);
		cloneByReflectionFruit(g);
		g.evaluate();
	}

	private static void cloneByTomatoConstructor(Tomato t) {
		// 这里这样克隆是武断的，如果t是Tomato的子类就会出错
		t = new Tomato(t);
		System.out.println("In cloneByTomatoConstructor, t is a "
				+ t.getClass().getSimpleName());
	}

	private static void cloneByFruitConstructor(Fruit f) {
		// 这里这样克隆是武断的，如果f是Fruit的子类就会出错
		f = new Fruit(f);
		System.out.println("In cloneByFruitConstructor, f is a "
				+ f.getClass().getSimpleName());
	}

	private static void cloneByReflectionTomato(Tomato t) {
		try {
			// 通过反射能够在运行时获取t的具体类型，然后调用它的构造器
			// 但是并不能保证每一个Tomato子类都有拷贝构造器
			Class<?> c = t.getClass();
			Constructor<?> ct = c.getConstructor(new Class[] { c });
			Object obj = ct.newInstance(new Object[] { t });
			System.out.println("In cloneByReflectionTomato, t is a "
					+ obj.getClass().getSimpleName());
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static void cloneByReflectionFruit(Fruit f) {
		try {
			Class<?> c = f.getClass();
			Constructor<?> ct = c.getConstructor(new Class[] { c });
			Object obj = ct.newInstance(new Object[] { f });
			System.out.println("In cloneByReflectionFruit, f is a "
					+ obj.getClass().getSimpleName());
		} catch (Exception e) {
			System.out.println(e);
		}
	}
}

class FruitQualities {

	private int weight;
	private int color;
	private int firmness;
	private int ripeness;
	private int smell;

	public FruitQualities() {
	}

	/**
	 * 特殊的构造器(拷贝构造器)，它的工作就是复制对象
	 */
	public FruitQualities(FruitQualities f) {
		weight = f.weight;
		color = f.color;
		firmness = f.firmness;
		ripeness = f.ripeness;
		smell = f.smell;
	}
}

class Seed {
	
	public Seed() {
	}

	/**
	 * 拷贝构造器
	 */
	public Seed(Seed s) {
	}
}

class Fruit {

	private FruitQualities fq;
	private int seeds;
	private Seed[] s;

	public Fruit(FruitQualities q, int seedCount) {
		fq = q;
		seeds = seedCount;
		s = new Seed[seeds];
		for (int i = 0; i < seeds; i++) {
			s[i] = new Seed();
		}
	}

	/**
	 * 注意每个类都有拷贝构造器，它们必须负责调用基类和成员对象的拷贝构造器，以达到深层拷贝的效果。
	 */
	public Fruit(Fruit f) {
		fq = new FruitQualities(f.fq);
		seeds = f.seeds;
		s = new Seed[seeds];
		for (int i = 0; i < seeds; i++) {
			s[i] = new Seed(f.s[i]);
		}
	}

	protected void addQualities(FruitQualities q) {
		fq = q;
	}

	protected FruitQualities getQualities() {
		return fq;
	}
}

class Tomato extends Fruit {

	public Tomato() {
		super(new FruitQualities(), 100);
	}

	public Tomato(Tomato t) {
		super(t);
	}
}

class ZebraQualities extends FruitQualities {

	private int stripedness;

	public ZebraQualities() {
		super();
	}

	public ZebraQualities(ZebraQualities z) {
		super(z);
		stripedness = z.stripedness;
	}
}

class GreenZebra extends Tomato {

	public GreenZebra() {
		addQualities(new ZebraQualities());
	}

	public GreenZebra(GreenZebra g) {
		super(g);
		addQualities(new ZebraQualities());
	}

	public void evaluate() {
		ZebraQualities zq = (ZebraQualities) getQualities();
		System.out.println(zq.getClass().getName());
	}
}
