import java.io.*;
import java.util.*;

import hashtable.*;

public class SpellCheck {
	public static void main(String[] args) throws IOException {
		HashTable ht = new HashTable();

		FileReader dictfilereader = null;
		try {
			dictfilereader = new FileReader(args[0]);
		} catch (FileNotFoundException e) {
			System.err.println("File does not exist!");
		}
		BufferedReader dictbufferedreader = new BufferedReader(dictfilereader);
		String newLine = dictbufferedreader.readLine();
		;
		while (newLine != null) {

			StringTokenizer st = new StringTokenizer(newLine);
			while (st.hasMoreTokens()) {
				ht.addWord(st.nextToken());
			}
			newLine = dictbufferedreader.readLine();
		}
		Scanner sc = new Scanner(System.in);
		while (sc.hasNext()) {
			String word = sc.next();
			if (!ht.isWordPresent(word))
				System.out.print(">>>"+word+"<<< ");
			else System.out.print(word + " ");
		}
		System.err.println(ht.howManyInternalNodeOperations());
		System.out.println();
	ht.print();
	}
}
