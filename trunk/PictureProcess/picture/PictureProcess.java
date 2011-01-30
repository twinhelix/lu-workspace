package picture;

import java.lang.reflect.Method;

public class PictureProcess {

	public static void main(String[] args) {

		PictureProcess pp = new PictureProcess();
		// get list of methods in class PictureProcess
		Method[] commandList = PictureProcess.class.getDeclaredMethods();
		// find matching transform to invoke
		boolean isCommand = false;
		for (int i = 0; i < commandList.length; i++) {
			// match found! (case-insensitive)
			if (commandList[i].getName().equalsIgnoreCase(args[0])) {
				try {
					assert (args.length > 1) : "Too few inputs";
					// invoke method, passing args as parameters
					commandList[i].invoke(pp, new Object[] { args });
					isCommand = true;

				} catch (Exception e) {
					System.out.println("Invalid entry");
				}
				return;
			}
		}
		if (!isCommand) {
			try {
				PictureTool.toScreen(PictureTool.loadImage(args[0]));
			} catch (Exception e) {
			}
		}
	}

	// Inverts the colours of the picture by using 255 - colour in RGB.
	public static void invert(String[] url) {
		Picture p = PictureTool.loadImage(url[1]);
		int h = p.getHeight(); // Gets the height and width
		int w = p.getWidth();
		Picture newP = PictureTool.createPicture(w, h); // Creates new picture
		for (int i = 0; i < w; i++) { // Loops through each pixel
			for (int j = 0; j < h; j++) {
				Color c = p.getPixel(i, j);
				c.setRed(255 - c.getRed()); // Changes all colours
				c.setGreen(255 - c.getGreen()); // to 255 - *
				c.setBlue(255 - c.getBlue());// Resets new colours
				newP.setPixel(i, j, c); // Puts new colour in picture
			}
		}
		PictureTool.toScreen(newP); // Displays picture
	}

