package simulation;

public abstract class Event implements Comparable<Object> {
	// Declares protected variables and objects
	protected double time; 		// time to invoke
	protected Simulation sim; 	// simulation object

	// Abstract invoke method, differs for inherited classes
	protected abstract void invoke();

	// Constructor
	public Event(double interval, Simulation s) {
		this.sim = s;
		this.time = this.sim.now() + interval;
		this.sim.schedule(this);
	}
	// Interface compareTO method
	public int compareTo(Object x) {
		int result = -2;
		if (!(x instanceof Event))
			result = -1;
		else {
			Event e = (Event) x;

			if (this.time < e.time)
				result = -1;
			else if (this.time == e.time)
				result = 0;
			else
				result = 1;
		}
		return result;
	}

	// Getter and Setter
	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
	}
}
