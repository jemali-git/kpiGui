package example2.gui.view.editor.models.serialization;

import java.io.Serializable;

import example2.gui.view.editor.models.ColumnModel;

public class ColumnModelSerialisation implements Serializable {

	String columnName;
	boolean isPrimaryKey;
	boolean isBaseOnUpdate;

	public ColumnModelSerialisation(ColumnModel columnModel) {
		columnName = "";
		isBaseOnUpdate = false;
		isBaseOnUpdate = true;
	}
}