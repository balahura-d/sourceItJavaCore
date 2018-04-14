package lesson14.homework;

import java.util.Scanner;

public class Spam {

//	static long[] millis = {     700,  1000,   700,  1500,       400,2700,         3500};
//	static String[] messages = { "re", "блин", "ку", "как дела", "?","чёмолчите?", "я тут вот шо придумал" };
	
	long[] millis;
	String[] messages;
	
//	public static void main(String[] args) {
//		spam();
//	}

	public Spam(long[] millis1, String[] messages1) {
		this.millis = millis1;
		this.messages = messages1;
	}
	
	public void spam() {
		thread.start();
		try (Scanner scan = new Scanner(System.in)) {
		//	while (true) {
				System.out.println("1");
				if (scan.hasNext() /*&& scan.next() == "1"System.lineSeparator()*/) {
					System.out.println("<<<Read ENTER");
					thread.interrupt();
				}
		//	}
		}
	}
	
	Runnable runnable = new Runnable() {
		@Override
		public void run() {
			if (millis.length == messages.length)
				for (int i = 0; i < millis.length; i++) {
					try {
						Thread.sleep(millis[i]);
						System.out.println(messages[i]);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
		}
	};
	Thread thread = new Thread(runnable);
}