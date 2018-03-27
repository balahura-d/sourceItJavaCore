package lesson9.homework9.textEditor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class TextStat {

	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Применение: TextStat путь_к_файлу");
			return;
		} else {
			showTextStat(args[0]);
		}
	}

	public static void showTextStat(String pathToFile) throws IOException {

		String s;
		int sumOfWords = 0;
		int sumOfChars = 0;
		int maxVowals = 0;
		int vowals = 0;

		System.out.println("TextStat in " + pathToFile);

		try (BufferedReader bfr = new BufferedReader(new FileReader(pathToFile));) {
			while (!((s = bfr.readLine()) == null)) {
				System.out.println(s + lesson4.Homework4.numberOfWords(s) + (sumOfChars += 1)
						+ (maxVowals += 1) + (vowals += 1));
				sumOfWords += lesson4.Homework4.numberOfWords(s);
			}
			System.out.println(">>>Загальна кількість слів у файлі: " + sumOfWords);
		}

		// try (Stream<String> fStream = Files.lines(path)) {
		// fStream.forEach(System.out::println;);
		// sumOfWords += 1;
		// sumOfChars += 1;
		// maxVowals += 1;
		// vowals += 1;

	}
}
