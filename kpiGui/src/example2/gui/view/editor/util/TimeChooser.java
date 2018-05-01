package example2.gui.view.editor.util;

import java.util.function.Function;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class TimeChooser extends HBox {
	int seconds;
	int minutes;
	int hours;
	TextField textTime;

	public TimeChooser(String msg, Function<Long, ?> setUpdatePeriod) {
		setSpacing(10);
		getChildren().add(new Label(msg + ": "));
		textTime = new TextField();
		textTime.setPromptText("Choose Periode");
		Label label = new Label("Seconds: " + seconds + " Minutes: " + minutes + " Hours: " + hours);

		textTime.textProperty().addListener((observable, oldValue, newValue) -> {
			textTime.setText(newValue.replaceAll("[^\\d]", ""));
			try {
				long time = Long.parseLong(textTime.getText());

				setUpdatePeriod.apply(time);
				hours = (int) time / (60 * 60);
				time = time % (60 * 60);
				minutes = (int) (time / 60);
				time = time % 60;
				seconds = (int) time;
				label.setText("Seconds: " + seconds + " Minutes: " + minutes + " Hours: " + hours);
			} catch (Exception e) {
				// TODO handle
			}

		});

		getChildren().addAll(textTime, label);
	}

	public void setTextTime(Long time) {
		this.textTime.setText(time.toString());
	}

}
