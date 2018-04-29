package example2.gui.toolBar.search;

import example2.gui.view.explorer.dataExplorer.DataBaseExplorer;
import example2.gui.view.explorer.dataExplorer.ServerExplorer;
import example2.gui.view.explorer.dataExplorer.viewExplorer;
import example2.gui.view.explorer.dataExplorer.util.Ticket;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;

public class SearchField extends TextField {

	public SearchField() {
		setPromptText("Quick Access");
	}

	public void addTreeView(TreeView<Object> treeView) {
		textProperty().addListener((observable, oldValue, newValue) -> {
			search(newValue, treeView);
		});
	}

	public void search(String word, TreeView<Object> treeView) {
		TreeItemDictionary treeItemDictionary = new TreeItemDictionary();

		ServerExplorer serverExplorer = (ServerExplorer) treeView.getRoot();
		serverExplorer.deselect();

		if (serverExplorer.isChildrenLoaded()) {
			treeItemDictionary.addTreeItem(treeView.getRoot());
			for (TreeItem<Object> child0 : serverExplorer.getChildren()) {
				DataBaseExplorer dataBaseExplorer = (DataBaseExplorer) child0;
				dataBaseExplorer.deselect();
				treeItemDictionary.addTreeItem(child0);
				if (dataBaseExplorer.isChildrenLoaded()) {
					for (TreeItem<Object> child1 : dataBaseExplorer.getChildren()) {
						treeItemDictionary.addTreeItem(child1);
						viewExplorer viewExplorer = (viewExplorer) child1;
						viewExplorer.deselect();
					}
				}
			}
		}

		for (TreeItem<Object> treeItem : treeItemDictionary.getMatchTreeItems(word)) {
			((Ticket) treeItem.getGraphic()).selectionOn();
			TreeItem<Object> parent = treeItem.parentProperty().get();
			if (parent != null) {
				parent.getChildren().remove(treeItem);
				parent.getChildren().add(0, treeItem);
				parent.setExpanded(true);
			}
		}
	}
}
