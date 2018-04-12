package lesson06;

import java.util.Arrays;

public class ClassLesson6 {
	public static void main(String[] args) {
	/*	int[] arr = { 1, 2, 3, 4, 5, 6 };
		int[] arr2 = Arrays.stream(arr).sorted().filter((int i) -> (i % 2) == 0).toArray();
		System.out.println(Arrays.toString(arr2));*/
		Vehicle c = new Car();
	}
}

class Vehicle {
	/*
	 * private double speed; private int passangersCapacity; public double
	 * getSpeed() { return speed; } public void setSpeed(double speed) {
	 * this.speed = speed; } public int getPassangersCapacity() { return
	 * passangersCapacity; } public void setPassangersCapacity(int
	 * passangersCapacity) { this.passangersCapacity = passangersCapacity; }
	 */
	static {
		System.out.println("stat par init");
	}
	{
		System.out.println("par init");
	}

	public Vehicle() {
		{
			System.out.println("par con");
		}
	}
}

class Car extends Vehicle {
	static {
		System.out.println("stat ch init");
	}
	{
		System.out.println("ch init");
	}
	private Object enjine;
	
	public Object getEnjine() {
		return enjine;
	}

	public void setEnjine(Object enjine) {
		this.enjine = enjine;
	}

	public Car() {
		{
			System.out.println("ch con");
		}
	}
}


