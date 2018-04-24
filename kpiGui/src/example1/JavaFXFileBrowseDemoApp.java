package example1;

import java.net.InetAddress;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class JavaFXFileBrowseDemoApp extends Application {
	private TreeView<Object> treeView;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		// create tree pane
		VBox treeBox = new VBox();
		treeBox.setPadding(new Insets(10, 10, 10, 10));
		treeBox.setSpacing(10);
		// setup the file browser root
		String hostName = "computer";
		try {
			hostName = InetAddress.getLocalHost().getHostName();
		} catch (Exception x) {
		}
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
		treeView = new TreeView<>(rootNode);
		// add everything to the tree pane
		treeBox.getChildren().addAll(new Label("File browser"), treeView);
		VBox.setVgrow(treeView, Priority.ALWAYS);

		// setup and show the window
		primaryStage.setTitle("JavaFX File Browse Demo");
		StackPane root = new StackPane();
		root.getChildren().addAll(treeBox);
		primaryStage.setScene(new Scene(root, 400, 300));
		primaryStage.show();
	}
}