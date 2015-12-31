/**
 * 
 */
package jdk6.ws.jax_ws;

import javax.xml.ws.Endpoint;

/**
 * 2，用wsgen生成服务类必要的帮助类，然后调用用EndPoint类的静态方法publish发布服务类。
 * wsgen -cp . jdk6.ws.jax_ws.BookService
 * 
 * 3，用wsimport为服务消费者(也就是服务的客户端)生成必要的帮助类，命令如下:
 * wsimport http://localhost:8888/ws/BookService?wsdl
 * 这会在 BookService 类指定的 targetNamespace 名(没有指定则放到包名文件夹中)倒序文件夹生成客户端的帮助类。
 * 本例会生成在 com/liuchenwei2000/ 文件夹下，可以将生成的class文件打成jar包给客户端使用。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-7-2
 */
public class WSServer {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Endpoint.publish("http://localhost:8888/ws/BookService", new BookService());
	}
}
