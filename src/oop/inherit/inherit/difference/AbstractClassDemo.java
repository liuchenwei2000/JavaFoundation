/**
 * 
 */
package inherit.difference;

/**
 * 抽象类实示例
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public abstract class AbstractClassDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SQLServer sqls = new SQLServer();
		sqls.showName();
		
		Oracle oracle = new Oracle();
		oracle.showName();
		oracle.showVersion();
	}
}

/**
 * 抽象数据库类
 * <p>
 * 抽象类：</br>
 * 提供一个类型的部分实现 ，可以有常量、实例变量/抽象方法和具体方法，但不可被实例化，可以含有也可以不含有抽象方法。
 * 其子类都必须实现超类中的所有的抽象方法，或者其子类自己也声明成abstract。</br>
 * 不可声明为抽象的方法：构造方法、静态方法、私有方法。</br>
 * 若一个类没有完全实现某个接口中的方法就应该被声明为abstract。
 */
abstract class Database {
	
	/** 可以定义并使用常量 */
	protected static final String TYPE = "Database";

	//即使有构造方法也不能被实例化
	public Database(){}
	public abstract void showName();
}

/**
 * Oracle类
 */
class Oracle extends Database {
	
	/** 数据库名 */
	private static final String NAME = "Oracle";
	
	private String version;// 版本号

	public Oracle() {
		version = "1.0";
	}

	public Oracle(String version) {
		this.version = version;
	}

	public void showName() {
		System.out.println("This is " + NAME + " " + Database.TYPE);
	}

	public void showVersion() {
		System.out.println("Version is " + version);
	}
}

/**
 * SQLServer类
 */
class SQLServer extends Database {
	
	/** 数据库名 */
	private static final String NAME = "SQLServer";

	@Override
	public void showName() {
		System.out.println("This is " + NAME + " " + TYPE);
	}
}