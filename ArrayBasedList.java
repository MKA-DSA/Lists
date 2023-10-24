/* Data Structures & Algos
 * Array Based List
 * Fall 2023
 */
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
	
	public String toString() { 
		if (size == 0) {
			return "{}";
		}
		String toReturn = "{";
		for(int i = 0; i < size - 1; i++) {
			toReturn += array[i].toString() + ", ";
		}
		toReturn += array[size - 1] + "}";
		return toReturn;
	}

	public boolean set(Comparable<T> o, int pos) throws Exception{ 
		if (pos >= 0 && pos < size){
			array[pos] = o;
			return true;
		} 
		throw new IndexOutOfBoundsException(); 
	}
	
	public void add(Comparable<T> o) {
		if (size >= array.length) {
			System.out.print("updating capacity of array to " + array.length*2 + " ");
			int capacity = array.length*2;
			Comparable<T>[] newArray = (Comparable<T>[]) Array.newInstance(Comparable.class, capacity);
			for(int i = 0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			array = newArray;
			System.out.println(array.length);
		}
		array[size] = o;
		size++;
	}

	public void insert(Comparable<T> o, int pos) throws Exception{
		if (pos > size) {
			throw new IndexOutOfBoundsException();
		}
		else if (pos == size) {
			this.add(o);
			return;
		}
		if (size >= array.length) {
			int capacity = array.length*2;
			Comparable<T>[] newArray = (Comparable<T>[]) Array.newInstance(Comparable.class, capacity);
			for(int i = 0; i < array.length; i++) {
				newArray[i] = array[i];
			}
			array = newArray;
		}
		
		for (int i = size-1; i >=pos; i--) {
			array[i+1]=array[i];
		}
		array[pos] = o;
		size++;
	}
	
	public Comparable<T> remove(int pos){ 
		Comparable<T> elt;
		if (0 <= pos && pos < size) {
			elt = array[pos];
			for (int i = pos + 1; i < size; i++) {
				array[i - 1] = array[i];
			}
			size--;
			return elt;
		}
		return null;
	}
	
	public boolean remove(Comparable<T> o) { 		
		int pos = this.find(o);
		if (pos >= 0) {
			try {
				this.remove(pos);
			}
			catch(Exception E) {}
			return true; //:)
		}
			return false; 
	}
	
	public void clear() {
		array = (Comparable<T>[]) Array.newInstance(Comparable.class, 10);
		size = 0;
	}
	
	public void sort() {
		int swaps = 0;
		
		for (int i = 0; i < size-1; i++) {
			for (int j = 0; j < size-1; j++) {
				if (((Comparable<T>)array[j+1]).compareTo((T)array[j]) < 0) {
					Comparable<T> temp = array[j];
					array[j] = array[j+1];
					array[j+1] = temp;
					swaps++;
				}
			}
			if (swaps == 0) 
				return;
		swaps = 0;
		}	
	}

}
