package lesson03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Homework3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		System.out.println("\nTask 1. Ladder with 5 steps and 3 steps.");
		showLadder(5);
		showLadder(3);
		
		System.out.println("\nTask 2. Prime Number from 1 to 100:");
		showPrimeNumbers();
		
		System.out.println("\nTask 3. Wallpapers. All parametrs: number of stripes"
				+ ", width of stripes and height, are castomizable.");
		drawWall(6, 3, 4);
		System.out.println();
		drawWall(9, 4, 5);
		
		System.out.println("\nTask 4. Two random arrays:");
		showTwoArrays();
		System.out.println("\nOverloaded method showing two random arrays:");
		showTwoArrays(7);
		
		System.out.println("\nTask 5. Rotating matrix.");
		System.out.print("\nPlease, enter dimention:");
		Scanner sc = new Scanner(System.in);		//рискнём сделать матрицу неизвестного размера. Но квадратную.
		Integer dimention = null;			//заглушка, без null-а не компилируется цикл ниже
		if (sc.hasNextInt())			//научились в предыдущем ДЗ, берём только нормальные целые числа
			dimention = sc.nextInt();	//(но не защищаемся от NullPointerException, только тсс
		ArrayList<ArrayList<Integer>> matrix1 = new ArrayList<>(); //делаем массив массивов
		for (int i = 0; i < dimention; i++) {			  //вот такого размера каждый
			matrix1.add(new ArrayList<Integer>());		 //добавляем в массив массивов массивы чисел
			for (int j = 0; j < dimention; j++) {		//и заполняем их
				matrix1.get(i).add((int)(Math.random()*100));//какими-нибудь числами от 0 до 100
			}
		}
		System.out.println("\nBase matrix:");
		showMatrix(matrix1);
		
		System.out.println("\nTurn 90 degrees:");
		doSmth(matrix1);
		showMatrix(matrix1);
		
		System.out.println("\nTurn 180 degrees:");
		doSmth(matrix1);
		showMatrix(matrix1);
		
		System.out.println("\nTurn 270 degrees:");
		doSmth(matrix1);
		showMatrix(matrix1);
		
		System.out.println("\nDo a barrel roll:");
		doABarrelRoll(matrix1); //делаем бочку. Оно того стоило, я думаю.
		showMatrix(matrix1);
	}
	
	//Task 1.
	private static void showLadder(int stepsNum) {
		// TODO Auto-generated method stub
		for (int i = 1;  i <= stepsNum; i++) {		//тут считаем номер строки - он же количество "ступенек" от одной до указаной высоты
			for (int j = 1; j <= i; j++) { 		//и рисуем ступеньки, от первой до номера строки
				System.out.print("* "); 	//вложеный цыкл пишет в одну строку
			}
			System.out.println(); 			//переводим строку после заполнения
		}
		for (; stepsNum > 0; stepsNum--) {		//то же, но наоборот; первый цикл нам задаёт количество звёзд-ступенек
			for (int j = 1; j <= (stepsNum - 1); j++) { //второй цикл их по одной отрисовывает
				System.out.print("* ");
			}
			System.out.println();
		}
		
	}
	
	//Task 2
	private static void showPrimeNumbers() {
		// TODO Auto-generated method stub
		for (int num = 2; num < 100; num ++) { 		//единица не считается простым числом, согласно Вики
			boolean isPrime = true; 		//устанавливаем флаг "простоты"
			for (int j = 2; j < num; j++) 		//перебираем делители для проверки от двух до выбраного числа, не включая его
				if (num%j == 0) { 		//проверяем, делится ли число без остатка
					isPrime = false; 	//и "бракуем"
					break; 			//если есть одно "попадание" - дальше можно не считать
				}
			if (isPrime) 				//если не было деления без остатка - 
				System.out.print(num + ", "); 	//дописываем число
		}
	}
	
	//Task 3
	private static void drawWall(int number, int width, int height) {
		// TODO Auto-generated method stub
		StringBuilder sbWall = new StringBuilder(); 	//будем клеить одновременно все полосы обоев
		for (int n = 0; n < number; n++) {		//намазываем клей поочерёдно на каждую полосу
			for (int w = 0; w < width; w++) {	//прикидываем ширину обоины
				if (n%2 == 0)			//и начинаем клеить обоины с разным рисунком по очереди
					sbWall.append('+');
				else
					sbWall.append('*');
			}
		}
		for (int h = 0; h < height; h++) {		//естественно, клеим на всю высоту стен
			System.out.println(sbWall);		//(да, в этой части задания не было необходимости :) )
		}
	}
	
	//Task 4
	private static void showTwoArrays() {
		// TODO Auto-generated method stub
		int[] arr1 = new int[10],			//Создаём массив случайных элементов размер 10. 
		      arr2 = new int[arr1.length * 2];		//Создать второй массив размером 20
		for (int i = 0; i < arr1.length; i++) {		//избавил задачку от зависимости от жесткой длинны массива
			arr1[i] = (int)(Math.random()*100);	//случайных, да
			arr2[i] = arr1[i];			//...где первые элементы повторяются
			arr2[i + arr1.length] = arr1[i]*2;	//а остальные числа являются увеличенными вдвое значениями первого массива
		}						//Один из результатов:
		System.out.println(Arrays.toString(arr1));//[14, 20, 60, 7, 33, 55, 50, 0, 5, 4]
		System.out.println(Arrays.toString(arr2));//[14, 20, 60, 7, 33, 55, 50, 0, 5, 4, 28, 40, 120, 14, 66, 110, 100, 0, 10, 8]
	}
	//Task 4.5
	private static void showTwoArrays(int arrLength) { 	//понравилась идея с избавлением от жёсткой длины массива
		// TODO Auto-generated method stub		//попробовал перегруженные методы. это скучно :с
		int[] arr1 = new int[arrLength],		//понял, что я ничего не знаю о массивах динамического размера, выполняя следующее задание
				      arr2 = new int[arr1.length * 2];
				for (int i = 0; i < arr1.length; i++) {
					arr1[i] = (int)(Math.random()*100);
					arr2[i] = arr1[i];
					arr2[i + arr1.length] = arr1[i]*2;
				}
				System.out.println(Arrays.toString(arr1));
				System.out.println(Arrays.toString(arr2));
	}
	//вывод, собственно, матрицы. один раз написал, 6 раз вызываю
	private static void showMatrix(ArrayList<ArrayList<Integer>> matrix1) {
		// TODO Auto-generated method stub
		for (int i = 0; i < matrix1.size(); i++) {
			for (int j = 0; j < matrix1.get(i).size(); j++) {
				System.out.print(matrix1.get(i).get(j) + "\t");
			}
			System.out.println("\n");
		}
	}
	//Task 5
	private static void doSmth(ArrayList<ArrayList<Integer>> matrix) {
		// TODO Auto-generated method stub 	//ну зачем я за это взялся...	
		Integer temp1, temp2;			//за дополнительные баллы смогу это сделать без темпов :р
		int semiHight = matrix.size() / 2;	//будем работать только с одной четвертью матрицы
		int semiLength = matrix.size() / 2;	//нужны две переменные на случай, если рамерность матрицы нечётная
	if (matrix.size()%2 != 0) {			//дальше будем считать, при матрице 5х5, две строки и три столбца
			semiLength += 1;		//элемент [3][3] не трогаем, он останется на своём месте
		} 					//при этом, на прямоугольной матрице метод скорее всего работать не будет :(
		for (int i = 0; i < semiHight; i++) {			//считаем половину строк матрицы без центральной строки, если размерность нечётная
			for (int j = 0; j < semiLength; j++) {		//считаем половину столбцов с центральным, если размерность нечётная
				temp1 = matrix.get(i).get(j);						//из первой четверти в память
				temp2 = matrix.get(j).get(matrix.size() - 1 - i); 			//из второй четверти в память
				matrix.get(j).set(matrix.size() - 1 - i, temp1);			//из первой четверти во вторую через память
				temp1 = matrix.get(matrix.size() - 1 - i).get(matrix.size() - 1 - j);	//из третьей четверти в память
				matrix.get(matrix.size() - 1 - i).set(matrix.size() - 1 - j, temp2);	//из второй четверти в третью через память
				temp2 = matrix.get(matrix.size() - 1 - j).get(i);			//из четвёртой четверти в память
				matrix.get(matrix.size() - 1 - j).set(i, temp1);			//из третьей четверти в четвёртую через память
				matrix.get(i).set(j, temp2);						//из памяти в первую четверть то, что было в четвёртой
			}
		}
	}
	//делаем бочку
	private static void doABarrelRoll(ArrayList<ArrayList<Integer>> matrix1) {
	// TODO Auto-generated method stub	//Гари Олдман получил Оскар. Он молодец, давно пора.
		doSmth(matrix1);
		doSmth(matrix1);
		doSmth(matrix1);
		doSmth(matrix1);
	}
}
