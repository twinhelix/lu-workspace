#include <stdio.h>
// specialcases
int main() { 
  int x;
  x = 42;
  x = (x+x)*0;
  x = (x+1)*1;
  x = (x+1)+0;
  x = x-0;
  x = x/1;
  printf("%d\n",x);
 }
