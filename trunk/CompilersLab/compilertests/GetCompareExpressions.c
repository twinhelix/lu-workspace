#include <stdio.h>
// GetCompareExpressions
int main() {
  int x,y,z;
  printf("type in the value of x\n");
  scanf("%d",&x);
  printf("type in the value of y\n");
  scanf("%d",&y);
  printf("type in the value of z\n");
  scanf("%d",&z);
  if((x+z)<(y+z)) {
    printf("x+z < y+z\n");
  } else {
    printf("(x+z) <(y+z): false\n");
  }
}
