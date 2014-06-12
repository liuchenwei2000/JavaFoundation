/**
 * 
 */
package initialize;

/**
 * ��ʼ��˳����ʾ
 * <p>
 * �������������ֶκ͹��췽���ĳ�ʼ��˳�� �����ȸ����ֶ��ȱ���ʼ��Ȼ�����ٵ��ù��췽����
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2007-8-28
 */
public class OrderOfInitialization {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Card c = new Card();
		c.f();
		// ���Ϊ��
		// Tag(1)
		// Tag(2)
		// Tag(3)
		// Card()
		// Tag(33)
		// f()
	}
}

/**
 * ����(�ֶε���������������)
 */
class Card {
	
	Tag t1 = new Tag(1);
	
	public Card() {
		System.out.println("Card()");
		t3 = new Tag(33);
	}

	Tag t2 = new Tag(2);

	public void f() {
		System.out.println("f()");
	}

	Tag t3 = new Tag(3);
}
/**
 * Tag��
 */
class Tag {
	
	public Tag(int marker) {
		System.out.println("Tag(" + marker + ")");
	}
}