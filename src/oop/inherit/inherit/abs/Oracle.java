/**
 * 
 */
package inherit.abs;

/**
 * Oracle类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public class Oracle extends Database {
	
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