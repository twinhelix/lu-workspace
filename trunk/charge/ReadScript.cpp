#include <boost/assign/list_of.hpp>
#include <boost/date_time/posix_time/posix_time.hpp>
#include <stdexcept>
#include <sstream>
#include "ReadScript.hpp"
#include "Council.hpp"

using boost::posix_time::ptime;
using boost::assign::list_of;
using namespace std;




class syntax_error : public runtime_error {
    // thrown if the script can't be parsed
public :
    explicit syntax_error( const  string &s ) :
            runtime_error(s) { }
};


ReadScript::ReadScript( string &name,bool doecho) :
        isregistered(),unitto(),dcar(),reducedrate(),witha(),
        borderis(),tcouncil(),moveto(),lastTime(),invalidTime(),tokenize(name,doecho),script() {
    // Initialize word sequence
    isregistered = list_of(is)(registered)(with)(the)(council);
    unitto = list_of( unit)( charge)( should)(be)(set_tok)(to);
    dcar = list_of(cars)(with)( emission)(less_tok)(than);
    reducedrate = list_of(ppcm)(pay)(the)(reduced)(rate)(dot);
    witha = list_of(with)(an)(emission)(rating)(of);
    borderis = list_of(border)(is)(now);
    tcouncil= list_of(town)(council);
    moveto = list_of(moves)(to);
}

void ReadScript::readscript() {
    // Main method
    // initilise the Council and read the script
    Council();
    while (getCommand()){};
}

void ReadScript::error(kind should) {
    throw syntax_error("line: "+tokenize.getLineNoS() + " expected \""
                       +tokenize.getName(should) +
                       ("\" got \""+tokenize.getName())+"\"");
}

void ReadScript::expects(kind should) {
    // check the next word
    tokenize.readNextToken() ;
    if ( tokenize.getKind() != should ) {
        error(should);
    }
}


// expect a list of items
void ReadScript::expects(vector <kind> should) {
    for ( vector<kind>::const_iterator it = should.begin(); it!= should.end(); ++it) {
        expects(*it);
    }
}

void ReadScript::skipPast(kind to) {
    // skip until the word in 'to' is read  and then  get next
    expects(to);
    tokenize.readNextToken();
}

void ReadScript::skipPast(vector <kind> to) {
    // skip until the words in 'to' are read  and then get  next
    expects(to);
    tokenize.readNextToken();
}
string ReadScript::readLicense() {
    // read a license plate and return it
    tokenize.readNextToken();
    if (tokenize.getKind() == license) {
        tokenize.readNextToken();
    }
    return tokenize.getText();
}

double ReadScript::readNum() {
    if (tokenize.getKind() == doublenum)  {
        return tokenize.getDouble();
    }
    if  (tokenize.getKind() ==  number) {
        return tokenize.getNum();
    }
    error(number);
    return 0;
}

Point ReadScript::readPoint() {
    // read a point
    double xcoord;
    tokenize.readNextToken();
    xcoord=readNum();
    skipPast(comma);
    return Point(xcoord,readNum());
}

ptime ReadScript::readTime() {
    // reads a date time in the form: date  time
    stringstream dates;
    ptime date_time;
    if (tokenize.getKind()!= date_tok) {
        error(date_tok);
    }
    /*
     * to read a ptime from a stream (using >>) there must be
     * only one space between the date and time. Using 2 tokens
     * means extra spaces in the script is accepted
     */
    dates << tokenize.getText();  // date
    dates << " "; // between the date and the time
    tokenize.readNextToken();    // time
    if (tokenize.getKind()!= time_tok) {
        error(time_tok);
    }
    dates << tokenize.getText();
    // the string stream dates contains "date time"
    /* There is a warning about /usr/include/boost/date_time/time_facet.hpp:977
    */
    // turn on failure if the date is not valid 
    dates.exceptions(std::ios_base::failbit);

    dates >> date_time;   // read it 
    
    /*
     * each ptime read should be later than the one before
     */
    if (invalidTime != lastTime && lastTime >= date_time) {
        cerr << endl << "last time read " << lastTime << endl ;
        cerr << "read " << date_time << endl;
        cerr << "script error at line " << tokenize.getLineNo() << endl;
        abort();
    }
    lastTime = date_time;
    return date_time ;
}

