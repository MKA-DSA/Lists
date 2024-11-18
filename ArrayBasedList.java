/* Data Structures & Algos
 * Array Based List
 * Fall 2024
 */
import java.util.*;

import java.lang.reflect.*;
public class ArrayBasedList<T> implements List<T> {

	// instance variables
	private Comparable<T>[] array; //array.length -> capacity
	private int size;
	
	// constructors
	@SuppressWarnings("unchecked")
	public ArrayBasedList() {
		size = 0;
		array = (Comparable<T>[]) Array.newInstance(Comparable.class, 10);
	}
	
	@SuppressWarnings("unchecked")
	public ArrayBasedList(int capacity) {
		size = 0;
		array = (Comparable<T>[]) Array.newInstance(Comparable.class, capacity);
	}
	
	// accessors
	public int length() {
		return size;
	}
	
	public Comparable<T> get(int pos) throws Exception{
		if (pos >= size || pos < 0) {
			throw new IndexOutOfBoundsException();
		}
		return array[pos];
	}
	
	public int find(Comparable<T> o) {
		for (int i = 0; i < size; i++) {
			if(array[i].equals(o)) return i;
		}
		return -1;
	}
	
	public String toString() { 
		String toRet = "{";
		for(int i = 0; i < size-1; i++) {
			toRet += array[i] + ", ";
		}
		toRet += array[size-1] + "}";
		return toRet;
		
	}

	//modifiers
	public boolean set(Comparable<T> o, int pos) throws Exception{ 
		if (pos >= size || pos < 0) {
			throw new IndexOutOfBoundsException();
		}
		array[pos] = o;
		return true; // paxton made this
	}
	
	@SuppressWarnings("unchecked")
	public void add(Comparable<T> o) {
		// we <3 dsa :)
		if (size < array.length) { //still room in array for elt
			array[size] = o;
			size++;
		} else {
			Comparable<T>[] newArray = (Comparable<T>[]) Array.newInstance(Comparable.class, size + 10);
			for (int i = 0; i < size; i++) {
				newArray[i] = array[i];
			}
			newArray[size] = o;
			size++;
			array = newArray;
		}
	}

	@SuppressWarnings("unchecked")
	public void insert(Comparable<T> o, int pos) throws Exception{
		if (pos > size || pos < 0) {
			throw new IndexOutOfBoundsException();
		}
		else if (pos == size) {
			this.add(o);
		}
		else {
			if (size+1 > array.length) { // size == array.length
				Comparable<T>[] newArray = (Comparable<T>[]) Array.newInstance(Comparable.class, size + 10);
				for (int i = 0; i < pos; i++) {
					newArray[i] = array[i];
				}
				newArray[pos] = o;
				for (int i = pos; i < size; i++) {
					newArray[i + 1] = array[i];
				}
				array = newArray;
			}
			else {
				for(int i = size; i >= pos; i--) {
					array[i] = array[i-1];
				}
				array[pos] = o;
			}
		}
	}
	
	public Comparable<T> remove(int pos) throws Exception{
		if(pos < 0 || size <= pos) throw new IndexOutOfBoundsException();
		Comparable<T> toReturn = array[pos];
		for(int i = pos; i < size-1; i++) {
			array[i] = array[i+1];
		}
		size --;
		return toReturn;
	} 
	
	public boolean remove(Comparable<T> o) { 
		int pos = this.find(o);
		if (pos >= 0) {
			try {
				this.remove(pos);
			}catch(Exception E){ System.out.println(E); };
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public void clear() {
		array = (Comparable<T>[]) Array.newInstance(Comparable.class, 10);
		size = 0;
	}
	
	public void sort() {
		int counter = 0;
		for(int i = 0; i < size; i++) {
			for(int j = 0; j < size-1; j++) {
				//System.out.println("iteration: " + i + " " +this);
				if(array[j+1].compareTo((T) array[j]) < 0) {
					//System.out.println("comparing " + (j+1) + " ");

					Comparable<T> store = array[j+1];
					array[j+1] = array[j];
					array[j] = store;
					counter++;
				}
			}
			if(counter == 0) {return;}
			counter = 0;
		}
	}
}
