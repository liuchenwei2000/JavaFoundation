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
 * 12���ű�����֧��(Scripting)ʾ��
 * <p>
 * JDK6�����˶Խű����Ե�֧��(JSR 223)��ԭ�����ǽ��ű����Ա���� bytecode��
 * �����ű�����Ҳ������Javaƽ̨��������ƣ���������ֲ�ԣ���ȫ�ȡ�
 * ���⣬���������Ǳ���� bytecode ����ִ�У����Ա�ԭ���߽��ͱ�ִ��Ч��Ҫ�ߺܶࡣ
 * <p>
 * ����Խű����Ե�֧�ֺ󣬶�Java����Ҳ�ṩ�����ºô���
 * 1�����ű����Զ��ж�̬���ԡ�
 * ���磬�㲻��Ҫ��һ������֮ǰ�����������������һ�����������ȫ��ͬ���͵Ķ����㲻��Ҫ��ǿ������ת������Ϊת�������Զ��ġ�
 * ����Java����Ҳ����ͨ���Խű����Ե�֧�ּ�ӻ����������ԡ�
 * 2�� �����ýű����Կ��ٿ�����Ʒԭ�ͣ���Ϊ���ڿ���Edit-Run��������Edit-Compile-Run��
 * 3��ͨ������ű����Կ�������ʵ��JavaӦ�ó������չ���Զ���.
 * ���԰�ԭ���ֲ�����JavaӦ�ó����е������߼�����ѧ���ʽ��ҵ�������ȡ������ת��JavaScript������
 * <p>
 * Sun��JDK6ʵ�ְ�����һ������Mozilla Rhino�� �ű��������棬֧��JavaScript��
 * �Ⲣ����˵��JDK6ֻ֧��JavaScript���κε������������Լ�ʵ��һ��JSR-223���ݵĽű�����ʹ��JDK6֧�ֱ�Ľű����ԡ�
 * <p>
 * Scripting Tool
 * <p>
 * SUN�ṩ��JDK6����һ�������й��� �������� jrunscript��������<JDK6_Home>/bin�����ҵ�������ߡ�
 * jrunscript��һ���ű����ԵĽ��ͳ����������ڽű����ԣ���Ĭ������JavaScript��
 * ������jrunscript�������Լ�д�Ľű������Ƿ���ȷ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-7-3
 */
public class ScriptingAPI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*
		 * Scripting API��������Java�����д�ű����Գ����API�����������API����дJavaScript����
		 * ��������һ��ScriptEngineManager�࣬����ʹ��Scripting API����ڡ�
		 * ScriptEngineManager����ͨ��jar������(service discovery)����Ѱ�Һ��ʵĽű�������(ScriptEngine)��
		 */
		// ����һ��ScriptEngineManager����
		ScriptEngineManager manager = new ScriptEngineManager();
		// ͨ��ScriptEngineManager���ScriptEngine����
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
	 * ��ʾ�����Java�������нű�����
	 */
	private static void testEvalScript(ScriptEngine engine) throws ScriptException {
		String script = "println('Hello Scripting')";
		engine.eval(script);// ��ScriptEngine��eval����ִ�нű�
	}

	/**
	 * ��ʾ��α�¶Java����Ϊ�ű����Ե�ȫ�ֱ���
	 */
	public static void testScriptVariables(ScriptEngine engine) throws ScriptException {
		Date date = new Date();
		engine.put("d", date);// ���������Ͷ����
		engine.eval("println('Today:'+ d.toString())");// �ű���ֱ��ʹ�ñ�����d����
	}

	/**
	 * ��ʾ�����Java�е��ýű����Եķ���
	 */
	public static void testInvokeScriptMethod(ScriptEngine engine) throws Exception {
		String script = "function hello(name) { return 'Hello,' + name;}";
		engine.eval(script);
		// Invocable ���� ScriptEngines ʵ�ֵĿ�ѡ�ӿڣ����������ǰִ�й��Ľű��еĺ���
		Invocable invocable = (Invocable) engine;
		// ���ýű��ж���Ķ������ͺ���
		String res = (String) invocable.invokeFunction("hello", "Scripting");
		System.out.println("res:" + res);
	}

	/**
	 * ��ʾ�ű��������ʵ��Java�Ľӿ�
	 */
	public static void testScriptInterface(ScriptEngine engine) throws ScriptException {
		String script = "var obj = new Object(); obj.run = function() { println('run method called'); }";
		engine.eval(script);
		// ��ȡ�ű��еı���ֵ
		Object obj = engine.get("obj");
		Invocable inv = (Invocable) engine;
		// ����һ���ӿڵ�ʵ�֣��ýӿ�ʹ�ý��������ѱ���ű�����ĳ�Ա������
		Runnable r = inv.getInterface(obj, Runnable.class);
		Thread th = new Thread(r);
		th.start();
	}

	/**
	 * ��ʾ�ű��������ʹ��JDKƽ̨�µ���
	 */
	public static void testUsingJDKClasses(ScriptEngine engine) throws Exception {
		// Packages�ǽű��������һ��ȫ�ֱ���,ר���ڷ���JDK��package
		String js = "function calculate(a,b) {var result = Packages.java.lang.Math.pow(a,b); return result;}";
		engine.eval(js);
		Invocable inv = (Invocable) engine;
		System.out.println(inv.invokeFunction("calculate", 2, 10));
	}
}
