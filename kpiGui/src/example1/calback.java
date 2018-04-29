package example1;

import java.util.function.Function;

public class calback {

	public calback() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		FirstClass first = new FirstClass("first");
		SecondClass second = new SecondClass();
		System.out.println(second.applyFunction("second", first::addPrefix));
	}
}

class FirstClass {
	String prefix;

	public FirstClass(String prefix) { 
		this.prefix = prefix;
	}

	public String addPrefix(String suffix) {
		return prefix + ":" + suffix;
	}
}

class SecondClass {
	public String applyFunction(String name, Function<String, String> function) {
		return function.apply(name);
	}
}
