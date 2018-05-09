package neuralNetworks;

public class Function {
	public static double sigmoïde(double t) {
		return 1 / (1 + Math.exp(-t));
	}

	public static double[] sigmoïde(double[] arr) {
		double[] result = new double[arr.length];
		for (int i = 0; i < arr.length; i++) {
			result[i] = sigmoïde(arr[i]);
		}
		return result;
	}

	public static double[] add(double[] vect0, double[] vect1) {
		double[] result = new double[vect0.length];
		for (int i = 0; i < vect0.length; i++) {
			result[i] = vect0[i] + vect1[i];
		}
		return result;
	}

	public static double[] add(double scalar, double[] vect) {
		double[] result = new double[vect.length];
		for (int i = 0; i < vect.length; i++) {
			result[i] = vect[i] + scalar;
		}
		return result;
	}

	public static double[][] add(double[][] mat0, double[][] mat1) {

		double[][] result = new double[mat0.length][mat0[0].length];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = mat0[i][j] + mat1[i][j];
			}
		}
		return result;
	}

	public static double[] multiply(double[] vect0, double[] vect1) {
		double[] result = new double[vect1.length];
		for (int i = 0; i < vect1.length; i++) {
			result[i] = vect0[i] * vect1[i];
		}
		return result;
	}

	public static double[] multiply(double scalar, double[] vect) {
		double[] result = new double[vect.length];
		for (int i = 0; i < vect.length; i++) {
			result[i] = vect[i] * scalar;
		}
		return result;
	}

	public static double sum(double[] vect) {
		double sum = 0;
		for (int i = 0; i < vect.length; i++) {
			sum += vect[i];
		}
		return sum;
	}
}
