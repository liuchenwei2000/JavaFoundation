/**
 * 
 */
package syntax;

/**
 * break演示类
 * <p>
 * 无标签的break:
 * 只能中止最内层的switch、for、while和do-while。</br>
 * 有标签的break:
 * 可以中止标签代表的语句块。
 * <p>
 * break也可以和总会被执行的finally语句一起配合使用，这样Java里就没有必要使用goto语句了。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-9-11
 */
public class BreakDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[][] array = { { 32, 87, 3, 589 }, { 12, 1076, 2000, 8 },
				{ 622, 127, 77, 955 } };
		int searchfor = 12;

		int i;
		int j = 0;
		boolean foundIt = false;

		search: for (i = 0; i < array.length; i++) {
			for (j = 0; j < array[i].length; j++) {
				if (array[i][j] == searchfor) {
					foundIt = true;
					// 若是 break; 则只中止j循环
					break search;
				}
			}
		}

		if (foundIt) {
			System.out.println("Found " + searchfor + " at " + i + "," + j);
		} else {
			System.out.println(searchfor + " not in the array");
		}
	}
}