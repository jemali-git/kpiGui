package example2.gui.view.editor;

import java.util.Set;

import example2.gui.view.editor.models.ColumnModel;
import example2.gui.view.editor.models.ViewModel;
import example2.gui.view.editor.util.TimeChooser;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.CheckBoxTableCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class Table extends Tab {

	public Table(ViewModel viewModel) {
		setText(viewModel.getViewName().get());

		VBox vBox = new VBox();
		vBox.setPadding(new Insets(10, 10, 50, 10));
		vBox.setSpacing(20);
		setContent(vBox);
		final TextField viewName = new TextField();
		viewName.textProperty().bindBidirectional(viewModel.getViewName());
		HBox hBox = new HBox(new Label("Table Name:"), viewName);
		hBox.setSpacing(3);

		vBox.getChildren().add(hBox);

		TableView<ColumnModel> simpleColumnsTable = new TableView<>();
		VBox.setVgrow(simpleColumnsTable, Priority.SOMETIMES);
		vBox.getChildren().add(simpleColumnsTable);

		simpleColumnsTable.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

		simpleColumnsTable.setEditable(true);

		/** customNameCol **/
		TableColumn<ColumnModel, String> columnNameCol = new TableColumn<>("Name");
		columnNameCol.setCellValueFactory(new PropertyValueFactory<>("columnName"));
		columnNameCol.setCellFactory(TextFieldTableCell.<ColumnModel>forTableColumn());

		columnNameCol.setOnEditCommit((CellEditEvent<ColumnModel, String> t) -> {
			((ColumnModel) t.getTableView().getItems().get(t.getTablePosition().getRow()))
					.setColumnName(t.getNewValue());
			// show(simpleColumns);
		});
		/** isPrimaryKeyCol **/
		TableColumn<ColumnModel, Boolean> isPrimaryKeyCol = new TableColumn<>("Primary Key");

		isPrimaryKeyCol.setCellValueFactory(new PropertyValueFactory<>("isPrimaryKey"));

		isPrimaryKeyCol.setCellValueFactory(param -> param.getValue().getIsPrimaryKey());

		isPrimaryKeyCol.setCellFactory(CheckBoxTableCell.forTableColumn(isPrimaryKeyCol));
		/** isBaseOnUpdate **/
		TableColumn<ColumnModel, Boolean> isBaseOnUpdateCol = new TableColumn<>("Update Base On");

		isBaseOnUpdateCol.setCellValueFactory(new PropertyValueFactory<>("isBaseOnUpdate"));

		isBaseOnUpdateCol.setCellValueFactory(param -> param.getValue().getIsBaseOnUpdate());

		isBaseOnUpdateCol.setCellFactory(CheckBoxTableCell.forTableColumn(isBaseOnUpdateCol));

		/** set data **/
		simpleColumnsTable.setItems(FXCollections.observableArrayList(viewModel.getColumnModels()));
		/** set column **/
		simpleColumnsTable.getColumns().addAll(columnNameCol, isPrimaryKeyCol, isBaseOnUpdateCol);
		/***************/

		Button save = new Button("Save");
		save.setOnAction(value -> {
			System.out.println(viewModel.getViewName().get());
			System.out.println(viewModel.getSaveOnly());
		});
		CheckBox saveOnly = new CheckBox("Save Without Update");
		saveOnly.selectedProperty().bindBidirectional(viewModel.getSaveOnly());
		
		TimeChooser timeChooser = new TimeChooser("Set Update Periode");

		saveOnly.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				timeChooser.setDisable(newValue);
			}
		});
		vBox.getChildren().addAll(save, saveOnly, timeChooser);

	}

	public void show(Set<ColumnModel> columnModels) {
		columnModels.forEach(col -> {
			// System.out.println(col.getOriginalName() + " " + col.getCustomName() + " " +
			// col.getIsPrimaryKey() + " "
			// + col.getIsBaseOnUpdate());
		});
	}

}
