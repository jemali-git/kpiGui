package example2.core.lotusNotes;

import java.util.function.Function;

import example2.core.template.KpiDataBase;
import example2.core.template.KpiServer;
import example2.gui.WorkBenchWindow;

public class ServerImpl extends Thread implements KpiServer {
	String serverPath;

	public ServerImpl(String name) {
		this.serverPath = name;
	}

	@Override
	public void getKpiDataBases(Function<KpiDataBase, ?> addChild,Function<String, ?> setTicketState) {
		KpiServer kpiServer=this;
		Thread thread = new Thread() {
			@Override
			public void run() {
				double count = 10;
				for (int i = 0; i < count; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					String progress = (new Double(i + 1) * 100 / count) + "%";
					if (i == count - 1) {
						progress = "complete";
					}
					setTicketState.apply(progress);
					addChild.apply(new DataBaseImpl(WorkBenchWindow.getRN(), kpiServer));
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
		return serverPath;
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