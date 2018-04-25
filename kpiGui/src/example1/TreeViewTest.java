package example1;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.TreeItem.TreeModificationEvent;
import javafx.scene.effect.Shadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class TreeViewTest extends Application {

	public TreeViewTest() {

	}

	Node rootIcon = new ImageView(new Image("file:resources/images/address_book_32.png"));

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) {
		
		

		TreeItem<Object> rootItem = new TreeItem<>("Inbox", rootIcon);
		rootItem.setExpanded(false);
		rootItem.addEventHandler(TreeItem.<String>branchExpandedEvent(),new EventHandler<TreeItem.TreeModificationEvent<String>>()
		{
			@Override
			public void handle(TreeModificationEvent<String> event)
			{
				System.out.println("aaaaaa");
			}
		});
		
		for (int i = 1; i < 3; i++) {
			Node itemIcon = new ImageView(new Image("file:resources/images/edit.png"));
			TreeItem<Object> item = new TreeItem<>(new A());
			rootItem.getChildren().add(item);
		}
		for (int i = 1; i < 3; i++) {
			Node itemIcon = new ImageView(new Image("file:resources/images/edit.png"));
			TreeItem<Object> item = new TreeItem<>(new B());

			rootItem.getChildren().add(item);
		}
		TreeView<Object> tree = new TreeView<>(rootItem);
				StackPane root = new StackPane();
		root.getChildren().add(tree);
		primaryStage.setScene(new Scene(root, 300, 250));
		primaryStage.show();
	}

}

interface AB {
	public void show();
}

class A implements AB {
	public A() {
	}

	@Override
	public String toString() {
		return "classA";
	}

	@Override
	public void show() {
		System.out.println("class A");
	}
}

class B implements AB {
	public B() {
	}

	@Override
	public void show() {
		System.out.println("class B");
	}

	@Override
	public String toString() {
		return "classB";
	}
}
