#include <stdio.h>
 // GetEvalExpr
int main() {
  int x;
  printf("type a value for x\n");
  scanf("%d",&x);
  x = ((1*x+2)*x+3)*x+4;
  printf("%d\n",x);
}
