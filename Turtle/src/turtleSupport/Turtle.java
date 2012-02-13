package turtleSupport;

public class Turtle {
	String name;
	boolean pen;
	char trail;
	int xpos;
	int ypos;
	int face;
	String type;

	public Turtle(String name, boolean pen, char trail, int xpos, int ypos,
			int face, String type) {
		this.name = name;
		this.pen = pen;
		this.trail = trail;
		this.xpos = xpos;
		this.ypos = ypos;
		this.face = face;
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isPen() {
		return pen;
	}

	public void setPen(boolean pen) {
		this.pen = pen;
	}

	public char getTrail() {
		return this.trail;
	}

	public void setTrail(char trail) {
		this.trail = trail;
	}

	public int getXpos() {
		return xpos;
	}

	public void setXpos(int xpos) {
		this.xpos = xpos;
	}

	public int getYpos() {
		return ypos;
	}

	public void setYpos(int ypos) {
		this.ypos = ypos;
	}

	public int getFace() {
		return face;
	}

	public void setFace(int face) {
		this.face = face;
		// N = 0, NE = 1, E = 2, SE = 3, S = 4, SW = 5, W = 6, NW = 7;
	}

}
