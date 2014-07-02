/**
 * 
 */
package jdk6;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

/**
 * 5，Http Server API示例
 * <p>
 * JDK6提供了一个简单的Http Server API，据此可以构建自己的嵌入式Http Server。
 * 它支持Http和Https协议，提供了HTTP1.1的部分实现，没有被实现的那部分可以通过扩展已有的Http Server API来实现。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-6-30
 */
public class HTTPServerAPI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// HttpServer是一个简单的Http服务器实现
			// 设置端口为 8888，最大连接数为 10
			HttpServer server = HttpServer.create(new InetSocketAddress(8888), 10);
			// 创建一个HttpContext————它是URL pattern 到 HttpHandler 的映射
			// 即用HelloHandler类实例处理 /hello 请求
			server.createContext("/hello", new HelloHandler());
			// 为HttpServer设置一个Executor，往往是线程池的实现，必须在server.start()方法前调用
			server.setExecutor(null);
			// 启动HttpServer
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 程序员必须自己实现HttpHandler接口，HttpServer会调用HttpHandler实现类的回调方法来处理客户端请求
	 */
	private static class HelloHandler implements HttpHandler {
		
		/**
		 * 一个Http请求和它的响应称为一个交换，包装成HttpExchange类。
		 * HttpServer负责将HttpExchange传给HttpHandler实现类的回调方法。
		 * 
		 * @see com.sun.net.httpserver.HttpHandler#handle(com.sun.net.httpserver.HttpExchange)
		 */
		public void handle(HttpExchange exchange) throws IOException {
			// HttpExchange可以获取到request和response的相关信息
			System.out.println(exchange.getRequestMethod());
			
			String response = "<html><body><h3>Hello World!</h3></body></html>";
			exchange.sendResponseHeaders(200, response.length());
			// 将信息写入到响应流中
			OutputStream os = exchange.getResponseBody();
			os.write(response.getBytes());
			os.flush();
			os.close();
		}
	}
}