	// Shows the picture in grayscale by averaging all colours in RGB
	public static void grayscale(String[] url) {
		Picture p = PictureTool.loadImage(url[1]);
		int h = p.getHeight();
		int w = p.getWidth();// Obtains size
		Picture newP = PictureTool.createPicture(w, h); // Creates new picture
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) { // Loops through all pixels
				Color c = p.getPixel(x, y);
				int newrgb = (c.getRed() + c.getGreen() + c.getBlue()) / 3;
				c.setRed(newrgb); // Finds average colour
				c.setGreen(newrgb); // Sets pixel to all the same average clr
				c.setBlue(newrgb);
				newP.setPixel(x, y, c);
			}
		}
		PictureTool.toScreen(newP); // Displays picture
	}

	// Rotates picture by 90/180/270 degrees by altering pixel positions
	public static void rotate(String[] url) {
		int degree = Integer.parseInt(url[1]);
		Picture p = PictureTool.loadImage(url[2]);
		int h = p.getHeight();
		int w = p.getWidth(); // Obtains size of picture
		Picture newP; // Creates new picture
		if (degree == 90) { // If statements to see which method should be used
			newP = PictureTool.createPicture(h, w);
			for (int x = 0; x < w; x++) {
				for (int y = 0; y < h; y++) {
					newP.setPixel(h - y - 1, x, p.getPixel(x, y));
				} // Switches x and y position, and flips the new x position
			}
		} else if (degree == 180) {
			newP = PictureTool.createPicture(w, h);
			for (int x = 0; x < w; x++) {
				for (int y = 0; y < h; y++) {
					newP.setPixel(w - x - 1, h - y - 1, p.getPixel(x, y));
				} // Switches x and y position, flips the new x and y position
			}
		} else if (degree == 270) {
			newP = PictureTool.createPicture(h, w);
			for (int x = 0; x < w; x++) {
				for (int y = 0; y < h; y++) {
					newP.setPixel(y, w - x - 1, p.getPixel(x, y));
				}// Switches x and y position, flips the new y position.
			}
		} else
			newP = p; // If a invalid degree is given, then no rotation is done
		PictureTool.toScreen(newP); // Displays picture.
	}

	public static void flip(String[] url) {
		Picture p = PictureTool.loadImage(url[2]);
		int h = p.getHeight();
		int w = p.getWidth(); // Obtains info
		Picture newP = PictureTool.createPicture(w, h); // Creates picture
		if (url[1].equalsIgnoreCase("H")) {
			for (int x = 0; x < w; x++) {
				for (int y = 0; y < h; y++) {
					newP.setPixel(w - x - 1, y, p.getPixel(x, y));
				} // flips x position.
			}
		} else if (url[1].equalsIgnoreCase("V")) {
			for (int x = 0; x < w; x++) {
				for (int y = 0; y < h; y++) {
					newP.setPixel(x, h - y - 1, p.getPixel(x, y));
				} // flips y position.
			}
		} else
			newP = p; // if invalid flip given, no flipping is done
		PictureTool.toScreen(newP); // Displays picture
	}

	public static void blend(String[] urls) {
		int len = urls.length - 1; // Gets total number of pictures
		Picture[] ps = new Picture[len]; // Creates array of pictures
		for (int i = 0; i < len; i++) {
			ps[i] = PictureTool.loadImage(urls[i + 1]);
		} // Loads all images from url
		int minW = ps[0].getWidth();
		for (int i = 1; i < len; i++) {
			if (ps[i].getWidth() < minW)
				minW = ps[i].getWidth();
		}
		int minH = ps[0].getHeight();
		for (int i = 1; i < len; i++) {
			if (ps[i].getHeight() < minH)
				minH = ps[i].getHeight();
		} // Finds smallest width and height
		Picture bl = PictureTool.createPicture(minW, minH); // Creates new pict
		for (int x = 0; x < minW; x++) {
			for (int y = 0; y < minH; y++) {
				Color rgb = aveColor(x, y, ps); // Calls helper function
				bl.setPixel(x, y, rgb); // Sets pixel to new value
			}
		}
		PictureTool.toScreen(bl); // Displays picture
	}

	private static Color aveColor(int x, int y, Picture[] ps) {
		int sumR = 0;
		int sumG = 0;
		int sumB = 0;
		int len = ps.length;
		Color pix;
		for (int i = 0; i < len; i++) {
			pix = ps[i].getPixel(x, y);
			sumR = sumR + pix.getRed();
			sumG = sumG + pix.getGreen();
			sumB = sumB + pix.getBlue();
		} // Finds total of all colours in RGB
		Color c = new Color(sumR / len, sumG / len, sumB / len); // Average RGB
		return c;
	}

	public static void blur(String[] url) {
		Picture p = PictureTool.loadImage(url[1]);
		int w = p.getWidth();
		int h = p.getHeight(); // Obtains info
		Picture newP = PictureTool.createPicture(w, h); // Creates picture
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) { // Loops through all pixels
				Color c = p.getPixel(x, y);
				if (x == 0 || y == 0 || x == w - 1 || y == h - 1) {
					newP.setPixel(x, y, c); // Check for edge pixels
				} else {
					newP.setPixel(x, y, pixelAve(x, y, p));
				} // Else calls helper function to find blur colour values
			}
		}
		PictureTool.toScreen(newP); // Displays picture
	}

	private static Color pixelAve(int x, int y, Picture p) {
		int sumR = 0;
		int sumG = 0;
		int sumB = 0;
		for (int i = -1; i <= 1; i++) {
			for (int j = -1; j <= 1; j++) {
				Color c = p.getPixel(x + i, y + i);
				sumR = sumR + c.getRed();
				sumG = sumG + c.getGreen();
				sumB = sumB + c.getBlue();
			} // Loop to obtain sum of all RGB in 3x3 pixels around target pix
		}
		Color newC = new Color(sumR / 9, sumG / 9, sumB / 9);
		return newC; // returns created average pixel
	}

	public static void mosaic(String[] urls) {
		int tile = Integer.parseInt(urls[1]);
		int len = urls.length - 2; // Gets total number of pictures
		Picture[] ps = new Picture[len]; // Creates array of pictures
		for (int i = 0; i < len; i++) {
			ps[i] = PictureTool.loadImage(urls[i + 2]);
		} // Loads all images from url
		int minW = ps[0].getWidth();
		for (int i = 1; i < len; i++) {
			if (ps[i].getWidth() < minW)
				minW = ps[i].getWidth();
		}
		int minH = ps[0].getHeight();
		for (int i = 1; i < len; i++) {
			if (ps[i].getHeight() < minH)
				minH = ps[i].getHeight();
		} // Finds smallest width and height
		Picture mos = PictureTool.createPicture(minW, minH); // Creates new pict
		// Fills individual tiles
		for (int x = 0; x < minW; x += tile) {
			for (int y = 0; y < minH; y += tile) {
				int arrNo = (x / tile + y / tile) % len;
				// Determines which picture to take
				for (int i = 0; i < tile; i++) {
					for (int j = 0; j < tile; j++) {
						if (mos.contains(x + i, y + j)) {
							Color c = ps[arrNo].getPixel(x + i, y + j);
							mos.setPixel(x + i, y + j, c);
						}
					}
				}
			}
		}
		PictureTool.toScreen(mos);
	}
}