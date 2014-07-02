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
 * webservice 示例
 * <p>
 * 自从JDK5添加了元数据功能(Annotation)之后，SUN几乎重构了整个J2EE体系。
 * 由于变化很大，干脆将名字也重构为Java EE，JavaEE5将元数据纳入很多规范当中，这其中就包括Web Services的相关规范。
 * 加入元数据之后的Web Services服务器端编程模型显然比以前的JAX-RPC编程模型简单(当然, Axis的编程模型也很简单)。
 * 这里要谈的Web服务元数据(JSR 181)只是Java Webservice规范中的一个，
 * 它跟Common Annotations, JAXB2, StAX, SAAJ和JAX-WS等共同构成JavaEE5的Web Services技术堆栈。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-7-2
 */
@WebService(targetNamespace = "http://www.liuchenwei2000.com", serviceName = "HelloService")
public class WSProvider {
	
	@WebResult(name = "Greetings")// 自定义该方法返回值在WSDL中相关的描述
	@WebMethod
	// @WebParam是自定义 参数name 在WSDL中相关的描述
	public String sayHello(@WebParam(name = "MyName") String name) {
		return "Hello," + name + "!!!"; 
	}

	@Oneway // 表明该服务方法是单向的，既没有返回值，也不应该声明检查异常
	@WebMethod(action = "printSystemDate", operationName = "printSystemDate")// 自定义该方法在WSDL中相关的描述
	public void printDate() {
		System.out.println(new Date());
	}
}