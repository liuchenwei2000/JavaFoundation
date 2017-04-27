/**
 * 
 */
package rtti.reflect.demo;

import rtti.reflect.MethodInvokingUtil;
import rtti.reflect.impl.AnonymousInnerImplFactory;

/**
 * AnonymousInnerImplFactory类演示
 * 
 * @author 刘晨伟
 *
 * 创建日期：2008-5-14
 */
public class AnonymousInnerImplDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Product a = AnonymousInnerImplFactory.makeProduct();
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
