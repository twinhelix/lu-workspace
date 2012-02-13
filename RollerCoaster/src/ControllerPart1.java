/**
 * Complete the implementation of this class in line with the FSP model
 */

import display.*;

public class ControllerPart1 {

	public static int Max = 9;
	protected NumberCanvas passengers;
	protected int count;

	public ControllerPart1(NumberCanvas nc) {
		// Initialization
		passengers = nc;
		count = 0;
	}

	public synchronized void newPassenger() throws InterruptedException {
		// Adds a new passenger if there's still more spaces
		// sets the value and notifies
		while (count >= Max)
			wait();
		count++;
		passengers.setValue(count);
		notifyAll();
	}

	public synchronized int getPassengers(int mcar) throws InterruptedException {
		// Completed implementation for part I
		// Checks that there's enough passengers to return,
		// decrements number of waiting passengers and notifies.
		while (!(mcar > 0 && count >= mcar))
			wait();
		count -= mcar;
		passengers.setValue(count);
		notifyAll();
		return mcar;
	}

	public synchronized void goNow() {
		// complete implementation for part II
	}

}