package lesson9.homework9;

import java.util.ArrayList;

public class DefaultMyList<T> implements MyList<T> {

	ArrayList<T> obj = new ArrayList<T>();
	ArrayList<Integer> numOfObj = new ArrayList<Integer>();

	@Override
	public void add(T t) {
		if (obj.contains(t)) { // если в обж уже есть элемент,
			numOfObj.set(obj.indexOf(t), // то по его индексу
					(numOfObj.get(obj.indexOf(t) + 1))); // инкрементим значение его кол-ва
		} else { // если же нет -
			obj.add(t); // добавляем в список
			numOfObj.set(obj.size() - 1, 1); // и указываем, что он первый
		}
	}

	@Override
	public void clear() { // прост))
		obj.clear();
		numOfObj.clear();
	}

	@Override
	public boolean remove(Object t) {
		if ((obj.contains(t)) & (numOfObj.get(obj.indexOf(t)) > 1)) { // если элементов больше одного
			numOfObj.set(obj.indexOf(t), // то по индексу элемена
					numOfObj.get(obj.indexOf(t) - 1)); // мы записываем меньшее на 1 количество
			return true; // и всё норм
		} else if ((obj.contains(t)) & (numOfObj.get(obj.indexOf(t)) == 1)) { // если элемент остался 1
			numOfObj.remove(obj.indexOf(t)); // удаляем инфо о его количестве (сначала, потому что ищем по
								// индексу)
			obj.remove(t); // затем удаляем сам элемент (он единственный по логике списка)
			return true;
		} else { // других вариантов быть не должно
			return false;
		}
	}

	public boolean removeAll(Object t) {
		if ((obj.contains(t)) & (numOfObj.get(obj.indexOf(t)) >= 1)) {
			numOfObj.remove(obj.indexOf(t));
			obj.remove(t);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Object[] toArray() {
		return obj.toArray(); // прост))
	}

	public Object[] toArrayAll() {
		int size = sizeAll();
		// T[] objArray = (T[])Array.newInstance(getClass(T), 10);
		Object[] objArray = new Object[size];
		for (int i = 0; i < size;) { // проходим по результативному циклу
			for (int j = 0; j < numOfObj.get(obj.indexOf(i)); j++) { // и "numOfObj" раз
				objArray[i + j] = obj.get(i); // записываем объект
			} // после чего
			i += numOfObj.get(obj.indexOf(i)); // переходим на следующую пустую позицию
		}
		return objArray;
	}

	@Override
	public int size() { // прост))
		return obj.size();
	}

	public int sizeAll() { // тут считаем сумму всех значений количества элементов
		return numOfObj.stream().mapToInt(n -> (int) n).sum();
	}

	@Override
	public boolean contains(Object t) { // подсмотрено у ArrayList
		return obj.indexOf(t) >= 0; // его же (AL) и используем)
	}

	@Override
	public boolean containsAll(MyList<?> ml) { // подсмотрено в AbstractCollection и -не- используем его
		// for (Object e : ml) // Оп! А вот и итератор "всплыл"
		// if (!contains(e)) // "Can only iterate over an array or an instance of java.lang.Iterable"
		// return false;
		// return true;
		for (int i = 0; i < ml.size(); i++) {
			if (!obj.contains(ml.get(i)))
				return false;
		}
		return true;
	}

	@Override
	public T get(int index) {
		return obj.get(index);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < obj.size(); i++) {
			sb.append('[');
			sb.append(obj.get(i).toString());
			sb.append(" :: ");
			sb.append(numOfObj.get(i));
			sb.append(']'+System.lineSeparator());
		}
		return sb.toString();
		
	}
}
