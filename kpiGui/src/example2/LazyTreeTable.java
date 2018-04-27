package example2;

import java.util.ArrayList;
import java.util.List;

import javax.security.auth.Refreshable;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class LazyTreeTable extends Application {
	TreeView<Object> treeView;

	@Override
	public void start(Stage primaryStage) {
		treeView = new TreeView<>();
		treeView.setRoot(new ItemTreeNode("server"));

		primaryStage.setScene(new Scene(new BorderPane(treeView), 400, 600));
		primaryStage.show();
	}

	public class ItemTreeNode extends TreeItem<Object> {
		private boolean childrenLoaded = false;
		private Double loadingProgress;

		public Double getLoadingProgress() {
			return loadingProgress;
		}

		@Override
		public String toString() {
			return getValue() + ": " + loadingProgress + " %";
		}
		public void setLoadingProgress(Double loadingProgress) {
			this.loadingProgress = loadingProgress;
		}

		public ItemTreeNode(Object value) {
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
		public ObservableList<TreeItem<Object>> getChildren() {
			if (childrenLoaded) {
				return super.getChildren();
			}
			childrenLoaded = true;
			ServerTepmlate serverTepmlate = new ServerTepmlate();
			serverTepmlate.getDataBases(null, this::addChild);
			return super.getChildren();
		}

		public Integer addChild(String value, Double progress) {
			ObservableList<TreeItem<Object>> objects = super.getChildren();

			Platform.runLater(new Runnable() {
				@Override
				public void run() {
					objects.add(new TreeItem<>(value));
					loadingProgress = progress;
				}
			});
			return null;
		}

		
	}

	public static void main(String[] args) {
		launch(args);
	}
}

class serverView extends TreeItem<Object> {
	public Integer progress = 0;
	public String name;

	@Override
	public String toString() {
		return "name" + ": " + progress + " %";
	}

}
