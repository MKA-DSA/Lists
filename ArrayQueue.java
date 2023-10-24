/* Data Structures & Algos
 * Array Based Queue
 * Fall 2023
 */
import java.lang.reflect.Array;

public class ArrayQueue<T> implements Queue<T> {
	// variables
	private T[] Q; 
	private int size;
	
	// constructors
	public ArrayQueue() {
		this.Q = (T[]) Array.newInstance(Object.class, 10);
		size = 0;
	}
	
	public void enqueue(T o) {
		if(Q.length > size) {
			Q[size++] = o;
			return;
		}
		int newCapacity = Q.length * 2;
		T[] temp = (T[]) Array.newInstance(Object.class, newCapacity);
		for(int i = 0; i < Q.length; i++) {
			temp[i] = Q[i];
		}
		temp[size++] = o;
		Q = temp;		
	}
	
	public T dequeue() {
		if(size == 0) {
			return null;
		}
		
		T temp = Q[0];
		for(int i = 1; i < size; i++) {
			Q[i-1] = Q[i];
		}
		size--;
		return temp;
	}
	
	public T peek() {
		return Q[0];
	}

}
