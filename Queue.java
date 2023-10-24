
public interface Queue<T> {
	void enqueue(T o);
	T dequeue();
	T peek();
}
