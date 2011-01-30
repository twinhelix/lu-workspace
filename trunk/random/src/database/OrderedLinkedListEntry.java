package database;

/** supporting class @ for ordered linked list implementation */
public class OrderedLinkedListEntry<K, V> implements DictionaryEntry<K, V> {
	private K NAME; // 'key'
	private V TINS; // 'value'
	private OrderedLinkedListEntry<K, V> next; // stores reference to next Node

	/** class contructors */
	public OrderedLinkedListEntry() {
	}

	public OrderedLinkedListEntry(K name, V tins) {
		NAME = name;
		TINS = tins;
	}

	// Accessors & Mutators //
	public K getKey() {
		return NAME;
	}

	public V getValue() {
		return TINS;
	}

	public void setName(K name) {
		this.NAME = name;
	}

	public void setFood(V tins) {
		this.TINS = tins;
	}

	public OrderedLinkedListEntry<K, V> getNext() {
		return next;
	}

	public void setNext(OrderedLinkedListEntry<K, V> next) {
		this.next = next;
	}
}
