/**
 * Complete the implementation of this class in line with the FSP model
 */

import display.*;

public class Controller {

	public static int Max = 9;
	protected NumberCanvas passengers;
	private int count;
	private boolean canGo;

	public Controller(NumberCanvas nc) {
		// Initialization
		passengers = nc;
		count = 0;
		canGo = false;

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
		// Altered implementation for part II
		// Gets passengers:
		// Allows car to get less than its max capacity
		while (!((mcar > 0 && count >= mcar) || canGo))
			wait();
		int numPassengers = 0;
		if (count < mcar)
			numPassengers = count;
		else
			numPassengers = mcar;
		count -= numPassengers;
		passengers.setValue(count);
		canGo = false;
		notifyAll();
		return numPassengers;
	}

	public synchronized void goNow() {
		// Sets canGo boolean to true if there are passengers waiting
		if (count > 0) {
			canGo = true;
			notifyAll();
		}
	}

}