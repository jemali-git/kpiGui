package example2.core.lotusNotes;

import java.util.function.BiFunction;

import example2.core.template.KpiDataBase;
import example2.core.template.KpiServer;
import example2.gui.WorkBenchWindow;

public class ServerImpl extends Thread implements KpiServer {
	String name;

	public ServerImpl(String name) {
		this.name = name;
	}

	@Override
	public void getKpiDataBases(BiFunction<KpiDataBase, Double, ?> function) {
		KpiServer kpiServer = this;
		Thread thread = new Thread() {
			@Override
			public void run() {
				double count = 10;
				for (int i = 0; i < count; i++) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					double progress = new Double(i + 1) * 100 / count;
					function.apply(new DataBaseImpl(WorkBenchWindow.getRN(), kpiServer), progress);
				}
			}
		};
		thread.start();
	}

	@Override
	public String toString() {
		return getServerPath();
	}

	@Override
	public String getServerPath() {
		return name;
	}

	@Override
	public String getServerPassword() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getKpiId() {
		return getServerPath();
	}

}