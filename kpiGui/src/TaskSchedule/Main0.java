package TaskSchedule;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main0 extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) {
		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd HH:mm:SS");
		// Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
		// label.setText(LocalDateTime.now().format(formatter));
		// System.out.println("eee");
		// }), new KeyFrame(Duration.seconds(1)));
		// clock.setCycleCount(Animation.INDEFINITE);
		// clock.play();

		VBox root = new VBox();
		root.getChildren().add(new TaskView());
		Scene scene = new Scene(root, 400, 400);
		stage.setScene(scene);
		stage.setTitle("Task Schedule");
		stage.show();
	}
}

class TaskView extends HBox {
	public TaskView() {
		Label title = new Label("title");
		Label description = new Label("description");
		Label time = new Label("time");
		setSpacing(10);
		getChildren().addAll(title, description, time);
	}
}