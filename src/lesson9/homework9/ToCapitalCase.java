package lesson9.homework9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class ToCapitalCase {
	public static void main(String[] args) throws IOException {
		String string = "Какая-то строка с разными словами, которые нужно вывести с большой буквы каждое. Ну не \" мама мыла раму \" же писать, это в каждом примере в гугле есть.";

		System.out.println(toCapitalCaseFromString(string));
		System.out.println(toCapitalCaseFromConsole());
		System.out.println(toCapitalCaseFromFile("testText.txt")); // как принято работать с файлами?

	}

	private static String toCapitalCase(String string) {
		char[] array = string.toCharArray();
		for (int i = 0; i < array.length; i++) {
			if (i == 0 || array[i - 1] == ' ' && i < array.length - 1)
				array[i] = Character.toUpperCase(array[i]);
		}
		return new String(array);
	}

	public static String toCapitalCaseFromFile(String pathToFile) throws IOException {
		StringBuilder sb = new StringBuilder();
		try (Stream<String> fStream = Files.lines(Paths.get(pathToFile))) {
			fStream.map(string -> toCapitalCase(string))
					.forEach(string -> sb.append(string + System.lineSeparator()));
		}
		return sb.toString();
	}

	public static String toCapitalCaseFromString(String string) {
		return toCapitalCase(string);
	}

	public static String toCapitalCaseFromConsole() throws IOException {
		System.out.print("Введите текст, который нужно преобразовать: ");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		return toCapitalCase(s);
	}

}
