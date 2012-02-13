package turtleSupport;

public class Paper {
	private char[][] field;

	public Paper(int width, int height) {
		field = new char[width][height];
	}

	public void setField(int width, int height) {
		this.field = new char[width][height];
	}

	public char[][] getField() {
		return field;
	}

	public void show() {
		for (int i = 0; i < field.length; i++) {
			for (int j = 0; j < field[0].length; j++) {
				System.out.print(field[i][j]);
			}
			System.out.println();
		}
	}

	public void setTrail(int x, int y, char trail) {
		if (x < field.length && y < field[0].length)
			field[x][y] = trail;
	}
}
