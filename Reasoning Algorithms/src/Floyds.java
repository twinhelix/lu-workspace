public class Floyds {

	public static void main(String[] args) {
		new Floyds();
	}

	public Floyds() {
		// Set up table
		double[][] edges = {
				{ 0, 7, 10, Double.POSITIVE_INFINITY, 12,
						Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY },
				{ 7, 0, 4, Double.POSITIVE_INFINITY, 6,
						Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY },
				{ 10, 4, 0, 5, Double.POSITIVE_INFINITY,
						Double.POSITIVE_INFINITY, 10 },
				{ Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 5, 0, 1,
						6, Double.POSITIVE_INFINITY },
				{ 12, 6, Double.POSITIVE_INFINITY, 1, 0, 5, 5.5 },
				{ Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY,
						Double.POSITIVE_INFINITY, 6, 5, 0, 2.5 },
				{ Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY, 10,
						Double.POSITIVE_INFINITY, 5.5, 2.5, 0 } };
		// Min cost array
		double[][] costs = new double[7][7];
		floyd(edges, costs);
		print(edges);
		System.err.println();
		print(costs);
	}
	
	// Floyd's algorithm for best cost paths
	public void floyd(double[][] edges, double[][] costs) {
		for (int i = 0; i < edges.length; i++)
			costs[i] = edges[i].clone();
		int n = 0;
		while (n < edges.length) {
			for (int i = 0; i < edges.length; i++) {
				for (int j = 0; j < edges.length; j++) {
					costs[i][j] = Math.min(costs[i][j],
							(costs[i][n] + costs[n][j]));
				}

			}
			n++;
		}
	}

	public void print(double[][] a) {
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++)
				System.err.print(wrap(a[i][j]));
			System.err.println();
		}
	}

	public String wrap(double a) {
		String ret = a + "";
		while (ret.length() < 10)
			ret = ret + " ";
		return ret;
	}

}
