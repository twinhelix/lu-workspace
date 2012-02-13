import simulation.* ;

class Print3 extends Simulation {

//
// stop() method used to terminate the simulation
// Here, the simulation sill stop when there are no more events
//
  public boolean stop() {
    return false ;
  }

//
// Constructor - this schedules three events and processes
// them by calling the simulate() method defined in the Simulation
// superclass. 
//
  public Print3() {
    new Print( 1, 7.2, this ) ;
    new Print( 2, 11.6, this ) ;
    new Print( 3, 2.9, this ) ;
    simulate() ;
  }

//
// Main method - starts simulation by building an instance
// of Print3
//
  public static void main( String args[] ) {
    new Print3() ;
  }
  
}
