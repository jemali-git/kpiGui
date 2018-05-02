package example2.gui.view.explorer;

import example2.core.lotusNotes.ServerImpl;
import example2.gui.WorkBenchWindow;
import example2.gui.toolBar.KpiToolBar;
import example2.gui.view.explorer.dataExplorer.ServerExplorer;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TreeView;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;

public class Explorer extends TabPane {

	SplitPane dataSources = new SplitPane();

	public Explorer() {
		Tab dataExplorer = new Tab("DataExlorer");

		dataExplorer.setContent(dataSources);
		getTabs().add(dataExplorer);
		addDataSource(null, null);
		addDataSource(null,null);
	}
	public void addDataSource(String serverPath,String serverPassword) {
		TreeView<Object> treeView = new TreeView<>(new ServerExplorer(new ServerImpl(WorkBenchWindow.getRN())));
		KpiToolBar.searchField.addTreeView(treeView);
		dataSources.getItems().add(treeView);
	}
}
