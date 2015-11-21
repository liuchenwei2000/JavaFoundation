/**
 * 
 */
package rtti.reflect;

import java.lang.reflect.Method;

/**
 * 方法调用工具
 * 
 * @author 刘晨伟
 *
 * 创建日期：2008-5-14
 */
public class MethodInvokingUtil {

	/**
	 * 通过反射机制调用隐藏的(如private)方法
	 * 
	 * @param obj
	 *            调用方法的对象
	 * @param methodName
	 *            方法名
	 */
	public static void callHiddenMethod(Object obj, String methodName)
			throws Exception {
		Method method = obj.getClass().getDeclaredMethod(methodName);
		// 通过这个方法甚至可以调用私有方法
		method.setAccessible(true);
		method.invoke(obj);
	}
}
