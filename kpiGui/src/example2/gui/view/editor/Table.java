package example2.gui.view.editor;

import java.util.Set;

import example2.gui.view.editor.models.SimpleColumn;
import example2.gui.view.editor.util.TimeChooser;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class Table extends Tab {

	public Table(Set<SimpleColumn> simpleColumns, String tableName) {
		setText(tableName);

		VBox vBox = new VBox();
		vBox.setPadding(new Insets(10, 10, 50, 10));
		vBox.setSpacing(20);
		setContent(vBox);

		TableView<SimpleColumn> simpleColumnsTable = new TableView<>();
		VBox.setVgrow(simpleColumnsTable, Priority.SOMETIMES);
		vBox.getChildren().add(simpleColumnsTable);

		simpleColumnsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		simpleColumnsTable.setEditable(true);

		/** originalNameCol **/
		TableColumn<SimpleColumn, String> originalNameCol = new TableColumn<>("Original Name");
		originalNameCol.setCellValueFactory(new PropertyValueFactory<>("originalName"));

		/** customNameCol **/
		TableColumn<SimpleColumn, String> customNameCol = new TableColumn<>("New Name");
		customNameCol.setCellValueFactory(new PropertyValueFactory<>("customName"));
		customNameCol.setCellFactory(TextFieldTableCell.<SimpleColumn>forTableColumn());

		customNameCol.setOnEditCommit((CellEditEvent<SimpleColumn, String> t) -> {
			((SimpleColumn) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setCustomName(t.getNewValue());
			// show(simpleColumns);
		});
		/** isPrimaryKeyCol **/
		TableColumn<SimpleColumn, Boolean> isPrimaryKeyCol = new TableColumn<>("Primary Key");

		isPrimaryKeyCol.setCellValueFactory(new PropertyValueFactory<>("isPrimaryKey"));

		isPrimaryKeyCol.setCellValueFactory(param -> param.getValue().getIsPrimaryKey());

		isPrimaryKeyCol.setCellFactory(CheckBoxTableCell.forTableColumn(isPrimaryKeyCol));
		/** isBaseOnUpdate **/
		TableColumn<SimpleColumn, Boolean> isBaseOnUpdateCol = new TableColumn<>("Update Base On");

		isBaseOnUpdateCol.setCellValueFactory(new PropertyValueFactory<>("isBaseOnUpdate"));

		isBaseOnUpdateCol.setCellValueFactory(param -> param.getValue().getIsBaseOnUpdate());

		isBaseOnUpdateCol.setCellFactory(CheckBoxTableCell.forTableColumn(isBaseOnUpdateCol));

		/** set data **/
		simpleColumnsTable.setItems(FXCollections.observableArrayList(simpleColumns));
		/** set column **/
		simpleColumnsTable.getColumns().addAll(originalNameCol, customNameCol, isPrimaryKeyCol, isBaseOnUpdateCol);
		/***************/

		Button save = new Button("Save");
		CheckBox saveOnly = new CheckBox("Save Without Update");
		TimeChooser timeChooser = new TimeChooser("Set Update Periode");

		saveOnly.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				timeChooser.setDisable(newValue);
			}
		});
		vBox.getChildren().addAll(save, saveOnly, timeChooser);
	}

	public void show(Set<SimpleColumn> simpleColumns) {
		simpleColumns.forEach(col -> {
			System.out.println(col.getOriginalName() + " " + col.getCustomName() + " " + col.getIsPrimaryKey() + " "
					+ col.getIsBaseOnUpdate());
		});
	}

}
