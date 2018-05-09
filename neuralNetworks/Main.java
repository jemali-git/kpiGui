package neuralNetworks;

public class Main {

	public static void main(String[] args) {
		double[] t = { 0.1, 0.3, 0.7 };

		double[][] W = { { 0.5, 0.3, 0.1 }, { 0.3, 0.2, 0.1 } };
		double[] x = { 1, 2, 3 };
		double[] b = Matrix.toVector(Matrix.cartesianProduct(W, Matrix.toMatrix(x)));
		double[] h = Function.sigmoïde(b);
		double[][] Z = { { 0.1f, 0.2f }, { 0.3f, 0.4f }, { 0.5f, 0.6f } };
		double[] a = Matrix.toVector(Matrix.cartesianProduct(Z, Matrix.toMatrix(h)));
		double[] o = Function.sigmoïde(a);
		double[] e = Function.add(t, Function.multiply(-1, o));
		double[] aDerivate = Function.multiply(o, Function.add(1, Function.multiply(-1, o)));
		double[] deltaOut = Function.multiply(aDerivate, e);

		double[][] newZ = Function.add(Z,
				Matrix.cartesianProduct(Matrix.toMatrix(deltaOut), Matrix.transpose(Matrix.toMatrix(h))));

//		double[] deltaHidden = Function.multiply(Function.multiply(h, Function.add(1, Function.multiply(-1, h))),
//				Matrix.toVector(Matrix.cartesianProduct(Z, Matrix.transpose(Matrix.toMatrix(deltaOut)))));
//		 show(deltaHidden);
		// double a=
		// System.out.println(result.length);
		// for (int i = 0; i < result.length; i++) {
		// for (int j = 0; j < result[i].length; j++) {
		// System.out.println(Function.sigmoïde(result[i][j]));
		// }
		// }
	}

	public static void show(double[] vector) {
		for (int i = 0; i < vector.length; i++) {
			System.out.print(vector[i] + " ");
		}
	}

	public static void show(double[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			show(matrix[i]);
			System.out.println();
		}
	}
}
