/**
 * 
 */
package inherit.itf;

/**
 * Oracle类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public class Oracle implements IDatabaseConnection {
	
	private static final String NAME = "Oracle";

	public void connect() {
		System.out.println("Connect to " + NAME);
	}
}