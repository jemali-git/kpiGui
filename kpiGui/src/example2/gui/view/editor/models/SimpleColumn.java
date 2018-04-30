package example2.gui.view.editor.models;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;

public class SimpleColumn {
	final SimpleStringProperty originalName;
	SimpleStringProperty customName;
	SimpleBooleanProperty isPrimaryKey;
	SimpleBooleanProperty isBaseOnUpdate;

	public SimpleColumn(String originalName) {
		this.originalName = new SimpleStringProperty(originalName);
		this.customName = new SimpleStringProperty(originalName);
		this.isPrimaryKey = new SimpleBooleanProperty(false);
		this.isBaseOnUpdate = new SimpleBooleanProperty(false);
	}

	public String getOriginalName() {
		return originalName.get();
	}

	public String getCustomName() {
		return customName.get();
	}

	public void setCustomName(String customName) {
		this.customName = new SimpleStringProperty(customName);
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
		return getOriginalName();
	}
}
