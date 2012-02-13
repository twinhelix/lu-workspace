#ifndef _TOKEN
#define _TOKEN

#include <string>


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

    kind getKind() {
        return tkind;
    }
    string getValue() {
        return value;
    }
    int getNum() {
        return num;
    }
    double getDouble() {
        return dbl;
    }
    std::string getText() {
        return value;
    }
};
#endif
