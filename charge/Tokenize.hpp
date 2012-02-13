#ifndef _TOKENIZE
#define _TOKENIZE

#include <fstream>
#include <string>
#include <map>
#include "kind.hpp"

using namespace std ;

class Token {

    // Represents a sequence of characters read in from the script

private:
    kind tkind;
    int num;
    std::string value;
    double dbl ;
public:
    // Initialization lists
    Token():tkind(endfile),num(0),value(""),dbl(0.0) { } ;
    Token(kind tk,std::string val):tkind(tk),num(0),value(val),dbl(0.0) { }
    Token(kind tk,std::string val,int numb):tkind(tk),num(numb),value(val),
            dbl(0.0) { }
            Token(kind tk,std::string val,double db):tkind(tk),num(0),value(val),
            dbl(db) {} ;

    inline kind getKind() {
        return tkind;
    }
    inline std::string getValue() {
        return value;
    }
    inline int getNum() {
        return num;
    }
    inline double getDouble() {
        return dbl;
    }
    inline std::string getText() {
        return value;
    }
};

class Tokenize {
    // Convert  strings read from a script into tokens
private:
    ifstream script;              // stream for the script
    string  buffer;               // current line
    string  buffer2;              // for case where the script line is split
    string::const_iterator start;
    string::const_iterator end;
    map<string,kind> kwords ;     //  string -> kind for key words
    bool doEcho ;                 //  echo the script as it is read
    int linenum;                  // line number of script
    Token currentToken;

public:

    Tokenize(string& name,bool doecho);

    string getName(kind tkind) ;
    string getName() ;

    int getLineNo();
    string getLineNoS();
    void readNextToken();
    kind getKind() ;
    string getText();
    double getDouble();
    int getNum() ;
};
#endif
