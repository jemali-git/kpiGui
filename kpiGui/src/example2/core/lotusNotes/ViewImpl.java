package example2.core.lotusNotes;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import example2.core.template.KpiColumn;
import example2.core.template.KpiDataBase;
import example2.core.template.KpiView;
import example2.gui.WorkBenchWindow;

public class ViewImpl extends Thread implements KpiView {
	String name;
	KpiDataBase kpiDataBase;

	public ViewImpl(String name, KpiDataBase kpiDataBase) {
		this.name = name;
		this.kpiDataBase = kpiDataBase;
	}

	@Override
	public void getKpiColumn(Function<Set<KpiColumn>, ?> function) {
		Thread thread = new Thread() {
			@Override
			public void run() {
				Set<KpiColumn> kpiColumns = new HashSet<>();
				for (int i = 0; i < 25; i++) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						System.out.println(e.toString());
					}
					kpiColumns.add(new ColumnImpl(WorkBenchWindow.getRN()));
				}

				function.apply(kpiColumns);
			}
		};
		thread.start();
	}

	@Override
	public String toString() {
		return getViewPath();
	}

	@Override
	public String getViewPath() {
		return name;
	}

	@Override
	public KpiDataBase getKpiDataBase() {
		return kpiDataBase;
	}

	@Override
	public String getKpiId() {
		return getName()+kpiDataBase.getKpiId();
	}

}