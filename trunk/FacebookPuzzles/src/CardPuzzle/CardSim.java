package CardPuzzle;

public class CardSim {

	public CardSim() {
		int n = 100000000;
		int total = 0;
		for (int i = 0; i < n; i++) {
			if (check(getRandomArray()))
				total++;
		}
		System.out.println(total/n);
	}

	private int[] getRandomArray() {

		int[] cards = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 1, 2, 3, 4,
				5, 6, 7, 8, 9, 10, 11, 12, 13, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
				11, 12, 13, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13 };

		for (int i = 51; i >= 1; i--) {
			int j = (int) (Math.random() * i);
			int source = cards[i];
			cards[i] = cards[j];
			cards[j] = source;
		}
		return cards;
	}

	private boolean check(int[] cards) {
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j <= 13; j++) {
				if (cards[13 * i + j - 1] == j)
					return false;
			}
		}
		return true;

	}

	public static void main(String[] args) {

		new CardSim();
	}

}
