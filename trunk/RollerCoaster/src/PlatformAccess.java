

/**
 * Complete the implementation of this class in line with the FSP model
 */

public class PlatformAccess {

  /* declarations required */
	// "Semaphore" for number of cars at the platform, notifies.
	private boolean slot = true;

  public synchronized void arrive() throws InterruptedException {
	  // Car waits for a slot, then takes it.
    while (!slot)
    	wait();
    slot = false;
  }

  public synchronized void depart() {
	 // Car leaves and returns slot, notifies.
	 slot = true;
	 notifyAll();
  }

}