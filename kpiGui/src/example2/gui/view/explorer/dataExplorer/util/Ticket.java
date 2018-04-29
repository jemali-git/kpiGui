package example2.gui.view.explorer.dataExplorer.util;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Ticket extends HBox {
	Label proress;
	Circle circle;

	HBox itemLabel = new HBox();
	HBox hCircle = new HBox();

	public Ticket(String type) {
		getChildren().addAll(itemLabel, hCircle);
		setPadding(new Insets(2, 2, 2, 2));
		setSpacing(5);

		circle = new Circle(3, 3, 3, Color.RED);
		itemLabel.getChildren().add(new Label(type));

		proress = new Label();
		itemLabel.getStyleClass().add("itemLabel");
	}

	public void selectionOn() {
		if (!hCircle.getChildren().contains(circle)) {
			hCircle.getChildren().add(circle);
		}
	}

	public void selectOff() {
		hCircle.getChildren().remove(circle);
	}
}
