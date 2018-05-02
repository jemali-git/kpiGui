package example2.core.template;

import java.util.function.Function;

public interface KpiServer {
	public String getServerPath();
	public String getServerPassword();
	public void getKpiDataBases(Function<KpiDataBase, ?> addChild,Function<String, ?> setTicketState);
	public String getKpiId();//TODO remove
}