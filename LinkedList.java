
public class LinkedList<T> implements List<T>{
	
	private CNode<T> start;
	private int size;
	
	public LinkedList() {
		start = null;
		size = 0;
	}
	
	public int find(Comparable<T> o) {
		int count = 0;
		CNode<T> curr = start;			
		while(curr != null) {
			if(curr.getElt().equals(o)) {
				return count;
			}
			curr = curr.getNext();
			count++;
		}
		return -1;
	}
	
	public int length() {
		return size;
	}
	public String toString() {
		String camron = "{ ";
		CNode<T> curr = start;
		// empty list
		if (curr == null) return "{}";
		while (curr.getNext() != null) {
			camron += curr.getElt() + ", ";
			curr = curr.getNext();
		}
		camron += curr.getElt() + " }";
		return camron;
	}
	
	public boolean set(Comparable<T> o, int pos) throws Exception{
		if(pos < 0 || pos > size - 1) { throw new IndexOutOfBoundsException();}
		CNode<T> curr = start;
		for(int i = 0; i < pos; i++) {
			curr = curr.getNext();
		}
		curr.setElt(o);
		return true;
	}
	
	public Comparable<T> get(int pos) throws Exception{
		if (pos < 0 || pos >= size) { throw new IndexOutOfBoundsException(); }
		CNode<T> curr = start;
		for (int i = 0; i < pos; i++) {
			curr = curr.getNext();
		}
		return curr.getElt();
	}
	
	public void add(Comparable<T> o) {
		CNode<T> toAdd = new CNode<T>(o);
		CNode<T> curr = start;	
		if(start == null) {
			start = toAdd;
			size++;
			return;
		}
		while (curr.getNext() != null) {
			curr = curr.getNext();
		}
		curr.setNext(toAdd);
		size++;
	}
	public void insert(Comparable<T> o, int pos) throws Exception{
		if (pos < 0 || pos > size) { throw new IndexOutOfBoundsException(); }
		if (pos == size) { this.add(o); return; }
		
		CNode<T> newNode = new CNode<T>(o);
		if (pos == 0) {
			newNode.setNext(start);
			start = newNode;
			size++;
			return; 
		}
 		CNode<T> curr = start;
		for (int i = 0; i < pos - 1; i++) {
			curr = curr.getNext();
		}
		newNode.setNext(curr.getNext());
		curr.setNext(newNode);
		size++;
	}
	public Comparable<T> remove(int pos) throws Exception{ 
		if (pos < 0 || pos >= size) { throw new IndexOutOfBoundsException(); }
		CNode<T> curr = start;
		Comparable<T> toRet;
		size--;
		if (pos == 0) {
			toRet = start.getElt();
			start = start.getNext();
			return toRet;
		} 
		for (int i = 0; i < pos - 1; i++) {
			curr = curr.getNext();
			System.out.println(curr + " " + i + " " + pos);
		}
		toRet = curr.getNext().getElt();
		curr.setNext(curr.getNext().getNext());
		return toRet;
	}
	
	public boolean remove(Comparable<T> o) { 
		if (this.find(o) == -1) {
			return false;
		}
		if (start.getElt().equals(o)) {
			start = start.getNext();
			size--;
			return true;
		}
		CNode<T> curr = start;
		CNode<T> prev = start;
		while (!(curr.getElt().equals(o))) {
			prev = curr;
			curr = curr.getNext();
		}
		prev.setNext(curr.getNext());
		size--;
		return true;
	}
	
	
	public void clear() {
		start = null;
		size = 0;
	}
	
	public void sort() {
		int numSwaps = 0;
		for (int i = 0; i < size; i++) {
			CNode<T> curr = start;
			for (int j = 0; j < size - 1; j++) {
				if (curr.getNext().getElt().compareTo((T) curr.getElt()) < 0) {
					Comparable<T> temp = curr.getElt();
					curr.setElt(curr.getNext().getElt());
					curr.getNext().setElt(temp);
					numSwaps++;
				}
				curr = curr.getNext();
			}
			if (numSwaps == 0) return;
			numSwaps = 0;
		}
		
	}
}
