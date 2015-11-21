/**
 * 
 */
package rtti.itf.demo;

import rtti.itf.Interface;
import rtti.itf.impl.ClassicImpl;

/**
 * ClassicImpl类演示
 * 
 * @author 刘晨伟
 *
 * 创建日期：2008-5-14
 */
public class ClassicImplDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Interface a = new ClassicImpl();
		a.f();
		// a.g(); // 编译器报错：g()方法对于a不可见
		System.out.println(a.getClass().getSimpleName());
		if (a instanceof ClassicImpl) {
			// 暴露了a的类型信息，产生了耦合
			ClassicImpl b = (ClassicImpl) a;
			b.g();
		}
	}
}
