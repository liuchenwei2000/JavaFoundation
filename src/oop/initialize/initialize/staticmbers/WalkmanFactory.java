/**
 * 
 */
package initialize.staticmbers;

/**
 * Walkman随身听工厂
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-11-8
 */
public class WalkmanFactory {

	private static int code = 1;// 编号

	private WalkmanFactory() {
		// do nothing and no instance
	}

	public static Walkman createWalkman() {
		return new Walkman(getCode());
	}

	/**
	 * 每生产一个Walkman编号就+1
	 */
	public static int getCode() {
		return code++;
	}
}