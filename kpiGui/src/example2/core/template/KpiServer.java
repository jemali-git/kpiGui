package example2.core.template;

import java.util.function.BiFunction;

import example2.gui.WorkBenchWindow;

public interface KpiServer {
	public String getServerPath();
	public String getServerPassword();
	public void getKpiDataBases(BiFunction<KpiDataBase, Double, ?> function);
}