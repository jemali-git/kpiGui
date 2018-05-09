package neuralNetworks;

public class Matrix {
	double[][] values;
	int rowNum;
	int columnNum;

	Matrix(double scalar) {
		rowNum = 1;
		columnNum = 1;
		values = new double[rowNum][columnNum];
		values[0][0] = scalar;

	}

	Matrix(double[] array1D) {
		rowNum = array1D.length;
		columnNum = 1;
		values = new double[rowNum][columnNum];
		for (int i = 0; i < array1D.length; i++) {
			values[i] = new double[] { array1D[i] };
		}
	}

	Matrix(double[][] array2D) {
		rowNum = array2D.length;
		columnNum = array2D[0].length;
		values = new double[rowNum][columnNum];
		for (int i = 0; i < array2D.length; i++) {
			for (int j = 0; j < array2D[i].length; j++) {
				values[i][j] = array2D[i][j];
			}
		}
	}

	public Matrix add(Matrix matrix) {
		double[][] values = matrix.getValues();
		double[][] newValues = new double[rowNum][columnNum];
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < columnNum; j++) {
				newValues[i][j] = this.values[i][j] + values[i][j];
			}
		}
		return new Matrix(newValues);
	}

	public Matrix add(double scalar) {
		double[][] newValues = new double[rowNum][columnNum];
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < columnNum; j++) {
				newValues[i][j] = this.values[i][j] + scalar;
			}
		}
		return new Matrix(newValues);
	}

	public Matrix mul(double scalar) {
		double[][] newValues = new double[rowNum][columnNum];
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < columnNum; j++) {
				newValues[i][j] = this.values[i][j] * scalar;
			}
		}
		return new Matrix(newValues);
	}
	public Matrix mul(Matrix matrix) {
		double[][] values = matrix.getValues();
		double[][] newValues = new double[rowNum][columnNum];
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < columnNum; j++) {
				newValues[i][j] = this.values[i][j]*values[i][j];
			}
		}
		return new Matrix(newValues);
	}
	
	public Matrix transpose() {
		double[][] newValues = new double[columnNum][rowNum];
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < columnNum; j++) {
				newValues[j][i] = this.values[i][j];
			}
		}
		return new Matrix(newValues);
	}

	public Matrix cartesianProduct(Matrix matrix) {
		double[][] newValues = new double[this.rowNum][matrix.getColumnNum()];
		Matrix matrixT = matrix.transpose();

		for (int i = 0; i < this.values.length; i++) {
			for (int j = 0; j < matrixT.getValues().length; j++) {
				newValues[i][j] = getScalar(this.values[i], matrixT.getValues()[j]);
			}
		}
		return new Matrix(newValues);
	}

	private double getScalar(double[] arr1, double[] arr2) {
		double sum = 0;
		for (int i = 0; i < arr1.length; i++) {
			sum += arr1[i] * arr2[i];

		}
		return sum;
	}

	public double[][] getValues() {
		return values;
	}

	public void setValues(double[][] values) {
		this.values = values;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public int getColumnNum() {
		return columnNum;
	}

	public void setColumnNum(int columnNum) {
		this.columnNum = columnNum;
	}

	@Override
	public String toString() {
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < rowNum; i++) {
			for (int j = 0; j < columnNum; j++) {
				stringBuilder.append(values[i][j] + " ");
			}
			stringBuilder.append("\n");
		}
		return stringBuilder.toString();
	}

}
