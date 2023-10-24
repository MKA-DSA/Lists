/* Data Structures & Algos
 * Linked Stack
 * Fall 2023
 */
public class LinkedStack<T> implements Stack<T> {
	// variables
	private Node<T> top;
	
	// constructors
	public LinkedStack(){
		top = null;
	}
	
	public void push(T o) {
		Node<T> temp = new Node<T>(o);
		if (top != null) {
			temp.setNext(top);
		}
		top = temp;
	}
	
	public T pop() {
		Node<T> temp = top;
		if (top != null) {
			top = top.getNext();
			return temp.getElt();
		}
		return null;
	}
	
	public T peek() {
		return top.getElt();
	}

}
