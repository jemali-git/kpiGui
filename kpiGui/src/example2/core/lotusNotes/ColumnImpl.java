package example2.core.lotusNotes;

import example2.core.template.KpiColumn;
import example2.core.template.KpiView;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class ColumnImpl extends Thread implements KpiColumn {
	String columnPath;

	public ColumnImpl(String columnName) {
		this.columnPath = columnName;
	}

	@Override
	public String getColumnPath() {
		return columnPath;
	}

	@Override
	public String toString() {
		return getColumnPath();
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