package lesson9;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClassWork9 {

	public static void main(String[] args) throws Exception {
//полезные методы класса Path
		Path p = Paths.get("src");
	//	Stream<Path> list = Files.list(p);
		Files.walk(p);
	//	Files.createDirectory(p);
	//	Files.lines(p);
		
		//все потоки необходимо корректно закрывать
		//для этого с 1.7 появилась конструкция try with resources
//		try (Stream<String> str = Files.lines(p);
//				Scanner sc = new Scanner(System.in);) {
//	//		Files.createFile(p);
//			Files.walk(p);
//		}
		
	// ## РАзобраться с созданием стримов
	// создать файл, записать в файл, прочитать из файла, удалить файл через потоки
		
	}

}
