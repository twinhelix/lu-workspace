#include <stdio.h>
// IfJumpAnd
int main() {
  int x;
  x = 0;
  if((x>0)&&((1/x)>0)) {
    printf("Incorrect:(x>0) && ((1 / x) > 0): true\n");
  } else {
    printf("Correct\n");
  }
}
