#ifndef _READSCRIPT
#define _READSCRIPT
#include <iostream>
#include <map>
#include <boost/date_time/posix_time/posix_time.hpp>
#include "Point.hpp"
#include "Tokenize.hpp"

using boost::posix_time::ptime;


class ReadScript {
    /*
    * read a script for the charge exercise
    * assumes each statement ends with a ' .'
    * parsing stops at the first error
    */
private :
// sequences of words to be found in the script
    vector<kind> isregistered ;
    vector<kind> unitto;
    vector<kind> dcar;
    vector<kind> reducedrate;
    vector<kind> witha;
    vector<kind> borderis ;
    vector<kind> tcouncil;
    vector<kind> moveto;
    ptime lastTime ;                      // value of the last time read
    ptime invalidTime;                    // stores the invalid time-date

    Tokenize tokenize;
    ifstream script;
    bool   getCommand();
    void   error(kind should);            // token is not what it should be
    void   expects(kind  should);         // next token should be
    void   expects(vector <kind> should); // following tokens should be
    // read items
    string readLicense();
    double readNum();
    Point  readPoint();
    ptime  readTime();
    kind   readVehicle(string &license ); // license is set
    void   skipPast(kind to);
    void   skipPast(vector <kind> to);

    void vehicleRegister();
    void councilDecides();
    void setZone(ptime change);


    void  vehicleMoves();
    void  passengerChange() ;
public :
    ReadScript( string &name,bool doecho) ;
    void readscript();
};
#endif
