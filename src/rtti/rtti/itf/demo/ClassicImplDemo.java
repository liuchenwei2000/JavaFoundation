/**
 * 
 */
package rtti.itf.demo;

import rtti.itf.Interface;
import rtti.itf.impl.ClassicImpl;

/**
 * ClassicImpl����ʾ
 * 
 * @author ����ΰ
 *
 * �������ڣ�2008-5-14
 */
public class ClassicImplDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Interface a = new ClassicImpl();
		a.f();
		// a.g(); // ����������g()��������a���ɼ�
		System.out.println(a.getClass().getSimpleName());
		if (a instanceof ClassicImpl) {
			// ��¶��a��������Ϣ�����������
			ClassicImpl b = (ClassicImpl) a;
			b.g();
		}
	}
}