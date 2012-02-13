package spreadsheet;

import java.util.*;
// Class to store information of a single cell
public class Cell {
	private String expression;
	private Object value;
	private Set<String> children;
	private Set<String> parents;
	private boolean dirty = false;

	// Constructor
	public Cell() {
		this.expression = "";
		children = new TreeSet<String>();
		parents = new TreeSet<String>();
	}

	// Getters and Setters
	public String getExpression() {
		return expression;
	}

	public void setExpression(String expression) {
		this.expression = expression;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Set<String> getChildren() {
		return children;
	}

	public boolean isDirty() {
		return dirty;
	}

	public void setDirty(boolean dirty) {
		this.dirty = dirty;
	}

	public void setChildren(Set<String> children) {
		this.children = children;
	}

	public Set<String> getParents() {
		return parents;
	}

	public void setParents(Set<String> parents) {
		this.parents = parents;
	}

}
