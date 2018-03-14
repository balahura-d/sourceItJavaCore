package Lesson4;

import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;

public class Homework4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printPi();
		
		System.out.println();
		int[] arr1 = new int[20];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = (int)(Math.random()*100);
		}
		int maxArr = maxInArray(arr1);
		System.out.println("В этом массиве:\n"+Arrays.toString(arr1)+"\nмаксимальное число равно " + maxArr);
		
		System.out.println();
		int h = (int)(Math.random()*8 + 2);
		int w = (int)(Math.random()*16 + 2);
		System.out.println("Прямоугольник размером " + h +"х" +w+ ":");
		drawRectangle(h, w);
		
		System.out.println();
		System.out.print("Привет. :) Расскажи что-нибудь: ");
		Scanner scan = new Scanner(System.in);
		String s = scan.nextLine();
		System.out.println(s + "?\nТы сказал "+numberOfWords(s)+" слов.");
	}

	private static int numberOfWords(String str) {
		// TODO Auto-generated method stub
		String [] words = str.split("[ -#$%^&!?,.0-9\\s]+");
		return words.length;
	}

	private static void drawRectangle(int higth, int width) {
		// TODO Auto-generated method stub
		char[] borderLine = new char[width],
		       midLine = new char[width];
		Arrays.fill(borderLine, '+');  
		midLine[0] = midLine[midLine.length-1] = '+';
		System.out.println(borderLine);
		for (int i = 0; i < higth-2; i++) {
			System.out.println(midLine);
		}
		System.out.println(borderLine);
	}

	private static int maxInArray(int[] array) {
		// TODO Auto-generated method stub
		int max = Integer.MIN_VALUE;
		for (int a : array) {
			if (a > max) {
				max = a;
			}
		}
		return max;
	}

	private static void printPi() {
		// TODO Auto-generated method stub
		Formatter f = new Formatter();
		f.format("Форматированный вывод: \n%.1f %n%.2f %n%.3f %n%.4f %n%.5f",
			  Math.PI,Math.PI,Math.PI,Math.PI,Math.PI);
		System.out.println(f);		
	}

}
