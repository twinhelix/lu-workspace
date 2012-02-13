#include <stdio.h>
int main() {
if (3>2) {
  printf("Correct\n");
 } else {
 // will never be reached
  printf("1/0 is %d\n",1/0);
  }
  }
