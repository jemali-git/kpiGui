package example2.gui.view.editor;

import java.util.HashSet;
import java.util.Set;
import java.util.function.Function;

import example2.core.template.KpiColumn;
import example2.core.template.KpiView;
import example2.gui.view.editor.models.SimpleColumn;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class Editor extends TabPane {
	public Editor() {
	}

	public void addView(Set<KpiColumn> columns, KpiView kpiView, Function<Boolean, ?> function) {

		Set<SimpleColumn> simpleColumns = new HashSet<>();
		columns.forEach(column -> {
			simpleColumns.add(new SimpleColumn(column.getColumnName()));
		});

		Table table = new Table(simpleColumns, kpiView.getViewPath());
		
		table.setOnCloseRequest(new EventHandler<Event>() {
			@Override
			public void handle(Event arg0) {
				 function.apply(false);
				 updateBounds();
			}
		});

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				getTabs().add(table);
				getSelectionModel().select(table);
			}
		});     
	}

	// public Boolean isEditing(String id) {
	// for (Tab tab : getTabs()) {
	// if (tab.getId().equals(id)) {
	// return true;
	// }
	// }
	// return false;
	// }
}
