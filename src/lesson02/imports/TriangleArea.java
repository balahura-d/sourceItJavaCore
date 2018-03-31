package lesson02.imports;

import java.util.Scanner;

import lesson02.Homework2;

public class TriangleArea {
	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in); // создаём один сканнер
		double sides[] = new double[3]; // массив для сторон треугольника

		while (true) { // "обёртка" для бесконечного выполнения, если того пожелает Пользователь
			int i = 0; //почему-то показалось, что создать одну итерационную переменную будет удобнее

			// ввод длин сторон и проверка на отрицательные стороны
			System.out.println("Введите длины сторон треугольника:");
			do {	//doбиваем Пользователя, пока он не введёт три положительные стороны
				if (scan.hasNextDouble()) {	//из консоли получаем число
					double side = scan.nextDouble();
					if (side > 0) {		//положительные - запоминаем
						sides[i] = side;
						i++;
					} else {
						System.out.println("Сторона треугольника не может"
								+ " быть отрицательной или нулём!"
								+ " Введите ещё сторону.");
					}
				}
			} while (i < 3);

			// проверка на корректные значения сторон
			// (длина двух сторон должна быть больше третьей)
			// и расчёт площади, если верно
			double maxLength = Double.MIN_VALUE;
			double p = 0; // периметр для формулы площади
			int n = 0; // номер наибольшей стороны
			boolean correct = true; // флак корректности треугольника
			for (i = 0; i < 3; i++) {
				p += sides[i]; // посчитаем и периметр, на всякий случай
				if (sides[i] > maxLength) { // проверяем длину стороны
					maxLength = sides[i]; // и запоминаем длину
					n = i; // и номер самой длиной
				}
			}
			switch (n) {	//самую длинную сторону сравниваем с суммой других
			case 0:
				if ((sides[1] + sides[2]) < sides[0]) {
					System.out.println("Стороны треугольника не корректны!");
					correct = false;
					break;
				}
			case 1:
				if ((sides[0] + sides[2]) < sides[1]) {
					System.out.println("Стороны треугольника не корректны!");
					correct = false;
					break;
				}
			case 2:
				if ((sides[1] + sides[0]) < sides[2]) {
					System.out.println("Стороны треугольника не корректны!");
					correct = false;
					break;
				}
			}
			if (correct) { // если всё правильно, НАКОНЕЦ-ТО считаем площадь
				p /= 2; // ниже - формула Герона
				double s = Math.sqrt(p * (p - sides[0]) * (p - sides[1]) * (p - sides[2]));
				System.out.println("Площадь Вашего треугольника равна " + s);
			}

			System.out.println("Повторить?\n1 - да, 2 - нет" + " (вернуться в главное меню)");
			if (!scan.next().equals("1")) {
				Homework2.b = true;
				return;
			}
		}
	}
}
