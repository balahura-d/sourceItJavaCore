package lesson06.homework;

import java.util.ArrayList;
import java.util.Arrays;

public class Gift implements Sweets {
	
	private String name;
	private ArrayList<Sweets> giftSet = new ArrayList<>();
	private ArrayList<Integer> numOfSweets = new ArrayList<Integer>();

	public Gift(String name) {
		this.name = name;
	}

	public Gift(ArrayList<Sweets> sweets, String name) {
		giftSet = sweets;
		this.name = name;
	}
	
	public Gift(Sweets[] sweets, String name) {
		giftSet = (ArrayList<Sweets>) Arrays.asList(sweets);
		this.name = name;
	}	
	
	public void giftAdd (Sweets sweet) {
		giftSet.add(sweet);
	}

	@Override
	public double getWeight() {
		return giftSet.stream().mapToDouble(Sweets -> Sweets.getWeight()).sum();
	}

	@Override
	public double getSugar() {
		return giftSet.stream().mapToDouble(Sweets -> Sweets.getSugar()).sum();
	}

	@Override
	public String getName() {
		return name;
	}
	
	public String toString () {
		StringBuilder sb = new StringBuilder();
		sb.append("The gift \"" + name + "\" have:\n");
		for (Sweets s : giftSet)
		{
			sb.append(s.toString() + "\n");
		}
		sb.append("It weights " + this.getWeight() + " and contains " + this.getSugar() + " gramm of sugar.");
		return sb.toString();
	}
	
}
