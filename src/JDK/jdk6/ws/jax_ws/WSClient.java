package jdk6.ws.jax_ws;

import com.liuchenwei2000.Book;
import com.liuchenwei2000.BookService;
import com.liuchenwei2000.Fetchbook;

/**
 * 4���ڿͻ�����������뼴�ɵ��ò���1�����Web Service��
 * <p>
 * Java���Կͻ��˿��Բ������ַ�ʽ����Զ�̵��ã���������RMI��
 * ��Ҫ����bookws.jar(��wsimport�������ɵ�class�ļ�)��classpath�С�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014-7-2
 */
public class WSClient {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// ���ڹ���ķ���������Ӧ��BookService�����õ�serviceName
		Fetchbook bs = new Fetchbook();
		BookService bookServicePort = bs.getBookServicePort();
		Book book = bookServicePort.getABook("what?");
		System.out.println(book.getName());
		System.out.println(book.getAuthor());
	}
}
