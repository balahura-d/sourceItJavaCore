package lesson2.imports;

import java.util.Scanner;

import lesson2.Homework2;

public class Numbers {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // сканнер
		while (true) {
			System.out.println("Введите Ваше число:");

			if (scan.hasNextInt()) {		//"обманка", смотрим, ввёл ли пользователь число
				String str = scan.next();	//и дальше работаем со строкой
				for (int i = 0; i < str.length(); i++) {	//просто выводим строку по одному символу
					System.out.println(str.charAt(i));
				}
			} else { // говорим, почему мы не выводили число
				System.out.println("Вы ввели не число.");
			}
			
			//эта часть повторется в каждом методе. Пытался сделать один метод в программе с меню,
			//однако return ТАМ выходил из ТОГО метода обратно сюда
			System.out.println("Повторить?\n1 - да, 2 - нет (вернуться в главное меню)");
			if (!scan.next().equals("1")) { //возможно, стоило отработать больше вариантов. если Пользователь вводит "1",
				Homework2.b = true;	//процесс повторяется, если нет (не только с двойкой) возвращаем его в меню
				return;
			}
		}
	}
}