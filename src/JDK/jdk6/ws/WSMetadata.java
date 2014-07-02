/**
 * 
 */
package jdk6.ws;

import javax.xml.ws.Endpoint;

/**
 * 10��Web Services Ԫ����(metadata)
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-6-30
 */
public class WSMetadata {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// �������������http://localhost:8888/ws/WSProvider?wsdl�Ϳ��Կ������ɵ�WSDL�ļ�
		new Thread(new WSPublisher()).start();
	}
}

/**
 * ����WSProvider��http://localhost:8888/ws/WSProvider�����ַ֮ǰ�������wsgen����
 * ���ɷ�����WSProvider��֧���࣬�������£�
 * wsgen -cp . jdk6.WSProvider
 * ��Ҫ�� WSProvider.class �ļ����ڵ�binĿ¼��ִ����������
 */
class WSPublisher implements Runnable {
	
	public void run() {
		Endpoint.publish("http://localhost:8888/ws/WSProvider", new WSProvider());
	}
}