package OrderedList;

public class ListNode <K extends Comparable<K>, V>{
	private K key;
	private V value;
	private ListNode<K,V> next;

	public ListNode (K key,	V value){
		this.key = key;
		this.value = value;
		this.next = null;
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

	public ListNode<K, V> getNext() {
		return next;
	}

	public void setNext(ListNode<K, V> next) {
		this.next = next;
	}
		
}
