/**
 * 
 */
package access;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * ���η���ӡ����
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-7-13
 */
public class ModifierPrinter {

	/**
	 * ��ӡ������ķ������η����乹�����ķ������η�
	 */
	public static void printModifier(Class<?> clazz) {
		try {
			Class<?> cl = Class.forName(clazz.getName());
			System.out.print("Class ");
			System.out.print(clazz.getSimpleName());
			System.out.print(" is : ");
			System.out.println(getModifier(cl.getModifiers()));
			Constructor<?>[] cs = cl.getDeclaredConstructors();
			for (Constructor<?> c : cs) {
				System.out.print("Constructor ");
				System.out.print(clazz.getSimpleName());
				System.out.print("() is : ");
				System.out.println(getModifier(c.getModifiers()));
			}
			System.out.println();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private static String getModifier(int modifier) {
		if (Modifier.isPublic(modifier)) {
			return "public";
		} else if (Modifier.isProtected(modifier)) {
			return "protected";
		} else if (Modifier.isPrivate(modifier)) {
			return "private";
		} else {
			return "default";
		}
	}
}