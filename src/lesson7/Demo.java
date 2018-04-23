package lesson7;

import lesson7.account.Account;
import lesson7.recordBook.RecordBook;
import lesson7.recordBook.RecordBook.Grade;

public class Demo {

	public static void main(String[] args) {

		//## RecordBook ##
//		RecordBook rbBDV = new RecordBook ("Balahura Denis Vas.", 2010, 9, 1);
//		rbBDV.add(Grade.EXAM,"SysProg",5,"Volk");
//		rbBDV.add(Grade.CREDIT, "History", 7, "Balaban");
		
//		System.out.println(rbBDV);
		
		//## Account ## //по хорошему нужно внутренний класс сделать вложенным, чтоб транзакции
		Account acc = new Account ("BDV");
		Account acc2 = new Account ("offshore");
		acc.deposit(5000);
		acc.addTrancfer(acc2, true, 2000);
		acc.addTrancfer(acc2, false, 1500);
		System.out.println(acc);
	}
}
