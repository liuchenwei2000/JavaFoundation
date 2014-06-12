/**
 * 
 */
package inner.nonstatic;

/**
 * �ڲ���(�Ǿ�̬Ƕ����)ʾ��
 * 
 * @author ����ΰ
 *
 * �������ڣ�2007-11-12
 */
public class BankAccount {
	
	private long number; // account number
	private long balance; // current balance (in cents)
	private Action lastAct; // last action performed

	public class Action {
		
		private String act;
		private long amount;

		private Action(String act, long amount) {
			// �����this��ָ�ڲ����Լ�
			this.act = act;
			this.amount = amount;
		}

		public String toString() {
			// �ڲ����ж��ⲿ������������BankAccount.this
			// �����Ҫ�����ⲿ��ĸ����ĳ������������
			// BankAccount.super.method()
			return number + ": " + act + " " + amount; // �൱��BankAccount.this.number
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

	public Action getLastAct() {
		return lastAct;
	}
}