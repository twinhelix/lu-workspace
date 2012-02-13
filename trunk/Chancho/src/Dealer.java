import java.util.*;

/**
 * The class Dealer encapsulates the actions of a Chancho game-dealer. The game
 * dealer is responsible for dealing cards from the provided game-deck to each
 * player, and scheduling rounds of the game until a player has won the game.
 * All players who have declared themselves as a winner should be congratulated.
 * 
 * Developers should provide the constructor,
 * 
 * public Dealer(Set<Player> players, Deck gameDeck);
 * 
 */
public final class Dealer {
	private Set<Player> players;

	public Dealer(Set<Player> players, Deck gameDeck) {
		this.players = players;
		for (int i = 0; i < 4; i++) {
			for (Player p : players)
				p.addToHand(gameDeck.removeFromTop());
		}
	}

	public void playGame() {
		while (!haveWinner()) {

			for (Player p : players) {
				p.discard();

			}

			for (Player p : players) {
				p.pickup();
			}
		}
		congratulateWinners();
	}

	private boolean haveWinner() {
		for (Player p : players) {
			if (p.hasWon())
				return true;
		}
		return false;
	}

	private void congratulateWinners() {
		System.out.println("The game has been won! Congratulations to:");
		for (Player p : players) {
			if (p.hasWon()) {
				System.out.println(p.toString());
			}
		}
	}

	// TODO: TASK 4: IMPLEMENTATION OF THIS CLASS

}