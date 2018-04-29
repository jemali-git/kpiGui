package example2.gui.view.explorer;

import example2.core.lotusNotes.KpiServerImpl;
import example2.gui.WorkBenchWindow;
import example2.gui.toolBar.KpiToolBar;
import example2.gui.view.explorer.dataExplorer.ServerExplorer;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TreeView;

public class Explorer extends TabPane {

	public Explorer() {
		Tab dataExplorer = new Tab("DataExlorer");
		TreeView<Object> treeView = new TreeView<>(new ServerExplorer(new KpiServerImpl(WorkBenchWindow.getRN())));
		
		dataExplorer.setContent(treeView);
		getTabs().add(dataExplorer);
		KpiToolBar.searchField.addTreeView(treeView);
	}
}
