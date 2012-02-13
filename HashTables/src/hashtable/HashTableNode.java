package hashtable;

public class HashTableNode<T extends Comparable<T>> {
	private T item;
	private HashTableNode<T> left;
	private HashTableNode<T> right;

	public HashTableNode(T item) {
		super();
		this.item = item;
		this.left = null;
		this.right = null;
	}

	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}

	public HashTableNode<T> getLeft() {
		return left;
	}

	public void setLeft(HashTableNode<T> left) {
		this.left = left;
	}

	public HashTableNode<T> getRight() {
		return right;
	}

	public void setRight(HashTableNode<T> right) {
		this.right = right;
	}

}
