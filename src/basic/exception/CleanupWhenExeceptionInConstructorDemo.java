/**
 * 
 */
package exception;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 清理演示
 * <p>
 * 对于在构造阶段可能会抛出异常并且要求清理的类，最安全的方式是使用嵌套的try子句，其基本规则是：
 * 在创建需要清理的对象之后，立即进入一个 try-finally 语句块。
 * 
 * @author 刘晨伟
 *
 * 创建日期：2008-5-6
 */
public class CleanupWhenExeceptionInConstructorDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String filePath = "files/exception.constructor/CleanupDemo.txt";
		try {
			InputFile in = new InputFile(filePath);
			try {
				String s;
				while ((s = in.getLine()) != null) {
					System.out.println(s);
				}
			} catch (Exception e) {
				System.out.println("caught exception in main");
				e.printStackTrace();
			} finally {
				in.dispose();
			}
		} catch (Exception e) {
			System.out.println("InputFile construction failed");
		}
	}
}

/**
 * 构造器中的异常处理演示
 * <p>
 * 如果异常发生了，所有的东西都能被正确清理么？尽管大多数情况下是非常安全的，但涉及到构造器时问题就出现了：
 * 构造器会把对象设置成安全的初始状态，但还会有别的动作，比如打开一个文件。
 * 这样的动作只有在对象使用完毕并且调用了特殊的清理方法之后才能得以清理，如果在构造器内抛出了异常，这些清理行为也许就不能正常工作。
 * 也许使用finally就可以解决问题，但并不只是这么简单，因为finally会每次都执行清理代码，
 * 如果构造器在其执行过程中半途而废，也许该对象的某些属性还没有被成功创建却要在finally中被清理。
 */
class InputFile {
	
	private BufferedReader in;

	public InputFile(String fileName) throws Exception {
		try {
			in = new BufferedReader(new FileReader(fileName));
			// other code that might throws exception
		} catch (FileNotFoundException e) {
			System.out.println("could not open " + fileName);
			// wasn't open,so don't close it
			throw e;
		} catch (Exception e) {
			// all other exception must close it
			try {
				in.close();
			} catch (IOException ex) {
				System.out.println("in.close unsuccessful");
			}
			throw e;
		} finally {
			// don't close it here
			// 由于finally会在每次构造器完成之后都执行一遍，所以它实在不应该是调用close()关闭文件的地方。
			// 因为希望文件在InputFile对象的整个生命周期内文件都处于打开状态。
		}
	}

	public String getLine() {
		String s;
		try {
			s = in.readLine();
		} catch (IOException e) {
			throw new RuntimeException("readline() failed");
		}
		return s;
	}

	public void dispose() {
		try {
			in.close();
			System.out.println("dispose() successful");
		} catch (IOException e) {
			throw new RuntimeException("in.close() failed");
		}
	}
}