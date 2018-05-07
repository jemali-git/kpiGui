package TaskSchedule;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TableViewSample extends Application {

	private TableView<Task> table = new TableView<Task>();
	private final ObservableList<Task> data = FXCollections.observableArrayList(new Task("Jacob", "Smith"));
	final HBox hb = new HBox();

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) {
		Scene scene = new Scene(new Group());
		stage.setTitle("Table View Sample");
		stage.setWidth(500);
		stage.setHeight(600);

		final Label label = new Label("Address Book");
		label.setFont(new Font("Arial", 20));

		table.setEditable(true);
		table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		TableColumn titleCol = new TableColumn("Title");
		titleCol.setMinWidth(100);
		titleCol.setCellValueFactory(new PropertyValueFactory<Task, String>("title"));
		titleCol.setCellFactory(TextFieldTableCell.forTableColumn());
		titleCol.setOnEditCommit(new EventHandler<CellEditEvent<Task, String>>() {
			@Override
			public void handle(CellEditEvent<Task, String> t) {
				((Task) t.getTableView().getItems().get(t.getTablePosition().getRow())).setTitle(t.getNewValue());
			}
		});

		TableColumn descriptionCol = new TableColumn("Description");
		descriptionCol.setMinWidth(100);
		descriptionCol.setCellValueFactory(new PropertyValueFactory<Task, String>("description"));
		descriptionCol.setCellFactory(TextFieldTableCell.forTableColumn());
		descriptionCol.setOnEditCommit(new EventHandler<CellEditEvent<Task, String>>() {
			@Override
			public void handle(CellEditEvent<Task, String> t) {
				((Task) t.getTableView().getItems().get(t.getTablePosition().getRow())).setDescription(t.getNewValue());
			}
		});

		table.setItems(data);
		table.getColumns().addAll(titleCol, descriptionCol);

		// data.forEach(person -> {
		// DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd HH:mm:SS");
		// Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
		// person.setTime(LocalDateTime.now().format(formatter));
		// table.refresh();
		// }), new KeyFrame(Duration.seconds(1)));
		// clock.setCycleCount(Animation.INDEFINITE);
		// clock.play();
		// });

		final TextField addFirstName = new TextField();
		addFirstName.setPromptText("First Name");
		addFirstName.setMaxWidth(titleCol.getPrefWidth());
		final TextField addLastName = new TextField();
		addLastName.setMaxWidth(descriptionCol.getPrefWidth());
		addLastName.setPromptText("Last Name");

		final Button addButton = new Button("Add");
		addButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				data.add(new Task(addFirstName.getText(), addLastName.getText()));
				addFirstName.clear();
				addLastName.clear();
			}
		});

		hb.getChildren().addAll(addButton,addFirstName, addLastName);
		hb.setSpacing(3);

		Button start = new Button("Start");
		Button reset = new Button("Reset");
		HBox hBox = new HBox(start, reset);

		hb.getChildren().add(hBox);

		final VBox vbox = new VBox();
		vbox.setSpacing(5);
		vbox.setPadding(new Insets(10, 0, 0, 10));
		vbox.getChildren().addAll(label, table, hb);

		((Group) scene.getRoot()).getChildren().addAll(vbox);

		stage.setScene(scene);
		stage.show();
	}

}