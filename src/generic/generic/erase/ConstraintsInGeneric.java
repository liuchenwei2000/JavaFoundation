/**
 * 
 */
package generic.erase;

import generic.Pair;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * 泛型的约束与局限性演示
 * 
 * @author 刘晨伟
 *
 * 创建日期：2009-8-3
 */
public class ConstraintsInGeneric {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		testPrimitiveType();
		testRTTI();
		testException();
		testArray();
		testGenericInstance();
		testStatic();
	}

	/**
	 * 1，基本类型
	 * <p>
	 * 不能用类型参数替换基本类型，没有Pair<double>，只有Pair<Double>，其原因是类型擦除。
	 * 擦除之后Pair类具有Object类型的字段，而Object不能存储double(基本类型)值。
	 * 可以用基本类型的包装器类解决这个问题。
	 */
	private static void testPrimitiveType() {
		// 下面的语句会有编译错
		// Pair<double> pair = new Pair<double>();
		Pair<Double> pair = new Pair<Double>();
		pair.setFirst(0.1);
		pair.setSecond(0.2);
	}
	
	/**
	 * 2，运行时类型查询
	 * <p>
	 * JVM中的对象总有一个特定的非泛型类型，因此所有的运行时类型查询RTTI(如 instanceof 或 getClass())只产生原生类型(即Pair.class)。
	 */
	private static void testRTTI() {
		Pair<String> pair = new Pair<String>();
		// 下面的语句会有编译错
		// boolean b = pair instanceof Pair<String>;
		boolean b = pair instanceof Pair;
		// 强制类型转换
		Pair<String> p = (Pair<String>) pair;
		Pair<Double> pair2 = new Pair<Double>();
		b = p.getClass() == pair2.getClass();
		System.out
				.println("Pair<String> and Pair<Double> are the same class type:"
						+ p.getClass() + " ? " + b);
	}
	
	/**
	 * 3，异常
	 * <p>
	 * 不能抛出也不能捕获泛型类的对象，实际上泛型类不能继承Throwable。
	 * 只可以在方法的异常声明中使用泛型。
	 */
	private static void testException() {
		// 泛型类扩展Throwable是不合法的
		// public class Problem<T> extends Exception{}
		class InnerClass {
			
			/** 不能在catch子句中使用类型变量(泛型) */
//			public <T extends Throwable> void doWork(Class<T> t) {
//				try {
//					// ...
//				} catch (T e)// 这里会报错
//				{
//					// ...
//				}
//			}

			/**
			 * 在方法的异常声明(throws)中可以使用类型变量(泛型)
			 */
			public <T extends Throwable> void doWork(T t) throws T // 这是可以的
			{
				try {
					throw new RuntimeException("exception in InnerClass.doWork(T t)");
				} catch (Throwable cause) {
					t.initCause(cause);
					throw t;
				}
			}
		}
		try {
			// 调用方式
			new InnerClass().doWork(new RuntimeException());
		} catch (Exception e) {
			System.out.println("catch exception in InnerClass.doWork(T):");
			System.out.println(e.getCause().getMessage());
		}
	}
	
	/**
	 * 4，数组
	 * <p>
	 * 不能声明参数化类型的数组，如果要收集参数化类型对象，使用ArrayList<Pair<String>>最安全有效。
	 */
	private static void testArray() {
		/* 
		 * 不能声明参数化类型的数组，如：
		 * 
		 * Pair<String>[] table = new Pair<String>[10];
		 * 
		 * 因为在类型擦除之后，table的类型为Pair[]，可以将其转换为Object[]:
		 * 
		 * Object[] objs = table;
		 * 
		 * 数组能够记住它的元素类型，如果试图存入一个错误类型的元素，就会抛出ArrayStoreException异常。
		 * 
		 * objs[0] = "hello"; 和 objs[0] = new Pair<Double>();
		 * 
		 * 是能够通过编译的，可以通过数组存储的检测，但仍然会导致类型错误，因此禁止使用参数化类型的数组。
		 */
		List<Pair<String>> list = new ArrayList<Pair<String>>();
		list.add(new Pair<String>());
		// 下面的语句会有编译错
		// list.add("string");
		// list.add(new Pair<Double>());
	}
	
	/**
	 * 5，泛型类型的实例化
	 * <p>
	 * 不能实例化泛型类型(即用new T()构造方式)，但是通过调用Class.newInstance和
	 * Array.newInstance方法，可以利用反射构造泛型对象和泛型数组。
	 */
	private static void testGenericInstance() {
		
		class Pair2<T> {
			
			private T first;
			private T[] second;

			@SuppressWarnings("unchecked")
			public Pair2(T t) {
				/*
				 * 下面的语句会有编译错
				 * 
				 * 类型擦除将T改变成Object，而且本意肯定不希望调用new Object(); 
				 * 类似的，不能建立一个泛型数组：T[] second = new T[2]; 
				 * 类型擦除会让方法总是构造一个Object[2]数组。
				 */
				// first = new T();
				// second[] = new T[2];
				try {
					// 通过调用Class.newInstance和Array.newInstance方法
					first = (T) (t.getClass().newInstance());
					second = (T[]) Array.newInstance(t.getClass(), 2);
					System.out.println("Pair2<T>.first class = "
							+ first.getClass());
					System.out.println("Pair2<T>.second class = "
							+ second.getClass());
					System.out.println("Pair2<T>.second length = "
							+ second.length);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		new Pair2<String>(new String());
	}
	
	/**
	 * 6，静态上下文
	 * <p>
	 * 不能在静态字段或方法中引用类型变量(泛型)。
	 */
	private static void testStatic() {
		
		class Singleton<T> {
			// 下面的语句会有编译错
//			private static T instance;
			// 下面的语句会有编译错
//			public static T getInstance() {
//				return instance;
//			}
		}
		new Singleton<String>();
	}
}