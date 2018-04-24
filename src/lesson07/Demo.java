package lesson07;

import lesson07.account.Account;
import lesson07.account.Account2;
import lesson07.account.Account2.Transact;
import lesson07.payment.Payment;
import lesson07.recordBook.RecordBook;
import lesson07.recordBook.RecordBook.Grade;

public class Demo {

	public static void main(String[] args) {

//		//## RecordBook ##
//		RecordBook rbBDV = new RecordBook ("Balahura Denis Vas.", 2014, 9, 1);
//		rbBDV.add(Grade.EXAM,"SysProg",5,"Volk");
//		rbBDV.add(Grade.CREDIT, "History", 4, "Balaban");
//		System.out.println(rbBDV);
//	Output:	Record book of Balahura Denis Vas. of 4 course.
//	[EXAM] SysProg : 5 : Volk : 2018-04-24
//	[CREDIT] History : 4 : Balaban : 2018-04-24
		
//		//## Account ## //по хорошему нужно внутренний класс сделать вложенным, чтоб транзакции
//		Account acc = new Account ("BDV");
//		Account acc2 = new Account ("offshore");
//		acc.deposit(5000);
//		acc.addTrancfer(acc2, true, 2000);
//		acc.addTrancfer(acc2, false, 1500);
//		System.out.println(acc);
//	Output:	id:1; name:BDV; amount:4500,00 transacts:
//	[Transfer to offshore. 2000.0 денег были переданы 2018-04-24T09:28:57.105.
//	, Transfer from offshore. 1500.0 денег были переданы 2018-04-24T09:28:57.246.
//	]
				
//		//## Account2 ## 
//		Account2 accBDV = new Account2 ("BDV");
//		Account2 accOffshore = new Account2 ("Offshore");
//		accOffshore.deposit(50000);
//		Transact.addTransact(accOffshore, accBDV, 20000);
//		Transact.addTransact(accBDV, accOffshore, 5000);
//		Transact.addTransact(accBDV, accOffshore, 50000);
//		System.out.println(accBDV);
//		System.out.println(accOffshore);
//	Output:id:1; name:BDV; amount:15000,00 transacts:
//	[Transact [from Offshore to BDV, transfer 20000.0 deneg, 2018-04-24T09:45:31.310, passed]
//	 Transact [from BDV to Offshore, transfer 5000.0 deneg, 2018-04-24T09:45:31.435, passed]
//	, Transact [from BDV to Offshore, transfer 50000.0 deneg, 2018-04-24T09:45:31.435, not passed]
//	]
//	id:2; name:Offshore; amount:35000,00 transacts:
//	[Transact [from Offshore to BDV, transfer 20000.0 deneg, 2018-04-24T09:45:31.310, passed]
//	, Transact [from BDV to Offshore, transfer 5000.0 deneg, 2018-04-24T09:45:31.435, passed]
//	, Transact [from BDV to Offshore, transfer 50000.0 deneg, 2018-04-24T09:45:31.435, not passed]
//	]	
	
		//##Payment##
		Payment payment = new Payment();
		payment.addProduct(12, "Метла", 2000);
		payment.addProduct(14, "Мантия", 500);
		payment.addProduct(13, "Котелок", 700);
		payment.addProduct(14, "Мантия", 500);
		payment.addProduct(12, "Метла", 2000);
		payment.addProduct(17, "Учебник зельеварения", 300);
		payment.addProduct(16, "Учебник по защите от Тёмных исскуств", 350);
		payment.removeProduct(12);
		payment.submit();
//	Output:<Volshebnaja Shkatulka> Shop2018-04-24 11:54:12
//	[14]	[Мантия]		[2]	[ 1000,00]
//	[13]	[Котелок]		[1]	[  700,00]
//	[12]	[Метла]			[1]	[ 2000,00]
//	[17]	[Учебник зельеварения]	[1]	[  300,00]
//	[16]	[Учебник по защите от Т][1]	[  350,00]
//	>>>TOTAL:4350.0
	}
}
