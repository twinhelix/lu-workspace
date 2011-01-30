#include <stdio.h>
// WhileNot
int main() {
  int x;
  x = 1230;
  while(!(x>=1234)) {
    x = x+2;
  }
  printf("%d\n",x);
}
