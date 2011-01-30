#include <stdio.h>
// IfList
int main() {
  int x,y;
  x = 123;
  if(x>0) {
    x = x*10;
    x = x+4;
  }
  printf("%d\n",x);
}
