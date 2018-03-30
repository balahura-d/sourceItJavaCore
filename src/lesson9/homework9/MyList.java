package lesson9.homework9;

public interface MyList<T> {
	
	void add(T t); // appends the specified element to the end of this list

	void clear(); // removes all of the elements from this list

	boolean remove(T t); // removes the first occurrence of the specified element from this list

	Object[] toArray(); // returns an array containing all of the elements in this list in proper sequence

	int size(); // returns the number of elements in this list

	boolean contains(T t); // returns true if this list contains the specified element.

	boolean containsAll(MyList<?> ml); // returns true if this list contains all of the elements of the specified list
	
	T get(int index);
}
