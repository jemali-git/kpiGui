package example2.core.lotusNotes;

import java.util.function.BiFunction;

import example2.core.template.KpiDataBase;
import example2.core.template.KpiServer;
import example2.gui.WorkBenchWindow;

public class KpiServerImpl extends Thread implements KpiServer {
	String name;

	public KpiServerImpl(String name) {
		this.name = name;
	}

	@Override
	public void getKpiDataBases(BiFunction<KpiDataBase, Double, ?> function) {
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
					function.apply(new KpiDataBaseImpl(WorkBenchWindow.getRN()), progress);
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
	public String getServerPath() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getServerPassword() {
		// TODO Auto-generated method stub
		return null;
	}

}