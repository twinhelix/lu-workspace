import java.util.Random;

public class AutoPlayer extends AbstractPlayer {

	AutoPlayer(CardPile left, CardPile right, String name) {
		super(right, left, name);
	}

	// TODO: TASK 3: IMPLEMENTATION OF THIS SUB-CLASS
	protected int selectCard() {
		
		int result = 0;
		boolean[] tally = findmax();
		boolean found = false;
		while (!found) {
			Random rdm = new Random();
			result = rdm.nextInt(HANDSIZE);
			if (!tally[result])
				found = true;
		}
		return result;
	}

	private boolean[] findmax() {
		boolean[] tally = new boolean[cards.length];
		for (int i = 0; i < cards.length; i++) {
			for (int j = i + 1; j < cards.length; j++) {
				if (cards[i].getRank().compareTo(cards[j].getRank())==0) {
					tally[i] = true;
					tally[j] = true;
				}
			}
		}
		boolean allTrue = true;
		for (int i = 0; i < tally.length; i++) {
			allTrue = allTrue && tally[i];
		}
		if (allTrue) tally = new boolean[cards.length];
		return tally;
	}
}