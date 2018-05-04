package lesson14.homework;

import java.io.ByteArrayInputStream;

public class Task2 {
	public static void main(String[] args) {			   //!
		//		     //700   //1700  //2400  //3900  //4300  //6000  //8500
		long[] millis = {     700,    1000,   700,    1500,   400,    1700,   2500 };
		String[] messages = { "msg1", "msg2", "msg3", "msg4", "msg5", "msg6", "msg7" };

		final Spam spam = new Spam(millis, messages);

		Thread potokKotoryjZapuskaetSpam = new Thread() {
			@Override
			public void run() {
				spam.spam();
			}
		};
		try {
			potokKotoryjZapuskaetSpam.start();
			Thread.sleep(5000); //остановка основного потока
			System.out.println(">>>Press ENTER");//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~``
			System.setIn(new ByteArrayInputStream(new byte[]{'\n'}));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}