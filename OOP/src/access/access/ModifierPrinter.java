/**
 * 
 */
package access;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

/**
 * 修饰符打印工具
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-7-13
 */
public class ModifierPrinter {

	/**
	 * 打印参数类的访问修饰符和其构造器的访问修饰符
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
