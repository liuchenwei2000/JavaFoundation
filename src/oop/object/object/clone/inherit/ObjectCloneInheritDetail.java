/**
 * 
 */
package object.clone.inherit;

/**
 * Object.clone()�̳е�ϸ��
 * <p>
 * SonInt �̳��� Int����������µĻ������ͳ�Ա��int j��
 * Ҳ����Ҫ����clone()��������ȷ�� j Ҳ�����ƣ������鲢����ˡ�
 * �� Int ��clone()�� SonInt �� clone()��������ʱ�����ֵ�����Object.clone()��
 * ���߻��ж����������� SonInt�����Ҹ��� SonInt ���������λ(bit)��
 * ֻҪû���������������Ҫ��¡�Ķ�����ô����clone()�����ڼ̳в���ж����λ�á�
 * ֻ�����Object.clone()һ�Σ�����������б�Ҫ�ĸ��ơ�
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-6-6
 */
public class ObjectCloneInheritDetail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SonInt si = new SonInt(1);
		SonInt clone = (SonInt) si.clone();
		System.out.println(clone);
	}
}

class SonInt extends Int {

	private int j;

	public SonInt(int j) {
		super(j);
		this.j = j;
	}

	public String toString() {
		return super.toString() + " j = " + j;
	}
}

class Int implements Cloneable {

	private int i;

	public Int(int i) {
		this.i = i;
	}

	public void increment() {
		i++;
	}

	public Object clone() {
		Object o = null;
		try {
			o = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return o;
	}

	public String toString() {
		return "i = " + i;
	}
}