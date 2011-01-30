#include <stdio.h>
// IfNotAnd
int main() {
  int i;
  i = 43;
  if(!((i>=44)&&(i==98))) {
    printf("Correct\n");
  } else {
    printf("Incorrect i:43:!((i >= 44) &&(i = 98)): false\n");
  }
}
