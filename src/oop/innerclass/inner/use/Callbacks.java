/**
 * 
 */
package inner.use;

/**
 * 内部类实现回调(callback)
 * <p>
 * 通过回调对象能够携带一些信息，这些信息允许它在稍后的某个时刻调用初始的对象。
 * 回调的价值在于它的灵活性：可以在运行时动态的决定需要调用什么方法。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-6
 */
public class Callbacks {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Callee1 c1 = new Callee1();
		Callee2 c2 = new Callee2();
		MyIncrement.f(c2);
		Caller caller1 = new Caller(c1);
		Caller caller2 = new Caller(c2.getCallbackReference());
		caller1.go();
		caller1.go();
		caller2.go();
		caller2.go();
	}
}

/**
 * 进一步揭示了外部类实现一个接口与内部类实现此接口之间的区别。
 * <p>
 * 就代码而言，Callee1是简单的解决方式，Callee2继承自MyIncrement，
 * 后者已经有了一个不同的increment方法，并且与Incrementable接口期望的increment方法完全不相关。
 * 所以如果Callee2继承了MyIncrement就不能为了Incrementable的用途而覆盖了increment方法，只能使用内部类独立的实现Incrementable。
 * 当创建一个内部类时，并没有在外部类的接口中添加东西，也没有修改外部类的接口。
 */
interface Incremnetable {
	
	void increment();
}

class Callee1 implements Incremnetable {
	
	private int i = 0;

	public void increment() {
		i++;
		System.out.println(i);
	}
}

class MyIncrement {
	
	void increment() {
		System.out.println("Other operation");
	}

	static void f(MyIncrement mi) {
		mi.increment();
	}
}

class Callee2 extends MyIncrement {
	
	private int i = 0;

	public void incr() {
		i++;
		System.out.println(i);
	}

	/**
	 * 内部类Closure实现了Incremnetable以提供一个返回Callee2的钩子。
	 * 这是一个安全的钩子，无论谁获得了此Incrementable的引用，都只能调用increment，除此之外没有其他功能。
	 * 回调的价值在于它的灵活性：可以在运行时动态地决定需要调用什么方法
	 */
	private class Closure implements Incremnetable {
		public void increment() {
			incr();
		}
	}

	Incremnetable getCallbackReference() {
		return new Closure();
	}
}

class Caller {
	
	private Incremnetable callbackreference;

	Caller(Incremnetable cbh) {
		callbackreference = cbh;
	}

	void go() {
		callbackreference.increment();
	}
}