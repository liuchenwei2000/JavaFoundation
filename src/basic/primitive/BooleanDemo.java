/**
 * 
 */
package primitive;

import java.util.HashMap;
import java.util.Map;

/**
 * boolean包装类的演示
 * <p>
 * Boolean类中没有太多实用的方法，但是用两个常量会经常被用到：
 * Boolean.TRUE 和 Boolean.FALSE。
 * 
 * 当需要创建Boolean对象时使用这两个常量会提高效率。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-11-13
 */
public class BooleanDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Map<String, Boolean> map = new HashMap<String, Boolean>();
		map.put("A", Boolean.TRUE);
		map.put("B", Boolean.FALSE);
		map.put("C", Boolean.TRUE);
		map.put("D", Boolean.FALSE);
		map.put("E", Boolean.TRUE);
		System.out.println(map);
	}
}