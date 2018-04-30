package example2.gui.view;

import example2.gui.view.editor.Editor;
import example2.gui.view.explorer.Explorer;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;

public class KpiPerspective extends AnchorPane {
	public static Explorer explorer;
	public static Editor editor;

	public KpiPerspective() {
		explorer = new Explorer();
		editor = new Editor();
		SplitPane splitPane = new SplitPane();
		getChildren().add(splitPane);
		AnchorPane.setBottomAnchor(splitPane, 0.0);
		AnchorPane.setTopAnchor(splitPane, 0.0);
		AnchorPane.setRightAnchor(splitPane, 0.0);
		AnchorPane.setLeftAnchor(splitPane, 0.0);
		splitPane.setDividerPositions(0.2);
		

		splitPane.getItems().add(explorer);
		splitPane.getItems().add(editor);
	}
}
