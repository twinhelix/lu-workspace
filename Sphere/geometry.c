/*
 * geometry.c
 */

#include "sphere.h"

static float mypow(float val, int pow); // Private functions are static. Native to geometry.c

float surface_area(float radius) {
	return 4 * PI * mypow(radius, 2);
}

float volume(float radius) {
	return 4 * PI * mypow(radius, 3) / 3;
}

static float mypow(float val, int pow) {
	if (pow < 0) {
		return 1 / mypow(val, -pow);
	}

	else if (pow == 0) {
		return 1;
	}

	else {
		return val * mypow(val, pow - 1);
	}
}

