package Lesson6.homework.sweets;

import Lesson6.homework.Sweets;

public class Chokolate implements Sweets {

	private double weight;
	private double sugar;
	private String name;

	public Chokolate(String name, double weight, double sugar) {
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
		return String.format("\"%s\" weights %.3f g. with %.2f grams sugar in.", name, weight, sugar);
	}
}
