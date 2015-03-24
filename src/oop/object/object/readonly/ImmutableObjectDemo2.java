/**
 * 
 */
package object.readonly;

/**
 * ���ɱ������ʾ��2
 * <p>
 * ����һ�����Ա��޸ĵİ����࣬�Ա������Ч�ʡ�
 * <p>
 * �������������ʱ���˷���ʮ�����ã�</br>
 * <li>1.��Ҫ���ɱ�Ķ��󣬶���
 * <li>2.������Ҫ���������޸ģ�����
 * <li>3.�����µĲ��ɱ������۰���
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
	 * �ڶ��ѭ����ʹ��ImmutableObject2���в������������������������ʹ����������ѹ������
	 */
	public static ImmutableObject2 modify1(ImmutableObject2 o) {
		ImmutableObject2 aio = o.add(12);
		aio = aio.multiply(3);
		aio = aio.add(11);
		aio = aio.multiply(2);
		return aio;
	}

	/**
	 * �ڶ��ѭ����ʹ��Mutable���в����Ͳ��������ϵ����⣬��Ϊ���в�����ʼ�ն���һ������Mutable��
	 */
	public static ImmutableObject2 modify2(ImmutableObject2 o) {
		Mutable m = o.makeMutable();
		m.add(12).multiply(3).add(11).multiply(2);
		return m.makeAdvancedImmutableObject();
	}
}

/**
 * ���ɱ���� 
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
 * ���ɱ����ImmutableObject2�Ŀɱ������
 * <p>
 * ���ۺ�ʱ����Ҫһ�����޸Ĺ��Ĳ��ɱ�������ʱ�򣬱���Ҫ���ܴ����¶���Ŀ�����Ҳ���Ƶ���������������ա�
 * ��ĳЩ����ԣ��ⲻ�����⣬������һЩ��(����String��)������ۿ��ܰ�������˲��ò���ֹ��ô����
 * ���֮���Ǵ���һ�����Ա��޸ĵİ�����(companion class)��
 * ������Ҫ�������޸Ķ���ʱ������תΪʹ�ÿ��޸ĵİ����࣬�޸Ĳ�����Ϻ���ת�غ㳣�ࡣ
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