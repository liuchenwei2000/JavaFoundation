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

	/**
	 * 显示当前调用方法的信息
	 */
	public static void showMethodInfo(){
		// 得到当前方法的名字
		String methodName = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.println(methodName);
		// 得到当前文件的名字
		String fileName = Thread.currentThread().getStackTrace()[2].getFileName();
		System.out.println(fileName);
		// 得到行号
		int lineNumber = Thread.currentThread().getStackTrace()[2].getLineNumber();
		System.out.println(lineNumber);
	}

	public static void main(String[] args) {
		showMethodInfo();
	}
}
