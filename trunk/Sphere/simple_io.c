/*
 * simple_io.c
 */

#include "sphere.h"

float get_value(void) {
	float result;
	scanf("%f", &result);
	return result;
}

void put_value(float val) {
	printf("%f\n", val);
}

