#include <stdio.h>
// WhileJumpOr
int main() {
  int x;
  x = 0;
  while(x==0||1/x==0) {
    printf("Correct\n");
    x = 1;
  }
}
