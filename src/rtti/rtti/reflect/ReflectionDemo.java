/**
 * 
 */
package rtti.reflect;

import java.lang.reflect.*;
import java.util.regex.Pattern;

/**
 * java.lang.reflect���Ļ�����ͽӿ� 
 * <p>
 * reflect���� </br>
 * �ṩ��ͽӿڣ��Ի�ȡ������Ͷ���ķ�����Ϣ����Method�ࡢField�ࡢConstructor�ࡣ
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public class ReflectionDemo {
	
	// ������������ʽ���뵽ģʽ��
    private static Pattern p = Pattern.compile("\\w+\\.");
    
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// ��������и����ַ����������ӿ��������Class����
			Class<?> c = Class.forName("inherit.differ.Human");
			System.out.println("Package : ");
			System.out.println("  " + c.getPackage());// ������İ���
			System.out.println("Class name : ");
			System.out.print("  " + c.getName());// �����������
			System.out.println("  " + c.getSimpleName());// ������ļ�����(û�а���)
			System.out.println("Superclass name : ");
			System.out.println("  " + c.getSuperclass().getName());// �������ֱ�ӳ�����
			System.out.println("Interfaces name : ");
			// ���ر�ʾĳЩ�ӿڵ�Type����Щ�ӿ��ɴ˶�������ʾ�����ӿ�ֱ��ʵ��(�������丸��ʵ�ֵĽӿ�)
			showAll(c.getInterfaces());
			System.out.println("Constructors : ");
			/*
			 * ����һ������ĳЩConstructor��������� 
			 * ��Щ����ӳ��Class��������ʾ��������й������췽��
			 */
			Constructor<?> constructors[] = c.getConstructors();
			show(constructors);

			System.out.println("Fields : ");
			/*
			 * ����һ������ĳЩField���������(�����̳е�) 
			 * ��Щ����ӳ��Class��������ʾ�����ӿڵ����пɷ��ʹ����ֶ�
			 */
			Field fields[] = c.getFields();
			showAll(fields);

			System.out.println("Methods : ");
			/*
			 * ����һ������ĳЩMethod���������(�����̳е�) 
			 * ��Щ����ӳ��Class��������ʾ�����ӿڵĹ�������
			 */
			Method methods[] = c.getMethods();
			show(methods);
			System.out.println("public static methods : ");
			for (Method method : methods) {
				// ��ȡ�������η�
				int modifier = method.getModifiers();
				// ͨ��Modifier��ľ�̬���������жϷ�������������
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
			 * ����ƥ������������ģʽ��ƥ���� 
			 * ��������ʽƥ�����ȥ���˷������ֶε�ǰ׺����
			 * ��java.lang.String��Ϊ��String
			 */
			System.out.println(p.matcher(obj[i].toString()).replaceAll(""));
		}
	}
}