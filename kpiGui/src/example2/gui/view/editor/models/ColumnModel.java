package example2.gui.view.editor.models;

import example2.core.template.KpiColumn;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class ColumnModel {
	KpiColumn kpiColumn;
	SimpleStringProperty columnName;
	SimpleBooleanProperty isPrimaryKey;
	SimpleBooleanProperty isBaseOnUpdate;

	public ColumnModel(KpiColumn kpiColumn) {
		this.kpiColumn = kpiColumn;
		this.columnName = new SimpleStringProperty(kpiColumn.getColumnPath());
		this.isPrimaryKey = new SimpleBooleanProperty(false);
		this.isBaseOnUpdate = new SimpleBooleanProperty(false);
	}

	public void setColumnName(String columnName) {
		this.columnName = new SimpleStringProperty(columnName);
	}

	public String getColumnName() {
		return columnName.get();
	}

	public SimpleBooleanProperty getIsPrimaryKey() {
		return isPrimaryKey;
	}

	public void setIsPrimaryKey(Boolean isPrimaryKey) {
		this.isPrimaryKey = new SimpleBooleanProperty(isPrimaryKey);
	}

	public SimpleBooleanProperty getIsBaseOnUpdate() {
		return isBaseOnUpdate;
	}

	public void setIsBaseOnUpdate(Boolean isBaseOnUpdate) {
		this.isBaseOnUpdate = new SimpleBooleanProperty(isBaseOnUpdate);
	}

	@Override
	public String toString() {
		return getColumnName();
	}
}
