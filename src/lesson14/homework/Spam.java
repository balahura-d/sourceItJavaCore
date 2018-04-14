package lesson14.homework;

import java.util.Scanner;

public class Spam {
	// public Spam (long[] milis, String[] messages) {
	// }
	public static void main(String[] args) {
		// try(Scanner scan = new Scanner(System.in) ){
		//
		// public void sendSpam(long[] millis, String[] messages) {
		// if (millis.length == messages.length)
		// for (int i = 0; i < millis.length; i++) {
		// Thread.sleep(millis[i]);
		// System.out.println(messages[i]);
		// }
		// }
		// }
		// public void sendSpam (long[] millis/*, String[] messages*/) {
		// if (millis.length == messages.length)
		// for (int i = 0; i < millis.length; i++) {
		// Thread.sleep(millis[i]);
		// System.out.println(messages[i]);
		// }
		// }

		try (Scanner scan = new Scanner(System.in)) {
			while (true)
				if (scan.hasNext()) {
					return;
				}

		}
	}

	public void spam(long[] millis, String[] messages) {
		if (millis.length == messages.length)
			for (int i = 0; i < millis.length; i++) {
				try {
					Thread.sleep(millis[i]);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(messages[i]);
			}
	}
}