/**
 * 
 */
package generic.app;


/**
 * Fibonacci��������
 * 
 * @author ����ΰ
 *
 * �������ڣ�2008-5-14
 */
public class FibonacciGenerator implements Generator<Integer> {
	
	private int count = 0;

	/**
	 * ����һ��Fibonacci������
	 * 
	 * @see generic.app.Generator#generate()
	 */
	public Integer generate() {
		return getFibonacci(count++);
	}

	/**
	 * ���ص�n��Fibonacci��
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