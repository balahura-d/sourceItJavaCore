package lesson6.homework;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CandyShop.doSmth();
		String[] str0 = { "1. Ассортимент.", "2. Сладкие подарки.", "0. Выход" };
		switch (showMenu(str0)) {
		case 1: { // "1. Ассортимент."
			String[] str01 = { "1. Просмотреть...", "2. Добавить", "3. Убрать" };
			switch (showMenu(str01)) {
			case 1: {// "1. Просмотреть..."
				String[] str011 = { "1. Весь асортимент", "2. Конфеты", "3. Печеньки", "4. Шоколадки" };
				switch (showMenu(str011)) {
				case 1: {// весь
					break;
				}
				case 2: {// конфеты
					break;
				}
				case 3: {// печенье
					break;
				}
				case 4: {// шоколадки
					break;
				}
				default:
					break;
				}
			}
			default:
				break;
			}
			break;
		}
		case 2: {// "2. Сладкие подарки."
			String[] str02 = { "1. Собрать", "2. Посмотреть сохранённые подарки" };
			switch (showMenu(str02)) {
			case 1: {// собрать
				break;
			}
			case 2: {// просмотреть сохранённые
				break;
			}
			default: // Выход
				break;
			}
		}
		default: // Выход
			break;
		}

	}

	static int showMenu(String[] str) {
		for (int i = 0; i < str.length; i++)
			System.out.println(str[i]);
		try (Scanner scan = new Scanner(System.in);) {
			if (scan.hasNextInt())
				return scan.nextInt();
			return 0;
		}
	}

}
