/**
 * 
 */
package syntax;

/**
 * if-else语句辨析
 * 
 * @author 刘晨伟
 * 
 * 创建日期：2007-9-10
 */
public class IfElseDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int score = 76;
		char grade = ' ';
		// if-else语句(当if后的语句为true时则执行完该if语句块后直接跳出if-else块)
		if (score >= 90) {
			grade = 'A';
		} else if (score >= 80) {
			grade = 'B';
		} else if (score >= 70) {
			grade = 'C';
		} else if (score >= 60) {
			grade = 'D';
		} else {
			grade = 'E';
		}
		System.out.println("Grade " + grade);

		// 纯if语句(顺序执行下去)
		if (score >= 90) {
			grade = 'A';
		}
		if (score >= 80) {
			grade = 'B';
		}
		if (score >= 70) {
			grade = 'C';
		}
		if (score >= 60) {
			grade = 'D';
		}
		if (score < 60) {
			grade = 'E';
		}
		System.out.println("Grade " + grade);
	}
}
