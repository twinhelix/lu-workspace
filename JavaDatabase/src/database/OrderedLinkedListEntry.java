package database;

public class OrderedLinkedListEntry<K extends Comparable<K>, V> implements
		DictionaryEntry<K, V> {
	/* Declare variables for Ordered Linked List */
	private K key;
	private V value;
	private OrderedLinkedListEntry<K, V> nextNode;

	/** Constructor */
	public OrderedLinkedListEntry(K name, V tins) {
		this.key = name;
		this.value = tins;
		this.nextNode = null;
	}

	/* Getters and Setters */
	public K getKey() {
		return key;
	}

	public void setKey(K name) {
		this.key = name;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V tins) {
		this.value = tins;
	}

	public OrderedLinkedListEntry<K, V> getNext() {
		return nextNode;
	}

	public void setNext(OrderedLinkedListEntry<K, V> nextNode) {
		this.nextNode = nextNode;
	}
}
