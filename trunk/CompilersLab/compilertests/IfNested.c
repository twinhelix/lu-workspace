#include <stdio.h>
// IfNested
int main() {
  int i,j;
  i = 3;
  j = 1230;
  if(i<2) {
    printf("Incorrect i:=3 i < 2: true\n");
  } else {
    if(j>1200) {
      printf("%d\n",i+j+1);
    } else {
      printf("Incorrect j:=1230 j >1200: false\n");
    }
  }
}
