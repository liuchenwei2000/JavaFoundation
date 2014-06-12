/**
 * 
 */
package generic;

/**
 * �ڲ���ķ���
 * <p>
 * һ����̬�ڲ�����������Լ������ͱ�������Ϊ���� ��</br>
 * ��Ȼ��̬��Ա�����漰������������ͱ���(����)�����Ǿ�̬�ڲ�������ͱ���
 * ��������Χ������ͱ����ǲ�ͬ�ģ���ʹ���������ͱ�����������һ���ġ�
 * 
 * <strong>
 * ������ƻ�ʹ�ó���ṹ��ø��Ӳ��Ҳ��׶���������ʹ�á�
 * </strong>
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-9-15
 */
public class NestedGenericType<E> {
	
	// private static Cell<E> invalid;// static�������ܺͷ���ͬʱʹ��
	protected Cell<E> head;// �����E���ⲿ��ķ���
	protected Cell<E> tail;

	/* ... rest of NestedGenericType ... */
	
	/**
	 * ��̬�ڲ�����ⲿ��ķ�������һ��������Ȼ�ᵼ�¿ɶ����½� ��
	 * �������������ϱ�ʾ���������������Ӧ����һ���ġ�
	 * �ڲ���ķ��ͻ������ⲿ����κη��ͣ���������Ӧ�ñ����⡣
	 */
	static class Cell<E> {
		
		private Cell<E> next;
		private E element;// ���������ֶο�����������Ϊ����

		public Cell(E element) {// ��ʽ����Ҳ��������Ϊ����
			this.element = element;
		}

		public Cell(E element, Cell<E> next) {
			this.element = element;
			this.next = next;
		}

		public E getElement() {// ��������Ҳ��������Ϊ����
			return element;
		}

		public Cell<E> getNext() {
			return next;
		}
	}

	/**
	 * �Ǿ�̬�ڲ������ֱ��ʹ���ⲿ��ķ���
	 */
	class Cell2 {
		
		private Cell2 next;
		private E element;

		public Cell2(E element) {
			this.element = element;
		}

		public Cell2(E element, Cell2 next) {
			this.element = element;
			this.next = next;
		}

		public E getElement() {
			return element;
		}

		public Cell2 getNext() {
			return next;
		}
	}
}