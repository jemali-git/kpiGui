package example2.core.template;

import java.util.function.Function;

import example2.gui.WorkBenchWindow;
import example2.gui.view.editor.models.ViewModel;

import java.util.Set;
import java.util.function.BiFunction;

public interface KpiView {
	public String getViewPath();

	public void getKpiColumn(Function<Set<KpiColumn>, ?> createColumns);

	public KpiDataBase getKpiDataBase();

	public String getKpiId();// TODO remove
	public void save(ViewModel viewModel,Function<String, ?> setTitle,Function<String, ?> setMessage,Function<Float, ?> setProgress);

	public void update(ViewModel viewModel,Function<String, ?> setTitle,Function<String, ?> setMessage,Function<Float, ?> setProgress);

}