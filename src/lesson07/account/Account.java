package lesson07.account;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

/**
 * Создать класс Account с внутренним классом, с помощью объектов которого можно
 * хранить информацию обо всех операциях со счетом (снятие, платежи,
 * поступления).
 * 
 * @author Дом
 */
public class Account {

	static int sid = 0;

	private String ownerName;
	private int id;
	private double amount;
	private List<Transact> transacts;/* = new LinkedList<>(); */

	public Account(String name) {
		if (name.length() < 0)
			throw new IllegalArgumentException("Account owner must have a name!");
		this.ownerName = name;
		id = ++sid;
		transacts = new LinkedList<>();
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double cash) {
		amount = cash;
	}

	public boolean deposit(double amount) {
		if (amount > 0)
			this.amount += amount;
		else {
			throw new IllegalArgumentException();
		}
		return true;
	}

	public String getName() {
		return ownerName;
	}

	public boolean addTrancfer(Account partner, boolean transfer, double amount) {
		Transact temp = new Transact(partner, transfer, amount);
		transacts.add(temp);
		if (temp.passed) {
			if (transfer) {
				this.amount -= amount;
				partner.setAmount(partner.getAmount() + amount);
			} else {
				this.amount += amount;
				partner.setAmount(partner.getAmount() - amount);
			}
		}
		return temp.passed;
	}

	@Override
	public String toString() {
		return String.format("id:%d; name:%s; amount:%.2f transacts:\n%s", id, ownerName, amount,
				transacts.toString());
	}

	class Transact {
		Account partner;
		boolean transfer;
		double amount;
		LocalDateTime date;
		boolean passed;

		Transact(Account partner, boolean transfer, double amount) {
			this.partner = partner;
			this.transfer = transfer;
			this.amount = amount;
			this.date = LocalDateTime.now();

			if (transfer) {
				passed = verify(Account.this, amount);
			} else {
				passed = verify(partner, amount);
			}
		}

		private boolean verify(Account sender, double amount) {
			if (sender.getAmount() > amount) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("Transfer ");
			if (transfer)
				sb.append("to ");
			else
				sb.append("from ");
			sb.append(partner.getName() + ". ");
			sb.append(amount + " денег ");
			if (!passed)
				sb.append("не ");
			sb.append("были переданы ");
			sb.append(date.toString() + "." + System.lineSeparator());

			return sb.toString();
		}
	}
}