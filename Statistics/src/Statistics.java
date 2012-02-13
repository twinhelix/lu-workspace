import uk.ac.imperial.doc.kenya.nio.KenyaNIO;

class courseMark {
	Courses cc;

	studentRecord[] sr;

	int noOfStudents;
}

class studentRecord {
	String login;

	int mark;
}

enum Courses {
	Programming, Logic, Hardware, DiscreteMathematics, MathematicalMethods, ComputerSystems, Graphics;
}

public class Statistics {
	static methods m = new methods();

	public static void main(String[] args) {
		System.out.print("Enter in Details: ");
		String input = KenyaNIO.get().readString();
		// Creates an array of obejects courseMark and inilizes it.
		courseMark[] cms = new courseMark[50];
		for (int i = 0; i < 50; i++)
			cms[i] = new courseMark();
		int subjects = 0;
		// While loop to check next input isn't a "." and terminates if it is.
		while (!(input).equals(".")) {
			// Declares a new object, fills it, puts it into the array of
			// obejects and then analyses it.
			courseMark cm = new courseMark();
			cm.cc = Courses.valueOf(input);
			cm.sr = m.getMarksForAnalysis();
			int len = 0;
			// Loop to obtain the number of student records in that object.
			while (cm.sr[len] != null)
				len++;

			cm.noOfStudents = len;
			cms[subjects] = cm;
			// Calls the methods to display the table and graph of results.
			subjects++;
			input = KenyaNIO.get().readString();
		}
		m.printRecords(cms, subjects);
	}
}

class methods {
	public studentRecord[] getMarksForAnalysis() {
		// Method which reads in all the marks of a course as an array of
		// classes and returns it into the class courseMark.
		String user = KenyaNIO.get().readString();
		studentRecord[] students = new studentRecord[50];
		int counter = 0;
		// While loop to check next input isn't a ";" which indicates all
		// records have been entered, and terminates when ";" is received.
		while (!(user).equals(";") && counter < 50) {
			// Creates and fills a class of studentRecord, it is then used to
			// Initialise and fill the array of objects.
			studentRecord oneStudent = new studentRecord();
			oneStudent.login = user;
			oneStudent.mark = KenyaNIO.get().readInt();
			students[counter] = oneStudent;
			user = KenyaNIO.get().readString();
			counter++;
		}
		// Sorts the students according to marks, also helps to find the median.
		for (int i = 0; i < counter; i++) {
			for (int j = i; j < counter; j++) {
				if (students[i].mark < students[j].mark) {
					studentRecord tempStu = new studentRecord();
					tempStu = students[i];
					students[i] = students[j];
					students[j] = tempStu;
				}
			}
		}
		return students;
	}

	public void printRecords(courseMark[] records, int subjects) {
		// A loop that prints an array of records and calls the required
		// functions.
		for (int i = 0; i < subjects; i++) {
			printStats(records[i]);
			System.out.println("\n\nMEAN: "
					+ findMean(records[i].sr, records[i].noOfStudents)
					+ "   STANDARD DEVIATION: "
					+ findStdDeviation(records[i].sr, records[i].noOfStudents)
					+ "   MEDIAN: "
					+ findMedian(records[i].sr, records[i].noOfStudents));
		}
	}

	public String convert(int mark) {
		// Method that returns the corresponding symbol of a given mark.
		if (mark <= 10 && mark >= 0) {
			String[] symbol = { "F", "F", "F", "E", "D", "C", "B", "A", "A",
					"A+", "A+" };
			return symbol[mark];
		} else
			return "F";
	}

	public void printStats(courseMark cm) {
		// Prints the table of logins and symbols.
		System.out.println("\nCOURSE:\t\t" + cm.cc);
		System.out.println("STUDENT\t\tGrade");
		for (int i = 0; i < cm.noOfStudents; i++) {
			System.out
					.println(cm.sr[i].login + "\t\t" + convert(cm.sr[i].mark));
		}
		printBarChart(cm.sr, cm.noOfStudents);
	}

	public void printBarChart(studentRecord[] sr, int len) {
		// Creates a bar chart of the records.
		System.out.println(" \nSTATISTICAL ANALYSIS: \n");
		int[] stats = new int[11];
		// An array of ints that records the number of people of each score
		// achieved.
		for (int i = 0; i < len; i++) {
			stats[sr[i].mark]++;
		}
		// Finds which score was achieved the most.
		int max = 0;
		for (int i = 0; i < 11; i++) {
			if (max < stats[i]) {
				max = stats[i];
			}
		}
		// Loops through each row, and fills in if that position should be a
		// star, line or space.
		for (int i = max; i >= 0; i--) {
			for (int j = 0; j < 11; j++) {
				if (stats[j] == i) {
					System.out.print("* ");
				} else if (stats[j] > i) {
					System.out.print("| ");
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		for (int i = 0; i < 11; i++) {
			System.out.print(i + " ");
		}
	}

	private static double findMean(studentRecord[] sr, int len) {
		// Method to find the mean of a list of marks, by adding them together
		// and dividing by the number of records.
		double sum = 0;
		for (int i = 0; i < len; i++) {
			sum = sum + sr[i].mark;
		}
		double mean = (sum / len);
		return mean;
	}

	private static double findStdDeviation(studentRecord[] sr, int len) {
		// Method to find the standard deviation of the records.
		double mean = findMean(sr, len);
		double sdSum = 0;
		for (int i = 0; i < len; i++) {
			sdSum = sdSum + Math.pow((sr[i].mark - mean), 2);
		}
		double sd = Math.sqrt(sdSum / len);
		return sd;
	}

	private static double findMedian(studentRecord[] sr, int len) {
		// Finds the median of the records (they have already been sorted in the
		// method getMarksForAnalysis).
		double median;
		if (len % 2 == 0) {
			median = ((sr[len / 2 - 1].mark + sr[len / 2].mark) + 0.0) / 2;
		} else {
			median = sr[(len + 1) / 2 - 1].mark;
		}
		return median;
	}
}
