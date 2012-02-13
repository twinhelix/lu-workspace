#include <stdio.h>
// WhileNested
int main() {
  int x,y;
  x = 0;
  while(x<1200) {
    y = 60;
    while(y<100) {
      y = y+20;
    }
    x = x+y;
  }
  while(x<1230) {
    x = x+10;
  }
  x = x+4;
  printf("%d\n",x);
}
