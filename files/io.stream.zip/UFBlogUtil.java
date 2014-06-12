import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;



/**
 * 
 *
 * @author 刘晨伟
 *
 * 创建日期：2008-11-3
 */
public class UFBlogUtil {
	
	public static void main(String[] args) {
		File file = new File("C://1.txt");
		File file2 = new File("C://2.txt");
		try {
			BufferedReader reader = new BufferedReader(new FileReader(file));
			StringBuilder sb = new StringBuilder();
			String s = null;
			while((s=reader.readLine()) != null){
				part(s,sb);
			}
			reader.close();
			BufferedWriter writer = new BufferedWriter(new FileWriter(file2));
			writer.write(sb.toString());
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void part(String original,StringBuilder sb){
		if(original.trim().length() != 0) {
			sb.append(original);
		} 
			sb.append("<br><br>");
	}
}