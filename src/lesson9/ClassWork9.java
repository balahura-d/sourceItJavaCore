package lesson9;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ClassWork9 {

	public static void main(String[] args) throws Exception {
//�������� ������ ������ Path
		Path p = Paths.get("src");
	//	Stream<Path> list = Files.list(p);
		Files.walk(p);
	//	Files.createDirectory(p);
	//	Files.lines(p);
		
		//��� ������ ���������� ��������� ���������
		//��� ����� � 1.7 ��������� ����������� try with resources
//		try (Stream<String> str = Files.lines(p);
//				Scanner sc = new Scanner(System.in);) {
//	//		Files.createFile(p);
//			Files.walk(p);
//		}
		
	// ## ����������� � ��������� �������
	// ������� ����, �������� � ����, ��������� �� �����, ������� ���� ����� ������
		
	}

}
