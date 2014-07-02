package jdk6.ws.jax_ws;

import com.liuchenwei2000.Book;
import com.liuchenwei2000.BookService;
import com.liuchenwei2000.Fetchbook;

/**
 * 4，在客户端用下面代码即可调用步骤1定义的Web Service。
 * <p>
 * Java语言客户端可以采用这种方式进行远程调用，而不再是RMI。
 * 需要导入bookws.jar(即wsimport命令生成的class文件)到classpath中。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-7-2
 */
public class WSClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 用于构造的服务类名对应于BookService类配置的serviceName
		Fetchbook bs = new Fetchbook();
		BookService bookServicePort = bs.getBookServicePort();
		Book book = bookServicePort.getABook("what?");
		System.out.println(book.getName());
		System.out.println(book.getAuthor());
	}
}
