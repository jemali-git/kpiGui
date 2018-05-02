package example2.gui.view.operationsProgress.operation;

import example2.gui.view.KpiPerspective;
import example2.gui.view.editor.models.ViewModel;
import example2.gui.view.operationsProgress.progressBar.KpiProgressBar;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class Operation extends VBox {

	ViewModel viewModel;
	boolean modelIsDisplayed;

	public Operation(ViewModel viewModel) {
		getStyleClass().add("operation");
		this.viewModel = viewModel;
		modelIsDisplayed = false;

		class CallBack {
			int setModelIsDisplayed(boolean state) {
				modelIsDisplayed = state;
				return 0;
			}
		}
		CallBack callBack = new CallBack();
		EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (event.getClickCount() == 2 && event.getButton().equals(MouseButton.PRIMARY)) {
					if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
						if (!modelIsDisplayed) {
							modelIsDisplayed = true;
							KpiPerspective.editor.displayViewModel(viewModel, callBack::setModelIsDisplayed);
						}
					}
					event.consume();
				}
			}
		};
		
		KpiProgressBar savingProgress = new KpiProgressBar(eventHandler);		
		getChildren().add(savingProgress);
		viewModel.getKpiView().save(viewModel, savingProgress::setTitle, savingProgress::setMessage,
				savingProgress::setProgress);

		if (!viewModel.getSaveOnly().get()) {
			KpiProgressBar updatingProgress = new KpiProgressBar(eventHandler);	
			getChildren().add(updatingProgress);
			viewModel.getKpiView().update(viewModel, updatingProgress::setTitle, updatingProgress::setMessage,
					updatingProgress::setProgress);
		}



	}
}
