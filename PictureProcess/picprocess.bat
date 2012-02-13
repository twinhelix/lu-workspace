#!/bin/bash
# java picture.PictureProcess 
# bash script which parses command-line arguments
url="http://www.zhiqing.org/wp-content/uploads/2008/01/guilin.jpg"
cmd="java -ea picture.PictureProcess"

if [ $# -eq 0 ]
then
	echo "No Arguments Supplied...Terminating"
else
case "$1" in
     invert)
		echo "invert"
		`$cmd invert $url`;;
	 grayscale)
		echo "grayscale"
		`$cmd grayscale $url`;;
	greyscale)
		echo "greyscale"
		`$cmd greyscale $url`;;
	rotate)
		echo "rotate 90"
		`$cmd rotate 90 $url`
		echo "rotate 180"
		`$cmd rotate 180 $url`
		echo "rotate 270"
		`$cmd rotate 270 $url`;;
	flip)
		echo "flip H"
		`$cmd flip H $url`
		echo "flip V"
		`$cmd flip V $url`;;
	blend)
		echo "blend"
		`$cmd blend $url http://images.xango.com/mangosteen-tree.jpg http://www.autounleashed.com/images/audi_locus_concept_car.jpg http://www.zhiqing.org/wp-content/uploads/2008/01/guilin.jpg`
		;;
	blur)
		echo "blur"
		`$cmd blur $url`
		;;
	auto)
		echo `$0 invert`
		echo `$0 grayscale`
		echo `$0 rotate`
		echo `$0 flip`
		echo `$0 blend`
		echo `$0 blur`
		;;
     *)
		`$cmd invert $url`
        exit;;
esac
fi
