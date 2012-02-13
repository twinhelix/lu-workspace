package GameshowQuestion;

public class Mainprogram {
	int[] doors1 = { 0, 0, 1 };
	int[] doors2 = { 0, 1, 0 };
	int[] doors3 = { 1, 0, 0 };
	final int TOTALGAMES = 1000000000;
	
	public Mainprogram() {
		int same = 0;
		int change = 0;
		for (int i = 0; i < TOTALGAMES; i ++){
			// Create the random prizes
			int[] doors = getRandomPrizes();
			
			// Calculate wins
			if (playSame(doors))
				same++;
			if (playAlternate(doors))
				change++;
		}
		System.out.println("Total Games: "+ TOTALGAMES);
		System.out.println("No change wins: " + same + "     " + ((double)same/TOTALGAMES * 100) + "%");
		System.out.println("Change wins: " + change + "     " + ((double)change/TOTALGAMES * 100) + "%");
		
	}

	private int[] getRandomPrizes() {

		int choice = (int) (Math.random() * 3);
		if (choice == 0)
			return doors1;
		else if (choice == 1)
			return doors2;
		else
			return doors3;
	}

	private boolean playSame(int[] doors) {
		int choice = (int) (Math.random() * 3);
		return (doors[choice] == 1);
	}

	private boolean playAlternate(int[] doors) {
		int choice = (int) (Math.random() * 3);
		int other;
		// Breaks if door is sheep
		int x =0;
		int i = 0;
		for (i = 0; i < 3; i++) {
			if (i != choice) {
				if (doors[i] == 0) {
					x = i;
				}
			}
		}
		int total = x + choice;
		if (total == 1)
			other = 2;
		else if (total == 2)
			other = 1;
		else
			other = 0;
		return (doors[other] == 1);
	}

	public static void main(String[] args) {
		new Mainprogram();
	}

}
