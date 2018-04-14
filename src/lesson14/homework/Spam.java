package lesson14.homework;

import java.util.Scanner;

public class Spam {

	long[] millis;
	String[] messages;

	public Spam(long[] millis1, String[] messages1) {
		this.millis = millis1;
		this.messages = messages1;
	}

	public void spam() {
		try /*(Scanner scan = new Scanner(System.in))*/ {
			int i = 1;	//~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
			thread.start();
			while (true) {
				System.out.println(i++); //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				Thread.sleep(100); //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
				if (true/*scan.hasNext()*/) {
					System.out.println("<<<Read ENTER"); //~~~~~~~~~~~~~~~~~~~~~~~~~~
					Thread.sleep(4000); //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
					thread.interrupt(); //39
				}
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
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
