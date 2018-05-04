package lesson14.homework;

import java.io.IOException;

public class Spam extends Thread {

	long[] millis;
	String[] messages;

	public Spam(long[] millis, String[] messages) {
		if (millis.length != messages.length)// можно я уже спёр тут прерывание?
			throw new IllegalArgumentException("Error! Arrays of latency and messages aren't equal!!!");
		this.millis = millis;
		this.messages = messages;
		start();
	}

	@Override
	public void run() {
		for (int i = 0; i < millis.length; i++) {
			try {
				if (System.in.available() > 0 && System.in.read() == '\n') {
					System.out.println("<<< Read ENTER");
					System.setIn(System.in);
					this.interrupt();
				}
				Thread.sleep(millis[i]);
				System.out.println(messages[i]);
			} catch (IOException | InterruptedException e) {
			}
		}
		// while (true) {
		// if (System.in.available() > 0 && System.in.read() == '\n') {
		// System.setIn(System.in);
		// potokCherezOtrezkiVremenyPechataetCoobshchenija.interrupt();
		// }
		// }
	}

	// Runnable runnable = new Runnable() {
	// @Override
	// public void run() {
	// if (millis.length == messages.length)
	// for (int i = 0; i < millis.length; i++) {
	// try {
	// Thread.sleep(millis[i]);
	// System.out.println(messages[i]);
	// } catch (InterruptedException e) {
	// e.printStackTrace();
	// }
	// }
	// }
	// };
	// Thread potokCherezOtrezkiVremenyPechataetCoobshchenija = new
	// Thread(runnable);
}
