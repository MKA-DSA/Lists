
public class Node<T> {
	private T element;
	private Node<T> next;
	
	Node(T elt, Node<T> next){
		element = elt;
		this.next = next;
	}
	Node(T elt){
		element = elt; 
		next = null;
	}
	Node(){
		element = null;
		next = null;
	}
	
	public Node<T> getNext() { return next; }
	public T getElt() { return element; }
	public void setNext(Node<T> nxt) { next = nxt; }
	public void setElt(T elt) { element = elt; }
	public String toString() { return element.toString(); }
	
}
