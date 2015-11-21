/**
 * 
 */
package rtti.reflect;

import java.lang.reflect.Field;

/**
 * 私有域修改演示
 * <p>
 * 没有任何方式可以阻止反射达到并调用那些非公共访问权限的域。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2008-5-14
 */
public class PrivateFieldModifyingDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		WithPrivateFieldClass wpfc = new WithPrivateFieldClass();
		System.out.println(wpfc);
		try {
			// 根据域名称返回对应的域对象
			Field field = wpfc.getClass().getDeclaredField("i");
			field.setAccessible(true);// 这样就可以访问 private域了
			System.out.println("f.getInt(wpfc)：" + field.getInt(wpfc));
			field.setInt(wpfc, 47);
			System.out.println(wpfc);
			System.out.println();
			
			field = wpfc.getClass().getDeclaredField("s");
			field.setAccessible(true);// final 域还是不可以再被赋值的
			System.out.println("f.get(wpfc)：" + field.get(wpfc));
			field.set(wpfc, "No,you're not!");
			System.out.println(wpfc);
			System.out.println();

			field = wpfc.getClass().getDeclaredField("s2");
			field.setAccessible(true);
			System.out.println("f.get(wpfc)：" + field.get(wpfc));
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
