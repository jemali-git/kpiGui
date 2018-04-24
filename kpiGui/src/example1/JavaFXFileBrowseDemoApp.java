package example1;

import java.net.InetAddress;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXFileBrowseDemoApp extends Application {
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		// create tree pane
		HBox hBox0 = new HBox();
		hBox0.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");

		Button button1 = new Button("button1");
		Button button2 = new Button("button2");
		hBox0.setAlignment(Pos.CENTER);
		HBox hBox1 = new HBox(button1);
		hBox1.setAlignment(Pos.CENTER_LEFT);
		HBox.setHgrow(hBox1,Priority.SOMETIMES);
//		hBox1.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
//				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
		HBox hBox2 = new HBox(button2);
		hBox2.setAlignment(Pos.CENTER_RIGHT);
		HBox.setHgrow(hBox2,Priority.SOMETIMES);
		
//		hBox2.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 2;"
//				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");

		hBox0.getChildren().addAll(hBox1,hBox2);

		primaryStage.setScene(new Scene(hBox0, 400, 300));
		primaryStage.show();
	}
}