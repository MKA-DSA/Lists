/* Data Structures & Algos
 * Linked Queue
 * Fall 2023
 */

public class LinkedQueue<T> implements Queue<T> {
	private Node<T> front;
	private Node<T> back;
	
	public LinkedQueue() {
		front = null;
		back = null;
	}
	
	public void enqueue(T o) {
		if(front == null) {
			front = new Node<T>(o);
			back = front;
		}
		else if (front == back) {
			back = new Node<T>(o);
			front.setNext(back);
		}
		else {
			Node<T> Jonny = new Node<T>(o);
			back.setNext(Jonny);
			back = Jonny;
		}
		
	}
	public T dequeue() {
		if (front == null) return null;
		T elt = front.getElt();
		front = front.getNext();
		return elt;
	}
	
	public T peek() {
		if (front == null) return null;
		return front.getElt();
	}

}
