package example2.gui.menuBar;

import example2.gui.menuBar.fileMenu.FileMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;

public class KpiMenuBar extends MenuBar {
	public KpiMenuBar() {
		getMenus().add(new FileMenu());
	}
}
