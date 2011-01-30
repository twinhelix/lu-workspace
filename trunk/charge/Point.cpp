#include "Point.hpp"
// implementation of << for Points
ostream &
operator<<(ostream& out, const  Point & obj ) {
    out  << obj.x << "," << obj.y;
    return out;
}

bool operator == (const Point &p1, const Point &p2 ) {
    return (p1.x == p2.x) && (p2.y == p1.y);
}

bool operator != (const Point &p1, const Point &p2 ) {
    return (p1.x != p2.x) || (p2.y != p1.y);
}
