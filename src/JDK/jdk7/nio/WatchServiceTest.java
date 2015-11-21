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
 * WatchService示例
 * <p>
 * 用IDE（例如Eclipse）编程时，外部修改了代码文件，IDE会马上提示"文件有更改"。
 * Java7的NIO2.0也提供了这个功能（Watch Service API），用于监听文件系统的更改。
 * 它采用类似观察者的模式，注册相关的文件更改事件（新建、删除、修改），当事件发生的通知相关的监听者。
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2014年12月24日
 */
public class WatchServiceTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			FileSystem fileSystem = FileSystems.getDefault();
			// 1，为文件系统创建一个WatchService 实例
			WatchService watchService = fileSystem.newWatchService();

			Path dir = Paths.get("D:/files");
			
			// 2，为想监听的目录注册 watchService。注册时，要注明监听那些事件。
			dir.register(watchService, StandardWatchEventKinds.ENTRY_CREATE, // 新建
					StandardWatchEventKinds.ENTRY_MODIFY, // 修改
					StandardWatchEventKinds.ENTRY_DELETE // 删除
					);

			// 3，在无限循环里面等待事件的触发。当一个事件发生时，key发出信号并且加入到 watchService 的queue。
			while (true) {
				System.out.println("Waiting for a watch event");
				// take方法会阻塞当前线程，直到一个文件变化的事件发生。此时，一个WatchKey对象会被返回。WatchKey对象包含了所发生事件的相关信息。
				WatchKey watchKey = watchService.take();
				System.out.println("Path being watched: " + watchKey.watchable());
				System.out.println();

				if (watchKey.isValid()) {
					// 5，遍历key的各种事件
					for (WatchEvent<?> event : watchKey.pollEvents()) {// pollEvents方法返回了一个所有要被执行的事件列表。
						System.out.println("Kinds: " + event.kind());
						System.out.println("Contnet: " + event.context());
						System.out.println("Count: " + event.count());
						System.out.println();
					}
					// 6，重置 key，重新等待该类型事件。
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
