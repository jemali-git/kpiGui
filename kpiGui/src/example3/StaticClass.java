package example3;

import org.omg.CORBA.BAD_POLICY;

import example3.A.C;

public class StaticClass {
	public static void main(String[] args) {
		A<Object> a = new A<Object>();
		C<Object> c=new C<Object>();
		
		// StaticClass.C c=new C();
		// c.name();
	}

}

class A<T> extends Object {
	public int aa=1;
	public static class C<T> implements BAD_POLICY {
		public void name() {
			//System.out.println(aa);
			
		}
	}
}
