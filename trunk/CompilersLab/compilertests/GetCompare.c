#include <stdio.h>
// GetCompare
int main() {
  int x;
  printf("Type a number \n");
  scanf("%d",&x);
  if(x==0) {
    x = 2;
  } else {
    x = 1;
  }
  if(x>0) {
    x = 34;
  } else {
    x = 2;
  }
  if(x<40) {
    x = 200+x;
  } else {
    x = 3;
  }
  if(x>=200) {
    x = x+1000;
  } else {
    x = 4;
  }
  if(x!=0) {
    x = x+1;
  } else {
    x = 5;
  }
  if(x<=2000) {
    x = x-1;
  } else {
    x = 6;
  }
  printf("Result:%d\n",x);
}
