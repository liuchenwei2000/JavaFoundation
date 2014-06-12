/**
 * 
 */
package inner.use;

/**
 * �ڲ���ʵ�ֻص�(callback)
 * <p>
 * ͨ���ص������ܹ�Я��һЩ��Ϣ����Щ��Ϣ���������Ժ��ĳ��ʱ�̵��ó�ʼ�Ķ���
 * �ص��ļ�ֵ������������ԣ�����������ʱ��̬�ľ�����Ҫ����ʲô������
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-6
 */
public class Callbacks {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Callee1 c1 = new Callee1();
		Callee2 c2 = new Callee2();
		MyIncrement.f(c2);
		Caller caller1 = new Caller(c1);
		Caller caller2 = new Caller(c2.getCallbackReference());
		caller1.go();
		caller1.go();
		caller2.go();
		caller2.go();
	}
}

/**
 * ��һ����ʾ���ⲿ��ʵ��һ���ӿ����ڲ���ʵ�ִ˽ӿ�֮�������
 * <p>
 * �ʹ�����ԣ�Callee1�Ǽ򵥵Ľ����ʽ��Callee2�̳���MyIncrement��
 * �����Ѿ�����һ����ͬ��increment������������Incrementable�ӿ�������increment������ȫ����ء�
 * �������Callee2�̳���MyIncrement�Ͳ���Ϊ��Incrementable����;��������increment������ֻ��ʹ���ڲ��������ʵ��Incrementable��
 * ������һ���ڲ���ʱ����û�����ⲿ��Ľӿ�����Ӷ�����Ҳû���޸��ⲿ��Ľӿڡ�
 */
interface Incremnetable {
	
	void increment();
}

class Callee1 implements Incremnetable {
	
	private int i = 0;

	public void increment() {
		i++;
		System.out.println(i);
	}
}

class MyIncrement {
	
	void increment() {
		System.out.println("Other operation");
	}

	static void f(MyIncrement mi) {
		mi.increment();
	}
}

class Callee2 extends MyIncrement {
	
	private int i = 0;

	public void incr() {
		i++;
		System.out.println(i);
	}

	/**
	 * �ڲ���Closureʵ����Incremnetable���ṩһ������Callee2�Ĺ��ӡ�
	 * ����һ����ȫ�Ĺ��ӣ�����˭����˴�Incrementable�����ã���ֻ�ܵ���increment������֮��û���������ܡ�
	 * �ص��ļ�ֵ������������ԣ�����������ʱ��̬�ؾ�����Ҫ����ʲô����
	 */
	private class Closure implements Incremnetable {
		public void increment() {
			incr();
		}
	}

	Incremnetable getCallbackReference() {
		return new Closure();
	}
}

class Caller {
	
	private Incremnetable callbackreference;

	Caller(Incremnetable cbh) {
		callbackreference = cbh;
	}

	void go() {
		callbackreference.increment();
	}
}