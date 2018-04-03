package lesson11.homework;

import java.util.Iterator;

import lesson9.homework9.MyList;

public class NewDefaultList implements MyList<Object>, ListIterable {

	int capacity;

	public NewDefaultList() {

	}

	public NewDefaultList(int n) {

	}

	@Override
	public ListIterator listIterator() {
		return null;
	}

	@Override
	public void add(Object t) {

	}

	@Override
	public void clear() {

	}

	@Override
	public boolean remove(Object t) {
		return false;
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public int size() {
		return 0;
	}

	@Override
	public boolean contains(Object t) {
		return false;
	}

	@Override
	public boolean containsAll(MyList<?> ml) {
		return false;
	}

	@Override
	public Object get(int index) {
		return null;
	}

	@Override
	public Iterator<Object> iterator() {
		return new IteratorImpl();
	}

	private class IteratorImpl implements Iterator<Object> {
		public boolean hasNext() { // returns true if the iteration has more elements
			// …
			return false;
		}

		public Object next() { // returns the next element in the iteration
			// …
			return null;
		}

		public void remove() { // removes from the underlying collection the last element returned by this
					// iterator
			// …
		}
	}
}
