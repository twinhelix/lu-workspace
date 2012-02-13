import Heap.*;
import java.util.*;

public class RunMe {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		MaxHeap<String> bla = new MaxHeap<String>(10);
		String [] a = {"b", "a", "e", "c","d"};
		bla.arrayToHeap(a);
		a = bla.heapSort(5);
		System.out.println(a[0] + a[1] + a[2] + a[3] +a[4]);
		/*Iterator<TreeNode<String, String>> i = bla.iterator();
		while (i.hasNext()) {
			System.out.println(i.next().getKey());
		}*/
	}

}
