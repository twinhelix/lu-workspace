#include <stdio.h>
// Compare
int main() {
  int x;
  x = 0;
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
  if(x!=1234) {
    printf("Incorrect result expected 1234 got %d\n",x);
   } else {
    printf("Correct\n");
  }
}
