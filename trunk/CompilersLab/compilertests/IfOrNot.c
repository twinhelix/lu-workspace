#include <stdio.h>
// IfOrNot
int main() {
  int i;
  i = 43;
  if(!(i>41)||!(i==98)) {
    printf("Correct\n");
  } else {
    printf("Incorrect i:43 !(i>41) && !(i==98): false\n");
  }
}
