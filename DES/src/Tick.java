import simulation.*;

public class Tick extends Event {
	// Constructor
	public Tick(double t, Simulation sim) {
		super(t, sim);
	}

	// Invoke current event, create next event
	@Override
	protected void invoke() {
		System.out.println("Tick at: " + sim.now());
		new Tick(1, sim);
	}
}
