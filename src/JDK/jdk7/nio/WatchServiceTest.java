/**
 * 
 */
package jdk7.nio;

import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

/**
 * WatchServiceʾ��
 * <p>
 * ��IDE������Eclipse�����ʱ���ⲿ�޸��˴����ļ���IDE��������ʾ"�ļ��и���"��
 * Java7��NIO2.0Ҳ�ṩ��������ܣ�Watch Service API�������ڼ����ļ�ϵͳ�ĸ��ġ�
 * ���������ƹ۲��ߵ�ģʽ��ע����ص��ļ������¼����½���ɾ�����޸ģ������¼�������֪ͨ��صļ����ߡ�
 * 
 * @author ����ΰ
 * 
 * �������ڣ�2014��12��24��
 */
public class WatchServiceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileSystem fileSystem = FileSystems.getDefault();
			// 1��Ϊ�ļ�ϵͳ����һ��WatchService ʵ��
			WatchService watchService = fileSystem.newWatchService();

			Path dir = Paths.get("D:/files");
			
			// 2��Ϊ�������Ŀ¼ע�� watchService��ע��ʱ��Ҫע��������Щ�¼���
			dir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, // �½�
					StandardWatchEventKinds.ENTRY_MODIFY, // �޸�
					StandardWatchEventKinds.ENTRY_DELETE // ɾ��
					);

			// 3��������ѭ������ȴ��¼��Ĵ�������һ���¼�����ʱ��key�����źŲ��Ҽ��뵽 watchService ��queue��
			while (true) {
				System.out.println("Waiting for a watch event");
				// take������������ǰ�̣߳�ֱ��һ���ļ��仯���¼���������ʱ��һ��WatchKey����ᱻ���ء�WatchKey����������������¼��������Ϣ��
				WatchKey watchKey = watchService.take();
				System.out.println("Path being watched: " + watchKey.watchable());
				System.out.println();

				if (watchKey.isValid()) {
					// 5������key�ĸ����¼�
					for (WatchEvent<?> event : watchKey.pollEvents()) {// pollEvents����������һ������Ҫ��ִ�е��¼��б�
						System.out.println("Kinds: " + event.kind());
						System.out.println("Contnet: " + event.context());
						System.out.println("Count: " + event.count());
						System.out.println();
					}
					// 6������ key�����µȴ��������¼���
					boolean valid = watchKey.reset();

					if (!valid) {
						// The watchKey is not longer registered
					}
				}
			}
		} catch (IOException | InterruptedException e) {
			e.printStackTrace();
		}
	}
}
