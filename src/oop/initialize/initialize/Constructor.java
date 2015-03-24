/**
 * 
 */
package initialize;

/**
 * ���������ڼ̳���ϵ�µĵ���˳����ʾ
 * <p>
 * ����Ĺ���������������Ĺ�������б����ã����Ұ��ռ̳в�����������ӣ�
 * ��ʹÿ������Ĺ��������ܵõ����ã���������������ġ�
 * ��Ϊ����������һ���������񣺼������Ƿ���ȷ�ع��죬����ֻ�ܷ������Լ��ĳ�Ա��
 * ���ܷ��ʻ����еĳ�Ա(ͨ����private��)��ֻ�л���Ĺ������ž���ǡ����֪ʶ��Ȩ�������Լ���Ԫ�ؽ��г�ʼ����
 * ��˱��������й��������õ����ã�����Ͳ�������ȷ������������
 * �����Ǳ�����ΪʲôҪǿ��ÿ�����඼������û��๹������ԭ��������Ĺ������У�
 * ���û����ȷָ������ĳ�����๹�����������������û����Ĭ�Ϲ�����(�޲ι�����)��
 * ���������Ĭ�Ϲ��������������ͻᱨ����ĳ����û�й��������������Զ�Ϊ������һ��Ĭ�Ϲ�������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-1
 */
public class Constructor extends PortableLunch {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Sandwich();
		// ���Ϊ��
		// Meal()
		// Lunch()
		// PortableLunch()
		// Bread()
		// Cheese()
		// Lettuce()
		// Sandwich()
	}
}

/**
 * ���Ӷ�����ù��췽����˳��</br>
 * <li>1�����û��๹�췽����
 * �������᲻�ϵط����ĵݹ���ȥ��</br>
 * �����ǹ������ֲ�νṹ�ĸ���Ȼ����һ������ֱ࣬����ײ�����ࡣ
 * <li>2��������˳����ó�Ա�ĳ�ʼ��������
 * <li>3���������๹�췽�������塣
 */
class Sandwich extends PortableLunch {
	
	@SuppressWarnings("unused")
	private Bread b = new Bread();
	@SuppressWarnings("unused")
	private Cheese c = new Cheese();
	@SuppressWarnings("unused")
	private Lettuce l = new Lettuce();

	public Sandwich() {
		System.out.println("Sandwich()");
	}
}

class Meal {
	Meal() {
		System.out.println("Meal()");
	}
}

class Bread {
	Bread() {
		System.out.println("Bread()");
	}
}

class Cheese {
	Cheese() {
		System.out.println("Cheese()");
	}
}

class Lettuce {
	Lettuce() {
		System.out.println("Lettuce()");
	}
}

class Lunch extends Meal {
	Lunch() {
		System.out.println("Lunch()");
	}
}

class PortableLunch extends Lunch {
	PortableLunch() {
		System.out.println("PortableLunch()");
	}
}