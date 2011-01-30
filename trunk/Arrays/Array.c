#include <stdio.h>
#define STUDENTS 10

int main(void) {
	int i, sum;
	int score[STUDENTS];
	float average;
	char grades[] = { 'A', 'B', 'C' };
	printf("Please input the grades: \n");

	for (i = 0; i < STUDENTS; i++) {
		scanf("%d", &score[i]);
	}

	sum = 0;

	for (i = 0; i < STUDENTS; i++) {
		if (score[i] >= 80) {
			printf("STUDEND %d got a %c \n", i + 1, grades[0]);
		}
		if (score[i] < 80 && score[i] >= 70) {
			printf("STUDEND %d got a %c \n", i + 1, grades[1]);
		}
		if (score[i] < 70 && score[i] >= 60) {
			printf("STUDEND %d got a %c \n", i + 1, grades[2]);
		}
		sum += score[i];
	}

	average = sum / STUDENTS;
	printf("The average of the class is %f", average);
	return 0;

}

