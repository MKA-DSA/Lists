
public class LinkedList<T> implements List<T>{
	
	private CNode<T> head;
	private int size;
	
	public LinkedList() {
		head = null;
		size = 0;
	}
	
	public boolean set(Comparable<T> o, int pos) {
		if (pos >= size) return false;
		CNode<T> curr = head;
		for (int i = 0; i< pos; i++) {
			curr = curr.getNext();
		}
		curr.setElt(o);
		return true;
	}
	
	public Comparable<T> get(int pos) throws Exception{
		if (pos >= size) {
			throw new IndexOutOfBoundsException();
		}
		CNode<T> curr = head;
		for (int i = 0; i< pos; i++) {
			curr = curr.getNext();
		}
		return curr.getElt();
	}
	public void add(Comparable<T> o) {
		CNode<T> n = new CNode<T>(o);
		if(head == null) {
			head = n;
		}
		else {
			CNode<T> curr = head;
			for (int i = 0; i < size-1; i++) {
				curr = curr.getNext();
			}
			curr.setNext(n);
		}
		size++;
	}
	public void insert(Comparable<T> o, int pos) throws Exception{
		if (pos > size) {
			throw new IndexOutOfBoundsException();
		}
		
		CNode<T> n = new CNode<T>(o);
		if (pos == 0) {
			n.setNext(head);
			head = n;
		}
		else {
			CNode<T> curr = head;
			for (int i = 0; i < pos-1; i++) {
				curr = curr.getNext();
			}
			
			n.setNext(curr.getNext());
			curr.setNext(n);
		}
		size++;
	}
	public Comparable<T> remove(int pos) throws Exception{ 
		if (pos >= size) {
			throw new IndexOutOfBoundsException();
		}
		if (pos == 0) {
			Comparable<T> toReturn = head.getElt();
			head = head.getNext();
			size--;
			return toReturn;
		}
		
		CNode<T> curr = head;
		for (int i = 0; i < pos-1; i++) {
			curr = curr.getNext();
		}
		Comparable<T> thing = curr.getNext().getElt();
		curr.setNext(curr.getNext().getNext());
		size--;
		return thing;
	}
	
	public boolean remove(Comparable<T> o) { 
		/* int pos = this.find(o);
		 * if (pos == -1) return false;
		 * this.remove(pos);
		 * return true;
		 */
		CNode<T> curr = head;
		int i = 0;
		if (o.equals(head.getElt())) {
			head = head.getNext();
			return true;
		}
		while (i < size-1 && !curr.getNext().getElt().equals(o)) {
			curr = curr.getNext();
			i++;
		}
		if (i == size-1) return false;
		curr.setNext(curr.getNext().getNext());
		size--;
		return true;
	}
	
	public int find(Comparable<T> o) {
		CNode<T> curr = head;
		for (int i = 0; i< size; i++) {
			if (curr.getElt().equals(o)) {
				return i;
			}
			curr = curr.getNext();
			
		}
		return -1;
	}
	
	public int length() {
		return size;
	}
	public String toString() {
		String s = "";
		CNode<T> curr = head;
		for (int i = 0; i< size; i++) {
			s += curr.toString() + " ";
			curr = curr.getNext();
		}
		return s;
	}
	
	public void clear() {
		head = null;
		size = 0;
	}
	
	public void sort() {
		
	}
	
	public static void main(String[] args) {
		LinkedList<Integer> ll = new LinkedList<Integer>();
		for (int i = 2; i < 10; i++) {
			ll.add(i);
		}
		System.out.println(ll);
		System.out.println(ll.find(7));
		System.out.println(ll.set(11, 4));
		System.out.println(ll.set(12, 15));
		System.out.println(ll);
		try {
			ll.insert(45, 5); 
			System.out.println(ll.remove(0));
			System.out.println(ll.remove((Integer)7));

		} catch(Exception E) { System.out.println(E); }
		
		System.out.println(ll);
		
	}

}
