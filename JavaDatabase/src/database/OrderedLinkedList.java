/*
 *  TEST RUNS FOR OrderedLinkedList:
 *	load 10			benchmark: 5.5
 *	load 100		benchmark: 50.5
 *	load 1000		benchmark: 500.5
 *	load 10000		benchmark: 5000.5
 */

package database;

import java.util.*;

public class OrderedLinkedList<K extends Comparable<K>, V> implements
		Dictionary<K, V> {
	/* Declare variables for Linked List */
	private OrderedLinkedListEntry<K, V> head;
	private int size;

	/** Constructor */
	public OrderedLinkedList() {
		head = null;
		size = 0;
	}

	/**
	 * Search item by iterating through whole list from the first node using a
	 * while loop, the returns value if found.
	 */
	public V get(K key) {
		V food = null;
		OrderedLinkedListEntry<K, V> temp = head;

		while (temp != null && temp.getKey().compareTo(key) > 0) {
			temp = temp.getNext();
		}
		if (temp != null)
			food = temp.getValue();
		else
			throw new NoSuchElementException();
		return food;
	}

	/**
	 * Puts a node in its ordered position according to its given key. If list
	 * is empty just puts node at the front, else uses a while loop to find its
	 * position, then sets its next node to the previous nodes next node and
	 * changes the next node for the previous node to the new node
	 */
	public void put(K key, V value) {

		OrderedLinkedListEntry<K, V> newNode = new OrderedLinkedListEntry<K, V>(
				key, value);
		OrderedLinkedListEntry<K, V> temp = head;
		if (head == null) {
			head = newNode;
		} else if (key.compareTo(head.getKey()) < 0) {
			newNode.setNext(head);
			head = newNode;
		} else {
			while (temp.getNext() != null) {
				if (temp.getNext().getKey().compareTo(key) < 0)
					temp = temp.getNext();
				else
					break;
			}
			newNode.setNext(temp.getNext());
			temp.setNext(newNode);
		}
		size++;
	}

	/**
	 * Finds node to remove, then sets the next node of its previous node to the
	 * delete items next node
	 */
	public void remove(K key) {
		if (head == null) {
			// No checks needed
		} else if (head.getKey().compareTo(key) == 0) {
			head = head.getNext();
			size--;
		} else {

			OrderedLinkedListEntry<K, V> temp = head;
			while (temp.getNext() != null
					&& temp.getNext().getKey().compareTo(key) != 0) {
				temp = temp.getNext();
			}
			if (temp.getNext().getKey().compareTo(key) == 0) {
				temp.setNext(temp.getNext().getNext());
				size--;
			}
		}
	}

	/** Clears list */
	public void clear() {
		head = null;
		size = 0;
	}

	/** Checks if list is empty by looking at the head */
	public boolean isEmpty() {
		return head == null;
	}

	/** Returns the size of the list */
	public int size() {
		return size;
	}

	/** Returns the iterator for the ordered linked list */
	public Iterator<DictionaryEntry<K, V>> iterator() {
		return new NodeIterater();
	}

	/** Creates an iterator for the ordered linked list */
	private class NodeIterater implements Iterator<DictionaryEntry<K, V>> {
		/* Declare variables for Iterator */
		OrderedLinkedListEntry<K, V> pointer = head;

		/** Checks if list has more items in it */
		public boolean hasNext() {
			return pointer != null;
		}

		/**
		 * Returns the next node in the ordered linked list, and moves the
		 * pointer forward
		 */
		public OrderedLinkedListEntry<K, V> next() {

			OrderedLinkedListEntry<K, V> ret = pointer;

			pointer = pointer.getNext();

			return ret;
		}

		/** Remove method not implemented */
		public void remove() {
			// No need to implement method
		}
	}
}
