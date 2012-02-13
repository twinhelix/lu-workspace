import simulation.*;

public class Departure extends Event {
	// Declares private variables and objects
	private State st;

	// Constructor
	public Departure(Simulation sim, State st) {
		super(0.25, sim);
		this.st = st;
	}

	// Invoke current event, creates next departure
	// if there is more people in the queue
	public void invoke() {
		st.setQueue(st.getQueue() - 1);
		System.out.println("Departure at: " + sim.now() + ", new population = "
				+ st.getQueue());
		if (st.getQueue() > 0)
			new Departure(sim, st);
	}
}
