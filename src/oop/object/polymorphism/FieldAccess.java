/**
 * 
 */
package polymorphism;

/**
 * ֻ����ͨ�ķ�������(�����������)�����Ƕ�̬�ġ�
 * ���ֱ�ӷ���ĳ����������ʽ��ڱ����ڽ��н�����
 * ��̬�Ƕ�̬�󶨡����ڰ󶨡�����ʱ�󶨡�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2008-4-8
 */
public class FieldAccess {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Super sup = new Sub();
		// ��Sub����ת��ΪSuper����ʱ���κ�����ʲ������ɱ����ڽ�������˲��Ƕ�̬��
		System.out.println("sup.field = " + sup.field + ", sup.getField() = "
				+ sup.getField());
		// �����sup.field = super field, sup.getField() = sub field
		Sub sub = new Sub();
		System.out.println("sub.field = " + sub.field + ", sub.getField() = "
				+ sub.getField() + ", sub.getSuperFiled() = "
				+ sub.getSuperFiled());
		// �����sub.field = sub field, sub.getField() = sub field, sub.getSuperFiled() = super field
	}
}

class Super {
	public String field = "super field";

	public String getField() {
		return field;
	}
}

class Sub extends Super {
	public String field = "sub field";

	public String getField() {
		return field;
	}

	public String getSuperFiled() {
		return super.field;
	}
}