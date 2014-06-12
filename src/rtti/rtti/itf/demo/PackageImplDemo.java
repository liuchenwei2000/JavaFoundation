/**
 * 
 */
package rtti.itf.demo;

import rtti.itf.Interface;
import rtti.itf.impl.PackageImplFactory;
import rtti.reflect.MethodInvokingUtil;

/**
 * PackageImpl类演示
 * 
 * @author 刘晨伟
 *
 * 创建日期：2008-5-14
 */
public class PackageImplDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Interface a = PackageImplFactory.makeInterface();
		a.f();
		System.out.println(a.getClass().getSimpleName());
//		以下代码编译器会报错，因为PackageC是包级访问权限
//		if(a instanceof PackageC){
//			PackageC c = (PackageC)a;
//			c.g();
//		}
		try {
			// 通过反射仍然可以调用g()，甚至私有方法
			MethodInvokingUtil.callHiddenMethod(a, "g");
			MethodInvokingUtil.callHiddenMethod(a, "u");
			MethodInvokingUtil.callHiddenMethod(a, "v");
			MethodInvokingUtil.callHiddenMethod(a, "w");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}