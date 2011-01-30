import simulation.*;

public class Ticks extends Simulation {
	// Declares private variables and objects
	private double stopTime;

	// Constructor, creates new event and simulates
	public Ticks(double stopTime) {
		this.stopTime = stopTime;
		new Tick(1, this);
		simulate();
	}

	// Abstract stop, stop if run time is over
	public boolean stop() {
		return (now() > stopTime - 1);
	}

	// Main method, creates an instance of Simulation
	public static void main(String[] args) {
		if (args.length < 1)
			new Ticks(-1);
		else
			new Ticks(Double.parseDouble(args[0]));
	}

}
