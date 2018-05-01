package example2.gui.view.operationProgress.operation;

import example2.core.template.KpiView;
import example2.gui.view.KpiPerspective;
import example2.gui.view.editor.models.ViewModel;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class Operation extends VBox {

	ViewModel viewModel;
	boolean modelIsDisplayed ;
	public Operation(ViewModel viewModel) {
		this.viewModel = viewModel;
		modelIsDisplayed = false;

		setPadding(new Insets(3, 10, 3, 10));
		Label title = new Label();
		ProgressBar progressBar = new ProgressBar();
		progressBar.setProgress(0);
		progressBar.setPrefWidth(300);
		Label message = new Label();
		getChildren().addAll(title, progressBar, message);

		class CallBack {
			int setTitle(String t) {
				title.setText(t);
				return 0;
			}

			int setMessage(String m) {
				message.setText(m);
				return 0;
			}

			int setProgress(float p) {
				progressBar.setProgress(p);
				return 0;
			}

			int setModelIsDisplayed(boolean state) {
				modelIsDisplayed = state;
				return 0;
			}
		}
		CallBack callBack = new CallBack();
		viewModel.getKpiView().save(viewModel, callBack::setTitle, callBack::setMessage, callBack::setProgress);

		progressBar.addEventHandler(MouseEvent.ANY, event -> {
			if (event.getClickCount() == 2 && event.getButton().equals(MouseButton.PRIMARY)) {
				if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
					if (!modelIsDisplayed) {
						modelIsDisplayed = true;
						KpiPerspective.editor.displayViewModel(viewModel, callBack::setModelIsDisplayed);
					}
				}
				event.consume();
			}
		});

	}

}
