package Queue;

public class Node <T>{
	private int priority;
	private T item;
	private Node<T> next;
	
	public Node (int priority, T item){
		this.priority = priority;
		this.item = item;
		next = null;
	}
	
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public T getItem() {
		return item;
	}
	public void setItem(T item) {
		this.item = item;
	}
	public Node<T> getNext() {
		return next;
	}
	public void setNext(Node<T> next) {
		this.next = next;
	}
	
	
	
}
