/**
 * 
 */
package rtti.reflect;

import java.lang.reflect.*;
import java.util.regex.Pattern;

/**
 * java.lang.reflect包的基本类和接口 
 * <p>
 * reflect包： </br>
 * 提供类和接口，以获取关于类和对象的反射信息，如Method类、Field类、Constructor类。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public class ReflectionDemo {
	
	// 给定的正则表达式编译到模式中
    private static Pattern p = Pattern.compile("\\w+\\.");
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// 返回与带有给定字符串名的类或接口相关联的Class对象
			Class<?> c = Class.forName("inherit.differ.Human");
			System.out.println("Package : ");
			System.out.println("  " + c.getPackage());// 返回类的包名
			System.out.println("Class name : ");
			System.out.print("  " + c.getName());// 返回类的类名
			System.out.println("  " + c.getSimpleName());// 返回类的简单类名(没有包名)
			System.out.println("Superclass name : ");
			System.out.println("  " + c.getSuperclass().getName());// 返回类的直接超类名
			System.out.println("Interfaces name : ");
			// 返回表示某些接口的Type，这些接口由此对象所表示的类或接口直接实现(不包括其父类实现的接口)
			showAll(c.getInterfaces());
			System.out.println("Constructors : ");
			/*
			 * 返回一个包含某些Constructor对象的数组 
			 * 这些对象反映此Class对象所表示的类的所有公共构造方法
			 */
			Constructor<?> constructors[] = c.getConstructors();
			show(constructors);

			System.out.println("Fields : ");
			/*
			 * 返回一个包含某些Field对象的数组(包括继承的) 
			 * 这些对象反映此Class对象所表示的类或接口的所有可访问公共字段
			 */
			Field fields[] = c.getFields();
			showAll(fields);

			System.out.println("Methods : ");
			/*
			 * 返回一个包含某些Method对象的数组(包括继承的) 
			 * 这些对象反映此Class对象所表示的类或接口的公共方法
			 */
			Method methods[] = c.getMethods();
			show(methods);
			System.out.println("public static methods : ");
			for (Method method : methods) {
				// 获取方法修饰符
				int modifier = method.getModifiers();
				// 通过Modifier类的静态方法可以判断方法的修饰属性
				if (Modifier.isPublic(modifier) && Modifier.isStatic(modifier))
					System.out.println(p.matcher(method.toString())
							.replaceAll(""));
			}
		} catch (Exception e) {
			System.out.println("Exception : " + e.getMessage());
		}
	}
	
	private static void showAll(Object obj[]) {
		for (int i = 0; i < obj.length; i++) {
			System.out.println(obj[i]);
		}
	}

	private static void show(Object obj[]) {
		for (int i = 0; i < obj.length; i++) {
			/*
			 * 创建匹配给定输入与此模式的匹配器 
			 * 按正则表达式匹配规则去掉了方法和字段的前缀修饰
			 * 如java.lang.String变为了String
			 */
			System.out.println(p.matcher(obj[i].toString()).replaceAll(""));
		}
	}
}