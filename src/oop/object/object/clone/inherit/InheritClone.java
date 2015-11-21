/**
 * 
 */
package object.clone.inherit;

/**
 * 克隆性的继承
 * <p>
 * 如果创建了一个类，其基类缺省为Object，那么它缺省是不具备克隆能力的。
 * 只要不明确地添加克隆能力，它就不会具备。
 * 但是可以向任意层次的子类添加克隆能力，从那层以下的子类，也就都具备了克隆能力。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-6-6
 */
public class InheritClone {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		Person p = new Person();
		@SuppressWarnings("unused")
		Hero h = new Hero();
		Scientist s = new Scientist();
		MadScientist m = new MadScientist();
		// p = (Person)p.clone(); // Compile error
		// h = (Hero)h.clone(); // Compile error
		s = (Scientist) s.clone();
		m = (MadScientist) m.clone();
	}
}

class Person {
}

class Hero extends Person {
}

class Scientist extends Person implements Cloneable {

	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			throw new RuntimeException(e);
		}
	}
}

class MadScientist extends Scientist {
}
