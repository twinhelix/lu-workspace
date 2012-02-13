package database;

import java.util.Scanner;

/**
 * Test harness for implementation classes BinarySearchTree.java, and
 * OrderedLinkedList.java which implement the interface class Dictionary.java
 * offering access procedures for a database of cats in a cattery and their
 * dietary requirements.
 */
public class CatAdmin {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			new CatAdmin();
		} catch (Exception e) {
			System.err
					.println("Could not launch the Cattery Administrative tool.");
			System.err.println("Please check your implementation.");
			e.printStackTrace();
		}
	}

	/**
	 * @throws Exception
	 */
	public CatAdmin() throws Exception {
		boolean finished = false;
		Scanner scanner = new Scanner(System.in);
		Database db = new Database(new BinarySearchTree<String, Integer>());
		String command, name;
		int num;

		System.out.println("Cattery Administration Tool in Java");
		printMainMenu();

		while (!finished) {
			System.out.print("Select a menu option: ");
			command = scanner.next();

			if (command.equals("add")) {
				name = scanner.next();
				num = scanner.nextInt();
				db.add(name, num);

			} else if (command.equals("lookup")) {
				name = scanner.next();
				num = db.lookup(name);
				System.out.println("NAME\tNO. OF TINS");
				if (num != -1) {
					System.out.println(name + "\t" + num);
				} else {
					System.out.println(name + "\t***Not found***");
				}

			} else if (command.equals("clear")) {
				db.clear();

			} else if (command.equals("count")) {
				System.out.println("NO. OF CATS\tTOTAL NO. OF TINS");
				System.out.println(db.countCats() + "\t\t" + db.countTins());

			} else if (command.equals("delete")) {
				name = scanner.next();
				db.delete(name);

			} else if (command.equals("print")) {
				System.out.println("NAME\tNO. OF TINS");
				db.printDatabase();

			} else if (command.equals("switch")) {

				db = (db.getDictionaryType().equals(BinarySearchTree.class
						.getSimpleName())) ? new Database(
						new OrderedLinkedList<String, Integer>())
						: new Database(new BinarySearchTree<String, Integer>());

				System.out.println("Using " + db.getDictionaryType()
						+ " implementation.\n");

			} else if (command.equals("benchmark")) {
				try {
					if (db.countCats() > 0) {
						new database.benchmark.Benchmark(System
								.currentTimeMillis()).testLoaded(db);
					} else {
						System.out
								.println("Nothing to benchmark: database is empty.");
					}

				} catch (ClassNotFoundException e) {
					System.out
							.println("Benchmarking libraries not loaded.  Reload the tool with the following command: ");
					System.out
							.println("java -javaagent:benchmark.jar database.CatAdmin");
				}

			} else if (command.equals("load")) {
				int number = scanner.nextInt();
				db.clear();
				new database.benchmark.Benchmark(System.currentTimeMillis())
						.load(db, number, false);

			} else if (command.equals("help")) {
				printMainMenu();

			} else if (command.equals("debug")) {
				printDebugMenu();

			} else if (command.equals("quit")) {
				finished = true;

			} else {
				System.out.println("***Command `" + command
						+ "' not recognized***");
				printMainMenu();

			}
		}

		System.out.println("Thank you for using Cattery Administration Tool");
	}

	/**
	 * 
	 */
	private void printMainMenu() {
		System.out.println("");
		System.out.println("    ****** MAIN MENU OPTIONS ******");
		System.out.println("");
		System.out.println("    add name tins - add a cat");
		System.out.println("    delete name   - delete a cat");
		System.out.println("    print         - print the whole database");
		System.out.println("    lookup name   - look up a cat by name");
		System.out.println("    count         - count the cats and tins");
		System.out.println("    clear         - empty the database");
		System.out.println("    debug         - display the debugging menu");
		System.out.println("    help          - display the main menu");
		System.out.println("    quit          - quit!");
		System.out.println("");
	}

	/**
	 * 
	 */
	private void printDebugMenu() {
		System.out.println("");
		System.out.println("    ****** DEBUG MENU OPTIONS ******");
		System.out.println("");
		System.out
				.println("    load number   - reload the database with `number' cats");
		System.out
				.println("    benchmark     - benchmark the current implementation");
		System.out
				.println("    switch        - toggle between your ADT implementations");
		System.out.println("    debug         - display the debugging menu");
		System.out.println("    help          - display the main menu");
		System.out.println("    quit          - quit!");
		System.out.println("");
	}

}