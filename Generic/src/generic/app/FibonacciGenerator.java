/**
 * 
 */
package generic.app;


/**
 * Fibonacci数生成器
 * 
 * @author 刘晨伟
 *
 * 创建日期：2008-5-14
 */
public class FibonacciGenerator implements Generator<Integer> {
	
	private int count = 0;

	/**
	 * 生成一个Fibonacci数对象
	 * 
	 * @see generic.app.Generator#generate()
	 */
	public Integer generate() {
		return getFibonacci(count++);
	}

	/**
	 * 返回第n个Fibonacci数
	 */
	private Integer getFibonacci(int n) {
		if (n < 2)
			return 1;
		return getFibonacci(n - 2) + getFibonacci(n - 1);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		FibonacciGenerator generator = new FibonacciGenerator();
		for (int i = 0; i < 10; i++) {
			System.out.print(generator.generate() + " ");
		}
	}
}
