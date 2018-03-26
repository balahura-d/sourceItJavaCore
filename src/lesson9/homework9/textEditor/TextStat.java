package lesson9.homework9.textEditor;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class TextStat {

	
	public static void main(String[] args) throws IOException {
		if (args.length != 1) {
			System.out.println("Применение: TextStat путь_к_файлу");
			return;
		} else {
			showTextStat(Paths.get(args[0]));
		}
	}

	public static void showTextStat(Path path) throws IOException {
		
		int sumOfWords = 0;
		int sumOfChars = 0;
		int maxVowals = 0;
		int vowals = 0;
		
		System.out.println("TextStat in " + path);
		try (Stream<String> fStream = Files.lines(path)) {
			fStream.forEach(System.out::println);
			sumOfWords += 1;
			sumOfChars += 1;
			maxVowals += 1;
			vowals += 1;
			
		}
	}
}
