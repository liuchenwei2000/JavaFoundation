/**
 * 
 */
package inherit.abs;

/**
 * ���ݿ���(abstract)
 * <p>
 * �����ࣺ</br>
 * �ṩһ�����͵Ĳ���ʵ�� �������г�����ʵ������/���󷽷��;��巽���������ɱ�ʵ������
 * ��������Ժ���Ҳ���Բ����г��󷽷���
 * �����඼����ʵ�ֳ����е����еĳ��󷽷��������������Լ�Ҳ������abstract��</br>
 * ��������Ϊ����ķ��������췽������̬������˽�з�����</br>
 * ��һ����û����ȫʵ��ĳ���ӿ��еķ�����Ӧ�ñ�����Ϊabstract��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public abstract class Database {
	
	/** ���Զ��岢ʹ�ó��� */
	protected static final String TYPE = "Database";

	//��ʹ�й��췽��Ҳ���ܱ�ʵ����
	public Database(){}
	public abstract void showName();
}