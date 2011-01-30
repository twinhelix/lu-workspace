package Tree;

public class TreeNode<K extends Comparable<K>, V> {
	private K key;
	private V value;
	private TreeNode<K, V> left;
	private TreeNode<K, V> right;

	public TreeNode(K key, V value) {
		super();
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}

	public TreeNode<K, V> getLeft() {
		return left;
	}

	public void setLeft(TreeNode<K, V> left) {
		this.left = left;
	}

	public TreeNode<K, V> getRight() {
		return right;
	}

	public void setRight(TreeNode<K, V> right) {
		this.right = right;
	}

}
