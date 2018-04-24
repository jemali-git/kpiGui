package application;

import java.io.File;
import java.io.IOException;
import java.util.prefs.Preferences;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import application.model.Person;
import application.model.PersonListWrapper;
import application.view.BirthdayStatisticsController;
import application.view.DataSourceEditDialogController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MainApp extends Application {

	private Stage primaryStage;
	private BorderPane rootLayout;

	/**
	 * The data as an observable list of Persons.
	 */
	private ObservableList<Person> personData = FXCollections.observableArrayList();

	/**
	 * Constructor
	 */
	public MainApp() {
		// Add some sample data
		personData.add(new Person("Hans", "Muster"));
		personData.add(new Person("Ruth", "Mueller"));
		personData.add(new Person("Heinz", "Kurz"));
		personData.add(new Person("Cornelia", "Meier"));
		personData.add(new Person("Werner", "Meyer"));
		personData.add(new Person("Lydia", "Kunz"));
		personData.add(new Person("Anna", "Best"));
		personData.add(new Person("Stefan", "Meier"));
		personData.add(new Person("Martin", "Mueller"));
	}

	public ObservableList<Person> getPersonData() {
		return personData;
	}

	@Override
	public void start(Stage primaryStage) {
		primaryStage.setMaximized(true);
		this.primaryStage = primaryStage;
		this.primaryStage.setTitle("AddressApp");

		// Set the application icon.
		this.primaryStage.getIcons().add(new Image("file:resources/images/address_book_32.png"));

		initRootLayout();
		//
		showPersonOverview();
	}

	/**
	 * Initializes the root layout and tries to load the last opened person file.
	 */
	public void initRootLayout() {
		try {
			// Load root layout from fxml file.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/RootLayout.fxml"));
			// rootLayout = (BorderPane) loader.load();

			BorderPane borderPane = new BorderPane();

			borderPane.getStylesheets().add(MainApp.class.getResource("view/DarkTheme.css").toExternalForm());
			//
			MenuBar menuBar = new MenuBar();
			borderPane.setTop(menuBar);
			BorderPane.setAlignment(menuBar, Pos.CENTER);
			Menu menu = new Menu("File");
			menuBar.getMenus().add(menu);

			menu.setMnemonicParsing(false);
			MenuItem menuItem = new MenuItem("Connect Data Source Explorer");
			menu.getItems().add(menuItem);
			menuItem.setMnemonicParsing(false);
			menuItem.setAccelerator(new KeyCodeCombination(KeyCode.N, KeyCombination.CONTROL_DOWN));
			rootLayout = borderPane;

			// Show the scene containing the root layout.
			Scene scene = new Scene(rootLayout);
			primaryStage.setScene(scene);

			// Give the controller access to the main app.
			// RootLayoutController controller = loader.getController();
			// controller.setMainApp(this);

			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Try to load last opened person file.
		// File file = getPersonFilePath();
		// if (file != null) {
		// loadPersonDataFromFile(file);
		// }
	}

	/**
	 * Shows the person overview inside the root layout.
	 */
	public void showPersonOverview() {
		try {
			// Load person overview.
			// FXMLLoader loader = new FXMLLoader();
			// loader.setLocation(MainApp.class.getResource("view/DataSourceOverview.fxml"));
			// AnchorPane personOverview = (AnchorPane) loader.load();
			/***/
			AnchorPane dataSourceOverview = new AnchorPane();
			dataSourceOverview.getStylesheets().add(MainApp.class.getResource("view/DarkTheme.css").toExternalForm());
			SplitPane splitPane = new SplitPane();
			dataSourceOverview.getChildren().add(splitPane);
			AnchorPane.setBottomAnchor(splitPane, 0.0);
			AnchorPane.setTopAnchor(splitPane, 0.0);
			AnchorPane.setRightAnchor(splitPane, 0.0);
			AnchorPane.setLeftAnchor(splitPane, 0.0);
			/***/
			AnchorPane anchorPane = new AnchorPane();
			anchorPane.setMaxWidth(300);
			anchorPane.setMinWidth(50);
			splitPane.getItems().add(anchorPane);

			Object hostName = "hostname";
			ImageView rooticon = new ImageView(new Image("file:resources/images/IBM_Notes.png"));
			rooticon.setFitHeight(30);
			rooticon.setFitWidth(30);

			TreeItem<Object> rootNode = new TreeItem<>(hostName, rooticon);
			for (int i = 0; i < 5; i++) {
				ImageView nodeIcon = new ImageView(new Image("file:resources/images/view.png"));
				nodeIcon.setFitHeight(30);
				nodeIcon.setFitWidth(30);
				TreeItem<Object> node = new TreeItem<>(hostName, nodeIcon);
				node.setExpanded(true);
				rootNode.getChildren().add(node);
			}
			rootNode.setExpanded(true);
			// create the tree view
			// add everything to the tree pane

			// VBox treeBox = new VBox();
			TreeView<Object> treeView = new TreeView<>(rootNode);

			Pane pane=new Pane();
			
			// treeBox.getChildren().addAll(new Label("File browser"), treeView);
			// VBox.setVgrow(treeView, Priority.ALWAYS);

			anchorPane.getChildren().add(treeView);
			//
			AnchorPane.setBottomAnchor(treeView, 0.0);
			AnchorPane.setTopAnchor(treeView, 0.0);
			AnchorPane.setRightAnchor(treeView, 0.0);
			AnchorPane.setLeftAnchor(treeView, 0.0);

			/***/
			AnchorPane anchorPane2 = new AnchorPane();
			splitPane.getItems().add(anchorPane2);
			TableView<Person> tableView2 = new TableView<>();
			AnchorPane.setBottomAnchor(tableView2, 0.0);
			AnchorPane.setTopAnchor(tableView2, 0.0);
			AnchorPane.setRightAnchor(tableView2, 0.0);
			AnchorPane.setLeftAnchor(tableView2, 0.0);
			anchorPane2.getChildren().add(tableView2);

			// Set person overview into the center of root layout.
			rootLayout.setCenter(dataSourceOverview);

			// Give the controller access to the main app.
			// DataSourceOverviewController controller = loader.getController();
			// controller.setMainApp(this);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Opens a dialog to edit details for the specified person. If the user clicks
	 * OK, the changes are saved into the provided person object and true is
	 * returned.
	 * 
	 * @param person
	 *            the person object to be edited
	 * @return true if the user clicked OK, false otherwise.
	 */
	public boolean showPersonEditDialog(Person person) {
		try {
			// Load the fxml file and create a new stage for the popup dialog.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/DataSourceEditDialog.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			// Create the dialog Stage.
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Edit Person");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the person into the controller.
			DataSourceEditDialogController controller = loader.getController();
			controller.setDialogStage(dialogStage);
			controller.setPerson(person);

			// Set the dialog icon.
			dialogStage.getIcons().add(new Image("file:resources/images/edit.png"));

			// Show the dialog and wait until the user closes it
			dialogStage.showAndWait();

			return controller.isOkClicked();
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * Opens a dialog to show birthday statistics.
	 */
	public void showBirthdayStatistics() {
		try {
			// Load the fxml file and create a new stage for the popup.
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MainApp.class.getResource("view/BirthdayStatistics.fxml"));
			AnchorPane page = (AnchorPane) loader.load();
			Stage dialogStage = new Stage();
			dialogStage.setTitle("Birthday Statistics");
			dialogStage.initModality(Modality.WINDOW_MODAL);
			dialogStage.initOwner(primaryStage);
			Scene scene = new Scene(page);
			dialogStage.setScene(scene);

			// Set the persons into the controller.
			BirthdayStatisticsController controller = loader.getController();
			controller.setPersonData(personData);

			// Set the dialog icon.
			dialogStage.getIcons().add(new Image("file:resources/images/calendar.png"));

			dialogStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Returns the person file preference, i.e. the file that was last opened. The
	 * preference is read from the OS specific registry. If no such preference can
	 * be found, null is returned.
	 * 
	 * @return
	 */
	public File getPersonFilePath() {
		Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
		String filePath = prefs.get("filePath", null);
		if (filePath != null) {
			return new File(filePath);
		} else {
			return null;
		}
	}

	/**
	 * Sets the file path of the currently loaded file. The path is persisted in the
	 * OS specific registry.
	 * 
	 * @param file
	 *            the file or null to remove the path
	 */
	public void setPersonFilePath(File file) {
		Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
		if (file != null) {
			prefs.put("filePath", file.getPath());

			// Update the stage title.
			primaryStage.setTitle("AddressApp - " + file.getName());
		} else {
			prefs.remove("filePath");

			// Update the stage title.
			primaryStage.setTitle("AddressApp");
		}
	}

	/**
	 * Loads person data from the specified file. The current person data will be
	 * replaced.
	 * 
	 * @param file
	 */
	public void loadPersonDataFromFile(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(PersonListWrapper.class);
			Unmarshaller um = context.createUnmarshaller();

			// Reading XML from the file and unmarshalling.
			PersonListWrapper wrapper = (PersonListWrapper) um.unmarshal(file);

			personData.clear();
			personData.addAll(wrapper.getPersons());

			// Save the file path to the registry.
			setPersonFilePath(file);

		} catch (Exception e) { // catches ANY exception
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not load data");
			alert.setContentText("Could not load data from file:\n" + file.getPath());

			alert.showAndWait();
		}
	}

	/**
	 * Saves the current person data to the specified file.
	 * 
	 * @param file
	 */
	public void savePersonDataToFile(File file) {
		try {
			JAXBContext context = JAXBContext.newInstance(PersonListWrapper.class);
			Marshaller m = context.createMarshaller();
			m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			// Wrapping our person data.
			PersonListWrapper wrapper = new PersonListWrapper();
			wrapper.setPersons(personData);

			// Marshalling and saving XML to the file.
			m.marshal(wrapper, file);

			// Save the file path to the registry.
			setPersonFilePath(file);
		} catch (Exception e) { // catches ANY exception
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("Could not save data");
			alert.setContentText("Could not save data to file:\n" + file.getPath());

			alert.showAndWait();
		}
	}

	/**
	 * Returns the main stage.
	 * 
	 * @return
	 */
	public Stage getPrimaryStage() {
		return primaryStage;
	}

	public static void main(String[] args) {
		launch(args);
	}
}