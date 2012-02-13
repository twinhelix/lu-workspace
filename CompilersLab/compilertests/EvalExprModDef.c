#include <stdio.h>
// By definition x%y +(x/y )*y== x if y >0
int main() {
  int x,y;
  printf("Type a positive number:");
  scanf(" %d",&x);
  printf("Type another positive number:");
  scanf("%d",&y);
  if (x%y +(x/y)*y == x) {
    printf("correct\n");
  }
  else {
     printf("Wrong x%%y +(x/y)*y != x\n");
  }
 
 }
