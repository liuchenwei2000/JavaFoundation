/**
 * 
 */
package nio.lock;

import java.io.FileOutputStream;
import java.nio.channels.FileLock;

/**
 * �ļ�������
 * <p>
 * ���ͬʱ���еĳ�����Ҫ�޸�ͬһ���ļ�ʱ������֮����Ҫĳ��ͨ�ţ�������ļ������ױ��𻵡�
 * �ļ������ƶ��ļ������ļ�һ�����ֽڵķ��ʡ�
 * <p>
 * �ļ�����������ͬ������ĳ����Ϊ������Դ���ļ���
 * ����ͬһ�ļ��������߳̿����ڲ�ͬ��Java������ϣ�����һ����Java�̣߳���һ���ǲ���ϵͳ�������ı����̡߳�
 * �ļ����������Ĳ���ϵͳ�����ǿɼ��ģ���ΪJava���ļ�����ֱ��ӳ�䵽�˱��ز���ϵͳ�ļ������ߡ�
 * 
 * @author ����ΰ
 *
 * �������ڣ�2009-5-13
 */
public class FileLockDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) throws Exception {
		String filePath = "files/nio.lock/file.txt";
		FileOutputStream fos = new FileOutputStream(filePath);
		// lock һֱ��������״ֱ̬����������
		// FileLock lock = fos.getChannel().lock();
		// tryLock �������أ����ظ���������null(�������������)
		FileLock lock = fos.getChannel().tryLock();
		// ����������ķ���ʵ�������ļ���һ����
		// ��shared��־ΪfalseʱΪ����������ռ��������ס���ļ��Ķ�д
        // ��shared��־Ϊtrueʱ��Ϊ�������������������������ļ������Ƿ�ֹ�κν��̻�ȡ������
		// �������еĲ���ϵͳ��֧�ֹ���������ˣ���������һ������������õĺܿ�����һ��������
		// FileLock lock = tryLock(long start, long size, boolean shared);
		if (lock != null) {
			// isShared�жϴ������Ƿ�Ϊ������ 
			System.out.println("lock is shared��" + lock.isShared());
			System.out.println("locked file");
			Thread.sleep(10000);
			// ���ͷ���֮ǰ�ֹ�ɾ�����ļ�OS�ᱨ��
			lock.release();
			System.out.println("released lock");
		}
		fos.close();
	}
}