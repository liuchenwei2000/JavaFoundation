/**
 * 
 */
package jdk6.ws.jax_ws;

import javax.xml.ws.Endpoint;

/**
 * 2����wsgen���ɷ������Ҫ�İ����࣬Ȼ�������EndPoint��ľ�̬����publish���������ࡣ
 * wsgen -cp . jdk6.ws.jax_ws.BookService
 * 
 * 3����wsimportΪ����������(Ҳ���Ƿ���Ŀͻ���)���ɱ�Ҫ�İ����࣬��������:
 * wsimport http://localhost:8888/ws/BookService?wsdl
 * ����� BookService ��ָ���� targetNamespace ��(û��ָ����ŵ������ļ�����)�����ļ������ɿͻ��˵İ����ࡣ
 * ������������ com/liuchenwei2000/ �ļ����£����Խ����ɵ�class�ļ����jar�����ͻ���ʹ�á�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-7-2
 */
public class WSServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8888/ws/BookService", new BookService());
	}
}
