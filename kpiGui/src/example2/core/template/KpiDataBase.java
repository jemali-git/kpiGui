package example2.core.template;

import java.util.function.BiFunction;

public interface KpiDataBase {
	public String getDataBasePath();

	public void getKpiView(BiFunction<KpiView, Double, ?> function);

	public KpiServer getKpiServer();

	public String getKpiId();//TODO remove
}