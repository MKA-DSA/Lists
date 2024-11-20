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
	// front = position 0; back = position size - 1
	public void enqueue(T o) {
		// if array is full
		if (Q.length == size) {
			T[] newArray = (T[]) Array.newInstance(Object.class, size + 10);
			for (int i = 0; i < size; i++) {
				newArray[i] = Q[i];
			}
			Q = newArray;
		}
		Q[size] = o;
		size++;
		// o!!
	}
	
	public T dequeue() {
		if (size == 0) {
			return null;
		}
		T temp = Q[0];
		for (int i = 0; i < size - 1; i++) {
			Q[i] = Q[i+1];
		}
		size--;
		return temp;
	}
	
	public T peek() {
		if (size == 0) {
			return null;
		}
		return Q[0]; 
	}
	public static void main(String[] args) {
		ArrayQueue<Integer> q = new ArrayQueue<Integer>();
		for (int i = 10; i >= 0; i--) {
			q.enqueue(i);
		//	System.out.println(q.peek());
		}
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

	}

}
