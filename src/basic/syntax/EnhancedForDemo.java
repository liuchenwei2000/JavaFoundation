/**
 * 
 */
package syntax;

/**
 * for循环的另一种遍历方式
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-9-10
 */
public class EnhancedForDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] n = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		// 推荐的遍历方式，变量item存储数组的当前元素
		for (int item : n) {
			System.out.print(item + " ");
		}
	}
}