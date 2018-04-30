package example3;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class LayerTest extends Application {
	@Override
	public void start(final Stage primaryStage) throws Exception {
		final Node layerA = createLayerA();
		final Node layerB = createLayerB();

		layerB.setPickOnBounds(false);

		final Parent root = new StackPane(layerA, layerB);
		final Scene scene = new Scene(root);
		StackPane stackPane=new StackPane();
		stackPane.setPickOnBounds(false);
		primaryStage.setScene(scene);
		primaryStage.setWidth(250);
		primaryStage.setHeight(200);
		primaryStage.show();
	}

	private Node createLayerA() {
		final AnchorPane layerA = new AnchorPane();
		layerA.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 4;"
				+ "-fx-border-insets: 5;" + "-fx-border-radius: 5;" + "-fx-border-color: blue;");
		final Button buttonA = new Button("Button A");
		AnchorPane.setLeftAnchor(buttonA, 10d);
		AnchorPane.setTopAnchor(buttonA, 10d);
		buttonA.setOnMouseClicked(e -> System.out.println("Button A clicked"));
		layerA.getChildren().setAll(buttonA);
		return layerA;
	}

	private Node createLayerB() {
		final AnchorPane layerB = new AnchorPane();
//		layerB.setStyle("-fx-padding: 10;" + "-fx-border-style: solid inside;" + "-fx-border-width: 10;"
//				+ "-fx-border-insets: 1;" + "-fx-border-radius: 1;" + "-fx-border-color: red;");
		final Button buttonB = new Button("Button B");
		AnchorPane.setRightAnchor(buttonB, 10d);
		AnchorPane.setBottomAnchor(buttonB, 10d);
		buttonB.setOnMouseClicked(e -> System.out.println("Button B clicked"));
		layerB.getChildren().setAll(buttonB);
		return layerB;
	}

	public static void main(String[] args) {
		launch(args);
	}
}