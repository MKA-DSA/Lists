/* Data Structures & Algos
 * Array Based Stack
 * Fall 2023
 */
import java.lang.reflect.Array;

public class ArrayStack<T> implements Stack<T> {
	private T[] s;
	private int size;
	
	public ArrayStack() {
		s = (T[]) Array.newInstance(Object.class, 10);
		size = 0;
	}
	
	public void push(T o) {
		if (s.length <= size) {
			T[] newArr = (T[]) Array.newInstance(Object.class, s.length * 2);
			for (int i = 0; i < size; i++) newArr[i] = s[i];
			s = newArr;
		}
		s[size] = o; 
		size++;		
	}
	
	public T pop() {
		if (size == 0) return null;
		T temp = s[size-1];
		s[size-1] = null;
		size--;
		return temp;
	}
	
	public T peek() { 
		if (size == 0) return null;
		return s[size-1];
	}
	
}
