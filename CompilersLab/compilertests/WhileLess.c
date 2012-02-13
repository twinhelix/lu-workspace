#include <stdio.h>
// WhileLess
int main() {
  int x;
  x = 0;
  while(x<1200) {
    x = x+100;
  }
  while(x<1230) {
    x = x+10;
  }
  x = x+4;
  printf("%d\n",x);
}
