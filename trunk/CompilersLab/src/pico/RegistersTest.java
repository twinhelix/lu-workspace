// ~lwy08, ~lx108, ~vdm108 / Jan 2010
// run with switch -ea to enable assertions
package pico;

import java.util.ArrayList;
import java.util.HashSet;

// JUnit test framework
public class RegistersTest extends junit.framework.TestCase {
	// class variables
	private Registers regs;
	private ArrayList<Register> used;
	private int count;

	// automatically executed before every test case
	protected void setUp() throws Exception {
		super.setUp();
		regs = new Registers();
		used = new ArrayList<Register>();
		count = regs.freeRegs();
	}

	/*
	 * cleanup operations automatically executed after every test case
	 */
	protected void tearDown() throws Exception {
		super.tearDown();
		regs = null;
		used = null;
		count = 0;
	}

	/* Test Cases */
	public void testNoOfRegs() {
		assertTrue("Less than 26 registers free: " + count, count >= 26);
	}

	private void allocateAllRegisters() {
		for (int i = 0; i < count; i++)
			used.add(regs.getFreeReg());
	}

	/*
	 * Attempt to allocate too many registers and check that getFreeReg()
	 * returns null if there are no free registers.
	 */
	public void testAllocTooManyRegs() {
		allocateAllRegisters();

		assertNull(
				"getFreeReg(): doesn't return null when there are no free registers",
				regs.getFreeReg());

		assertEquals("Too many registers allocated: " + used.size(), count,
				used.size());
	}

	/*
	 * Allocate all the registers and check that the same register is not
	 * allocated twice.
	 */
	public void testAllocRegsTwice() {
		allocateAllRegisters();

		HashSet<Register> set = new HashSet<Register>();
		for (int i = 0; i < used.size(); i++) {
			Register reg = used.get(i);
			assertTrue("Register " + reg + " was allocated twice", set.add(reg));
		}
	}

	public void testFreeRegs() throws Exception {
		allocateAllRegisters();

		// free all allocated registers
		for (Register register : used) {
			regs.free(register);
		}

		assertEquals("freeRegs(): incorrect no. of registers", count, regs
				.freeRegs());

		// check for attempt to free same register twice - expect error
		try {
			regs.free(used.get(0));
			regs.free(used.get(0));
		} catch (AssertionError errormessage) {
			String message = errormessage.getMessage();
			assertTrue(message.equals("register freed twice")
					|| message.equals("attempt to free dirty register"));
		}

		// have they all been freed ?
		int freenow = regs.freeRegs();
		assertEquals("original free reg: " + count + " now: " + freenow, count,
				freenow);
	}

	/*
	 * Attempt to call setVar() twice with the same register without calling
	 * unsetVar() on the Register inbetween.
	 */
	public void testSetVarTwice() {
		Register reg = regs.getFreeReg();
		// initially value = null
		assertNull(reg.getValue());

		regs.setVar(reg, "X");
		assertEquals("X", reg.getValue());

		try {
			regs.setVar(reg, "Y");
		} catch (AssertionError errormessage) {
			String message = errormessage.getMessage();
			assertTrue(message.equals("register is not free, cannot setVar()")
					| message.equals("register is storing " + reg.getValue()
							+ ", cannot setVar()"));
		}
	}

	public void testSetUnsetVar() {
		Register reg = regs.getFreeReg();
		// initially value = null
		assertNull(reg.getValue());

		regs.setVar(reg, "X");
		assertEquals("X", reg.getValue());

		regs.unSetVar(reg);
		assertNull(reg.getValue());

		regs.setVar(reg, "Y");
		assertEquals("Y", reg.getValue());
	}

	public void testSetDirtyCleanReg() throws Exception {
		Register reg = regs.getFreeReg();
		// initially clean
		assertFalse("Register reg initially dirty", regs.isDirty(reg));

		regs.setDirty(reg);
		assertTrue("Register reg is clean", regs.isDirty(reg));

		// check for attempt to free dirty register - expect error
		try {
			regs.free(reg);
			regs.free(reg);
		} catch (AssertionError errormessage) {
			String message = errormessage.getMessage();
			assertTrue(message.equals("register freed twice")
					|| message.equals("attempt to free dirty register"));
		}

		regs.setClean(reg);
		assertFalse("Register reg is dirty", regs.isDirty(reg));
	}

	public void testSetTempReg() {
		Register reg = regs.getFreeReg();
		// initially no temporary value
		assertFalse("Register reg initially temporary", reg.isTemp());

		regs.setTemp(reg);
		assertTrue("Register reg not holding temporary value", reg.isTemp());

		regs.notTemp(reg);
		assertFalse("Register reg used for temporary value", reg.isTemp());
	}
}
