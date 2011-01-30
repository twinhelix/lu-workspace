// break 
#include <stdio.h>
int main() {
  int i =1;
  while ( i < 10) {
    i=i+1;
    if (i > 4) {
      break;
    }
  }
  printf("i=%d\n",i);
}