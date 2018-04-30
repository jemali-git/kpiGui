package example2.core.template;

import java.util.function.Function;

import example2.gui.WorkBenchWindow;

import java.util.Set;
import java.util.function.BiFunction;

public interface KpiView {
	public String getViewPath();
	public void getKpiColumn(Function<Set<KpiColumn>, ?> function);
	public KpiDataBase getKpiDataBase();
	public String getKpiId();//TODO remove
}