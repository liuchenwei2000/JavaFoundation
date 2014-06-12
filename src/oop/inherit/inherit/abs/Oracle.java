/**
 * 
 */
package inherit.abs;

/**
 * Oracle��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public class Oracle extends Database {
	
	/** ���ݿ��� */
	private static final String NAME = "Oracle";
	
	private String version;// �汾��

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