#include <stdio.h>
// IfAndFalse
int main() {
  int i,j;
  i = 43;
  j = 44;
  if(i<j&&j<i) {
    printf("Incorrect i:=43;j:=44 i<j AND j<i: true\n");
  } else {
    printf("Correct\n");
  }
}
