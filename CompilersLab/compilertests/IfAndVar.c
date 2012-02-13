#include <stdio.h>
// IfAndVar
int main() {
  int i,j;
  i = 43;
  j = 44;
  if((i<j)&&(i!=(j+1))) {
    printf("Correct\n");
  } else {
    printf("Incorrect i:=43; j:=44 (i < j) AND (i # (j+1)): false\n");
  }
}
