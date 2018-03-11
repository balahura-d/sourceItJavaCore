//import java.io.IOException; 	// Пробовал делать ввод через System.in самостоятельно, eclipce подставил

import java.util.Scanner; //импорт класса сканнера
import imports.Numbers; // импорт класса для первой задачки
import imports.TriangleArea; // импорт класса для второй задачки
import imports.Circumference;	// импорт класса для третьей задачки

public class Homework2 {

	public static boolean b = true;		//из вызываемых методов меняем это поле, поэтому public static

	// основной метод, для обработки выбора пункта меню - задач
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in); // сканнер
		do {
			welcome();	//строки приветствия. одним методом, ниже, чтоб не мешали
			switch (scan.next()) { // смотрим ввод из консоли
			case "1": // первая задачка, ввод числа и вывод по цифрам
				b = false;
				Numbers.main(null); // вызов метода из отдельного файла
				break;
			case "2": // площадь треугольника
				b = false;
				TriangleArea.main(null);
				break;
			case "3": // длина окружности
				b = false;
				Circumference.main(null);
				break;
			case "0": // выход из меню
				System.out.println("Пока. :)");
				b = false;
				break;
			default: // напоминалка про корректный ввод номера пункта меню
				System.out.println("Повторите ввод корректно.");
			}
		} while (b); 	// если мы не попали в кейсы - повторяем ввод
				// также показываем меню, если выбрали этот вариант в вызываемых методах
		
		/*
		 * try {    - Пробовал сделать без Сканнера, не очень получилось. Строка в "default" выводилась три раза
		 * 	boolean b = true; 
		 * 	do { 
		 * 		welcome(); 
		 * 		char ch = (char)System.in.read();
		 * 		switch (ch) { 
		 * 			case '1': 
		 * 				System.out.println('1'); 
		 * 				b = false; 
		 * 				break; 
		 * 			case '2':
		 * 				System.out.println('2'); 
		 * 				b = false; 
		 * 				break; 
		 * 			case '3': System.out.println('3');
		 * 				b = false; 	
		 * 				break; 
		 * 			case '0': 
		 * 				System.out.println("Пока. :)"); 
		 * 				b = false; 
		 * 				break;
		 * 			default: //строка выводится три раза
		 * 				System.out.println("Повторите ввод корректно."); 
		 * 		} 
		 * 	} while (b);
		 * } catch (IOException e) { 
		 * 	// TODO Auto-generated catch block
		 * 	e.printStackTrace(); 
		 * }
		 */
	}

	// вывод приветствия и меню одним методом
	public static void welcome() {
		System.out.println("Приветствую!\nВыберите одну из трёх программ:");
		System.out.println("[1] - Разложение числа;");
		System.out.println("[2] - Подсчёт площади треугольника;");
		System.out.println("[3] - Подсчёт длины окружности;");
		System.out.println("[0] - Выход из меню.");
	}
}
