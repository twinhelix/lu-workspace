// ~lwy08, ~lx108, ~vdm108 / Jan 2010
package pico;

public class Register {
	private String name = null, value = null;
	private boolean isDirty = false, isTemp = false, immediate = false;

	// default class constructor
	public Register(String name) {
		this.name = name;
	}

	// overrides toString() methods : returns user-friendly name
	public String toString() {
		return name;
	}

	// accessor methods //
	public String getValue() {
		return value;
	}

	public boolean isDirty() {
		return isDirty;
	}

	public boolean isTemp() {
		return isTemp;
	}

	public boolean isImmediate() {
		return immediate;
	}

	// mutator methods //
	public void setValue() {
		value = null;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public void setDirty(boolean isDirty) {
		this.isDirty = isDirty;
	}

	public void setTemp(boolean isTemp) {
		this.isTemp = isTemp;
	}

	public void setImmediate(boolean immediate) {
		this.immediate = immediate;
	}
}