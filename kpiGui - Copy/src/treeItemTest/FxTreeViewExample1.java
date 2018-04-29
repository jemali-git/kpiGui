package treeItemTest;



import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FxTreeViewExample1 extends Application
{
	public static void main(String[] args)
	{
		Application.launch(args);
	}

	@Override
	public void start(Stage stage)
	{

		ArrayList<TreeItem<String>> products = new ArrayList<>();

		// Create the TreeView
		TreeView<String> treeView = new TreeView<>();
		// Create the Root TreeItem
		TreeItem<String> rootItem = new TreeItem<String>("Vehicles");
		// Add children to the root
		rootItem.getChildren().addAll(products);
		// Set the Root Node
		treeView.setRoot(rootItem);   //

		// Create the VBox
		VBox root = new VBox();
		// Add the TreeView to the VBox
		root.getChildren().add(treeView);

		// Create the Scene
		Scene scene = new Scene(root,400,400);
		// Add the Scene to the Stage
		stage.setScene(scene);
		// Set the Title for the Scene
		stage.setTitle("TreeView Example 1");
		// Display the stage
		stage.show();
	}
}
