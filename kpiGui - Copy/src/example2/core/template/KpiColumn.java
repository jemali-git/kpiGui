package example2.core.template;

import java.util.function.Function;

public interface KpiColumn {
	public String getColumnName();

	public void getKpiColumn(Function<String, ?> function);
}
