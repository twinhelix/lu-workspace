package picture;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.MediaTracker;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

/**
 * A set of convenient methods to create and display Picture objects.
 */
public final class PictureTool {

	/**
	 * The minimum pixel border-size required by the size of an image for it to
	 * be displayed in full size.
	 */
	private static final int SCREEN_GAP = 100;

	/**
	 * Hide default constructor (static methods only).
	 */
	private PictureTool() {
	}

	/**
	 * Create a new instance of a Picture object of the specified width and
	 * height, using the RGB colour model.
	 * 
	 * @param width
	 *            width of new Picture
	 * @param height
	 *            height of new Picture
	 * @return a new instance of a Picture object of the specified size.
	 */
	public static Picture createPicture(int width, int height) {
		BufferedImage img = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		if (img != null) {
			return new Picture(img);
		}

		throw new RuntimeException("Cannot create a Picture of size: " + width
				+ "x" + height);
	}

	/**
	 * Create a Picture object from the the image at the specified url.
	 * 
	 * @param urlString
	 *            URL of the image to be loaded.
	 * @return a Picture representing the image at the specified URL, or.
	 */
	public static Picture loadImage(String urlString) {

		BufferedImage img = null;
		BufferedImage origImage = null;
		Picture result = null;

		try {
			origImage = ImageIO.read(new URL(urlString));
		} catch (Exception e) {
			System.err.println("Unable to load " + urlString);
		}

		// Ensure the entire image is loaded first....
		try {
			MediaTracker tracker = new MediaTracker(new JPanel());
			tracker.addImage(origImage, 0);
			tracker.waitForID(0);
			if (tracker.statusID(0, true) != MediaTracker.COMPLETE) {
				System.err.println("Unable to load " + urlString);
			}
		} catch (InterruptedException e) {
			// won't be interrupted
			System.err.println("Unable to load " + urlString);
		}

		// If image loaded, then create a BufferedImage which is modifiable
		int imageWidth = origImage.getWidth(null);
		int imageHeight = origImage.getHeight(null);
		if ((origImage != null) && (imageWidth > 0) && (imageHeight > 0)) {
			img = new BufferedImage(imageWidth, imageHeight,
					BufferedImage.TYPE_INT_RGB);
			Graphics g = img.createGraphics();
			g.drawImage(origImage, 0, 0, null);
			result = new Picture(img);
		}

		return result;

	}

	/**
	 * Display the specified Picture on-screen.
	 * 
	 * @param picture
	 *            the picture to be displayed on-screen
	 */
	public static void toScreen(Picture picture) {

		new JFrame("Picture") {

			private BufferedImage img;

			private Dimension imgSize;

			public void init(Picture p) {
				img = p.getImage();
				imgSize = new Dimension(p.getWidth(), p.getHeight());
				setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

				// create image panel
				JPanel imagePanel = new JPanel() {
					public void paintComponent(Graphics g) {
						super.paintComponent(g);
						g.drawImage(img, 0, 0, null);
					}

					public Dimension getPreferredSize() {
						return imgSize;
					}
				};

				setContentPane(new JScrollPane(imagePanel));

				// set size
				Dimension frameSize;
				Dimension screenSize = Toolkit.getDefaultToolkit()
						.getScreenSize();
				if ((img.getWidth() > (screenSize.width - SCREEN_GAP))
						|| (img.getHeight() > (screenSize.height - SCREEN_GAP))) {
					frameSize = new Dimension(screenSize.width / 2,
							screenSize.height / 2);
					setPreferredSize(frameSize);
				} else {
					frameSize = imgSize;
					setSize(frameSize);
				}

				// set location
				setLocation((screenSize.width - frameSize.width) / 2,
						(screenSize.height - frameSize.height) / 2);
				pack();

				setVisible(true);
			}
		}.init(picture);

	}

	/**
	 * Returns a String representation of the RGB components of the picture.
	 * 
	 * @param picture
	 *            the picture to convert to a String
	 * @return a String representation of the specified Picture
	 */
	public static String toArray(Picture picture) {
		StringBuffer sb = new StringBuffer();

		for (int y = 0; y < picture.getHeight(); y++) {
			for (int x = 0; x < picture.getWidth(); x++) {
				Color rgb = picture.getPixel(x, y);
				sb.append("(");
				sb.append(rgb.getRed());
				sb.append(",");
				sb.append(rgb.getGreen());
				sb.append(",");
				sb.append(rgb.getBlue());
				sb.append(")");
			}
			sb.append("\n");
		}
		sb.append("\n");
		return sb.toString();
	}

}
