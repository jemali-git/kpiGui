package example2;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class ThreadListner {
	public Integer setResult(List elements) {
		return elements.size();
	}

	public ThreadListner() {
		MyThread myThread = new MyThread();
		List<String> elements = new ArrayList<>();	
		System.out.println("******* "+myThread.getResult(elements, this::setResult));
	}

	public static void main(String[] args) {
		new ThreadListner();
	}
}

class MyThread extends Thread {
	public Integer getResult(List<String> elements, Function<List<String>, Integer> function) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000000; i++) {
					elements.add("" + i);
				}
				 function.apply(elements);
			}
		};
		thread.start();
		System.out.println("start");
		return 0;
	}
}

