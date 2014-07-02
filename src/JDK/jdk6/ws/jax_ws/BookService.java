/**
 * 
 */
package jdk6.ws.jax_ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * 1����д������,����Web Services Metadata(JSR-181)��ע��������ࡣ
 * <p>
 * JAX-WS���԰�����POJO��¶ΪWeb Services�������಻��Ҫʵ�ֽӿڣ����񷽷�Ҳû�б�Ҫ�׳�RMI�쳣��
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-7-2
 */
@WebService(targetNamespace = "http://www.liuchenwei2000.com", serviceName = "fetchbook")
public class BookService {

	@WebMethod
	@WebResult(name = "book")
	public Book getABook(@WebParam(name = "about") String about) {
		Book book = new Book();
		book.setName("Thinking in Java");
		book.setAuthor("Bruce Eckel");
		return book;
	}
}
