#include <stdio.h>
// IfJumpOr
int main() {
  int x;
  x = 0;
  if((x==0)||((1/x)>0)) {
    printf("Correct\n");
  } else {
    printf("Incorrect x=0 (x==0) ||  ((1 / x) > 0) false\n");
  }
}
