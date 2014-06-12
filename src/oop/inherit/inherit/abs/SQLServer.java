/**
 * 
 */
package inherit.abs;

/**
 * SQLServer类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public class SQLServer extends Database {
	
	/** 数据库名 */
	private static final String NAME = "SQLServer";

	@Override
	public void showName() {
		System.out.println("This is " + NAME + " " + TYPE);
	}
}