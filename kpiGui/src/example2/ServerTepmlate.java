package example2;

import java.util.function.Function;
import java.util.function.BiFunction;

public class ServerTepmlate extends Thread {

	public void getDataBases(String elements, BiFunction<String, Double, ?> function) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 1000; i++) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					Double progress = new Double(i + 1) * 100 / 1000;
					function.apply("" + i, progress);
				}
			}
		};
		thread.start();
		System.out.println("start");
	}
}