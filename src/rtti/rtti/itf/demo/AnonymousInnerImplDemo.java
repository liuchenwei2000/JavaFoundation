/**
 * 
 */
package rtti.itf.demo;

import rtti.itf.Interface;
import rtti.itf.impl.AnonymousInnerImplFactory;
import rtti.reflect.MethodInvokingUtil;

/**
 * AnonymousInnerImplFactory����ʾ
 * 
 * @author ����ΰ
 *
 * �������ڣ�2008-5-14
 */
public class AnonymousInnerImplDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Interface a = AnonymousInnerImplFactory.makeInterface();
		a.f();
		System.out.println(a.getClass().getSimpleName());
		try {
			// ͨ��������Ȼ���Ե���g()������˽�з���
			MethodInvokingUtil.callHiddenMethod(a, "g");
			MethodInvokingUtil.callHiddenMethod(a, "u");
			MethodInvokingUtil.callHiddenMethod(a, "v");
			MethodInvokingUtil.callHiddenMethod(a, "w");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}