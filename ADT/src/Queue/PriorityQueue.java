package Queue;

import java.util.*;

;

public class PriorityQueue<T> {
	private Node<T> first;
	private Node<T> last;
	private int size;

	public PriorityQueue() {
		first = null;
		last = null;
		size = 0;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int getSize() {
		return size;
	}

	public void enqueue(int priority, T item) {
		Node<T> newItem = new Node<T>(priority, item);
		if (first == null) {
			first = newItem;
			last = first;
			size++;
		} else if (first.getPriority() > priority) {
			newItem.setNext(first);
			first = newItem;
			size++;
		} else {
			Node<T> prev = findPrev(priority);
			newItem.setNext(prev.getNext());
			prev.setNext(newItem);
			size++;
		}
		if (newItem.getNext() == null)
			last = newItem;
	}

	public T dequeue() {
		
		T ret = null;
		if (!isEmpty()) {
			ret = first.getItem();
			first = first.getNext();
			size--;
		}
		return ret;
	}

	public T getFront() {
		if (!isEmpty())
			return first.getItem();
		else
			return null;
	}

	public T getBack() {
		if (!isEmpty())
			return last.getItem();
		else
			return null;
	}

	private Node<T> findPrev(int priority) {
		Node<T> prev = first;
		if (prev != null && prev.getPriority() < priority) {
			Node<T> current = prev.getNext();
			while (current != null && current.getPriority() <= priority) {
				prev = current;
				current = current.getNext();
			}
		}
		return prev;
	}

	public Iterator<Node<T>> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<Node<T>> {

		Node<T> pointer;

		public QueueIterator() {
			pointer = first;
		}

		public boolean hasNext() {
			return pointer != null;
		}

		public Node<T> next() {
			Node<T> result = pointer;
			pointer = pointer.getNext();
			return result;
		}

		public void remove() {
			// TODO Auto-generated method stub

		}

	}

}
