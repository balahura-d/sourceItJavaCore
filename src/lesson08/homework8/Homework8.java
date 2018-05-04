package lesson08.homework8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Homework8 {
	public static void main(String[] args) throws IOException {
		File filePath = new File("src");
		String extension = ".java";
		String directory = "src";
		int depth = 1;

		System.out.println(countFiles(filePath, extension) + "\n");
		System.out.println(countFiles(filePath, depth, extension) + "\n");

		System.out.println(newFileCounter(directory, extension));
		System.out.println(newListOfFileWithDepth(depth, directory));
	}

	private static String newListOfFileWithDepth(int depth, String directory) throws IOException {
		StringBuilder sb = new StringBuilder();
		Files.walk(Paths.get(directory), depth).forEach(path -> sb.append(path.toString() + ", "));
		return sb.toString();
	}

	private static long newFileCounter(String directory, String extension) throws IOException {
		return Files.walk(Paths.get(directory)).filter(path -> path.toString().endsWith(extension))
				/* .peek(System.out::println) */.count();
		// никто не говорил, что надо выводить названия файлов. Но мы могём.
	}

	private static int countFiles(File filePath, int depth, String extension) {
		int counter = 0;
		StringBuilder sb = new StringBuilder();
		File[] filesList = filePath.listFiles();
		for (File file : filesList) {
			if ((depth > 0) && file.isDirectory()) {
				counter += countFiles(file, (depth - 1), extension);
			} else if (file.getName().endsWith(extension)) {
				counter++;
				sb.append(file.getName() + "; ");
			}
		}

		System.out.print(sb);// для каждой папки создаётся свой sb, поэтому тут схитрим и будем выводить без переноса строк
		return counter;
	}

	private static int countFiles(File filePath, String extension) {
		int counter = 0;
		StringBuilder sb = new StringBuilder();
		File[] filesList = filePath.listFiles();
		for (File file : filesList) {
			if (file.isDirectory()) {
				counter += countFiles(file, extension);
			} else if (file.getName().endsWith(extension)) {
				counter++;
				sb.append(file.getName() + "; ");
			}
		}
		System.out.print(sb);// для каждой папки создаётся свой sb, поэтому тут схитрим и будем выводить без переноса строк
		return counter;
	}

}
