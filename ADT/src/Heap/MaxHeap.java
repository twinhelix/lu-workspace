package Heap;

import com.sun.xml.internal.ws.handler.HandlerException;

public class MaxHeap<T extends Comparable<T>> {
	private T[] heap;
	private int last;
	private int size;

	@SuppressWarnings("unchecked")
	public MaxHeap(int size) {
		this.size = size;
		this.last = 0;
		heap = (T[]) new Comparable[size];
	}

	public boolean isEmpty() {
		return last == 0;
	}

	public int getSize() {
		return size;
	}

	public T getMax() {
		T root = null;
		if (!isEmpty())
			root = heap[0];
		return root;
	}

	public void add(T newItem) throws HandlerException {
		heap[last] = newItem;
		rebuildUp(last);
		last++;
	}

	public T removeMax() {
		T root = heap[0];
		heap[0] = heap[last - 1];
		last--;
		heapRebuild(0);
		return root;
	}

	private void heapRebuild(int root) {

		if (last > root * 2 + 1) {
			int child = root * 2 + 1;
			if (last > child + 1) {
				int rightChild = child + 1;

				if (heap[rightChild].compareTo(heap[child]) > 0)
					child = rightChild;
			}
			if (heap[root].compareTo(heap[child]) < 0) {
				swap(child, root);
				heapRebuild(child);
			}

		}
	}

	private void rebuildUp(int node) {
		int parent = (node - 1) / 2;
		if (heap[parent].compareTo(heap[node]) < 0) {
			swap(parent, node);
			rebuildUp(parent);
		}
	}

	private void swap(int fst, int sec) {
		T temp = heap[fst];
		heap[fst] = heap[sec];
		heap[sec] = temp;
	}

	public void arrayToHeap(T[] array) {
		heap = array.clone();
		last = array.length;
		for (int i = last - 1; i >= 0; i--) {
			heapRebuild(i);
		}
	}

	public T[] heapSort(int n) {

		int lastIndex = n - 1;
		for (int i = 0; i < n; i++) {
			swap(0, lastIndex);
			lastIndex--;
			heapRebuild(0);
		}
		return heap;
	}
}
