/**
 * 
 */
package inherit.itf;

/**
 * SQLServer��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public class SQLServer implements IDatabaseConnection {
	
	private static final String NAME = "SQLServer";

	public void connect() {
		System.out.println("Connect to " + NAME);
	}
}