package lesson11.homework;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

import lesson9.homework9.MyList;

public class NewDefaultList<T> implements MyList<T>, ListIterable {

	public int capacity = 10;
	private int size = 0;
	Object[] data;

	public NewDefaultList() {
		data = new Object[capacity];
	}

	public NewDefaultList(int init) {
		data = new Object[init];
	}

	@Override
	public ListIterator<Object> listIterator() {
		return new ListIteratorImpl(0);
	}

	@Override
	public String toString() {
		if (size() == 0)
			return "{empty}";
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for (int i = 0;; i++) {
			sb.append(get(i).toString());
			if (i == (size() - 1))
				return sb.append(']').toString();
			sb.append(", ");
		}
	}

	public ListIterator<Object> listIterator(int index) {
		if (index < 0 || index > size)
			throw new IndexOutOfBoundsException("Index: " + index);
		return new ListIteratorImpl(index);
	}

	public void set(int i, Object obj) {
		if (i < size)
			data[i] = obj;
		else
			throw new IndexOutOfBoundsException("Index " + i + " > Size " + size);
	}

	@Override
	public void add(T t) {
		data[size] = t;
		if ((++size) == capacity) {
			capacity = (int) ((capacity * 1.5 < Integer.MAX_VALUE) ? (capacity * 1.5)
					: (Integer.MAX_VALUE));
			Object[] newArray = new Object[capacity];
			System.arraycopy(data, 0, newArray, 0, data.length);
			data = newArray;
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
			throw new IndexOutOfBoundsException("Index " + index + " >= Size " + size);
	}

	@Override
	public Iterator<Object> iterator() {
		return new IteratorImpl();
	}

	private class IteratorImpl implements Iterator<Object> {
		int cursor = 0;
		int returned = -1;

		public boolean hasNext() { // returns true if the iteration has more elements
			// …
			return (cursor != size);
		}

		public T next() { // returns the next element in the iteration
			// … public E next() {
			try {
				int n = cursor;
				T next = get(n);
				returned = n;
				cursor = n + 1;
				return next;
			} catch (IndexOutOfBoundsException e) {
				throw new NoSuchElementException();
			}
		}

		public void remove() { // removes from the underlying collection the last element returned by this
					// iterator
			if (returned >= 0) {
				NewDefaultList.this.remove(data[returned]);
				returned = -1;
			} else
				throw new IllegalStateException();
		}
	}

	private class ListIteratorImpl extends IteratorImpl implements ListIterator<Object> {

		ListIteratorImpl(int index) {
			super();
			cursor = index;
		}

		@Override
		public boolean hasPrevious() {
			return cursor != 0;
		}

		@Override
		public Object previous() {
			int p = cursor - 1;
			T previous = get(p);
			returned = p;
			cursor = p;
			return previous;
		}

		@Override
		public void set(Object obj) {
			if (returned >= 0) {
				NewDefaultList.this.set(returned, obj);
				returned = -1;
			} else
				throw new IllegalStateException();
		}

	}

}
