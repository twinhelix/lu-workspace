import uk.ac.imperial.doc.kenya.nio.KenyaNIO;

public class Owari {

	static final int numberOfBowls = 12;

	static final int numberOfStones = 4;

	static final int totalNumberOfStones = 48;

	static final int winningNumber = 24;

	static final int bowlsOnOneSide = 6;

	public static void main(String[] args) {
		main();
	}

	static int[] initialiseBoard(int[] board) {
		// Assigns values to all bowls on the board using a loop.
		int i;
		for (i = 0; i < numberOfBowls; i++) {
			board[i] = numberOfStones;
		}
		return board;
	}

	static int getMove() {
		// Reads in input of move by the user.
		int move = KenyaNIO.get().readInt();
		return move;
	}

	static void putMove(int player, int bowlChosen) {
		// Displays the last move made.
		System.out.println("Player: " + player + " has chosen bowl "
				+ bowlChosen + "\n");
	}

	static void displayScoreAndBoard(int[] board, int[] player) {
		// Method used to display the board of bowls and number of stones in
		// them.
		int i;
		System.out.println("Player 2: " + player[1] + " stones taken");
		System.out.println("");

		for (i = numberOfBowls; i > numberOfBowls / 2; i--) {
			System.out.print("  " + i + "\t");
		}
		System.out.println("");

		for (i = numberOfBowls - 1; i >= numberOfBowls / 2; i--) {
			System.out.print("( " + board[i] + " )\t");
		}
		System.out.println("");
		System.out.println("");

		for (i = 0; i < numberOfBowls / 2; i++) {
			System.out.print("( " + board[i] + " )\t");
		}
		System.out.println("");

		for (i = 1; i <= numberOfBowls / 2; i++) {
			System.out.print("  " + i + "\t");
		}
		System.out.println("");
		System.out.println("");
		System.out.println("Player 1: " + player[0] + " stones taken");
	}

	static void playGame(int[] human) {
		// Calls all the functions that run the game.
		// Creates board and initialises it.
		int[] thisBoard = new int[numberOfBowls];
		thisBoard = initialiseBoard(thisBoard);
		// Sets up players bowl with 0 stones.
		int[] player = { 0, 0 };
		int[] taken = { 0, 0 };
		// Calls display method to show the board.
		displayScoreAndBoard(thisBoard, player);
		int move;
		int playerTurn = 1;
		int noTaken = 0;
		boolean testMove;
		String name;
		// While loop used to test that no one has won yet, else game will
		// terminate.
		do {
			// Works out what player the computer is.
			int ai = human[playerTurn - 1];
			if (ai != 0) {
				name = "Player " + ai;
			} else {
				name = "Computer " + playerTurn;
			}
			// Tests to see if the current player can make a move, if not, skips
			// current player's turn.
			if (canMove(playerTurn, thisBoard)) {
				// While loop to test that the current player has made a valid
				// move.
				do {
					if (ai != 0) {
						System.out.print("\n" + name + "'s move: ");
						move = getMove();
					} else
						move = compuMove(playerTurn, thisBoard,
								player[playerTurn - 1]);
					// System.out.println(move);
					testMove = possibleMove(playerTurn, thisBoard, move);
					if (!testMove)
						System.out.println("Invalid move, try again.");
				} while (!testMove);
				putMove(playerTurn, move);
				thisBoard = processMoves(move, thisBoard, playerTurn, player);
				displayScoreAndBoard(thisBoard, player);
			} else
				System.out.println(name
						+ " can not move and will skip this turn");
			// Checks that a player has taken a stone within the last 50 moves.
			if (taken[0] == player[0] && taken[1] == player[1])
				noTaken++;
			else {
				taken[0] = player[0];
				taken[1] = player[1];
				noTaken = 0;
			}
			// playerTurn works out the player number.
			playerTurn = playerTurn % 2 + 1;
		} while (!testWin(player) && noTaken < 50);
		// When while loop ends when a player has won or no stones have been
		// take after 50 moves.
		if (testWin(player))
			System.out.println("Congratulations! " + name
					+ " has won the game.");
		else
			System.out
					.println("50 turns have gone passed without any stones being collected, it is a draw.");
	}

	static boolean canMove(int player, int[] thisBoard) {
		// Boolean function to test that a player can make a move: must have
		// stones in current player's bowls.
		boolean canmove = false;
		if (player == 1) {
			for (int i = 0; i < bowlsOnOneSide; i++) {
				if (thisBoard[i] != 0)
					canmove = true;
			}
		} else {
			for (int j = bowlsOnOneSide; j < numberOfBowls; j++) {
				if (thisBoard[j] != 0)
					canmove = true;
			}
		}
		return canmove;
	}

