package TaskSchedule;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Main extends Application {
	public static void main(String[] args) {
		Application.launch(args);
	}
	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();
		Scene scene = new Scene(root, 380, 150, Color.WHITE);

		GridPane gridpane = new GridPane();
//		gridpane.setPadding(new Insets(5));
		gridpane.setHgap(10);
		gridpane.setVgap(10);
		
		
//		ColumnConstraints column1 = new ColumnConstraints(100);
//		ColumnConstraints column2 = new ColumnConstraints(50, 150, 300);
//		column2.setHgrow(Priority.ALWAYS);
//		gridpane.getColumnConstraints().addAll(column1, column2);

		Label title = new Label("Title");
		gridpane.add(title, 0, 0);
		Label description = new Label("Description");
		gridpane.add(description, 1, 0);
		Label time = new Label("Time");
		gridpane.add(time, 2, 0);
		
		Label actions = new Label("Actions");
		gridpane.add(actions, 3, 0);
		

		
		
		
		
		
		
		TextField lNameFld = new TextField();
		TextField fNameFld = new TextField();
		Button saveButt = new Button("Save");

		// First name label
		//GridPane.setHalignment(fNameLbl, HPos.RIGHT);
		

		// Last name label
		//GridPane.setHalignment(lNameLbl, HPos.RIGHT);
		

		// First name field
//		GridPane.setHalignment(fNameFld, HPos.LEFT);
//		gridpane.add(fNameFld, 1, 0);

		// Last name field
//		GridPane.setHalignment(lNameFld, HPos.LEFT);
//		gridpane.add(lNameFld, 1, 1);

		// Save button
//		GridPane.setHalignment(saveButt, HPos.RIGHT);
//		gridpane.add(saveButt, 1, 2);

		root.setCenter(gridpane);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}