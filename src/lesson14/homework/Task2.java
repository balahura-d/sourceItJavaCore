package lesson14.homework;

import java.io.ByteArrayInputStream;

public class Task2 {

	public static void main(String[] args) {

		long[] millis = { 700, 1000, 700, 1500, 400, 1700, 2500 };
		String[] messages = { "re", "блин", "ку", "как дела", "?", "чёмолчите?", "я тут вот шо придумал" };

		final Spam spam = new Spam(millis, messages);

		Thread thread = new Thread() {
			@Override
			public void run() {
				spam.spam();
			}
		};
		try {
			thread.start();
			Thread.sleep(5000);
			System.out.println(">>>Press ENTER");//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~``
			System.setIn(new ByteArrayInputStream("\n".getBytes()));
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
