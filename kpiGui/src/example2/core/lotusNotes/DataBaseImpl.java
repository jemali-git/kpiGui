package example2.core.lotusNotes;

import java.util.function.BiFunction;

import example2.core.template.KpiDataBase;
import example2.core.template.KpiServer;
import example2.core.template.KpiView;
import example2.gui.WorkBenchWindow;

public class DataBaseImpl extends Thread implements KpiDataBase {
	String name;
	KpiServer kpiServer;

	public DataBaseImpl(String name, KpiServer kpiServer) {
		this.name = name;
		this.kpiServer = kpiServer;
	}

	@Override
	public void getKpiView(BiFunction<KpiView, Double, ?> function) {
		KpiDataBase kpiDataBase = this;
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
					function.apply(new ViewImpl(WorkBenchWindow.getRN(), kpiDataBase), progress);
				}
			}
		};
		thread.start();
	}

	@Override
	public String toString() {
		return getDataBasePath();
	}

	@Override
	public String getDataBasePath() {
		return name;
	}

	@Override
	public KpiServer getKpiServer() {
		return kpiServer;
	}

	@Override
	public String getKpiId() {
		return getDataBasePath() + kpiServer.getKpiId();
	}

}