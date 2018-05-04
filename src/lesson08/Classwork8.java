package lesson08;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Classwork8 {

	public static void main(String[] args) throws Throwable {/*
		// TODO Auto-generated method stub
		// ## Exceptions ##
		// ������: throw new IllegalArgumentException();
		try { // ���� ����, ��� �������� ���������
			System.out.println(5 / 0);
		} catch (Throwable t) {
			System.out.println("Error is happend!");
		} finally {
			// ���� ���� ���������� ������
			// ��� �����, ��������, ��������� �����������
			// ������� ���������� �������-����, ����� �������� ����������
		}
		try {
			doSmth();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		File file = new File("some");
//		file.mkdir(); //create directory
//		file.mkdirs(); //create dir. ierarhy
//		file.createNewFile(); //format your system disk (no)
//		file.exists();
//		file.isDirectory();
		//print "file." and look
		
		
		
	}

	public static void doSmth() throws FileNotFoundException {
		FileReader fr = new FileReader(new File(""));
	}

}
