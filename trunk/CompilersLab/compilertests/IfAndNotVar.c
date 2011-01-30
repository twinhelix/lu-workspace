#include <stdio.h>
// IfAndNotVar
int main() {
  int i,j;
  i = 43;
  j = 44;
  if(!(i>=j)&&!(i==j+1)) {
    printf("Correct\n");
  } else {
    printf("Incorrect i:=43;j:=44;NOT(i >= j) AND NOT(i = j+1): false\n");
  }
}
