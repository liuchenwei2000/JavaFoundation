/**
 * 
 */
package syntax;

/**
 * return关键字示例
 * <p>
 * return的两个作用：
 * <li>1，指定一个方法返回什么值(void和非void)
 * <li>2，导致当前方法退出并返回那个值</br>
 * 
 * 如果在void方法中没有return语句则在该方法的结尾处会有一个隐式的return，
 * 若想提前退出某个void方法可以使用return。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-9-11
 */
public class ReturnDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		invokeSearch(a, 4);
	}

	/**
	 * 调用search方法
	 */
	private static void invokeSearch(int a[], int n) {
		System.out.println("before invoking search()");
		search(a, n);
		System.out.println("after invoking search()");
	}

	private static void search(int a[], int n) {
		if (a.length == 0)
			return;
		for (int i = 0; i < a.length; i++) {
			if (a[i] == n) {
				System.out.println("find index = " + i);
				return;
			}
		}
	}
}
