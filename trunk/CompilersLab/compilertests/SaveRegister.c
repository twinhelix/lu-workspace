#include <stdio.h>
 // SaveRegister
 // Catch the case where $a0 is used and not saved
int main() {
  int x;
  x = 1234;
  printf("%d\n",x);
  printf("%d\n",x);
 
}
