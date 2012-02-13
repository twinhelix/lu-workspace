import simulation.* ;

//
// Defines the Print event
//
class Print extends Event {
  int n ;

//
// Print event takes the default time interval and current simulation
// parameters, in addition to an integer parameter which is printed
// when the event is eventually invoked
//
  public Print( int n, double t, Simulation s ) {
    super( t, s ) ;
    this.n = n ;
  }

//
// invoke method - called when the event instance hits the
// front of the event list.
// Note: sim is an instance variable in the Event superclass 
// denoting the current simulation - it is set to whatever s was 
// in the constructor above
//
  public void invoke() {
    System.out.println( "Event " + n + " invoked at time " + sim.now() ) ;
  }
}
