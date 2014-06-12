/**
 * 
 */
package inherit.itf;

/**
 * ��ʾ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
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