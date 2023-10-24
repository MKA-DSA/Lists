
public class CNode<T> {
	private Comparable<T> element;
	private CNode<T> next;
	
	CNode(Comparable<T> elt, CNode<T> next){
		element = elt;
		this.next = next;
	}
	CNode(Comparable<T> elt){
		element = elt; 
		next = null;
	}
	CNode(){
		element = null;
		next = null;
	}
	
	public CNode<T> getNext() { return next; }
	public Comparable<T> getElt() { return element; }
	public void setNext(CNode<T> nxt) { next = nxt; }
	public void setElt(Comparable<T> elt) { element = elt; }
	public String toString() { return element.toString(); }
	
}