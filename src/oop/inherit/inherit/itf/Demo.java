/**
 * 
 */
package inherit.itf;

/**
 * 演示类
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-8-28
 */
public class Demo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SQLServer sqls = new SQLServer();
		Oracle oracle = new Oracle();
		System.out.print("Now ");
		connect2DB(sqls);
		System.out.print("Now ");
		connect2DB(oracle);
	}

	private static void connect2DB(IDatabaseConnection idc) {
		idc.connect();
	}
}