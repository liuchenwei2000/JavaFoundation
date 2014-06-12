/**
 * 
 */
package object.clone.inherit;

import java.lang.reflect.Constructor;

/**
 * ͨ��������ʵ�ֿ�¡��ʾ
 * <p>
 * ���ۣ���Java��ʹ�ÿ�����������������ľֲ������ǲ����еġ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2009-6-8
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
		// ����������¡����ϵģ����t��Tomato������ͻ����
		t = new Tomato(t);
		System.out.println("In cloneByTomatoConstructor, t is a "
				+ t.getClass().getSimpleName());
	}

	private static void cloneByFruitConstructor(Fruit f) {
		// ����������¡����ϵģ����t��Fruit������ͻ����
		f = new Fruit(f);
		System.out.println("In cloneByFruitConstructor, f is a "
				+ f.getClass().getSimpleName());
	}

	private static void cloneByReflectionTomato(Tomato t) {
		try {
			// ͨ�������ܹ�������ʱ��ȡt�ľ������ͣ�Ȼ��������Ĺ�����
			// ���ǲ����ܱ�֤ÿһ��Tomato���඼�п���������
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
	 * ����Ĺ�����(����������)�����Ĺ������Ǹ��ƶ���
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
	 * ����������
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
	 * ע��ÿ���඼�п��������������Ǳ��븺����û���ͳ�Ա����Ŀ������������Դﵽ��㿽����Ч����
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