package example2.core.template;

import java.util.function.Function;

public interface KpiDataBase {
	public String getDataBasePath();

	public void getKpiView(Function<KpiView, ?> addChild,Function<String, ?> setTicketState);

	public KpiServer getKpiServer();

	public String getKpiId();//TODO remove
}