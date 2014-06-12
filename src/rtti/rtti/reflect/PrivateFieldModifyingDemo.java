/**
 * 
 */
package rtti.reflect;

import java.lang.reflect.Field;

/**
 * ˽�����޸���ʾ
 * <p>
 * û���κη�ʽ������ֹ����ﵽ��������Щ�ǹ�������Ȩ�޵���
 * 
 * @author ����ΰ
 *
 * �������ڣ�2008-5-14
 */
public class PrivateFieldModifyingDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WithPrivateFieldClass wpfc = new WithPrivateFieldClass();
		System.out.println(wpfc);
		try {
			// ���������Ʒ��ض�Ӧ�������
			Field field = wpfc.getClass().getDeclaredField("i");
			field.setAccessible(true);
			System.out.println("f.getInt(wpfc)��" + field.getInt(wpfc));
			field.setInt(wpfc, 47);
			System.out.println(wpfc);

			field = wpfc.getClass().getDeclaredField("s");
			field.setAccessible(true);
			System.out.println("f.get(wpfc)��" + field.get(wpfc));
			field.set(wpfc, "No,you're not!");
			System.out.println(wpfc);

			field = wpfc.getClass().getDeclaredField("s2");
			field.setAccessible(true);
			System.out.println("f.get(wpfc)��" + field.get(wpfc));
			field.set(wpfc, "No,you're not!");
			System.out.println(wpfc);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class WithPrivateFieldClass {
	
	private int i = 1;
	private final String s = "I'm totally safe";
	private String s2 = "Am I safe?";

	public String toString() {
		return "i = " + i + ". " + s + ". " + s2;
	}
}