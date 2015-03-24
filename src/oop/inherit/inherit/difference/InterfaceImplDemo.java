/**
 * 
 */
package inherit.difference;

/**
 * �ӿ�ʵ��ʾ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public class InterfaceImplDemo {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SQLServerConnection sqls = new SQLServerConnection();
		System.out.print("Now ");
		connect2DB(sqls);
		System.out.print("Now ");
		OracleConnection oracle = new OracleConnection();
		connect2DB(oracle);
	}

	/**
	 * �������ֻ���������ݿ⣬����������ݿ��ɴ���Ĳ�������ȷ��
	 */
	private static void connect2DB(IDatabaseConnection idc) {
		// ��SQLServer�Ķ����������SQLServer��connect()����
		// ��Oracle�Ķ����������Oracle��connect()����
		idc.connect();
	}
}

/**
 * ���ݿ����ӽӿ�
 * <p>
 * �ӿڣ�</br>
 * ��һЩ���������ļ��϶�û�з�����ʵ�֣���Щ�����ڲ�ͬ������ᱻʵ�ֳɲ�ͬ����Ϊ��
 * <p>
 * ע��</br>
 * �ӿ��еı���Ĭ����final static�ģ����ǵ�ֵ����ͨ��ʵ����ı��ұ����Գ�����ʼ����
 * ʵ�������ʵ�ֽӿ��е����еķ����������������Ϊabstract�ࡣ
 * <p>
 * ����˵����
 * ���ڲ�ͬ�����ݿ⣬����Ҫ���������ӣ����ӷ����ǲ�һ���ġ�
 * ��ĳ�������£�����ֻ֪���и����ݿ⣬����֪������ô���ӵģ�ֻ֪�������ӡ�
 */
interface IDatabaseConnection {
	
	public void connect();// �������ݿ�ķ���
}

/**
 * Oracle���ݿ�ʵ�����ݿ����ӽӿ�
 */
class OracleConnection implements IDatabaseConnection {
	
	private static final String NAME = "Oracle";

	public void connect() {
		System.out.println("Connect to " + NAME);
	}
}

/**
 * SQLServer���ݿ�ʵ�����ݿ����ӽӿ�
 */
class SQLServerConnection implements IDatabaseConnection {
	
	private static final String NAME = "SQLServer";

	public void connect() {
		System.out.println("Connect to " + NAME);
	}
}