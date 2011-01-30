#ifndef POINT_HPP_
#define POINT_HPP_
#include <iostream>

using namespace std;

class Point {

// overload of <<  for Point output
    friend   ostream &
    operator<<(ostream& out, const  Point & obj );

// overload of comparison operators
    friend bool operator == (const Point &p1, const Point &p2 );
    friend bool operator != (const Point &p1, const Point &p2 );

public:
    double x,y;
    Point():x(0.0),y(0.0) {};
    Point(double xp,double yp):x(xp),y(yp) {} ;
};


#endif /*POINT_HPP_*/
