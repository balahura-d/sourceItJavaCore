package lesson9.homework9;

import java.util.ArrayList;

public class DefaultMyList<T> implements MyList {
	
	ArrayList<T> obj = new ArrayList<T>();
	ArrayList<Integer> numOfObj = new ArrayList<Integer>();
		
	@Override
	public void add(Object e) {
	}

	@Override
	public void clear() {
	}

	@Override
	public boolean remove(Object o) {
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
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public boolean containsAll(MyList c) {
		return false;
	}
	
	@Override
	public String toString() {
		return null;
	}

}
