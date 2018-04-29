package example2.core.lotusNotes;

import java.util.function.BiFunction;

import example2.core.template.KpiDataBase;
import example2.core.template.KpiView;
import example2.gui.WorkBenchWindow;

public class KpiDataBaseImpl extends Thread implements KpiDataBase {
	String name;

	public KpiDataBaseImpl(String name) {
		this.name = name;
	}

	@Override
	public void getKpiView(BiFunction<KpiView, Double, ?> function) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				double count = 5;
				for (int i = 0; i < count; i++) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					double progress = new Double(i + 1) * 100 / count;
					function.apply(new KpiViewImpl(WorkBenchWindow.getRN()), progress);
				}
			}
		};
		thread.start();
	}

	@Override
	public String toString() {
		return name;
	}

	@Override
	public String getDataBasePath() {
		// TODO Auto-generated method stub
		return null;
	}

}