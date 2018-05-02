package example2.gui.view.operationsProgress.progressBar;

import javafx.application.Platform;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class KpiProgressBar extends VBox {
	Label title = new Label();
	Label message = new Label();
	ProgressBar progressBar = new ProgressBar();

	public KpiProgressBar(EventHandler<MouseEvent> eventHandler) {
		HBox hBox = new HBox(title, message);
		hBox.setSpacing(5);

		progressBar.addEventHandler(MouseEvent.ANY, eventHandler);
		progressBar.setProgress(0);
		progressBar.setPrefWidth(300);
		getChildren().addAll(hBox, progressBar);
	}

	public int setTitle(String t) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				title.setText(t + ":");
			}
		});
		return 0;
	}

	public int setMessage(String msg) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				message.setText(msg);
			}
		});
		return 0;
	}

	public int setProgress(Float p) {
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				progressBar.setProgress(p);
			}
		});
		return 0;
	}
}
