package lesson11.homework;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import lesson9.homework9.MyList;

public class NewDefaultList<T> implements MyList<T>, ListIterable {

	private int capacity = 10;
	private int size = 0;
	Object[] data;

	public NewDefaultList() {
		data = new Object[capacity];
	}

	public NewDefaultList(int init) {
		data = new Object[init];
	}

	@Override
	public ListIterator listIterator() {
		return null;
	}

	@Override
	public void add(T t) {
		data[size] = t;
		if ((size++) == capacity) {
			capacity = (int) ((capacity * 1.5 < Integer.MAX_VALUE) ? (capacity * 1.5)
					: (Integer.MAX_VALUE));
		}
	}

	@Override
	public void clear() {
		for (int i = 0; i < size; i++)
			data[i] = null;
		size = 0;
	}

	@Override
	public boolean remove(Object obj) {
		for (int i = 0; i < size; i++)
			if (obj.equals(data[i])) {
				System.arraycopy(data, i + 1, data, i, size - i - 1);
				data[--size] = null;
				return true;
			}
		return false;
	}

	@Override
	public Object[] toArray() {
		return Arrays.copyOf(data, size);
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean contains(Object o) {
		for (int i = 0; i < size; i++)
			if (o.equals(data[i]))
				return true;
		return false;
	}

	@Override
	public boolean containsAll(MyList<?> ml) {
		for (Object o : ml)
			if (!contains(o))
				return false;
		return true;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int index) {
		if (index < size)
			return (T) data[index];
		else
			throw new IndexOutOfBoundsException("Index " + index + " > Size " + size);
	}

	@Override
	public Iterator<Object> iterator() {
		return new IteratorImpl();
	}

	private class IteratorImpl implements Iterator<Object> {
		int cursor = 0;
		int returned = 0;

		public boolean hasNext() { // returns true if the iteration has more elements
			// …
			return (cursor != size);
		}

		public T next() { // returns the next element in the iteration
			// … public E next() {
			try {
				int i = cursor;
				T next = get(i);
				cursor = i + 1;
				returned++;
				return next;
			} catch (IndexOutOfBoundsException e) {
				throw new NoSuchElementException();
			}
		}

		public void remove() { // removes from the underlying collection the last element returned by this
					// iterator
			if (returned != 0) {
				NewDefaultList.this.remove(data[cursor - returned]);
				returned = 0;
			} else
				throw new IllegalStateException();
		}
	}

}
