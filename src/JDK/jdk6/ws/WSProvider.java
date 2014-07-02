/**
 * 
 */
package jdk6.ws;

import java.util.Date;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * webservice ʾ��
 * <p>
 * �Դ�JDK5�����Ԫ���ݹ���(Annotation)֮��SUN�����ع�������J2EE��ϵ��
 * ���ڱ仯�ܴ󣬸ɴཫ����Ҳ�ع�ΪJava EE��JavaEE5��Ԫ��������ܶ�淶���У������оͰ���Web Services����ع淶��
 * ����Ԫ����֮���Web Services�������˱��ģ����Ȼ����ǰ��JAX-RPC���ģ�ͼ�(��Ȼ, Axis�ı��ģ��Ҳ�ܼ�)��
 * ����Ҫ̸��Web����Ԫ����(JSR 181)ֻ��Java Webservice�淶�е�һ����
 * ����Common Annotations, JAXB2, StAX, SAAJ��JAX-WS�ȹ�ͬ����JavaEE5��Web Services������ջ��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-7-2
 */
@WebService(targetNamespace = "http://www.liuchenwei2000.com", serviceName = "HelloService")
public class WSProvider {
	
	@WebResult(name = "Greetings")// �Զ���÷�������ֵ��WSDL����ص�����
	@WebMethod
	// @WebParam���Զ��� ����name ��WSDL����ص�����
	public String sayHello(@WebParam(name = "MyName") String name) {
		return "Hello," + name + "!!!"; 
	}

	@Oneway // �����÷��񷽷��ǵ���ģ���û�з���ֵ��Ҳ��Ӧ����������쳣
	@WebMethod(action = "printSystemDate", operationName = "printSystemDate")// �Զ���÷�����WSDL����ص�����
	public void printDate() {
		System.out.println(new Date());
	}
}