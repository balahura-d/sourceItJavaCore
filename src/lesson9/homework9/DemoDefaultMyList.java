package lesson9.homework9;

import java.util.Arrays;

public class DemoDefaultMyList {

	public static void main(String[] args) {
		DefaultMyList<String> dml = new DefaultMyList<>();
		dml.add("qwe");
		dml.add("qwe");
		dml.add("asd");
		dml.add("asd");
		dml.add("qwe");
		dml.add("zxc");
		dml.add("qwe");
		System.out.println(dml + "\nsize:" + dml.size() + "; full size: " + dml.sizeAll());

		

		DefaultMyList<String> dml2 = dml;
		dml2.remove("qwe");
		dml2.removeAll("asd");
		System.out.println(dml2 + "\nsize:" + dml2.size());
		
		System.out.println(dml2.contains("qwe")?"содержит":"не содержит");
		System.out.println(dml2.contains("asd")?"содержит":"не содержит");
		System.out.println(dml.containsAll(dml2)?"содержит":"не содержит");
		dml2.add("zxc");
		System.out.println(dml.containsAll(dml2)?"содержит":"не содержит");

		dml2.clear();
		System.out.println(dml2 + "\nsize:" + dml2.size());
		
		
		Object[] array = new Object[dml.size()];
		array = dml.toArray();
		System.out.println(Arrays.toString(array));
		
		Object[] arrayAll = new Object[dml.sizeAll()];
		arrayAll = dml.toArrayAll();
		System.out.println(Arrays.toString(arrayAll));
		
		
	}

}
