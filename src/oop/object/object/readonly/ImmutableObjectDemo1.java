/**
 * 
 */
package object.readonly;

/**
 * ���ɱ������ʾ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2009-6-8
 */
public class ImmutableObjectDemo1 {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ImmutableObject x = new ImmutableObject(47);
		System.out.println("before println(x)��x = " + x.read());
		println(x);
		System.out.println("after println(x)��x = " + x.read());
	}
	
	private static void println(ImmutableObject io) {
		ImmutableObject multiply = io.multiply(4);
		System.out.println("io = " + io.read());
		System.out.println("multiply = " + multiply.read());
	}
}

/** 
 * ���ɱ���� 
 */
class ImmutableObject {

	/* �������ݶ���private�ģ�������final�� */
	private int value;

	public ImmutableObject(int value) {
		this.value = value;
	}

	/* û���޸�private���ݵķ��� */
	public int read() {
		return value;
	}

	public boolean nonzero() {
		return value != 0;
	}

	/**
	 * ������һ���µĶ��󷵻أ���û���޸�ԭ����
	 */
	public ImmutableObject multiply(int multiplier) {
		return new ImmutableObject(value * multiplier);
	}
}