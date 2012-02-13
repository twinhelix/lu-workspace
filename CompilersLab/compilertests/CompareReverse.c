#include <stdio.h>
// CompareReverse
int main() {
  int x;
  x = 0;
  if(0==x) {
    x = 2;
  } else {
    x = 1;
  }
  if(0<x) {
    x = 34;
  } else {
    x = 2;
  }
  if(40>x) {
    x = 200+x;
  } else {
    x = 3;
  }
  if(200<=x) {
    x = x+1000;
  } else {
    x = 4;
  }
  if(0!=x) {
    x = x+1;
  } else {
    x = 5;
  }
  if(2000>=x) {
    x = x-1;
  } else {
    x = 6;
  }
  printf("%d\n",x);

}
