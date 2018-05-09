package neuralNetworks;

public class Main {
	static Matrix W = new Matrix(new double[][] { { 0.5, 0.3, 0.1 }, { 0.3, 0.2, 0.1 } });
	static Matrix Z = new Matrix(new double[][] { { 0.1f, 0.2f }, { 0.3f, 0.4f }, { 0.5f, 0.6f } });
	public static void main(String[] args) {
		Matrix t = new Matrix(new double[] { 0.1, 0.3, 0.7 });		
		Matrix x = new Matrix(new double[] { 1, 2, 3 });
		
		Matrix t2 = new Matrix(new double[] { 0.5, 0.1, 0.2 });		
		Matrix x2 = new Matrix(new double[] { 5, 6, 7 });
		
	
		
		
		
		
		for (int i = 0; i < 100000; i++) {
			calculate(t,x);
			calculate(t2,x2);
		}
		
		System.out.println(calculate(t,x));
		//System.out.println(calculate(t5,x5));
		
	}
	static Matrix calculate(Matrix t,Matrix x) {

		Matrix b = W.cartesianProduct(x);
		Matrix h = Function.sigmoïde(b);
		
		
		Matrix a = Z.cartesianProduct(h);
		Matrix o = Function.sigmoïde(a);
		Matrix e = o.mul(-1).add(t);
		
		Matrix aDerivate = o.mul(-1).add(1).mul(o);
		Matrix deltaOut = aDerivate.mul(e);
		Z = Z.add(deltaOut.cartesianProduct(h.transpose()));
		Matrix deltaHidden = h.mul(h.mul(-1).add(1)).mul(Z.transpose().cartesianProduct(deltaOut));
		W=W.add(deltaHidden.cartesianProduct(x.transpose()));

		return o;
	} 
}
