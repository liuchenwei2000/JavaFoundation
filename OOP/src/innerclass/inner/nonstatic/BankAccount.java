/**
 * 
 */
package inner.nonstatic;

/**
 * 内部类(非静态嵌套类)示例
 * 
 * @author 刘晨伟
 *
 * 创建日期：2007-11-12
 */
public class BankAccount {
	
	private long number; // account number
	private long balance; // current balance (in cents)
	private Action lastAct; // last action performed

	public class Action {
		
		private String act;
		private long amount;

		private Action(String act, long amount) {
			// 这里的this是指内部类Action自己
			this.act = act;
			this.amount = amount;
		}

		public String toString() {
			// 内部类中对外部类对象的引用是BankAccount.this
			// 如果需要调用外部类的父类的某个方法可以用 BankAccount.super.method()
			return number + ": " + act + " " + amount; // 相当于BankAccount.this.number
		}
	}

	public void deposit(long amount) {
		balance += amount;
		lastAct = new Action("deposit", amount);
	}

	public void withdraw(long amount) {
		balance -= amount;
		lastAct = new Action("withdraw", amount);
	}

	public void transfer(BankAccount other, long amount) {
		other.withdraw(amount);
		deposit(amount);
		lastAct = this.new Action("transfer", amount);
		other.lastAct = other.new Action("transfer", amount);
	}
	
	public long getBalance() {
		return balance;
	}

	public Action getLastAct() {
		return lastAct;
	}
}
