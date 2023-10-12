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
		//#3
		if (pos >= 0 && pos < size){
			array[pos] = o;
			return true;
		} 
		throw new IndexOutOfBoundsException(); 
	}
	
	public void add(Comparable<T> o) { // for homework #1
		// size is the number of elements, array.length is capacit
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
		// #2
		if (pos > size) {
			throw new IndexOutOfBoundsException();
		}
		else if (pos == size) {
			this.add(o);
			return;
		}
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
		// have enough space and pos is valid
		// shift everything over - starting at the end 
		for (int i = size-1; i >=pos; i--) {
			array[i+1]=array[i];
		}
		array[pos] = o;
		size++;
	}
	
	public Comparable<T> remove(int pos){ 
		// pos out of bound
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
		// smart bubble sort
		// high iq bubble sort
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
	
	public static void main(String[] args) {
		ArrayBasedList<Integer> list = new ArrayBasedList<Integer>();
		int val = 0;
		for (int i = 0; i < 19; i++) {
			list.add(val);
			val += 4;
		}
		// test find, clear, length, get
		// find
		System.out.println(list.find(8) + " should be 2");
		System.out.println(list.find(27) + " should be -1");

		//length
		System.out.println(list.length() + " should be 15");
		
		//get
		try {
			System.out.println(list.get(12) + " should be 48");
			// insert
			list.insert(-10, 2);
			list.insert(-5, 0);
			list.insert(1000, 21);

			//list.insert(-12, 25);
			
			list.set(500, 8);
			//list.set(-50, 27);
			System.out.println(list);
			System.out.println(list.remove((Integer)43));
			System.out.println(list);
			list.sort();
			System.out.println(list);
			
		} catch (Exception E) { System.out.println(E); }

		
		//clear
		list.clear();
		System.out.println(list.length());
		System.out.println(list);
		
		
	}
}
