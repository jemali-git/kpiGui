package neuralNetworks;

public class Function {
	public static double sigmoïde(double t) {
		return 1 / (1 + Math.exp(-t));
	}
	public static Matrix sigmoïde(Matrix matrix) {
		double[][] result = new double[matrix.getRowNum()][matrix.getColumnNum()];
		double[][] values = matrix.getValues();
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				result[i][j] = sigmoïde(values[i][j]);
			}
		}
		return new Matrix(result);
	}
}
