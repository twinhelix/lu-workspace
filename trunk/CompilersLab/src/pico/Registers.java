// ~lwy08, ~lx108, ~vdm108 / Jan 2010
package pico;

import java.util.ArrayList;

public class Registers {
	/*
	 * not using mips registers $at, $k0, $k1, $zero $v0/$a0 reserved for
	 * syscall where appropriate $sp/$ra for loops/conditionals
	 */
	private String[] mipsUserRegs = new String[] { "a0", "a1", "a2", "a3",
			"v0", "v1", "t0", "t1", "t2", "t3", "t4", "t5", "t6", "t7", "t8",
			"t9", "s0", "s1", "s2", "s3", "s4", "s5", "s6", "s7", "sp", "fp",
			"ra" };
	private Register[] allRegs;
	private ArrayList<Register> allocatedRegs;

	// default class constructor
	public Registers() {
		// init all registers
		allRegs = new Register[mipsUserRegs.length];
		for (int i = 0; i < mipsUserRegs.length; i++)
			allRegs[i] = new Register("$" + mipsUserRegs[i]);

		allocatedRegs = new ArrayList<Register>();
	}

	// Returns a free register, or null if there are no free registers.
	public Register getFreeReg() {
		for (Register reg : allRegs) {
			if (isFree(reg)) {
				allocatedRegs.add(reg);
				return reg;
			}
		}
		return null;
	}

	// The register can be reused.
	public void free(Register reg) {
		// cannot free a dirty register until value in variable is updated
		assert !reg.isDirty() : "attempt to free dirty register";

		// cannot free same register twice
		assert !isFree(reg) : "register freed twice";

		// at this point, allocatedRegs.contains(reg)
		reg.setValue();
		allocatedRegs.remove(reg);
	}

	// Is a particular register free? - used by getFreeReg()
	private boolean isFree(Register reg) {
		return !allocatedRegs.contains(reg);
	}

	// how many registers are free
	public int freeRegs() {
		int count = 0;
		for (Register reg : allRegs)
			if (isFree(reg))
				count++;
		return count;
	}

	// The register is not free, and will contain the value of the variable.
	public void setVar(Register reg, String variable) {
		assert !isFree(reg) : "register is free, cannot setVar()";

		assert reg.getValue() == null : "register is storing " + reg.getValue()
				+ ", cannot setVar()";

		reg.setValue(variable);
	}

	// The register will not contain a variables value.
	public void unSetVar(Register reg) {
		reg.setValue();
	}

	/*
	 * The register has been changed and not stored in the variable in main
	 * memory.
	 */
	public void setDirty(Register reg) {
		reg.setDirty(true);
	}

	/*
	 * The code generator would probably not call the this method each time it
	 * generates code to change the register. The register value is the same as
	 * variable in memory.
	 */
	public void setClean(Register reg) {
		reg.setDirty(false);
	}

	/*
	 * Returns true if code has been generated so the register value is not the
	 * same as the memory location for the variable.
	 */
	public boolean isDirty(Register reg) {
		return reg.isDirty();
	}

	// The register is used for a temporary value, and not mirroring a variable.
	public void setTemp(Register reg) {
		assert !isFree(reg) : "register is free, cannot setTemp()";

		assert reg.getValue() == null : "register is storing " + reg.getValue()
				+ ", cannot setTemp()";

		reg.setTemp(true);
	}

	// The register does not hold a temporary value.
	public void notTemp(Register reg) {
		reg.setTemp(false);
	}
}
