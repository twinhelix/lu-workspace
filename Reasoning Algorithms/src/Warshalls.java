public class Warshalls {

	public static void main(String[] args) {
		new Warshalls();
	}

	public Warshalls() {
		boolean[][] a = { 
				{ false, true, true, false },
				{ false, false, true, false },
				{ false, false, false, true },
				{ false, true, false, false }};
		boolean[][] b = new boolean[4][4];
		trans(a, b);
		print(b);
	}

	// Warshall's algorithm for transitive graph
	public void trans(boolean[][] edges, boolean[][] paths) {
		for (int i = 0; i < edges.length; i++)
			paths[i] = edges[i].clone();
		int n = 0;
		while (n < edges.length) {
			for (int i = 0; i < edges.length; i++) {
				for (int j = 0; j < edges.length; j++) {
					paths[i][j] = paths[i][j] || (paths[i][n] && paths[n][j]);
				}
			}
			n++;
		}
	}

	public void print(boolean[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++)
				System.err.print(a[i][j] + " ");
			System.err.println();
		}
	}
}
