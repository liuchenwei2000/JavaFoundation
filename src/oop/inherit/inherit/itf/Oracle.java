/**
 * 
 */
package inherit.itf;

/**
 * Oracle��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public class Oracle implements IDatabaseConnection {
	
	private static final String NAME = "Oracle";

	public void connect() {
		System.out.println("Connect to " + NAME);
	}
}