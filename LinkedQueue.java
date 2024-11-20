

public class LinkedQueue<T> implements Queue<T> {
	private Node<T> front;
	private Node<T> back;
	
	public LinkedQueue() {
		front = null;
		back = null;
	}
	
	public void enqueue(T o) {
		Node<T> newNode = new Node<T>(o);
		if (front == null) { front = newNode; back = newNode;}
		else if (front == back) { 
			back = newNode;
			back.setNext(front);	
		}
		else {
			newNode.setNext(back);
			back = newNode;
		}
		
	}
	public T dequeue() {
		//empty
		if (front == null) {
			return null;
		}
		
		//front = back
		if (front == back) {
			T temp = front.getElt();
			front = null;
			back = null;
			return temp;
		}
		// front != back
		T temp = front.getElt();
		Node<T> current = back;
		while (current.getNext().getNext() != null) {
			current = current.getNext();
		}
		current.setNext(null);
		front = current;
		return temp;
	}
	
	public T peek() {
		if (front == null) return null;
		return front.getElt();
	}
	
	public static void main(String[] args) {
		LinkedQueue<Integer> q = new LinkedQueue<Integer>();
		for (int i = 10; i >= 0; i--) {
			q.enqueue(i);
			System.out.println(q.peek());
		}
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());
		System.out.println(q.dequeue());

	}

}
