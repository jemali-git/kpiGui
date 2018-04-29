package example2.core.lotusNotes;

import java.util.function.Function;

import example2.core.template.KpiView;
import example2.gui.WorkBenchWindow;

import java.util.function.BiFunction;

public class KpiViewImpl extends Thread implements KpiView {
	String name;

	public KpiViewImpl(String name) {
		this.name = name;
	}

	@Override
	public void getKpiColumn(Function<String, ?> function) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						System.out.println(e.toString());
					}
				}
				function.apply(WorkBenchWindow.getRN());
			}
		};
		thread.start();
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public String getViewPath() {
		// TODO Auto-generated method stub
		return null;
	}

}