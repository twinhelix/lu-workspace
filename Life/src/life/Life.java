package life;

public class Life {
	private static int rows;
	private static final int DEFAULT_ROWS = 30;
	
	public static void main(String[] args){
		// Try convert argument to row size, set default is there's no args
		try {
			rows = Integer.parseInt(args[0]);
		
			if (rows < 4) {
				throw new IndexOutOfBoundsException("Invalid Rows Size.");
			}
		} catch (Exception e) {
			System.out.println("Using Default Row Size 30.");
			rows = DEFAULT_ROWS;
		}
		
		startGame();
	}
	
	public static void startGame(){
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                Model m = Model.getInstance();
                m.initialize(rows);
            }
        });
	}
	
	public static void quit(){
		System.exit(0);
	}
	
}
