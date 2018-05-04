package lesson07.account;

import java.time.LocalDateTime;
import java.util.LinkedList;
import java.util.List;

public class Account2 {
	static int sid = 0;

	private String ownerName;
	private int id;
	private double amount;
	private List<Transacts> transacts;/* = new LinkedList<>(); */

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

	public boolean sendTransfer(Account2 recipient, double amount, LocalDateTime date,
			boolean passed) {
		transacts.add(new Transacts(this, recipient, amount, date, passed));
		if (passed) 
		{
			this.amount -= amount;
		}
		return true;
	}
	public boolean receiveTransfer(Account2 transmitter, double amount, LocalDateTime date,
			boolean passed) {
		transacts.add(new Transacts(transmitter, this, amount, date, passed));
		if (passed) {
			this.amount += amount;
		}
		return true;
	}

	@Override
	public String toString() {
		return String.format("id:%d; name:%s; amount:%.2f transacts:\n%s", id, ownerName, amount,
				transacts.toString());
	}
	
	private class Transacts {
		Account2 transmitter;
		Account2 recipient;
		double amount;
		LocalDateTime date;
		boolean passed;

		public Transacts(Account2 transmitter, Account2 recipient, double amount, LocalDateTime date,
				boolean passed) {
			this.transmitter = transmitter;
			this.recipient = recipient;
			this.amount = amount;
			this.date = date;
			this.passed = passed;
		}
		@Override
		public String toString() {
			return ("Transact [from " + transmitter.getName() + " to " + recipient.getName() + ", transfer "
					+ amount + " deneg, " + date + ", " + ((passed)?("passed"):("not passed")) + "]\n");
		}
	}
	
	public static class Transact {

		public static boolean addTransact(Account2 transmitter, Account2 recipient, double amount) {
			LocalDateTime date = LocalDateTime.now();
			boolean passed = verify(transmitter, amount);
			
			transmitter.sendTransfer(recipient, amount, date, passed);
			recipient.receiveTransfer(transmitter, amount, date, passed);
			
			return passed;
		}

		private static boolean verify(Account2 transmitter, double amount) {
			if (transmitter.getAmount() > amount) {
				return true;
			} else {
				return false;
			}
		}
	}
}
