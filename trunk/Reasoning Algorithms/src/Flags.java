enum Col {
	Red, White, Blue
}

enum Dir {
	Up, Down
}

public class Flags {

	public static void main(String[] args) {
		new Flags();
	}

	public Flags() {
		Col a[] = { Col.Red, Col.White, Col.Red, Col.White, Col.White };
		restore2(a);
		print(a);
		System.err.println();
		Col b[] = { Col.Red, Col.Blue, Col.Blue, Col.White, Col.Red, Col.White,
				Col.White };
		restore3(b);
		print(b);

	}

	public void swap(Col[] a, int i, int j) {
		Col temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	public void print(Col[] a) {
		for (int i = 0; i < a.length; i++) {
			System.err.println(a[i]);
		}
	}

	public void restore(Col[] a) {
		int pink = 0;
		int red = a.length;
		while (pink < red) {
			switch (a[pink]) {
			case White:
				pink++;
				break;
			case Red:
				swap(a, pink, red - 1);
				red--;
				break;
			}
		}
	}

	public void restore2(Col[] a) {
		Col store = a[0];
		int left = 0;
		int right = a.length - 1;
		Dir d = Dir.Down;

		while (left < right) {
			switch (d) {
			case Up:
				if (a[left] == Col.White)
					left++;
				else {
					a[right] = a[left];
					right--;
					d = Dir.Down;
				}
				break;
			case Down:
				if (a[right] == Col.Red)
					right--;
				else {
					a[left] = a[right];
					left++;
					d = Dir.Up;
				}
				break;

			}
		}

		a[left] = store;

	}

	public void restore3(Col[] a) {
		int ws = 0;
		int gs = 0;
		int bs = a.length;
		while (gs < bs) {
			switch (a[gs]) {
			case Red:
				swap(a, gs, ws);
				
				ws++;gs++;
				break;
			case White:
				
				gs++;
				break;
			case Blue:
				swap(a, gs, bs-1); bs--;
				break;
			}
		}

	}
}
