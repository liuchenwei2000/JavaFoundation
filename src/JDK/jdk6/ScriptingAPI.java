/**
 * 
 */
package jdk6;

import java.util.Date;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 12，脚本语言支持(Scripting)示例
 * <p>
 * JDK6增加了对脚本语言的支持(JSR 223)，原理上是将脚本语言编译成 bytecode。
 * 这样脚本语言也能享用Java平台的诸多优势，包括可移植性，安全等。
 * 另外，由于现在是编译成 bytecode 后再执行，所以比原来边解释边执行效率要高很多。
 * <p>
 * 加入对脚本语言的支持后，对Java语言也提供了以下好处：
 * 1、许多脚本语言都有动态特性。
 * 比如，你不需要用一个变量之前先声明它，你可以用一个变量存放完全不同类型的对象，你不需要做强制类型转换，因为转换都是自动的。
 * 现在Java语言也可以通过对脚本语言的支持间接获得这种灵活性。
 * 2、 可以用脚本语言快速开发产品原型，因为现在可以Edit-Run，而无需Edit-Compile-Run。
 * 3、通过引入脚本语言可以轻松实现Java应用程序的扩展和自定义.
 * 可以把原来分布在在Java应用程序中的配置逻辑，数学表达式和业务规则提取出来，转用JavaScript来处理。
 * <p>
 * Sun的JDK6实现包含了一个基于Mozilla Rhino的 脚本语言引擎，支持JavaScript。
 * 这并不是说明JDK6只支持JavaScript，任何第三方都可以自己实现一个JSR-223兼容的脚本引擎使得JDK6支持别的脚本语言。
 * <p>
 * Scripting Tool
 * <p>
 * SUN提供的JDK6中有一个命令行工具 ———— jrunscript，可以在<JDK6_Home>/bin下面找到这个工具。
 * jrunscript是一个脚本语言的解释程序，它独立于脚本语言，但默认是用JavaScript。
 * 可以用jrunscript来测试自己写的脚本语言是否正确。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-7-3
 */
public class ScriptingAPI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Scripting API是用于在Java里面编写脚本语言程序的API，就是用这个API来编写JavaScript程序。
		 * 这里面有一个ScriptEngineManager类，它是使用Scripting API的入口。
		 * ScriptEngineManager可以通过jar服务发现(service discovery)机制寻找合适的脚本引擎类(ScriptEngine)。
		 */
		// 创建一个ScriptEngineManager对象
		ScriptEngineManager manager = new ScriptEngineManager();
		// 通过ScriptEngineManager获得ScriptEngine对象
		ScriptEngine engine = manager.getEngineByName("javascript");
		try {
			testEvalScript(engine);
			testScriptVariables(engine);
			testInvokeScriptMethod(engine);
			testScriptInterface(engine);
			testUsingJDKClasses(engine);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 演示如何在Java里面运行脚本语言
	 */
	private static void testEvalScript(ScriptEngine engine) throws ScriptException {
		String script = "println('Hello Scripting')";
		engine.eval(script);// 用ScriptEngine的eval方法执行脚本
	}

	/**
	 * 演示如何暴露Java对象为脚本语言的全局变量
	 */
	public static void testScriptVariables(ScriptEngine engine) throws ScriptException {
		Date date = new Date();
		engine.put("d", date);// 将变量名和对象绑定
		engine.eval("println('Today:'+ d.toString())");// 脚本中直接使用变量名d即可
	}

	/**
	 * 演示如何在Java中调用脚本语言的方法
	 */
	public static void testInvokeScriptMethod(ScriptEngine engine) throws Exception {
		String script = "function hello(name) { return 'Hello,' + name;}";
		engine.eval(script);
		// Invocable 是由 ScriptEngines 实现的可选接口，允许调用以前执行过的脚本中的函数
		Invocable invocable = (Invocable) engine;
		// 调用脚本中定义的顶层程序和函数
		String res = (String) invocable.invokeFunction("hello", "Scripting");
		System.out.println("res:" + res);
	}

	/**
	 * 演示脚本语言如何实现Java的接口
	 */
	public static void testScriptInterface(ScriptEngine engine) throws ScriptException {
		String script = "var obj = new Object(); obj.run = function() { println('run method called'); }";
		engine.eval(script);
		// 获取脚本中的变量值
		Object obj = engine.get("obj");
		Invocable inv = (Invocable) engine;
		// 返回一个接口的实现，该接口使用解释器中已编译脚本对象的成员函数。
		Runnable r = inv.getInterface(obj, Runnable.class);
		Thread th = new Thread(r);
		th.start();
	}

	/**
	 * 演示脚本语言如何使用JDK平台下的类
	 */
	public static void testUsingJDKClasses(ScriptEngine engine) throws Exception {
		// Packages是脚本语言里的一个全局变量,专用于访问JDK的package
		String js = "function calculate(a,b) {var result = Packages.java.lang.Math.pow(a,b); return result;}";
		engine.eval(js);
		Invocable inv = (Invocable) engine;
		System.out.println(inv.invokeFunction("calculate", 2, 10));
	}
}
