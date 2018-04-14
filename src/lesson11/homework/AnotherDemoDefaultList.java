package lesson11.homework;

import java.util.Iterator;

public class AnotherDemoDefaultList {

	public static void main(String[] args) {
		NewDefaultList<String> ndl = new NewDefaultList<>();
		NewDefaultList<Object> ndl2 = new NewDefaultList<>();

		ndl.add("first");
		ndl2.add("first");
		ndl.add("second");
		ndl2.add("second");
		ndl.add("joker");
		ndl.add("third");
		ndl.add("fourth");
		System.out.println(ndl + "; Size: " + ndl.size());
		System.out.println("List contain \"joker\" (expected true): " + ndl.contains("joker"));
		ndl.remove("joker");
		System.out.println(ndl + "; Size: " + ndl.size());
		System.out.println("List contain \"joker\" (expected false): " + ndl.contains("joker"));
		System.out.println("containsAll() check: " + ndl.containsAll(ndl2));

		// демонстрация работа итератора
		System.out.println("Look! Here's iterator!");
		System.out.println("foreEach:");
		for (Object obj : ndl) {
			System.out.println(obj);
		}
		System.out.println("while(hasNext):");
		Iterator<Object> it = ndl.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		it.remove();
		System.out.println("Last element was removed:");
		System.out.println(ndl + "; Size: " + ndl.size());

		// демонстрация работы листИтератора
		System.out.println("It best then iterator. It\'s... ListIterator!");
		ListIterator<Object> lit = ndl.listIterator(ndl.size());
		while (lit.hasPrevious()) {
			System.out.println(lit.previous());
			lit.set("lit works!");
		}
		System.out.println(ndl);

		NewDefaultList<Integer> intNDL = new NewDefaultList<>();
		for (int i = 0; i < 76; i++) {
			intNDL.add(i);
			System.out.println("Size:" + intNDL.size() + "\t\tcapacity:" + intNDL.capacity);
		}
		System.out.println(intNDL);
	}

}
