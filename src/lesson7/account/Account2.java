package lesson7.account;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

import lesson7.account.Account.Transact;

public class Account2 {
	static int sid = 0;

	private String ownerName;
	private int id;
	private double amount;
	private List<Transact> transacts;/* = new LinkedList<>(); */

	public Account2(String name) {
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

//	public boolean addTrancfer(Account partner, boolean transfer, double amount) {
//		Transact temp = new Transact(partner, transfer, amount);
//		transacts.add(temp);
//		if (temp.passed) {
//			if (transfer) {
//				this.amount -= amount;
//				partner.setAmount(partner.getAmount() + amount);
//			} else {
//				this.amount += amount;
//				partner.setAmount(partner.getAmount() - amount);
//			}
//		}
//		return temp.passed;
//	}

	@Override
	public String toString() {
		return String.format("id:%d; name:%s; amount:%.2f transacts:\n%s", id, ownerName, amount,
				transacts.toString());
	}
	static class Transact {
		Account transmitter;
		Account recipient;
		double amount;
		LocalDateTime date;
		boolean passed;

		Transact(Account transmitter, Account recipient, double amount) {
			this.transmitter = transmitter;
			this.recipient = recipient;
			this.amount = amount;
			this.date = LocalDateTime.now();


				passed = verify(transmitter, amount);

		}

		private boolean verify(Account transmitter, double amount) {
			if (transmitter.getAmount() > amount) {
				return true;
			} else {
				return false;
			}
		}

		@Override
		public String toString() {
			StringBuilder sb = new StringBuilder("Transfer from ");
			sb.append(transmitter.getName()
					+ "to ");
			sb.append(recipient.getName()
					+ ". ");
			sb.append(amount + " денег ");
			if (!passed)
				sb.append("не ");
			sb.append("были переданы ");
			sb.append(date.toString() + "." + System.lineSeparator());

			return sb.toString();
		}
	}
}
