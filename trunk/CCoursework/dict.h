/*
 * SUPPLIED CODE: C_Dictionary.
 *
 * "dict.h":
 * header file defining types and function prototypes for the dictionary.
 */

#define MAXWORDSIZE 100
typedef char word[MAXWORDSIZE+1];  /* extra 1 to make room for null char */
typedef struct dictionary *dict;

/* the structure used to construct the dictionary */
struct dictionary {
  dict left,right;
  word theword;
} ;


/* prototypes for public functions used by main program test harness */

dict addword(char aword[], dict adict);
/*
 * pre:  adict is a valid dictionary
 * post: the result contains all the words of adict and   'aword' is added
 *       in the correct (alphabetic) place
 *
 * note: it is wrong to write word aword in the first argument
 *       because it would include the size of the array, which the compile
 *       ignores
 */


void printdict(dict adict);
/*
 * pre:  'adict' is a valid dictionary
 * post: the words in 'adict' are written to standard output one per line in
 *       alphabetic order
 */


int lookup(char aword[], dict adict);
/*
 * pre:  adict is a valid dictionary
 * post: the value returned is non-zero if 'aword' appears in adict, 0 otherwise
 */


int countwords(dict adict);
/*
 * pre:  adict is a valid dictionary
 * post: the result is the number of words in adict
 */


int findword(dict adict, int n, char aword[]);
/*
 * pre:  adict is a valid dictionary
 * post: if  1 <= n <= countwords(adict) the nth word in alphabetic
 *       order is copied into aword and a non-zero value is returned.
 *       Otherwise aword is not changed and 0 is returned
 */


dict deleteword(char aword[], dict adict);
/*
 * pre:  adict is a valid dictionary
 * post: the result contains all the words in adict except aword and the
 *       storage used by aword is reclaimed
 */


dict deletedict(dict adict);
/*
 * pre:  adict is a valid dictionary
 * post: the result is empty; all storage used by adict is reclaimed
 */
