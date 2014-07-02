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
 * 5��Http Server APIʾ��
 * <p>
 * JDK6�ṩ��һ���򵥵�Http Server API���ݴ˿��Թ����Լ���Ƕ��ʽHttp Server��
 * ��֧��Http��HttpsЭ�飬�ṩ��HTTP1.1�Ĳ���ʵ�֣�û�б�ʵ�ֵ��ǲ��ֿ���ͨ����չ���е�Http Server API��ʵ�֡�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-6-30
 */
public class HTTPServerAPI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			// HttpServer��һ���򵥵�Http������ʵ��
			// ���ö˿�Ϊ 8888�����������Ϊ 10
			HttpServer server = HttpServer.create(new InetSocketAddress(8888), 10);
			// ����һ��HttpContext������������URL pattern �� HttpHandler ��ӳ��
			// ����HelloHandler��ʵ������ /hello ����
			server.createContext("/hello", new HelloHandler());
			// ΪHttpServer����һ��Executor���������̳߳ص�ʵ�֣�������server.start()����ǰ����
			server.setExecutor(null);
			// ����HttpServer
			server.start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����Ա�����Լ�ʵ��HttpHandler�ӿڣ�HttpServer�����HttpHandlerʵ����Ļص�����������ͻ�������
	 */
	private static class HelloHandler implements HttpHandler {
		
		/**
		 * һ��Http�����������Ӧ��Ϊһ����������װ��HttpExchange�ࡣ
		 * HttpServer����HttpExchange����HttpHandlerʵ����Ļص�������
		 * 
		 * @see com.sun.net.httpserver.HttpHandler#handle(com.sun.net.httpserver.HttpExchange)
		 */
		public void handle(HttpExchange exchange) throws IOException {
			// HttpExchange���Ի�ȡ��request��response�������Ϣ
			System.out.println(exchange.getRequestMethod());
			
			String response = "<html><body><h3>Hello World!</h3></body></html>";
			exchange.sendResponseHeaders(200, response.length());
			// ����Ϣд�뵽��Ӧ����
			OutputStream os = exchange.getResponseBody();
			os.write(response.getBytes());
			os.flush();
			os.close();
		}
	}
}
