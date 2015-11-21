/**
 * 
 */
package jdk6.ws;

import javax.xml.ws.Endpoint;

/**
 * 10，Web Services 元数据(metadata)
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014-6-30
 */
public class WSMetadata {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 在浏览器中输入http://localhost:8888/ws/WSProvider?wsdl就可以看到生成的WSDL文件
		new Thread(new WSPublisher()).start();
	}
}

/**
 * 发布WSProvider到http://localhost:8888/ws/WSProvider这个地址之前必须调用wsgen命令
 * 生成服务类WSProvider的支持类，命令如下：
 * wsgen -cp . jdk6.WSProvider
 * 需要在 WSProvider.class 文件所在的bin目录里执行上述命令
 */
class WSPublisher implements Runnable {
	
	public void run() {
		Endpoint.publish("http://localhost:8888/ws/WSProvider", new WSProvider());
	}
}
