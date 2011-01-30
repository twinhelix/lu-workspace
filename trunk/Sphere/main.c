/*
 * main.c
 */

#include "sphere.h"

int main(void){
	float radius, vol;

	printf("Input the radius of the sphere: ");
	radius = get_value();

	printf("Surface area : ");
	put_value(surface_area(radius));

	vol = volume(radius);
	printf("Volume : ");
	put_value(vol);
	return 0;
}
