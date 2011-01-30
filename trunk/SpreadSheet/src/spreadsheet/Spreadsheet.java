package spreadsheet;

import spreadsheet.parser.*;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

public class Spreadsheet implements SpreadsheetInterface {
	// Hash map used to store cells
	private HashMap<String, Cell> cells;
	// String to save last altered position
	private String lastCell = null;
	// Set to save cells visited during circular reference check
	Queue<String> visitCell;
	// Rows and columns
	private int numRows;
	private int numColumns;

	// Constructor
	public Spreadsheet(int numRows, int numColumns) {
		this.numRows = numRows;
		this.numColumns = numColumns;
		cells = new HashMap<String, Cell>();
	}

	public void recompute() {
		computeValue(lastCell);
		Queue<String> queue = new ConcurrentLinkedQueue<String>();
		queue.addAll(cells.get(lastCell).getChildren());

		for (String child : queue) {
			if (!cells.get(child).isDirty()){
				lastCell = child;
				computeValue(child);
				recompute ();
			}
			queue.remove();
		}
	}

	// Calculates the value of a cell, checks for circular reference too
	private void computeValue(String position) {
		// Saves the cell in a variable
		Cell c = new Cell();
		c = cells.get(position);

		String expression = c.getExpression().toLowerCase();

		// Sets its parents
		if (Expression.isFormula(expression)) {
			cells.get(position)
					.setParents(Expression.getReferences(expression));

			Map<String, Double> map = new HashMap<String, Double>();
			// Iterate through parents to get their values
			for (String parent : cells.get(position).getParents()) {
				String ref = parent;
				if (cells.containsKey(ref)) {
					// Checks to see if value is a double, if it is, puts in
					// map for calculation
					if (cells.get(ref).getValue() instanceof Double)
						map.put(ref, (Double) cells.get(ref).getValue());

				} else
					cells.put(ref, new Cell());
				// Adds current cell as a child of its parent cells
				Set<String> child = cells.get(ref).getChildren();
				child.add(position);
			}
			visitCell = new ConcurrentLinkedQueue<String>();

			checkLoop(position);
			if (!c.isDirty()) {
				c.setValue(Expression.computeValue(expression, map));
			}
		} else
			c.setValue(cells.get(position).getExpression());
	

	}

	private void checkLoop(String currCell) {

		visitCell.add(currCell);
		cells.get(currCell).setDirty(false);

		for (String branch : cells.get(currCell).getChildren()) {

			if (visitCell.contains(branch)) {
				// Removes all cells before the loop begins.
				for (String x : visitCell) {
					if (branch.compareTo(x) != 0)
						visitCell.remove(x);
					else
						break;
				}
				dirtyCells(visitCell);
				break;
			}
			checkLoop(branch);
			visitCell.remove(branch);
		}
	}

	// Method to set all cells in a queue dirty
	private void dirtyCells(Queue<String> circle) {

		for (String c : circle) {
			Cell cell = cells.get(c);
			cell.setDirty(true);
			cell.setValue(spreadsheet.SpreadsheetInterface.LOOP);
		}
	}

	// Getters and Setters

	public void setExpression(String location, String expression) {

		location = location.toLowerCase();

		if (Expression.isCellLocation(location)) {

			if (!cells.containsKey(location))
				cells.put(location, new Cell());

			cells.get(location).setExpression(expression);
			lastCell = location;
			removeParents(lastCell);

			for (String kids : cells.get(location).getChildren())
				cells.get(kids).setDirty(false);

		}
	}

	// Removes cell from all parent cells
	private void removeParents(String position) {

		for (String parent : cells.get(position).getParents()) {
			Set<String> child = cells.get(parent).getChildren();
			child.remove(position);
		}
	}

	public int getColumnCount() {
		return numColumns;
	}

	public int getRowCount() {
		return numRows;
	}

	public Object getValue(String location) {
		if (cells.containsKey(location))
			return cells.get(location).getValue();
		else
			return null;
	}

	public String getExpression(String location) {
		if (cells.containsKey(location))
			return cells.get(location).getExpression();
		else
			return null;
	}
}
