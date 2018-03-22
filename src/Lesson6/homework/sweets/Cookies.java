package Lesson6.homework.sweets;

import Lesson6.homework.Sweets;

public class Cookies implements Sweets {

	private double weight;
	private double sugar;
	private String name;

	public Cookies(String name, double weight, double sugar) {
		this.name = name;
		this.weight = weight;
		this.sugar = sugar;
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return weight;
	}

	@Override
	public double getSugar() {
		// TODO Auto-generated method stub
		return sugar;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
	}

	@Override
	public String toString() {
		if (sugar != 0) {
			return String.format("\"%s\" weights %.3f with %f grams sugar in.", name, weight, sugar);
		} else {
			return String.format("\"%s\" weights %.3f with no sugar.",name, weight);

		}
	}
}
