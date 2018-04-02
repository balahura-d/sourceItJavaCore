package lesson11.homework;

import lesson9.homework9.MyList;

public class DefaultList implements MyList<Object>, ListIterable {

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

}
