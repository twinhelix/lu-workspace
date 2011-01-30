/**
 * This class implements a Deck of playing cards using a min-heap to store the
 * cards. Complete implementations of the methods: size(), isEmpty(),
 * addToBottom(Card) and removeFromTop() have been provided and should not be
 * modified.
 * 
 * The developer should implement the two Deck shuffling operations: cut() and
 * riffleShuffle(Deck).
 */
public final class MinHeapDeck implements Deck {

	private final IMinHeap<HeapEntry<Card>> heap;

	public MinHeapDeck() {
		heap = new MinHeap<HeapEntry<Card>>();
	}

	public int size() {
		return heap.size();
	}

	public boolean isEmpty() {
		return heap.isEmpty();
	}

	public void addToBottom(Card card) {
		assert card != null : "Attempting to add 'null' to a MinHeapDeck";

		heap.add(new HeapEntry<Card>(card, size()));
	}

	public Card removeFromTop() {
		assert !isEmpty() : "Attempting to remove a card from an empty MinHeapDeck.";
		return heap.removeMin().getItem();
	}

	public Deck cut() {
		// TODO: TASK 2a: IMPLEMENTATION OF THIS METHOD
		Deck cutDeck = new MinHeapDeck();
		int half = size() / 2;
		for (int i = 0; i < half; i++)
			cutDeck.addToBottom(this.removeFromTop());
		return cutDeck;
	}

	// pre: currentDeck.size() == deck.size()
	public Deck riffleShuffle(Deck deck) {
		// TODO: TASK 2b: IMPLEMENTATION OF THIS METHOD
		Deck result = new MinHeapDeck();
		while (size() > 0 && deck.size() > 0) {
			result.addToBottom(this.removeFromTop());
			result.addToBottom(deck.removeFromTop());
		}
		return result;
	}

	@Override
	public String toString() {
		return heap.toString();
	}

}