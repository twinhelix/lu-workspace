package database;

import junit.framework.*;
import java.util.*;

public class TestOrderedLinkedList extends TestCase {
	/* Variable declaration */
	private OrderedLinkedList<String, Integer> d;

	private final static int TEST_SIZE = 10;

	/** Constructor */
	public TestOrderedLinkedList(String name) {
		super(name);
	}

	/** Sets up new object before testing */
	protected void setUp() {
		d = new OrderedLinkedList<String, Integer>();
	}

	/** Clears object after testing */
	protected void tearDown() {
		d = null;
	}

	/** Tests isEmpty() method */
	public void testisEmpty() {
		boolean tester = false;
		setUp();
		tester = d.isEmpty();
		d.put("Tiddles", 10);
		tester = !d.isEmpty();
		assertTrue("isEmpty not working", tester);
		tearDown();
	}

	/** Tests size() method */
	public void testsize() {
		setUp();
		loadTest();
		assertEquals("Size returns wrong number", TEST_SIZE, d.size());
		tearDown();
	}

	/** Tests clear() method */
	public void testclear() {
		setUp();
		loadTest();
		d.clear();
		assertTrue("List not cleared", d.isEmpty());
		tearDown();
	}

	/** Tests put() method */
	public void testput() {
		setUp();
		d.put("Tiddles", 10);
		assertSame("Item not added correctly", 10, d.get("Tiddles"));
		tearDown();

	}

	/** Tests get() method */
	public void testget() {
		setUp();
		d.put("Tiddles", 10);
		assertTrue("Gettin on item failed", d.get("Tiddles") == 10);
		tearDown();
	}

	/** Tests remove() method */
	public void testremove() {
		setUp();
		d.put("Tiddles", 10);
		d.remove("Tiddles");
		try {
			d.get("Tiddles");
			fail("Cat should be removed");
		} catch (NoSuchElementException e) {
			assertTrue(true);
		}
		tearDown();
	}

	/** Tests if Exception is thrown in get() method */
	public void testgetException() {
		setUp();
		try {
			d.get("Tiddles");
			fail("Looking up cat not in database should cause exception");
		} catch (NoSuchElementException e) {
			assertTrue(true);
		}
		tearDown();
	}

	/** Tests if iterator works properly */
	public void testListIterator() {
		boolean tester = true;
		setUp();
		Iterator<DictionaryEntry<String, Integer>> it = d.iterator();
		tester = !it.hasNext();

		loadTest();
		it = d.iterator();

		for (int i = 0; i < TEST_SIZE && tester; i++) {
			if (it.next().getKey().compareTo("Cat" + i) != 0)
				tester = false;
		}
		tester = !it.hasNext();
		assertTrue("Iterator is not working", tester);
		tearDown();
	}

	/** Helper method to set up a list of cats */
	protected void loadTest() {
		for (int i = 0; i < TEST_SIZE; i++) {
			String temp = "Cat" + i;
			d.put(temp, i);
		}
	}

	/** Test sutie */
	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(new TestOrderedLinkedList("testisEmpty"));
		suite.addTest(new TestOrderedLinkedList("testsize"));
		suite.addTest(new TestOrderedLinkedList("testclear"));
		suite.addTest(new TestOrderedLinkedList("testput"));
		suite.addTest(new TestOrderedLinkedList("testget"));
		suite.addTest(new TestOrderedLinkedList("testremove"));
		suite.addTest(new TestOrderedLinkedList("testgetException"));
		suite.addTest(new TestOrderedLinkedList("testListIterator"));
		return suite;
	}

}
