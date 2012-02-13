package database;

public class BinarySearchTreeEntry<K extends Comparable<K>, V> implements
		DictionaryEntry<K, V> {
	/* Declare variables for Binary Tree nodes */
	private K key;
	private V value;
	private BinarySearchTreeEntry<K, V> leftTree;
	private BinarySearchTreeEntry<K, V> rightTree;

	/** Constructor */
	public BinarySearchTreeEntry(K key, V value) {
		this.key = key;
		this.value = value;
		this.leftTree = null;
		this.rightTree = null;
	}

	/* Getters and Setters */
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

	public BinarySearchTreeEntry<K, V> getLeftTree() {
		return leftTree;
	}

	public void setLeftTree(BinarySearchTreeEntry<K, V> leftTree) {
		this.leftTree = leftTree;
	}

	public BinarySearchTreeEntry<K, V> getRightTree() {
		return rightTree;
	}

	public void setRightTree(BinarySearchTreeEntry<K, V> rightTree) {
		this.rightTree = rightTree;
	}
}
