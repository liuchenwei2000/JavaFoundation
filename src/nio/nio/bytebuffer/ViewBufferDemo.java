/**
 * 
 */
package nio.bytebuffer;

import java.nio.ByteBuffer;
import java.nio.IntBuffer;

import nio.IConst;

/**
 * 3����ͼ��������ʾ��
 * <p>
 * ��ͼ������(view buffer)����ͨ��ĳ���ض��Ļ����������͵��Ӵ��鿴��ײ��ByteBuffer��
 * ByteBuffer��Ȼ��ʵ�ʴ洢���ݵĵط���"֧��"��ǰ�����ͼ����˶���ͼ���κ��޸Ķ���ӳ���Ϊ��ByteBuffer�����ݵ��޸ġ�
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-7-23
 */
public class ViewBufferDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ByteBuffer byteBuffer = ByteBuffer.allocate(IConst.K);
		IntBuffer intBuffer = byteBuffer.asIntBuffer();
		// ͨ��IntBuffer�洢һ������
		intBuffer.put(new int[] { 11, 42, 47, 99, 143, 811, 1016 });
		// ͨ��IntBuffer����get��put�������������ֱ��Ӱ��ByteBuffer
		System.out.println(intBuffer.get(3));
		intBuffer.put(3, 1811);
		// ���ƴ˻���������λ������Ϊ 0 ��������ǡ� 
		intBuffer.rewind();
		while (intBuffer.hasRemaining()) {
			int i = intBuffer.get();
			// ���û���¾佫�᷵������buffer������û�洢���ݵ�λ�ö���\0
			if (i == 0) break; 
			System.out.print(i + " ");
		}
	}
}