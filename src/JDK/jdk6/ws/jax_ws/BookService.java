/**
 * 
 */
package jdk6.ws.jax_ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

/**
 * 1，编写服务类,并用Web Services Metadata(JSR-181)标注这个服务类。
 * <p>
 * JAX-WS可以把任意POJO暴露为Web Services，服务类不需要实现接口，服务方法也没有必要抛出RMI异常。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-7-2
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
