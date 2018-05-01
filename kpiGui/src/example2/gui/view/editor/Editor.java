package example2.gui.view.editor;

import java.util.function.Function;

import example2.core.template.KpiView;
import example2.gui.view.editor.models.ViewModel;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TabPane;


public class Editor extends TabPane {
	public Editor() {
	}

	public void createViewModel(KpiView kpiView, Function<Boolean, ?> function) {
		class CallBack {	
			public int addViewModel(Table table) {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						getTabs().add(table);
						getSelectionModel().select(table);
					}
				});
				table.setOnCloseRequest(new EventHandler<Event>() {
					@Override
					public void handle(Event arg0) {
						function.apply(false);
						updateBounds();
					}
				});
				return 0;
			}
		}
		
		CallBack callBack=new CallBack();
		ViewModel viewModel = new ViewModel(kpiView, callBack::addViewModel);
	}	
}
