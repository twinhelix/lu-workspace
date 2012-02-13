public class Node<T> {
	private String key;
	private T value;
	private Node<T> left;
	private Node<T> right;

	public Node(String key, T value) {
		this.key = key;
		this.value = value;
		left = null;
		right = null;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public Node<T> getLeft() {
		return left;
	}

	public void setLeft(Node<T> left) {
		this.left = left;
	}

	public Node<T> getRight() {
		return right;
	}

	public void setRight(Node<T> right) {
		this.right = right;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}

}