#include <stdio.h>
int main() {
  /*
  Assume a word is at least 32 bits long and that << goes to the
  high end. Avoids changing the high bit
  */
  int rowsize = 7;
  
  int rows1 = (1 << 0) | (1 << (1+rowsize) ) | (1 << (2 +2*rowsize)) |
                    (1 << (3 + 3*rowsize));
                      
  int rows2 =  (1 << 4) | (1 << (5+rowsize) ) | (1 << (6 +2*rowsize)) |
                    (1 << (7 + 3*rowsize));
                    
  int row=0;
  int rowsperword = 4 ;
  
  while (row < rowsize) {
    int col =0;
    while ( col< rowsize) {
      if (row < rowsperword) {
        if (  ((1 << (row * rowsize +col)) & rows1) != 0 ) {
           printf("*");
        } else {
           printf(" ");
        }
      }
      else {
        if (( ((1 << (row -rowsperword)* rowsize +col)) & rows2 ) !=0) {
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
 
