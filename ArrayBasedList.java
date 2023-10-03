import java.util.*;
import java.lang.reflect.*;
public class ArrayBasedList<T> implements List<T> {
	// instance variables
	private Comparable<T>[] array;
	private int size;
	
	// constructors
	public ArrayBasedList() {
		size = 0;
		array = (Comparable<T>[]) Array.newInstance(Comparable.class, 10);
	}
	
	public ArrayBasedList(int capacity) {
		size = 0;
		array = (Comparable<T>[]) Array.newInstance(Comparable.class, capacity);
	}
	
	// accessors
	public Comparable<T> get(int pos) throws Exception{
		if (pos < size) {
			return array[pos];
		}
		throw new IndexOutOfBoundsException();
	}
	
	public int find(Comparable<T> o) {
		for (int i = 0; i < size; i++) {
			if (array[i].equals(o)) {
				return i;
			}
		}
		return -1;
	}
	public int length() {
		return size;
	}
	
	public String toString() { return null; }

	public boolean set(Comparable<T> o, int pos) { return false; }
	public void add(Comparable<T> o) {}
	public void insert(Comparable<T> o, int pos) throws Exception{}
	public Comparable<T> remove(int pos) throws Exception{ return null; }
	public boolean remove(Comparable<T> o) { return false; }
	public void clear() {
		array = (Comparable<T>[]) Array.newInstance(Comparable.class, 10);
		size = 0;
	}
	public void sort() {}
	
	public static void main(String[] args) {		
	}
}
