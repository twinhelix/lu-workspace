#include <stdio.h>
int main() {
  /*
  Assume a word is at least 32 bits long and that << goes to the
  high end. Avoids changing the high bit
  */
  int rowsize = 7;
  int left = 1 << 28;
  int rows1 = (left >> 0) | (left >> (1+rowsize) ) | (left >> (2 +2*rowsize)) |
                    (left >> (3 + 3*rowsize));
                      
  int rows2 =  (left >> 4) | (left>> (5+rowsize) ) | (left >> (6 +2*rowsize)) |
                    (left >> (7 + 3*rowsize));
                    
  int row=0;
  int rowsperword = 4 ;
  
  while (row < rowsize) {
    int col =0;
    while ( col< rowsize) {
      if (row < rowsperword) {
        if (  ((left >> (row * rowsize +col)) & rows1) != 0 ) {
           printf("*");
        } else {
           printf(" ");
        }
      }
      else {
        if (( ((left >> (row -rowsperword)* rowsize +col)) & rows2 ) !=0) {
           printf("*");
        } else {
           printf(" ");
        }
      }
      col = col+1;
    }
    printf("\n");
    row = row+1;
  }
}
 
