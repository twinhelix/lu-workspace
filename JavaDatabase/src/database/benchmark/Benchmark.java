package database.benchmark;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Vector;

import database.Database;

/**
 * @author Administrator
 *
 */
public class Benchmark {

	public static boolean BENCHMARK_LOADED = false;
	/**
	 * 
	 */
	private Random randTins;
	
	/**
	 * 
	 */
	private Random randCatOrder;

	/**
	 * @param seed
	 */
	public Benchmark(long seed) {
		randTins = new Random(seed);
		randCatOrder = new Random(randTins.nextInt());
	}

	public void testLoaded(Database db) throws Exception {
		if (BENCHMARK_LOADED) {
			System.out.println("Cats ... Avg. Lookups");
			System.out.println("---------------------");
			System.out.print(db.countCats()+"   ");
			System.out.println(runTest(db, db.countCats(),false));
			System.out.print("\n");
		} else {
			throw new ClassNotFoundException("Benchmarking tool not loaded. "
					+ "Refer to the Lab Specification for further instruction.");
		}

	}
	
	/**
	 * @param db
	 * @throws Exception
	 */
	public void test(Database db) throws Exception {

		if (BENCHMARK_LOADED) {
			System.out.println("\nCats\t\t\t\t Avg. Lookups");
			System.out.println("----\t\t\t\t --------------");
			System.out.print("10   ");
			System.out.println(runTest(db, 10, true));
			System.out.print("50   ");
			System.out.println(runTest(db, 50, true));
			System.out.print("100  ");
			System.out.println(runTest(db, 100, true));
			System.out.print("500  ");
			System.out.println(runTest(db, 500, true));
			System.out.print("1000 ");
			System.out.println(runTest(db, 1000, true));
			System.out.print("5000 ");
			System.out.println(runTest(db, 5000, true));
			System.out.print("10000");
			System.out.println(runTest(db, 10000, true));
			System.out.print("50000");
			System.out.println(runTest(db, 50000, true));
			System.out.print("\n");
			db.clear();
		} else {
			throw new ClassNotFoundException("Benchmarking tool not loaded. "
					+ "Refer to the Lab Specification for further instruction.");
		}
	}

	/**
	 * @param db
	 * @param testsize
	 * @return
	 * @throws Exception
	 */
	private double runTest(Database db, int testsize, boolean load)
	throws Exception {

		// insert length items
		double averageLookups = 0;

		int base = String.valueOf(testsize).length();
		
		if(load) {
			db.clear();
			load(db, testsize, true);
		}
		int prev = -1;
		
		for (int i = 0; i < testsize; i++) {
			if(Math.abs(i*15/testsize)>prev){
				System.out.print('.');
				prev = Math.abs(i*15/testsize); 
			}
			Counter.reset();
			db.lookup("Cat" + String.format("%0" + base + "d", i));
			averageLookups += Counter.value();
		}

		System.out.print(' ');
		return averageLookups / testsize;
	}

	/**
	 * @param db
	 * @param testsize
	 * @param showProgress
	 */
	public void load(Database db, int testsize, boolean showProgress) {
		try {
			int base = String.valueOf(testsize).length();
			int prev=-1;

			List<String> catList = new Vector<String>(testsize);
			for (int i = 0; i < testsize; i++) {
				catList.add("Cat" + String.format("%0" + base + "d", i));
			}
			Collections.shuffle(catList, randCatOrder);

			for (int i = 0; i < testsize; i++) {
				if(showProgress&&(Math.abs(i*9/testsize)>prev)){
					System.out.print('.');
					prev = Math.abs(i*9/testsize); 
				}
				db.add(catList.get(i), randTins.nextInt(20) + 1);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}