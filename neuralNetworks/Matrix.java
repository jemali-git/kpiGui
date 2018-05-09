package neuralNetworks;

public class Matrix {
	Vector[] vectors;

	public Matrix(Vector[] vectors) {
		this.vectors = vectors;
	}

	public Matrix add(Matrix matrix) {
		Vector[] newVectors = new Vector[vectors.length];

		Vector[] vectors1 = matrix.getVectors();
		for (int i = 0; i < vectors.length; i++) {
			newVectors[i] = vectors[i].add(vectors1[i]);
		}
		return new Matrix(newVectors);
	}

	public Matrix transpose(Matrix matrix) {
		
		return null;
	}

	public Vector[] getVectors() {
		return vectors;
	}

	public void setVectors(Vector[] vectors) {
		this.vectors = vectors;
	}

	public static double[][] cartesianProduct(double[][] mat0, double[][] mat1) {
		int rows0 = mat0.length;
		int columns0 = mat0[0].length;

		int rows1 = mat1.length;
		int columns1 = mat1[0].length;
		if (columns0 != rows1) {
			return null;
		}
		double[][] result = new double[rows0][columns1];

		double[][] mat1T = transpose(mat1);

		for (int i = 0; i < mat0.length; i++) {
			for (int j = 0; j < mat1T.length; j++) {
				result[i][j] = Function.sum(Function.multiply(mat0[i], mat1T[j]));
			}
		}
		return result;
	}

	public static double[][] transpose(double[][] mat) {
		int rows = mat.length;
		int comlumns = mat[0].length;
		double[][] result = new double[comlumns][rows];
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				result[j][i] = mat[i][j];
			}
		}
		return result;
	}

	public static double[][] toMatrix(double[] array) {
		double[][] result = new double[array.length][1];
		for (int i = 0; i < array.length; i++) {
			double[] arr = new double[1];
			arr[0] = array[i];
			result[i] = arr;
		}
		return result;
	}

	public static double[] toVector(double[][] matrix) {
		double[] result = new double[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			result[i] = matrix[i][0];
		}
		return result;
	}
}
