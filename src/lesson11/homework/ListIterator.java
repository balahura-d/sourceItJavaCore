package lesson11.homework;

import java.util.Iterator;

public interface ListIterator<T> extends Iterator<Object> { // java.util.Iterator

	boolean hasPrevious(); // returns true if this list iterator has more elements when traversing the list
				// in the reverse direction

	T previous(); // returns the previous element in the list and moves the cursor position
				// backwards

	void set(T t); // replaces the last element returned by next or previous with the specified
				// element

	void remove(); // removes from the list the last element that was returned by next or previous
}