kind ReadScript::readVehicle(string &license  ) {
    // get the vehicle type and information eg
    // petrol car, or bus
    tokenize.readNextToken()  ;
    kind which = tokenize.getKind();
    switch (which) {
    case bus:
        break;
    case lorry:
        break;
    case petrol:
        expects(car);
        break;
    case diesel:
        expects(car);
        break;
    default:
        throw syntax_error( "line " + tokenize.getLineNoS() +
                            " error: could not recognize " +tokenize.getText() );
    }
    license = readLicense();
    return which;
}

void  ReadScript::vehicleMoves() {
    // A vehicle moves
    string license ;
    Point to;
    ptime movetime;
    readVehicle(license);
    expects(moveto);
    to = readPoint();
    skipPast(on);
    movetime = readTime();
    // Tell the council
    Council::moves(license,movetime,to);
}

void  ReadScript::passengerChange() {
    /*
     a number of passengers leave or enter a bus
    */
    string license;
    kind boardOrleave;
    ptime when = readTime();
    tokenize.readNextToken();
    int num = tokenize.getNum();
    skipPast(passengers);
    boardOrleave =tokenize.getKind();
    expects(the);
    readVehicle(license);
    // tell the council how many, and if they boarded or left
    Council::passengerChange(license,num,boardOrleave==board,when);
}


void ReadScript::vehicleRegister() {
    /*
      read the information to register a vehicle
      and create a new vehicle
    */
    string license ;
    kind whatKind = readVehicle(license);
    int value=0 ;
    // read extra information for lorries and diesel cars
    if (whatKind == lorry) {
        skipPast(with);
        value = tokenize.getNum();  // number of axles
        expects(axles);
    }
    if (whatKind == diesel) {
        skipPast(witha);
        value = tokenize.getNum(); // amount of pollution produced
        expects(ppcm);
    }
    expects(isregistered);
    skipPast(on);
    ptime whenRegistered = readTime();
    tokenize.readNextToken() ;
    Point where = readPoint();
    // what kind of vehicle
    // if this is a diesel car  value is the ppcm it produces
    // if this is a lorry it is the number of axles
    Council::registerV(whatKind,license,whenRegistered,where,value);

}

void  ReadScript::councilDecides() {
    // read information for a council meeting
    ptime change ;
    expects(decides);
    skipPast(on);
    change = readTime();
    skipPast(that);
    if (tokenize.getKind() == the) {
        tokenize.readNextToken() ;
    }
    switch (tokenize.getKind()) {
    case diesel:
        /* The threshold of ppcm where a diesel car is changed
          and the string is converted into a char* and that to an int
          which is passed to the Council
        */
        skipPast(dcar);
        Council::setppcm(tokenize.getNum(),change);
        expects(reducedrate);
        break;
    case basic:
        skipPast(unitto);
        // set the cost of a unit
        Council::setRate(tokenize.getDouble(),change);
        break;
    case zone:
        // read the corners of the zone and tell the council
        setZone(change);
        break;
    default:
        throw syntax_error( "Don't Recognize " + tokenize.getText() + " line "
                            + tokenize.getLineNoS());
    }
}

void ReadScript::setZone(ptime change) {
    /*
     Read four pairs of Points to define the corners of
     the zone border. The points don't have to be in any
     particular order
     */
    Council::emptyMap(); // Remove the old map items
    expects(borderis);
    for (int i=0; i < 4 ; i++ ) {
        Point pt = readPoint();
        cout << pt << " ";
        Council::addMapPoint(pt);
    }
    cout << "on "<< change << endl ;

}

bool ReadScript::getCommand() {
    // look at the first word
    tokenize.readNextToken() ;
    switch (tokenize.getKind()) {
        //  a vehicle is registered, and added to vehicles
    case a:
        vehicleRegister();
        break;
        // the vehicle moves
    case the:
        vehicleMoves();
        break;
        // sleepy town council
    case sleepy:
        expects(tcouncil);
        councilDecides();
        break;
        // end of script
    case endfile:
        return false;
        break;
    case dot:   // end of command
        return true;
    case print: // the rest of the command is printed
        cout << endl ;
        tokenize.readNextToken() ;
        while (!script.eof() && tokenize.getKind() != dot) {
            cout <<  tokenize.getText()
                 << " " ;

            tokenize.readNextToken() ;
        }
        cout << endl ;
        break;
    case on:
        tokenize.readNextToken();
        passengerChange();
        break;
    default:
        throw syntax_error( " Unexpected word " + tokenize.getText() +
                            " line "+tokenize.getLineNoS()
                          ) ;

    }
    return true;
}



