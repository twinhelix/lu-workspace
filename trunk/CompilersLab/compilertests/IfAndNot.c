#include <stdio.h>
// IfAndNot
int main() {
  int i;
  i = 43;
  if(!(i>=44)&&!(i==98)) {
    printf("Correct\n");
  } else {
    printf("Incorrect i:=43;OT(i >= 44) AND NOT(i = 98)\n");
  }
}
