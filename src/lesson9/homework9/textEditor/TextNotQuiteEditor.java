package lesson9.homework9.textEditor;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class TextNotQuiteEditor {

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("Применение: TextNotQuiteEditor путь_к_файлу");
			return;
		}

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				BufferedOutputStream bw = new BufferedOutputStream(
						Files.newOutputStream(Paths.get(args[0]), StandardOpenOption.CREATE,
								StandardOpenOption.APPEND))) {
			while (true) {
				String s = br.readLine();
				if (s.equals("exit")) {
					TextStat.getTextStat(args[0]);
					return;
				}
				Files.write(Paths.get(args[0]), (s + "\n").getBytes(), StandardOpenOption.CREATE,
						StandardOpenOption.APPEND);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
