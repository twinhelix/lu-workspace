#include <stdio.h>
#define MAXLENGTH 1000

int getline(char string[], int maxlen);
void copy(char to[], char from[]);

// Saves the longest string of all typed strings.
int main(void) {
	int len, max;
	char line[MAXLENGTH];
	char longest[MAXLENGTH];

	max = 0;

	while ((len = getline(line, MAXLENGTH)) > 1) {
		if (len > max) {
			max = len;
			copy(longest, line);
		}
	}

	if (max > 0) {
		printf("%s", longest);
	}
	return 0;
}

// Gets new line and returns the length. Adds the '\0' char at the end to show end of word.
int getline(char string[], int maxlen) {
	int chr, i;

	for (i = 0; i < maxlen - 1 && (chr = getchar()) != EOF && chr != '\n'; i++) {
		string[i] = chr;
	}
	if (chr == '\n') {
		string[i] = chr;
		i++;
	}
	string[i] = '\0';
	return i;
}

// Copy 'from' into 'to'; assume it is big enough
void copy(char to[], char from[]) {
	int i = 0;

	while ((to[i] = from[i]) != '\0') {
		i++;
	}
}
