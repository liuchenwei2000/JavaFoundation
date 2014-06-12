/**
 * 
 */
package object.clone.inherit;

/**
 * ��¡�Եļ̳�
 * <p>
 * ���������һ���࣬�����ȱʡΪObject����ô��ȱʡ�ǲ��߱���¡�����ġ�
 * ֻҪ����ȷ����ӿ�¡���������Ͳ���߱���
 * ���ǿ����������ε�������ӿ�¡���������ǲ����µ����࣬Ҳ�Ͷ��߱��˿�¡������
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-6-6
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