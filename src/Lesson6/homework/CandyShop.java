package Lesson6.homework;

import java.util.ArrayList;
import java.util.Arrays;

import Lesson6.homework.sweets.Candies;
import Lesson6.homework.sweets.Chokolate;
import Lesson6.homework.sweets.Cookies;

public class CandyShop {
	public static ArrayList<Sweets> productRange = new ArrayList<>(); //тут нужно использовать какой-нибудь Set, который будет следить за уникальностью ассортимента
	
	
	public static Gift assembleGiftByWeight(String name, double weightTotal) {
		return null;
	}
	
	public static Gift assembleGiftBySugar(String name, double sugarTotal) {
		return null;
	}
	
	public static Gift assembleGift (String name, ArrayList<Sweets> sweetsSet) {
		return new Gift (sweetsSet, name);
	}
	
	public static void main(String[] args) {
		Candies candy1 = new Candies ("шоколадная конфета", 30, 6);
		Candies candy2 = new Candies ("мармеладная конфета", 27, 10);
		Sweets /*работает :)*/ candy3 = new Candies ("конфета \"птичье молоко\" ", 25, 5);
		Sweets candy4 = new Candies ("очень сладкая конфета", 28, 30); // *упс*
		
		System.out.println(candy1);
		System.out.println(candy2);
		System.out.println(candy3);
		System.out.println(candy4);
		
		productRange.add(candy1);
		productRange.add(candy2);
		productRange.add(candy3);
		productRange.add(candy4);
				
		Chokolate choko1 = new Chokolate("пористая шоколадка", 70, 20);
		Chokolate choko2 = new Chokolate("молочная шоколадка", 60, 20);
		Chokolate choko3 = new Chokolate("чёрная шоколадка", 70, 14);
		
		productRange.add(choko1);
		productRange.add(choko2);
		productRange.add(choko3);
		
		Sweets cookie1 = new Cookies ("сахарная палочка", 50, 25);
		Sweets cookie2 = new Cookies ("овсяное печенье", 80, 25);
		Sweets cookie3 = new Cookies ("невкусное диетическое печенье без грамма сараха как-они-вообще-такое-едят", 50, 0);
		
		productRange.add(cookie1);			
		productRange.add(cookie2);			
		productRange.add(cookie3);			
		
		System.out.println(Arrays.toString(productRange.toArray()) );
		
		Gift fullRangeGift = assembleGift("Полный фарш", productRange);
		
		
		
		System.out.println(fullRangeGift);
		
	}
}
