package lesson06.homework.sweets;

import lesson06.homework.Sweets;

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

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Chokolate c = (Chokolate) obj;
		return weight == c.getWeight() && sugar == c.getSugar() && name.equals(c.getName());
	}
}