	static boolean possibleMove(int player, int[] thisBoard, int move) {
		// Boolean function to test that a move is valid: move must in current
		// player's side and have at least one stone in it.
		boolean posMove = false;
		if (player == 1) {
			if (move >= 1 && move <= bowlsOnOneSide && thisBoard[move - 1] != 0)
				posMove = true;
		} else {
			if (move >= bowlsOnOneSide + 1 && move <= numberOfBowls
					&& thisBoard[move - 1] != 0)
				posMove = true;
		}
		return posMove;
	}

	static boolean testWin(int[] player) {
		// Returns whether or not a player has won.
		return (player[0] >= winningNumber || player[1] >= winningNumber);
	}

	static int[] processMoves(int move, int[] thisBoard, int playerTurn,
			int[] player) {
		// For loop to drop all stones from selected bowl into bowls following
		// it, 1 in each bowl.
		int stones = thisBoard[move - 1];
		thisBoard[move - 1] = 0;
		boolean[] oneStones = new boolean[numberOfBowls];
		for (int i = 0; i < stones; i++) {
			int nextBowl = (move + i) % numberOfBowls;
			// if statement that checks if there is just 1 stone in that bowl.
			// Saves the bowl number in a boolean array to be processed later.
			if (thisBoard[nextBowl] == 1)
				oneStones[nextBowl] = true;
			thisBoard[nextBowl]++;
		}
		// Loop that empties all the stones in those bowls into the current
		// players collected bowl.
		for (int i = 0; i < numberOfBowls; i++) {
			if (oneStones[i] && thisBoard[i] >= 2) {
				player[playerTurn - 1] = player[playerTurn - 1] + thisBoard[i];
				thisBoard[i] = 0;
			}
		}
		// Empties chosen bowl and displays the updated board.
		return thisBoard;
	}

	static int compuMove(int player, int[] thisBoard, int score) {

		int[] possibleScores = new int[bowlsOnOneSide];
		for (int i = 1; i <= bowlsOnOneSide; i++) {
			if (possibleMove(player, thisBoard, (player - 1) * 6 + i))
				possibleScores[i - 1] = calculateMove((player - 1) * 6 + i,
						thisBoard, score);
			// System.out.println(possibleScores[i - 1] + " " + score);
		}

		int move = (player - 1) * 6 + 1;
		int maxScore = possibleScores[0];
		for (int i = 0; i < bowlsOnOneSide; i++) {
			if (possibleScores[i] > maxScore) {
				maxScore = possibleScores[i];
				move = (player - 1) * 6 + 1 + i;
			}
		}
		// System.out.println(move);
		return move;
	}

	static int calculateMove(int move, int[] thisBoard, int score) {
		int[] tempBoard = new int[numberOfBowls];
		for (int i = 0; i < numberOfBowls; i++)
			tempBoard[i] = thisBoard[i];

		int stones = tempBoard[move - 1];
		tempBoard[move - 1] = 0;
		boolean[] oneStones = new boolean[numberOfBowls];
		// For loop to drop all stones from selected bowl into bowls following
		// it, 1 in each bowl.
		for (int i = 0; i < stones; i++) {
			int nextBowl = (move + i) % numberOfBowls;
			// if statement that checks if there is just 1 stone in that bowl.
			// Saves the bowl number in a boolean array to be processed later.
			if (tempBoard[nextBowl] == 1)
				oneStones[nextBowl] = true;
			tempBoard[nextBowl]++;
		}
		// Loop that empties all the stones in those bowls into the current
		// players collected bowl.
		for (int i = 0; i < numberOfBowls; i++) {
			if (oneStones[i] && tempBoard[i] >= 2) {
				score = score + tempBoard[i];
				// thisBoard[i] = 0;
			}
		}
		// Empties chosen bowl and displays the updated board.
		return score;
	}

	static void main() {
		System.out
				.println("Owari:\n1. Player vs. Player\n2. Player 1 vs. "
						+ "Computer\n3. Computer vs. Player 2\n4. Computer vs. Computer");
		boolean valid = false;
		do {
			int choice = KenyaNIO.get().readInt();
			int[] play = new int[2];

			switch (choice) {
			case 1:
				play[0] = 1;
				play[1] = 2;
				playGame(play);
				valid = true;
				break;
			case 2:
				play[0] = 1;
				play[1] = 0;
				playGame(play);
				valid = true;
				break;
			case 3:
				play[0] = 0;
				play[1] = 2;
				playGame(play);
				valid = true;
				break;
			case 4:
				play[0] = 0;
				play[1] = 0;
				playGame(play);
				valid = true;
				break;
			default:
				System.out.print("Invalid player number, please re-enter: ");
			}
		} while (!valid);

	}

}
