/**
 * This class implements a min-heap abstract data type (as described by the
 * generic interface IMinHeap<T extends Comparable<T>>) using a fixed array of
 * size MinHeap.MAXIMUM_HEAP_SIZE.
 */
public class MinHeap<T extends Comparable<T>> implements IMinHeap<T> {
	private T[] heap;

	private static final int MAX_HEAP = 52;

	private int size;

	@SuppressWarnings("unchecked")
	public MinHeap() {
		heap = (T[]) new Comparable[MAX_HEAP];
		size = 0;
	}

	public void add(T element) throws HeapException {
		if (size == MAX_HEAP)
			throw new HeapException("No more space on heap");
		else {

			heap[size] = element;
			trickle(size);
			size++;
		}
	}

	public T getMin() {
		return heap[0];
	}

	public boolean isEmpty() {
		return heap[0]==null;
	}

	public T removeMin() {
		T ret = null;
		if (size != 0) {
			ret = heap[0];
			heap[0] = heap[size - 1];
			size--;
			rebuild(0);
		}
		return ret;
	}

	public int size() {
		return size;
	}

	private void rebuild(int pos) {

		if (!isLeaf(pos)) {
			int child = 2 * pos + 1;
			if (child + 1 < size) {
				if (heap[child].compareTo(heap[child + 1]) > 0)
					child++;
			}

			if (heap[pos].compareTo(heap[child]) > 0) {
				T temp = heap[pos];
				heap[pos] = heap[child];
				heap[child] = temp;
				rebuild(child);
			}
		}
	}

	private boolean isLeaf(int pos) {
		return pos * 2 + 1 > size;

	}

	private void trickle(int pos) {

		int parent = (pos - 1) / 2;

		if (heap[parent].compareTo(heap[pos]) > 0) {
			T temp = heap[pos];
			heap[pos] = heap[parent];
			heap[parent] = temp;

		}
		if (parent != 0)
			trickle(parent);
	}
}