package liarliar;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class CheckLiar {
	TreeSet<String> first = new TreeSet<String>();
	TreeSet<String> second = new TreeSet<String>();

	class Vet {
		public String person = "";
		public String[] liars = null;
	}

	private FileInputStream in;
	private String text = "";

	public CheckLiar(String filename) throws IOException {
		in = new FileInputStream(filename);
		makeString();
	}

	private void makeString() throws IOException {
		Scanner scanner = new Scanner(in);
		try {
			while (scanner.hasNextLine()) {
				text += scanner.nextLine() + "\n";
			}
		} finally {
			scanner.close();
		}
	}

	public String getDetails() {
		return text;
	}

	public static void main(String[] args) throws java.io.IOException {
		CheckLiar file = new CheckLiar(args[0]);

		String text = file.getDetails();
		StringTokenizer st = new StringTokenizer(text);

		int no = 0;
		int fieldSize = Integer.parseInt(st.nextToken());

		Vet[] info = new Vet[fieldSize];

		for (int i = 0; i < fieldSize; i++) {
			info[i] = file.new Vet();
			info[i].person = st.nextToken();

			no = Integer.parseInt(st.nextToken());
			info[i].liars = new String[no];
			for (int j = 0; j < no; j++)
				info[i].liars[j] = st.nextToken();
		}

		file.showGroups(info);

	}

	public void showGroups(Vet[] info) {

		for (int i = 0; i < info.length; i++) {
			int side = 1;
			if (first.isEmpty() && second.isEmpty())
				first.add(info[i].person);

			else if (!first.contains(info[i].person)
					&& !second.contains(info[i].person)) {
				side = checkChildren(info[i]);
			}

			else if (second.contains(info[i].person))
				side = 2;

			process(info[i], side);
		}
		System.out.println(first.size() + " " + second.size());

	}

	private int checkChildren(Vet vet) {
		int side = 1;
		for (int i = 0; i < vet.liars.length; i++) {
			if (first.contains(vet.liars[i])) {
				side = 2;
				break;
			}
		}
		if (side == 1)
			first.add(vet.person);
		else
			second.add(vet.person);
		return side;
	}

	private void process(Vet vet, int side) {

		if (side == 1) {
			for (int i = 0; i < vet.liars.length; i++)
				second.add(vet.liars[i]);
		} else {
			for (int i = 0; i < vet.liars.length; i++)
				first.add(vet.liars[i]);
		}
		printSets();
	}

	private void printSets() {
		Iterator<String> it = first.iterator();
		while (it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
		it = second.iterator();
		while (it.hasNext())
			System.out.print(it.next() + " ");
		System.out.println();
	}
}
