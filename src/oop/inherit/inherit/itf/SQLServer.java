/**
 * 
 */
package inherit.itf;

/**
 * SQLServer类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public class SQLServer implements IDatabaseConnection {
	
	private static final String NAME = "SQLServer";

	public void connect() {
		System.out.println("Connect to " + NAME);
	}
}