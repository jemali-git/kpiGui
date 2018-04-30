package example2.core.lotusNotes;

import example2.core.template.KpiColumn;
import example2.core.template.KpiView;

public class ColumnImpl extends Thread implements KpiColumn {
	String columnName;

	public ColumnImpl(String columnName) {
		this.columnName = columnName;
	}

	@Override
	public String getColumnName() {
		return columnName;
	}

	

	@Override
	public String toString() {
		return getColumnName();
	}

	@Override
	public KpiView getKpiView() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getKpiId() {
		return null;
	}
}