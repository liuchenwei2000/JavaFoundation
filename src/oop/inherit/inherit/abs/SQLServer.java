/**
 * 
 */
package inherit.abs;

/**
 * SQLServer��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public class SQLServer extends Database {
	
	/** ���ݿ��� */
	private static final String NAME = "SQLServer";

	@Override
	public void showName() {
		System.out.println("This is " + NAME + " " + TYPE);
	}
}