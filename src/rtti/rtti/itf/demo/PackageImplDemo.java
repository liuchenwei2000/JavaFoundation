/**
 * 
 */
package rtti.itf.demo;

import rtti.itf.Interface;
import rtti.itf.impl.PackageImplFactory;
import rtti.reflect.MethodInvokingUtil;

/**
 * PackageImpl����ʾ
 * 
 * @author ����ΰ
 *
 * �������ڣ�2008-5-14
 */
public class PackageImplDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Interface a = PackageImplFactory.makeInterface();
		a.f();
		System.out.println(a.getClass().getSimpleName());
//		���´���������ᱨ����ΪPackageC�ǰ�������Ȩ��
//		if(a instanceof PackageC){
//			PackageC c = (PackageC)a;
//			c.g();
//		}
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