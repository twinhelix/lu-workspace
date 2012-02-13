#include <boost/assign/list_of.hpp>
#include <boost/regex.hpp>
#include <iostream>
#include <sstream>
#include "Tokenize.hpp"

using namespace std ;

Tokenize::Tokenize(string& name,bool doecho):
        script(name.c_str()),buffer(""),buffer2(""),start(),end(),kwords(),
        doEcho(doecho),linenum(0),currentToken() {

    // initialise kwords: word ->   kind using boost assign library
   kwords=boost::assign::map_list_of("a",a)("the",the)("sleepy",sleepy)("basic",basic)("diesel",diesel)
           ("board",board)("leave",leave)("bus",bus)("an",an)("lorry",lorry)("car",car)("petrol",petrol)
           ("license",license)(".",dot)(",",comma)(":",colon)(";",semicolon)("-",dash)
           ("with",with)("date",date_tok)("time",time_tok)("ppcm",ppcm)("of",of)("than",than)
           ("decides",decides)("to",to)("on",on)("cars",cars)("at",at)("council",council)("passengers",passengers)
           ("there",there)("town",town)("that",that)("moves",moves)("is",is)("axles",axles)("emission",emission)
           ("less",less_tok)("unit",unit)("drivers",drivers)("charge",charge)("should",should)("be",be)
           ("set",set_tok)("ppcm",ppcm)("pay",pay)("reduced",reduced)("rate",rate)("rating",rating)
           ("print",print)
           ("zone",zone)("border",border)("now",now)("registered",registered);
    if (!script) {
        cerr << "The file " << name<< " can't be opened " << endl ;
        exit(1);
    }
    start = buffer.begin();
}

string Tokenize::getName(kind tkind) {
    // returns the string for the key for tkind in kwords
    for (map<string,kind>::iterator mapit = kwords.begin(); mapit!= kwords.end(); ++mapit) {
        if (mapit->second == tkind) {
            return mapit->first;
        }
    }
    cerr << "No string returned from getName";
    exit(3) ;
}

string Tokenize::getName() {
    return currentToken.getText();
}

int Tokenize::getLineNo() {
    return linenum;
}

kind Tokenize::getKind() {
    return currentToken.getKind();
}

string Tokenize::getLineNoS() {
    ostringstream ostream;
    ostream << linenum;
    return ostream.str();
}

string Tokenize::getText() {
    return currentToken.getText();
}
double Tokenize::getDouble() {
    return currentToken.getDouble();
}

int Tokenize::getNum() {
    return currentToken.getNum();
}

void Tokenize::readNextToken() {
    // get a token from the buffer
    kind tkind;
    string value;
    boost::smatch match_result ;
    /* regular expression that matches all of the input
        follows perl regex syntax but has 2 '\' because this is a C++ string
      the alternatives are float,date,time
    */
    const boost::regex alt("^(?:(\\d+\\.\\d*)|(\\d{4}\\-\\w+\\-\\d+)|(\\d{2}:\\d{2}(?::\\d{2})?)|(\\d+)|(\\w+)|([,.;:\\-])|(#.+)|(\\s+))");
    end = buffer.end();
    while (true) {

        while (buffer.empty() || start == end) {
            // test for
            if (script.eof()) {
                script.close();
                currentToken = Token(endfile,"end of file");
                return;
            }
            // a non-empty line
            getline(script,buffer);
            while (doEcho && !script.eof() && buffer[buffer.size()-1]!='.') {
                getline(script,buffer2);
                buffer.append(" ");
                buffer.append(buffer2);
            }
            linenum++;
            if (doEcho) {
                cout << buffer << endl ;
            }
            start = buffer.begin();
            end = buffer.end();
        }

        if ( boost::regex_search(start,end,match_result,alt,boost::match_default|
                                 boost::match_partial)) {
            // matches
            int mat=0;
            start = match_result[0].second; // use rest of line next time
            // look at match_result[i] to see what was matched
            for (unsigned int  i=0; i<match_result.size() ; i++) {
                if (match_result[i].matched) {
                    value="";
                    // get the matched string
                    for ( string::const_iterator it = match_result[i].first;
                            it !=match_result[i].second ; ++ it) {
                        value.push_back(*it);
                    }
                    mat=i;
                }
            }
            switch (mat) { // number of the pattern matched
            case  1: { // floating point number
                double dbl;
                istringstream str(value);
                str >> dbl;
                currentToken = Token(doublenum,value,dbl);
                return;
            }
            case  2: // string in a date format like 2007-dec-04  stored as a string
                currentToken = Token(date_tok,value);
                return;
            case  3: // string in a time format like 12:00:03  stored as a string
                currentToken = Token(time_tok,value);
                return;
            case  4: { // int
                int num;
                istringstream str(value);
                str >> num;
                currentToken = Token(number,value,num);
                return;
            }
            case  5: { // word
                // make a lowercase copy of the word read and search kwords
                string lowercase(value);
                for (string::iterator iter = lowercase.begin();
                        iter != lowercase.end(); iter++) {
                    *iter=tolower(*iter);
                }

                if (kwords.count(lowercase) == 1) {
                    // Predefined word
                    tkind = kwords[lowercase];
                    currentToken =  Token(tkind,lowercase);
                } else {
                    currentToken = Token(word,value);
                }
                return;
            }
            case  6: // one character  ',' '.' ';' ':' '-'
                // look value up in kwords
                currentToken = Token(kwords[value],value);
                return;

            case  7: // '#' ignore the rest of the line
                buffer.clear();
                start=end;
                break;

            case  8: //  spaces or tabs
                break;

            default:
                cerr << "Error Tokenize regex match number " <<
                     "line "<< getLineNo() <<
                     mat << " " << value << endl ;
                exit(1);
            }
        } else {
            cerr << "Unmatched text in a script"
                 << "line " << getLineNo() << " "
                 << buffer ;
            exit(2);
        }
    }
}


