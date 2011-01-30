#include <stdio.h>
// CompareExpressions
int main() {
  int x,y,z;
  x = 2;
  y = 3;
  z = 4;
  if((x+z)<(y+z)) {
    printf("Correct\n");
  } else {
    printf("Incorrect x:=2;y:=3z:=4; (x+y) <(y+z): false\n");
  }
}
