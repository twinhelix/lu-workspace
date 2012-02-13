/*
 * SKELETON: C_Dictionary.
 *
 * "dict.c":
 * implements the functions given in header file "dict.h".
 */

/*
 * Include standard I/O definitions,
 * no input/output should be done by
 * these functions, except for debugging
 */
#include <stdio.h>
#include <sys/types.h>
#include <stdlib.h>
#include <string.h>
#include <assert.h>

/*
 * include the header file defining types and function prototypes
 */
#include "dict.h"

dict deleteNode(dict adict);
dict findLeftMost(dict adict);
dict deleteLeftMost(dict adict);

dict addword(char aword[], dict adict) {
	if (adict == NULL) {
		adict = malloc(sizeof(struct dictionary));
		adict -> left = NULL;
		adict -> right = NULL;
		strcpy(adict -> theword, aword);
	}

	else if (strcmp(aword, adict -> theword) < 0)
		adict -> left = addword(aword, adict->left);

	else if (strcmp(aword, adict -> theword) > 0)
		adict -> right = addword(aword, adict -> right);

	return adict;
}

void printdict(dict adict) {
	if (adict != NULL) {
		printdict(adict -> left);
		printf("%s\n", adict -> theword);
		printdict(adict -> right);
	}
}

int lookup(char aword[], dict adict) {
	if (adict == NULL)
		return 0;
	else if (strcmp(adict -> theword, aword) == 0)
		return 1;
	else
		return lookup(aword, adict->left) + lookup(aword, adict->right);
}

int countwords(dict adict) {
	return adict == NULL ? 0 : 1 + countwords(adict -> left) + countwords(
			adict -> right);
}

int findword(dict adict, int pos, char aword[]) {

	if (pos >= 1 && pos <= countwords(adict)) {

		int leftSize = countwords(adict -> left);

		if (leftSize + 1 == pos) {
			strcpy(aword, adict -> theword);
		}

		else if (pos <= leftSize) {
			findword(adict->left, pos, aword);
		}

		else {
			findword(adict->right, pos - (leftSize + 1), aword);
		}
		return 1;
	}

	else
		return 0;

}

dict findLeftMost(dict adict) {
	return (adict->left == NULL) ? adict : findLeftMost(adict->left);
}

dict deleteLeftMost(dict adict) {
	if (adict->left == NULL) {
		dict newNode = adict->right;
		return newNode;
	} else {
		adict->left = deleteLeftMost(adict->left);
		return adict;
	}
}

dict deleteNode(dict adict) {

	if (adict->left == NULL && adict->right == NULL) {
		free(adict);
		return NULL;
	} else if (adict->right == NULL) {
		dict newNode = adict->left;
		free(adict);
		return newNode;
	} else if (adict->left == NULL) {
		dict newNode = adict->right;
		free(adict);
		return newNode;
	} else {
		dict newNode = findLeftMost(adict->right);
		newNode -> left = adict -> left;
		newNode -> right = deleteLeftMost(adict->right);
		free(adict);
		return newNode;
	}
}

dict deleteword(char aword[], dict adict) {
	if (adict == NULL)
		return NULL;

	if (strcmp(aword, adict->theword) == 0)
		return deleteNode(adict);
	else if (strcmp(aword, adict->theword) < 0)
		adict -> left = deleteword(aword, adict->left);
	else if (strcmp(aword, adict->theword) > 0)
		adict -> right = deleteword(aword, adict->right);
	return adict;
}

dict deletedict(dict adict) {
	if (adict != NULL) {
		deletedict(adict -> left);
		deletedict(adict -> right);
		free(adict);
		adict = NULL;
	}
	return NULL;
}
