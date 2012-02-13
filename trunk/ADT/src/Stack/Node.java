package Stack;

public class Node<T> {
	private T item;
	private Node<T> above;

	public Node(T item) {
		this.item = item;
		this.above = null;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public Node<T> getAbove() {
		return above;
	}

	public void setAbove(Node<T> above) {
		this.above = above;
	}

}
