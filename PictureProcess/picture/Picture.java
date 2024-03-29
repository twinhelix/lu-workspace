package picture;

import java.awt.image.BufferedImage;

/**
 * A class that encapsulates and provides a simplified interface for
 * manipulating an image. The internal representation of the image is based on
 * the RGB direct colour model. Refer to <tt>picture.PictureTool</tt> for
 * information on how to create instances of this class.
 * 
 * @see picture.PictureTool PictureTool
 */
public class Picture {

	/** The internal image representation of this picture. */
	private final BufferedImage image;

	/**
	 * Construct a new Picture object from the specified image.
	 * 
	 * @param image
	 *            the internal representation of the image.
	 */
	protected Picture(BufferedImage image) {
		this.image = image;
	}

	/**
	 * Return the internal image represented by the Picture.
	 * 
	 * @return the <tt>BufferedImage</tt> associated with this
	 *         <tt>Picture</tt>.
	 */
	protected BufferedImage getImage() {
		return image;
	}

	/**
	 * Return the width of the <tt>Picture</tt>.
	 * 
	 * @return the width of this <tt>Picture</tt>.
	 */
	public int getWidth() {
		return image.getWidth();
	}

	/**
	 * Return the height of the <tt>Picture</tt>.
	 * 
	 * @return the height of this <tt>Picture</tt>.
	 */
	public int getHeight() {
		return image.getHeight();
	}

	/**
	 * Return the colour components (red, green, then blue) of the pixel-value
	 * located at (x,y).
	 * 
	 * @param x
	 *            x-coordinate of the pixel value to return
	 * @param y
	 *            y-coordinate of the pixel value to return
	 * @return the RGB components of the pixel-value located at (x,y).
	 * @throws ArrayIndexOutOfBoundsException
	 *             if the specified pixel-location is not contained within the
	 *             boundaries of this picture.
	 */
	public Color getPixel(int x, int y) {
		int rgb = image.getRGB(x, y);
		return new Color( (rgb >> 16) & 0xff, (rgb >> 8) & 0xff, rgb & 0xff);
	}

	/**
	 * Update the pixel-value at the specified location.
	 * 
	 * @param x
	 *            the x-coordinate of the pixel to be updated
	 * @param y
	 *            the y-coordinate of the pixel to be updated
	 * @param rgb
	 *            the RGB components of the updated pixel-value
	 * @throws ArrayIndexOutOfBoundsException
	 *             if the specified pixel-location is not contained within the
	 *             boundaries of this picture.
	 */
	public void setPixel(int x, int y, Color rgb) {

		image.setRGB(x, y, 0xff000000 | (((0xff & rgb.getRed()) << 16)
				| ((0xff & rgb.getGreen()) << 8) | (0xff & rgb.getBlue())));
	}

	/**
	 * Test if the specified point lies within the boundaries of this picture.
	 * 
	 * @param x
	 *            the x co-ordinate of the point
	 * @param y
	 *            the y co-ordinate of the point
	 * @return <tt>true</tt> if the point lies within the boundaries of the
	 *         picture, <tt>false</tt> otherwise.
	 */
	public boolean contains(int x, int y) {
		return x >= 0 && y >= 0 && x < getWidth() && y < getHeight();
	}

}
