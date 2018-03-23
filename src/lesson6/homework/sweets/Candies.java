package lesson6.homework.sweets;

import lesson6.homework.Sweets;

public class Candies implements Sweets {

	private double weight;
	private double sugar;
	private String name;

	public Candies(String name, double weight, double sugar) {
		try {
			this.name = name;
			this.weight = weight;
			if (sugar < weight)
				this.sugar = sugar;
			else
				throw new IllegalArgumentException(); // как можно в этом случае не создавать конфету?
		} catch (IllegalArgumentException e) {
			System.out.println("Can't create this candy!");
			return;
		}

	}

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public double getSugar() {
		return sugar;
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return String.format("\"%s\" weights %.3f gramms with %.0f%% sugar in.", name, weight,
				(sugar / weight * 100));
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj == null || obj.getClass() != this.getClass()) {
			return false;
		}
		Candies c = (Candies) obj;
		return weight == c.getWeight() && sugar == c.getSugar() && name.equals(c.getName());
	}
}
