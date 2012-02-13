#include <stdio.h>

int main(void) {
	// Declarations ***
	int opt = 0, i = 1, j = 2;
	void exchange(int i, int j);
	void exchangePointers(int *ip, int *jp);
	// END 			***

	printf("main BEFORE : i = %d j = %d\n", i, j);
	printf(
			"Please enter 1 for exchange with OUT pointers, 2 for exchange of pointers: ");
	scanf("%d", &opt);

	switch (opt) {
	case 1:
		exchange(i, j);
		break;
	case 2:
	// & yields the pointer of a variable.
		exchangePointers(&i, &j);
	}


	printf("main AFTER  : i = %d j = %d\n", i, j);

	return 0;
}

void exchange(int i, int j) {

	int temp;

	temp = i;
	i = j;
	j = temp;
	printf("exchange withOUT pointers: i = %d j = %d\n", i, j);
}

void exchangePointers(int *ip, int *jp) {
	// * yields the value of a pointer

	int temp;

	temp = *ip;
	*ip = *jp;
	*jp = temp;
	printf("exchange WITH pointers: i = %d j = %d\n", *ip, *jp);
}
