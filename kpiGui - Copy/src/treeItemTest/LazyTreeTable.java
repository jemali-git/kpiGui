package treeItemTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LazyTreeTable extends Application {

	@Override
	public void start(Stage primaryStage) {
		TreeView<Item> treeView = new TreeView<>();

		treeView.setRoot(new ItemTreeNode(new Item(1)));

		primaryStage.setScene(new Scene(new BorderPane(treeView), 400, 600));
		primaryStage.show();
	}

	public static class ItemTreeNode extends TreeItem<Item> {
		private boolean childrenLoaded = false;

		public ItemTreeNode(Item value) {
			super(value);
		}

		@Override
		public boolean isLeaf() {
			if (childrenLoaded) {
				return getChildren().isEmpty();
			}
			return false;
		}

		@Override
		public ObservableList<TreeItem<Item>> getChildren() {
			if (childrenLoaded) {
				return super.getChildren();
			}

			childrenLoaded = true;

			List<TreeItem<Item>> children = new ArrayList<>();
			for (int i = 0; i < 10; i++) {
				children.add(new ItemTreeNode(new Item(i)));
			}
			super.getChildren().addAll(children);
			return super.getChildren();
		}
	}

	public static class Item {
		private int value;

		public Item(int value) {
			this.value = value;
		}

		@Override
		public String toString() {

			return value + "";
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}