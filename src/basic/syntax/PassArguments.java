/**
 * 
 */
package syntax;

/**
 * �����Ĳ���������ʾ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-9-11
 */
public class PassArguments {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// �������Ͳ���
		int a = 3;
		System.out.println("before changing a = " + a);
		change(a);
		System.out.println("after changing a = " + a);
		
		System.out.println();
		
		// �������Ͳ���
		Person p = new Person(50);
		System.out.println("before changing age of p is " + p.age);
		changeObject(p);
		System.out.println("after changing age of p is " + p.age);
	}
	
	/**
	 * �������Ĳ���Ϊ�������͵�ʱ����ȫ�Ǵ�ֵ����
	 * �Բ����ĸı�ֻ���ڷ��������Ǵ��ڵ�
	 * һ���������أ��������ʧ�����ж������޸�Ҳ����ʧ
	 */
	private static void change(int n) {
		n = 9;
		System.out.println("now in change() a = " + n);
	}
	
	
	/**
	 * �������Ĳ���Ϊ��������(����)��ʱ��
	 * ��ʵҲ��һ�ִ�ֵ���ݣ�����������ʱ����ָ��Ķ��󲻱�
	 * ���ǿ����ڷ�����ͨ����������޸�ָ������ĳЩ����
	 */
	private static void changeObject(Person p) {
		p.age = 100;
		p = new Person(0);
		System.out.println("in changeObject() age of p is " + p.age);
	}
}

class Person {
	
	int age;

	public Person(int newAge) {
		age = newAge;
	}
}