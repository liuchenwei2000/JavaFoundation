/**
 * 
 */
package inherit.abs;

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
		sqls.showName();
		Oracle oracle = new Oracle();
		oracle.showName();
		oracle.showVersion();
	}
}