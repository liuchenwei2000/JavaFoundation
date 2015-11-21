/**
 * 
 */
package inherit.difference;

/**
 * 接口实现示例
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public class InterfaceImplDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SQLServerConnection sqls = new SQLServerConnection();
		System.out.print("Now ");
		connect2DB(sqls);
		System.out.print("Now ");
		OracleConnection oracle = new OracleConnection();
		connect2DB(oracle);
	}

	/**
	 * 这个方法只管连接数据库，具体何种数据库由传入的参数类型确定
	 */
	private static void connect2DB(IDatabaseConnection idc) {
		// 传SQLServer的对象进来就用SQLServer的connect()方法
		// 传Oracle的对象进来就用Oracle的connect()方法
		idc.connect();
	}
}

/**
 * 数据库连接接口
 * <p>
 * 接口：</br>
 * 是一些方法特征的集合而没有方法的实现，这些方法在不同的类里会被实现成不同的行为。
 * <p>
 * 注：</br>
 * 接口中的变量默认是final static的，它们的值不可通过实现类改变且必须以常量初始化。
 * 实现类必须实现接口中的所有的方法，否则必须声明为abstract类。
 * <p>
 * 场景说明：
 * 对于不同的数据库，都需要被程序连接，连接方法是不一样的。
 * 在某个环境下，我们只知道有个数据库，但不知道是怎么连接的，只知道能连接。
 */
interface IDatabaseConnection {
	
	public void connect();// 连接数据库的方法
}

/**
 * Oracle数据库实现数据库连接接口
 */
class OracleConnection implements IDatabaseConnection {
	
	private static final String NAME = "Oracle";

	public void connect() {
		System.out.println("Connect to " + NAME);
	}
}

/**
 * SQLServer数据库实现数据库连接接口
 */
class SQLServerConnection implements IDatabaseConnection {
	
	private static final String NAME = "SQLServer";

	public void connect() {
		System.out.println("Connect to " + NAME);
	}
}
