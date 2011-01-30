#include <stdio.h>
// NestedAndOr
int main() {
  int x;
  x = 5;
  if((x<10||x<0)&&(1/x>=0||x==10)) {
    printf("Correct\n");
  } else {
    printf("Incorrect x=5;(x <10 || x <0) && ( 1/x >=0 || x = 10)\n");
  }
}
