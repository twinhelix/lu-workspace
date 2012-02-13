package database.benchmark;

/**
 * @author Administrator
 *
 */
public final class Counter {
	/**
	 * 
	 */
	private static int count = 0;

	/**
	 * 
	 */
	public synchronized static void inc(){
		count++;
	}
	
	/**
	 * 
	 */
	public static void reset(){count = 0;}
	
	/**
	 * @return
	 */
	public static int value(){return count;}
}