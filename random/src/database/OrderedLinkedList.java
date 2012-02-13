package database;

import java.util.*;

/** an ordered singly linked list implementation */
public class OrderedLinkedList<K extends Comparable<K>, V> implements
		Dictionary<K, V> {
	private int SIZE = 0; // stores size of the list
	/*
	 * stores references to first and last added element; current used for loop
	 * iteratons
	 */
	private OrderedLinkedListEntry<K, V> firstElement, currentElement, current;

	/** empty class constructor */
	public OrderedLinkedList() {
	}

	/**
	 * returns the size of the current list
	 */
	public int size() {
		return SIZE;
	}

	/**
	 * clears the Ordered Linked List by setting element to null
	 */
	public void clear() {
		firstElement = null;
		currentElement = null;
		SIZE = 0;
	}

	/**
	 * returns boolean indicating if list is empty
	 */
	public boolean isEmpty() {
		return firstElement == null;
	}

	/**
	 * returns value associated with the given key
	 */
	public V get(K key) {
		current = firstElement;
		while (current != null) {
			if (current.getKey().equals(key)) {
				return current.getValue();
			}
			// advance to next element to check
			current = current.getNext();
		}

		return null; // no match found!
	}

	/**
	 * inserts new key/value pair into current list
	 */
	public void put(K key, V value) {
		// create a new entry
		OrderedLinkedListEntry<K, V> newEntry = new OrderedLinkedListEntry<K, V>(
				key, value);
		if (SIZE < 1) {
			// sets newEntry as only element in ordered linked list
			firstElement = newEntry;
			currentElement = firstElement;
		} else { // SIZE >= 1
			// newEntry <= firstElement = insert @ front
			if (key.compareTo(firstElement.getKey()) < 1) {
				newEntry.setNext(firstElement);
				firstElement = newEntry;
			} else { // newEntry > firstElement
				/* sorting code - in ascending order by key */
				boolean added = false;
				current = firstElement;
				while (current.getNext() != null) {
					if (key.compareTo(current.getNext().getKey()) < 1) {
						// insert newEntry before current
						newEntry.setNext(current.getNext());
						current.setNext(newEntry);
						added = true;
						break;
					}
					// advance to next element
					current = current.getNext();
				}
				/* ////////////// */
				if (!added) {
					// newEntry > all elements in current list = insert @ end
					// sets current element's next to newEntry
					currentElement.setNext(newEntry);

					// progress 1 element forward
					currentElement = newEntry;
				}
			}
		}

		// increment SIZE
		SIZE++;
	}

	/**
	 * removes the reference of a particular element matching key from the list
	 */
	public void remove(K key) {
		if (SIZE < 1) {
			// do nothing
			return;
		} else if (SIZE == 1) {
			if (firstElement.getKey().equals(key)) {
				clear();
				SIZE = 0; // no elements left in the list
			}
			return;
		} else // SIZE > 1
		{
			if (firstElement.getKey().equals(key)) {
				// set reference to second element in the list
				firstElement = firstElement.getNext();
				SIZE--;
			}

			// check from second element subsequently
			current = firstElement;
			while (current.getNext() != null) {
				if (current.getNext().getKey().equals(key)) {
					current.setNext(current.getNext().getNext());
					SIZE--;
				}
				// advance to next element to check
				current = current.getNext();
			}
		}
	}

	/** custom Iterator inner class implementing the Iterator pattern */
	private class OrderedLinkedListIterator implements
			Iterator<DictionaryEntry<K, V>> {
		private OrderedLinkedListEntry<K, V> element;

		/** class constructor */
		public OrderedLinkedListIterator() {
			// start stepping through the array from the beginning
			element = firstElement;
		}

		/** check if a current element is the last in collection */
		public boolean hasNext() {
			return element != null;
		}

		/** gets next element in the list */
		public OrderedLinkedListEntry<K, V> next() {
			// get current element's value
			OrderedLinkedListEntry<K, V> value = element;

			// advance by 1 element
			element = element.getNext();

			return value;
		}

		/** removes the element at the front of the list */
		public void remove() {
			firstElement = firstElement.getNext();

			// decrement SIZE
			SIZE--;
		}
	}

	/** @returns an Iterator for this class */
	public Iterator<DictionaryEntry<K, V>> iterator() {
		return new OrderedLinkedListIterator();
	}
}
