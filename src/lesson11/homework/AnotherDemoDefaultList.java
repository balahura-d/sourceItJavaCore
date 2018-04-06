package lesson11.homework;

import java.util.Arrays;
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
		System.out.println(Arrays.toString(ndl.toArray())+ "; Size: "+ndl.size());
		System.out.println("List contain \"joker\" (expected true): "+ndl.contains("joker"));
		ndl.remove("joker");
		System.out.println(Arrays.toString(ndl.toArray())+ "; Size: "+ndl.size());
		System.out.println("List contain \"joker\" (expected false): "+ndl.contains("joker"));
		
		System.out.println("containsAll() check: "+ndl.containsAll(ndl2));
		
		for (Object obj : ndl) {
			System.out.println(obj);
		}
		
		Iterator<Object> it = ndl.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}

}
