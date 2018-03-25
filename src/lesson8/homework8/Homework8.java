package lesson8.homework8;

import java.io.File;

public class Homework8 {
	public static void main(String[] args) {
		File filePath = new File("src");
		String extension = ".java";
		int depth = 1;
		System.out.println(countFiles(filePath, extension) + "\n");
		System.out.println(countFiles(filePath, depth, extension));
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

		System.out.print(sb);// для каждой папки создаётся свой sb, поэтому тут схитрим и будем выводить без
					// переноса строк
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
		System.out.print(sb);// для каждой папки создаётся свой sb, поэтому тут схитрим и будем выводить без
					// переноса строк
		return counter;
	}
}
