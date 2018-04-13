package lesson14.homework;

public class Task1 {

	public static void main(String[] args) {

		Runnable runnable = new Runnable() {
			@Override
			public void run() {
				try {
					Thread internal = new InternalThread();
					internal.start();
					Thread.sleep(5000);
					internal.interrupt();
					System.out.println("That's all :)");
				} catch (InterruptedException i_ex) {

				}
			}
		};

		Thread external = new Thread(runnable);
		external.start();

	}
}

class InternalThread extends Thread {
	@Override
	public void run() {
		try {
			while (true) {
				Thread.sleep(500);
				System.out.println(Thread.currentThread().getName());
			}
		} catch (InterruptedException i_ex) {

		}
	}

}