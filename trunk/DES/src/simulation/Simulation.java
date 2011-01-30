package simulation;
import java.util.*;

public abstract class Simulation {
	// Declares private variables, objects and lists
	private double time;
	private SortedSet<Event> diary = null;

	// Abstract stop method, differs for inherited classes
	public abstract boolean stop();

	// Constructor
	public Simulation() {
		time = 0;
		diary = new TreeSet<Event>();
	}

	// Returns the current time
	public double now() {
		return time;
	}

	// Adds given event to the sorted list
	public void schedule(Event e) {
		diary.add(e);
	}

	// Simulation, invokes events and deletes then till
	// stops triggers or no more events are left
	public void simulate() {
		while (!diary.isEmpty() && !stop()) {
			Event e = diary.first();
			time = e.getTime();
			if (!stop()) {
				diary.remove(e);
				e.invoke();
			}
		}
	}
}
