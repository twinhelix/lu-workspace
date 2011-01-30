public class Quiksort {
	public static void main(String[] args) {
		new Quiksort();
	}

	public Quiksort() {
		int [] a = {1,3,5,2,5,62,4,68,6,34,5};
		quickSort(a,2,a.length);
		print(a);
	}

	private int partition(int[] a, int start, int rest, int k) {
		while (start < rest) {
			if (a[start] >= k) {
				swap (a, start, rest-1);
				rest--;
			} else
				start++;
		}
		return start;
	}

	public void swap(int[] a, int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private void quickSort (int[] a, int start, int rest){
		int red;
		if (start < rest-1) {
			red = partition(a,start+1,rest,a[start]);
			swap (a,start,red-1);
			quickSort(a,start,red-1);
			quickSort(a,red,rest);
		}
	}
	public void print(int[] a) {
		for (int i = 0; i < a.length; i++) {
			System.err.println(a[i]);
		}
	}
}
