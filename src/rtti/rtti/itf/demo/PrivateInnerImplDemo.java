/**
 * 
 */
package rtti.itf.demo;

import rtti.itf.Interface;
import rtti.itf.impl.PrivateInnerImplFactory;
import rtti.reflect.MethodInvokingUtil;

/**
 * PrivateInnerImpl类演示
 * 
 * @author 刘晨伟
 *
 * 创建日期：2008-5-14
 */
public class PrivateInnerImplDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Interface a = PrivateInnerImplFactory.makeInterface();
		a.f();
		System.out.println(a.getClass().getSimpleName());
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
