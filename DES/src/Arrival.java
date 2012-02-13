import simulation.*;

public class Arrival extends Event {
	// Declares private variables and objects
	private State st;

	// Constructor
	public Arrival(Simulation sim, State st) {
		super(st.interval(), sim);
		this.st = st;

	}

	// Invoke current event, creates a departure is queue
	// is empty, creates next arrival
	public void invoke() {
		int q = st.getQueue();
		st.setQueue(q + 1);
		System.out.println("Arrival at: " + sim.now() + ", new population = "
				+ st.getQueue());
		if (q == 0)
			new Departure(sim, st);
		new Arrival(sim, st);

	}

}
