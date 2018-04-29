package example2.gui.toolBar;

import example2.gui.toolBar.search.SearchField;
import javafx.scene.control.ToolBar;

public class KpiToolBar extends ToolBar {
	public static SearchField searchField;

	public KpiToolBar() {
		searchField = new SearchField();
		getItems().add(searchField);
	}
}
