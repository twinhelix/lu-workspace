package BoyGirl;

public class BoyGirl {
	
	private int RUNS = 1000000000;
	
	private BoyGirl() {
	
		double total = 0;
		double twoGirls = 0;
		
		for (int i = 0; i < RUNS; i++){
			int[] kids = makeKids();
			if (isOneGirl(kids)){
				total++;
				if (isOtherGirl(kids))
					twoGirls++;
			}
		}
		System.out.println("percentage: " + (twoGirls/total));		
	}

	private int[] makeKids() {
		int[] kids = new int[2];
		// 0 = boy, 1 = girl
		kids[0] = (int) (Math.random() * 2);
		kids[1] = (int) (Math.random() * 2);
		return kids;
	}
	
	private boolean isOneGirl(int[] kids){
		if (kids[0] == 1 || kids[1] == 1)
			return true;
		return false;
	}
	
	private boolean isOtherGirl(int[]kids){
		if (kids[0] == 1 && kids[1] == 1)
			return true;
		return false;
	}

	public static void main(String[] args) {
		new BoyGirl();
	}

}
