#include <stdio.h>
// WhileIf
int main() {
  int x,y;
  x = 0;
  while(x<1200) {
    y = 60;
    if(y<100) {
      y = y+40;
    }
    x = x+y;
  }
  while(x<1230) {
    x = x+10;
  }
  x = x+4;
  printf("%d\n",x);
}
