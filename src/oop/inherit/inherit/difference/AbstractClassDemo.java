/**
 * 
 */
package inherit.difference;

/**
 * ������ʵʾ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
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
 * �������ݿ���
 * <p>
 * �����ࣺ</br>
 * �ṩһ�����͵Ĳ���ʵ�� �������г�����ʵ������/���󷽷��;��巽���������ɱ�ʵ���������Ժ���Ҳ���Բ����г��󷽷���
 * �����඼����ʵ�ֳ����е����еĳ��󷽷��������������Լ�Ҳ������abstract��</br>
 * ��������Ϊ����ķ��������췽������̬������˽�з�����</br>
 * ��һ����û����ȫʵ��ĳ���ӿ��еķ�����Ӧ�ñ�����Ϊabstract��
 */
abstract class Database {
	
	/** ���Զ��岢ʹ�ó��� */
	protected static final String TYPE = "Database";

	//��ʹ�й��췽��Ҳ���ܱ�ʵ����
	public Database(){}
	public abstract void showName();
}

/**
 * Oracle��
 */
class Oracle extends Database {
	
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

/**
 * SQLServer��
 */
class SQLServer extends Database {
	
	/** ���ݿ��� */
	private static final String NAME = "SQLServer";

	@Override
	public void showName() {
		System.out.println("This is " + NAME + " " + TYPE);
	}
}