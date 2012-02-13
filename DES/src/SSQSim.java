import simulation.*;

public class SSQSim extends Simulation {
	// Declares private variables and objects
	private double stopTime;
	private State st;

	// Abstract stop, stop if run time is over
	public boolean stop() {
		return (now() > stopTime);
	}

	// Constructor
	public SSQSim(double stopTime, long seed) {
		this.stopTime = stopTime;
		st = new State(seed);
		new Arrival(this, st);
		simulate();
		System.out.println("SIMULATION COMPLETE");
	}

	// Main method, creates an instance of Simulation
	public static void main(String[] args) {
		new SSQSim(Double.parseDouble(args[0]), Long.parseLong(args[1]));
	}
}
