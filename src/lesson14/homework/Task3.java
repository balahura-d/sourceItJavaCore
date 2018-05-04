package lesson14.homework;

import java.util.concurrent.*;
import java.util.stream.IntStream;

public class Task3 {
	static int counter1 = 0;
	static int counter2 = 0;

	private static final int NUM_INCREMENTS = 10;

	public static void main(String[] args) {
		try {
			notSynchRun();
			System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
			synchRun();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static void notSynchRun() throws InterruptedException {
		counter1 = 0;
		counter2 = 0;

		ExecutorService executor = Executors.newFixedThreadPool(5);

		IntStream.range(0, NUM_INCREMENTS).forEach(i -> executor.submit(Task3::count));

		executor.awaitTermination(3, TimeUnit.SECONDS);

		System.out.println("NonSync. Counter1: " + counter1 + " Counter2: " + counter2);
	}

	private static void synchRun() throws InterruptedException {
		counter1 = 0;
		counter2 = 0;

		ExecutorService executor = Executors.newFixedThreadPool(5);

		IntStream.range(0, NUM_INCREMENTS).forEach(i -> executor.submit(Task3::synchCount));

		executor.awaitTermination(3, TimeUnit.SECONDS);

		System.out.println("   Sync. Counter1: " + counter1 + " Counter2: " + counter2);
	}

	private static void count() {
		try {
			System.out.println(((counter1 == counter2) ? " счётчики равны " : " счётчики не равны ") + "Counter1: " + counter1 + " Counter2: " + counter2);
			counter1++;
			TimeUnit.MILLISECONDS.sleep(10);
			counter2++;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private static synchronized void synchCount() {
		try {
			System.out.println(((counter1 == counter2) ? " счётчики равны " : " счётчики не равны ") + "Counter1: " + counter1 + " Counter2: " + counter2);
			counter1++;
			TimeUnit.MILLISECONDS.sleep(10);
			counter2++;
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
