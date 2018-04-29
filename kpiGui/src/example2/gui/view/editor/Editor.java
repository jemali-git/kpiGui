package example2.gui.view.editor;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;

public class Editor extends TabPane {

	public Editor() {
        Tab table1=new Tab("table1");
        getTabs().add(table1);
        Tab table2=new Tab("table2");
        getTabs().add(table2);
	}
}
