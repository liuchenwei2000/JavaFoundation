/**
 * 
 */
package generic.app.coffee;

/**
 * Coffee类
 * 
 * @author 刘晨伟
 *
 * 创建日期：2008-5-14
 */
public class Coffee {
	
	// 用来统计Coffee对象的数目
	private static int counter = 0;
	// 每一个Coffee对象都有唯一的不可变的id
	private final int id = counter++;
	
	/**
	 * 返回形式：对象的实际类名 id
	 *
	 * @see java.lang.Object#toString()
	 */
	public String toString(){
		return getClass().getSimpleName() + " " + id;
	}
}