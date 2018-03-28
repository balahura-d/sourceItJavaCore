package lesson9.homework9.textEditor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TextStat {
	
	String s;
	static int sumOfWords = 0;
	static int sumOfChars = 0;
	int maxVowals = 0;
	int vowals = 0;

	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Применение: TextStat путь_к_файлу");
			return;
		} else {
			getTextStat(args[0]);
		}
	}

	public static void getTextStat (String pathToFile) throws IOException {



		System.out.println(">>>TextStat in " + pathToFile);

//		try (BufferedReader bfr = new BufferedReader(new FileReader(pathToFile));) {
//			while (!((s = bfr.readLine()) == null)) {
//				System.out.println(s + lesson4.Homework4.numberOfWords(s) + (sumOfChars += 1)
//						+ (maxVowals += 1) + (vowals += 1));
//				sumOfWords += lesson4.Homework4.numberOfWords(s);
//			}
//			System.out.println(">>>Загальна кількість слів у файлі: " + sumOfWords);
//		}

		 try (Stream<String> fStream = Files.lines(Paths.get(pathToFile))) {
		 fStream.forEach(TextStat::methForForEach);
		 System.out.println(">>>Загальна кількість слів у файлі: " + sumOfWords);
		 System.out.println(">>>Загальна кількість символів у файлі: " + sumOfChars);
		// maxVowals += 1;
		// vowals += 1;
		 }

	}
	private static void methForForEach(String s) {
		System.out.println(s);
		sumOfWords += lesson4.Homework4.numberOfWords(s);
		sumOfChars += s.length();
	}
}
