package lesson06.homework;

import java.util.ArrayList;

import lesson06.homework.sweets.Candies;
import lesson06.homework.sweets.Chokolate;
import lesson06.homework.sweets.Cookies;

public class CandyShop {
	public static class ProductRange {
		ArrayList<Sweets> sweets = new ArrayList<>();
		ArrayList<Integer> numberOfSweets = new ArrayList<>();

		void add(Sweets sweet) {
			if (sweets.contains(sweet)) {
				numberOfSweets.set(sweets.indexOf(sweet),
						numberOfSweets.get(sweets.indexOf(sweet)) + 1);
			} else {
				sweets.add(sweet);
				numberOfSweets.add(1);
			}
		}

		void remove(Sweets sweet) {
			if (sweets.contains(sweet)) {
				if (numberOfSweets.get(sweets.indexOf(sweet)) == 1) {
					sweets.remove(sweets.indexOf(sweet));
					numberOfSweets.remove(sweets.indexOf(sweet));
				} else {
					numberOfSweets.set(sweets.indexOf(sweet),
							numberOfSweets.get(sweets.indexOf(sweet)) - 1);
				}
			}
		}

		public String toString() {
			StringBuilder sb = new StringBuilder();
			sb.append("The ProductRange in this shop have:\n");
			for (int i = 0; i < sweets.size(); i++) {
				sb.append(sweets.get(i).toString() + " X" + numberOfSweets.get(i) + "\n");
			}
			return sb.toString();
		}
	}

	public Gift assembleGiftByWeight(String name, double weightTotal) {
		return null;
	}

	public Gift assembleGiftBySugar(String name, double sugarTotal) {
		return null;
	}

	public Gift assembleGift(String name, ArrayList<Sweets> sweetsSet) {
		return new Gift(sweetsSet, name);
	}

	public static void doSmth() {
		ProductRange productRange = new ProductRange();

		Candies candy1 = new Candies("шоколадная конфета", 30, 6);
		Candies candy2 = new Candies("мармеладная конфета", 27, 10);
		Sweets /* работает :) */ candy3 = new Candies("конфета \"птичье молоко\" ", 25, 5);
		Sweets candy4 = new Candies("очень сладкая конфета", 28, 30); // *упс*

		productRange.add(candy1);
		productRange.add(candy1);
		productRange.add(candy1);
		productRange.add(candy2);
		productRange.add(candy2);
		productRange.add(candy2);
		productRange.add(candy3);
		productRange.add(candy3);
		productRange.add(candy4);
		productRange.add(new Candies("шоколадная конфета", 30, 6));

		Chokolate choko1 = new Chokolate("пористая шоколадка", 70, 20);
		Chokolate choko2 = new Chokolate("молочная шоколадка", 60, 20);

		productRange.add(choko1);
		productRange.add(new Chokolate("молочная шоколадка", 60, 20));
		productRange.add(choko2);
		productRange.add(new Chokolate("чёрная шоколадка", 70, 14));

		Sweets cookie1 = new Cookies("сахарная палочка", 50, 25);
		Sweets cookie2 = new Cookies("овсяное печенье", 80, 25);
		Sweets cookie3 = new Cookies(
				"невкусное диетическое печенье без грамма сараха как-они-вообще-такое-едят", 50, 0);

		productRange.add(cookie1);
		productRange.add(cookie2);
		productRange.add(cookie3);

		// Gift fullRangeGift = assembleGift("Полный фарш", productRange);

		System.out.println(productRange);
		
		

	}
}
