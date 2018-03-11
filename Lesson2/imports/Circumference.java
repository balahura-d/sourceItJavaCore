package imports;

import java.util.Scanner;
import Homework2;

public class Circumference {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); 
		while (true) {		//после предыдущих программ тут - всё просто
			System.out.println("Введите радиус Вашей окружности:");
			if (scan.hasNextDouble()) { 	//проверяем, корректно ли введено число
				double rad = scan.nextDouble(); //читаем из консоли
				if (rad > 0) {			//работаем только с положительным радиусом
					System.out.println("Длина Вашей окружности равна " 
							+ (2 * rad * Math.PI)); //самая обычная 2пиР

				} else if (rad == 0)		//окружность с нулевым радиусом - а почему бы и нет?
					System.out.println("Это точка.");
				else {				//но отрицательный радиус - это уже перебор
					System.out.println("Радиус окружности не может" + " быть отрицательным!"
							+ " Введите корректный радиус.");
				}
			}
			System.out.println("Повторить?\n1 - да, 2 - нет" + " (вернуться в главное меню)");
			if (!scan.next().equals("1")) {
				Homework2.b = true;
				return;
			}
		}
	}
}
