package life;

import java.awt.*;

public class Model {
	private int rows;
	private PointColor[][] area, areaCopy;
	private static Model instance = null;
	private View v = null;
	private final Color CELL_ALIVE1 = Color.red;
	private final Color CELL_ALIVE2 = Color.green;
	private final Color CELL_DEAD = Color.gray;

	private Model() {
		// Purely for singleton purposes.
	}

	// Return the instance of the singelton class
	public static Model getInstance() {
		if (instance == null)
			instance = new Model();
		return instance;
	}

	// Initialize arrays and gets an instance of View
	public void initialize(int rows) {
		this.rows = rows;
		area = new PointColor[rows][rows];
		initArea();

		v = View.getInstance();
		v.initialize(rows);
	}

	public void initArea() {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < rows; c++)
				area[r][c] = new PointColor(c, r, CELL_DEAD);
		}
	}

	// Add point to the Area
	public void addPoint(PointColor pc) {
		area[pc.y][pc.x] = pc;
	}
	
	// Clear resets to GRAY
	public void clear() {
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < rows; c++)
				area[r][c].color = CELL_DEAD;
		}
	}

	// Make a copy of the area, then find which cells need to be changed
	// And update those cells in the GUI
	// Change Area to the copy after all working is done.
	public void step() {
		areaCopy = new PointColor[rows][rows];
		areaCopy = copyArr(area);

		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < rows; c++) {
				if (cellChanged(r, c))
					v.updateCellColour(areaCopy[r][c]);
			}
		}
		area = copyArr(areaCopy);
	}

	// Checks the cell at (r,c) and checks its neighbors
	// Changes the cell is needed, turns turn if cell
	// has been changed.
	public boolean cellChanged(int r, int c) {
		Color before = area[r][c].color;
		int reds = 0;
		int greens = 0;

		for (int y = -1; y <= 1; y++) {
			for (int x = -1; x <= 1; x++) {
				if (x != 0 || y != 0) {
					// Work out positions of neighbors
					int a = (r + y + rows) % rows;
					int b = (c + x + rows) % rows;
					Color temp = area[a][b].color;

					// Add neighbors
					if (temp.equals(CELL_ALIVE1))
						reds++;
					else if (temp.equals(CELL_ALIVE2))
						greens++;
				}
			}
		}
		int neighbours = reds + greens;
		// Exactly 3 neighbors spawns a new cell
		if (area[r][c].color.equals(CELL_DEAD) && neighbours == 3) {
			// System.out.println("SPAWN");
			if (reds > greens)
				areaCopy[r][c].color = CELL_ALIVE1;
			else
				areaCopy[r][c].color = CELL_ALIVE2;
		}
		// Cell dies from isolation or suffocation
		else if (neighbours <= 1 || neighbours >= 4)
			areaCopy[r][c].color = CELL_DEAD;

		// 2 or 3 neighbors the cell will lives on.		
		return (!(before.equals(areaCopy[r][c].color)));
	}

	private PointColor[][] copyArr(PointColor[][] target) {
		PointColor[][] copy = new PointColor[rows][rows];
		for (int r = 0; r < rows; r++) {
			for (int c = 0; c < rows; c++)
				copy[r][c] = new PointColor(c, r, target[r][c].color);
		}
		return copy;
	}
}
