#include <stdio.h>
// IfNot
int main() {
  int x;
  x = 20;
  if(!(x>20)) {
    printf("Correct\n");
  } else {
    printf("Incorrect x=20 !(x>20): false\n");
  }
}
