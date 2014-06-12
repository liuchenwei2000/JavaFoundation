/**
 * 
 */
package rtti.reflect;

import java.lang.reflect.Method;

/**
 * �������ù���
 * 
 * @author ����ΰ
 *
 * �������ڣ�2008-5-14
 */
public class MethodInvokingUtil {

	/**
	 * ͨ��������Ƶ������ص�(��private)����
	 * 
	 * @param obj
	 *            ���÷����Ķ���
	 * @param methodName
	 *            ������
	 */
	public static void callHiddenMethod(Object obj, String methodName)
			throws Exception {
		Method method = obj.getClass().getDeclaredMethod(methodName);
		// ͨ����������������Ե���˽�з���
		method.setAccessible(true);
		method.invoke(obj);
	}
}