package OrderedList;

import java.util.Iterator;

public class OrderedList<K extends Comparable<K>, V> {
	private ListNode<K, V> head;
	private int size;

	public OrderedList() {
		head = null;
		size = 0;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int getSize() {
		return size;
	}

	public void put(K key, V value) {
		ListNode<K, V> newItem = new ListNode<K, V>(key, value);
		if (head == null) {
			head = new ListNode<K, V>(key, value);
		} else if (head.getKey().compareTo(key) > 0) {
			newItem.setNext(head);
			head = newItem;
		} else {
			ListNode<K, V> prev = findPrev(key);
			newItem.setNext(prev.getNext());
			prev.setNext(newItem);
		}
		size++;
	}

	public void delete(K key) {
		if (head.getKey().compareTo(key) > 0) {
			// Do nothing
		} else if (head.getKey().compareTo(key) == 0) {
			head = head.getNext();
			size--;
		} else {
			ListNode<K, V> prev = findPrev(key);
			prev.setNext(prev.getNext().getNext());
			size--;
		}
	}

	public V get(K key) {
		if (head == null)
			return null;
		else {
			ListNode<K, V> curr = head;
			while (curr != null && curr.getKey().compareTo(key) < 0)
				curr = curr.getNext();
			if (curr != null && curr.getKey().compareTo(key) == 0)
				return curr.getValue();
			return null;
		}
	}

	private ListNode<K, V> findPrev(K key) {
		ListNode<K, V> prev = head;
		if (prev != null && prev.getKey().compareTo(key) < 0) {
			ListNode<K, V> curr = prev.getNext();

			while (curr != null && curr.getKey().compareTo(key) <= 0) {
				prev = curr;
				curr = curr.getNext();
			}
		}
		return prev;
	}

	public Iterator<ListNode<K, V>> iterator() {
		return new ListIterator();
	}

	private class ListIterator implements Iterator<ListNode<K, V>> {
		ListNode<K, V> curr;

		public ListIterator() {
			curr = head;
		}

		public boolean hasNext() {
			return curr != null;
		}

		public ListNode<K, V> next() {
			ListNode<K, V> ret = curr;
			curr = curr.getNext();
			return ret;
		}

		public void remove() {
		}

	}

}
