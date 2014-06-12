/**
 * 
 */
package puzzler;

/**
 * ��try������return���ʱ�Ŀ�������ʾ��
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-11-7
 */
public class ReturnInTryBlock {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if (decision())
			System.out.println("return in try");
		else
			System.out.println("return in finally");
		testReturn();
	}

	/**
	 * һ������һ�����������׳���һ���쳣�����߶�ĳ��������ִ����һ��break��continue����returnʱ��
	 * �����������������Ϊ������ֹ����ȥ��˳��ִ���������䡣
	 * 
	 * ��try�����finally���鶼�������ʱ��try�������������������ԭ�򽫱�������
	 * ������try-finally������������ԭ����finally�������������ԭ����ͬ��
	 * 
	 * ��֮��ÿһ��finally���鶼Ӧ�����������������׳����ǲ��ܲ���쳣��
	 * Ҳ���ǲ�Ҫ��return��break��continue��throw���˳�һ��finally���飬
	 * Ҳ��Ҫ��һ���ܲ��쳣����finally����֮��ȥ�� 
	 * 
	 * ����������⣺ ��������(try)����(return)true ��������(finally)����(return)false
	 */
	@SuppressWarnings("finally")
	private static boolean decision() {
		try {
			return true;
		} finally {
			return false;
		}
	}

	/**
	 * ��try��������return��Ϊ�����÷����ı�־ʱ���ڿ���������returnʱ������ִ��finally���飬Ȼ����ִ��return������������
	 */
	private static void testReturn() {
		try {
			System.out.println("try before return");
			return;
		} finally {
			System.out.println("finaly");
		}
	}
}