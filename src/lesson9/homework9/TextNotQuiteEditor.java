package lesson9.homework9;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import lesson9.homework9.textEditor.TextStat;

public class TextNotQuiteEditor {

	public static void main(String[] args) {

		if (args.length != 1) {
			System.out.println("Применение: TextNotQuiteEditor путь_к_файлу");
			return;
		}

		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
				OutputStream fout = Files.newOutputStream(Paths.get(args[0]), StandardOpenOption.CREATE,
						StandardOpenOption.APPEND)) {
			while(true)
			{
				String s = br.readLine();
				if (s.equals("exit")) {
					TextStat.showTextStat(Paths.get(args[0]));
					return;
				}
				fout.write((s+"\n").getBytes());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
