package example2.gui.statusLine;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;

public class KpiStatusLine extends HBox {
	public KpiStatusLine() {
		setPadding(new Insets(3, 5, 3, 5));
		
		setAlignment(Pos.CENTER);
		HBox leftHBox = new HBox(new Label("message"));
		HBox.setHgrow(leftHBox, Priority.SOMETIMES);
		leftHBox.setAlignment(Pos.CENTER_LEFT);
		/*******/

		getChildren().addAll(leftHBox);
	}
}
