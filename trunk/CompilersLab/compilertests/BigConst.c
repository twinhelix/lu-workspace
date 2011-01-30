#include <stdio.h>
// BigConst
int main() {
  int x,y;
  x = 1234000;
  y = 123*1000+4000;
  if(x==1234000) {
    printf("%d\n",x/1000);
  } else {
    printf("%d\n",x/y);
  }

}
