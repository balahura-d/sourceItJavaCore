package lesson14.homework;

import java.io.IOException;

public class Spam {

	long[] millis;
	String[] messages;

	public Spam(long[] millis1, String[] messages1) {
		this.millis = millis1;
		this.messages = messages1;
	}

	public void spam() {
		try {
			potokCherezOtrezkiVremenyPechataetCoobshchenija.start();
			while (true) {
				if (System.in.available() > 0 && System.in.read() == '\n') {
					System.setIn(System.in);
					potokCherezOtrezkiVremenyPechataetCoobshchenija.interrupt();
				}
			}
		} catch (IOException e) {
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
	Thread potokCherezOtrezkiVremenyPechataetCoobshchenija = new Thread(runnable);

}
