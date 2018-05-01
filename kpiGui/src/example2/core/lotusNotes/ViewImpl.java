package example2.core.lotusNotes;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import example2.core.template.KpiColumn;
import example2.core.template.KpiDataBase;
import example2.core.template.KpiView;
import example2.gui.WorkBenchWindow;
import example2.gui.view.editor.models.ViewModel;

public class ViewImpl extends Thread implements KpiView {
	String viewPath;
	KpiDataBase kpiDataBase;
	

	public ViewImpl(String viewPath, KpiDataBase kpiDataBase) {
		this.viewPath = viewPath;
		this.kpiDataBase = kpiDataBase;
	}

	@Override
	public void getKpiColumn(Function<Set<KpiColumn>, ?> createColumns) {
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
				createColumns.apply(kpiColumns);
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
		return viewPath;
	}

	@Override
	public KpiDataBase getKpiDataBase() {
		return kpiDataBase;
	}

	@Override
	public String getKpiId() {
		return getName() + kpiDataBase.getKpiId();
	}

	@Override
	public void save(ViewModel viewModel, Function<String, ?> setTitle, Function<String, ?> setMessage,
			Function<Float, ?> setProgress) {
		Thread saveThread = new Thread() {
			public void run() {
				setTitle.apply("lotus notes save Data");
				for (int i = 0; i < 100; i++) {
					setProgress.apply(new Float(i) / 100);

					if (i % 10 == 0) {
						setMessage.apply("new message");
					}
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

				// if (!viewModel.getSaveOnly().get()) {
				// update(viewModel);
				// }
			};

		};
		saveThread.start();

	}

	@Override
	public void update(ViewModel viewModel) {
		long updatePeriod = viewModel.getUpdatePeriode().get();
		Boolean stop = false;
		Thread updateThread = new Thread() {
			public void run() {
				while (!stop) {
					// update data TODO
					try {
						sleep(updatePeriod);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			};

		};
		updateThread.start();
	}

}