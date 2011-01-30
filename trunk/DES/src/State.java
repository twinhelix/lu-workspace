import java.util.Random;

// Class State stores queue and random number generator
public class State {
	// Declares private variables and objects
	private Random gen;
	private int queue;

	// Constructor
	public State(Long seed) {
		gen = new Random(seed);
		queue = 0;
	}

	// Getters and setters for queue
	public void setQueue(int queue) {
		this.queue = queue;
	}

	public int getQueue() {
		return queue;
	}

	// Returns a random generated number
	public double interval() {
		return gen.nextDouble();
	}
}