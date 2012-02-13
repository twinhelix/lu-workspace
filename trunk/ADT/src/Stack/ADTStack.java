package Stack;

import java.util.*;

public class ADTStack<T> {
	private Node<T> top;
	int size;

	public ADTStack() {
		top = null;
		size = 0;
	}

	public void push(T item) {
		Node<T> newItem = new Node<T>(item);
		newItem.setAbove(top);
		top = newItem;
		size++;
	}

	public boolean isEmpty() {
		return top == null;
	}

	public T peek() {
		return top.getItem();
	}

	public void pop() {
		top = top.getAbove();
		size--;
	}

	public Iterator<Node<T>> iterator() {
		return new StackIterator();
	}

	private class StackIterator implements Iterator<Node<T>> {
		Node<T> pointer;

		public StackIterator(){
			pointer = top;
		}

		public boolean hasNext() {
			return pointer!=null;
		}

		public Node<T> next() {
			Node<T> result = pointer;
			pointer = pointer.getAbove();
			return result;
		}

		public void remove() {
			// TODO Auto-generated method stub

		}

	}

}
