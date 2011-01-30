import java.io.*;
public class Test {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader (new InputStreamReader(System.in));
		System.out.print("What is your name: ");
		String x = br.readLine();
		if (x.equalsIgnoreCase("mark") ||x.equalsIgnoreCase("chainz") ) 
			System.out.print("Mark Is Gay");
		else
			System.out.print("LU IS AWESOME");
		

	}

}
