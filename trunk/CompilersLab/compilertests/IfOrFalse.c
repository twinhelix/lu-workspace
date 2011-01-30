#include <stdio.h>
// IfOrFalse
int main() {
  int i,j;
  i = 43;
  j = 44;
  if(i>j||j<0) {
    printf("Incorrect i=43;j=44; i>j || j < 0:true\n");
  } else {
    printf("Correct\n");
  }
}
