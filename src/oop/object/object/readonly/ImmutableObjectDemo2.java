/**
 * 
 */
package object.readonly;

/**
 * �㳣������ʾ��2
 * <p>
 * ����һ�����Ա��޸ĵİ����࣬�Ա������Ч�ʡ�
 * <p>
 * �������������ʱ���˷���ʮ�����ã�</br>
 * <li>1.����Ҫ�㳣�Ķ��󣬶���
 * <li>2.�㾭����Ҫ���������޸ģ�����
 * <li>3.�����µĺ㳣������۰���
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2009-6-8
 */
public class ImmutableObjectDemo2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ImmutableObject2 aio = new ImmutableObject2(47);
		ImmutableObject2 aio1 = modify1(aio);
		ImmutableObject2 aio2 = modify2(aio);
		System.out.println("aio = " + aio.read());
		System.out.println("aio1 = " + aio1.read());
		System.out.println("aio2 = " + aio2.read());
	}
	
	/**
	 * �ڶ��ѭ����ʹ��AdvancedImmutableObject���в�����
	 * �������������������ʹ����������ѹ������
	 */
	public static ImmutableObject2 modify1(ImmutableObject2 o) {
		ImmutableObject2 aio = o.add(12);
		aio = aio.multiply(3);
		aio = aio.add(11);
		aio = aio.multiply(2);
		return aio;
	}

	/**
	 * �ڶ��ѭ����ʹ��Mutable���в����Ͳ��������ϵ����⣬
	 * ��Ϊ���в�����ʼ�ն���һ������Mutable��
	 */
	public static ImmutableObject2 modify2(ImmutableObject2 o) {
		Mutable m = o.makeMutable();
		m.add(12).multiply(3).add(11).multiply(2);
		return m.makeAdvancedImmutableObject();
	}
}

/**
 * �㳣���� 
 */
class ImmutableObject2 {
	
	private int value;

	public ImmutableObject2(int value) {
		this.value = value;
	}

	public int read() {
		return value;
	}

	public boolean nonzero() {
		return value != 0;
	}

	public ImmutableObject2 add(int x) {
		return new ImmutableObject2(value + x);
	}

	public ImmutableObject2 multiply(int x) {
		return new ImmutableObject2(value * x);
	}

	public Mutable makeMutable() {
		return new Mutable(value);
	}
}

/**
 * �㳣����ImmutableObject2�Ŀɱ������
 */
class Mutable {

	private int value;

	public Mutable(int value) {
		this.value = value;
	}

	public Mutable add(int x) {
		value += x;
		return this;
	}

	public Mutable multiply(int x) {
		value *= x;
		return this;
	}

	public ImmutableObject2 makeAdvancedImmutableObject() {
		return new ImmutableObject2(value);
	}
}