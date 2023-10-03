
public interface List<T> {
	Comparable<T> get(int pos) throws Exception;
	int find(Comparable<T> o);
	int length();
	String toString();
	
	boolean set(Comparable<T> o, int pos);
	void add(Comparable<T> o);
	void insert(Comparable<T> o, int pos) throws Exception;
	Comparable<T> remove(int pos) throws Exception; 
	boolean remove(Comparable<T> o);
	void clear();
	void sort();
}
