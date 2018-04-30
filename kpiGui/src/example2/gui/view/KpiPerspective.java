package example2.gui.view;

import example2.gui.view.editor.Editor;
import example2.gui.view.explorer.Explorer;
import javafx.geometry.Orientation;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Border;
import javafx.scene.layout.StackPane;

public class KpiPerspective extends AnchorPane {
	public static Explorer explorer;
	public static Editor editor;
	public static SplitPane splitPane0_1_H;
	public static SplitPane splitPane1_2_V;

	public KpiPerspective() {
		explorer = new Explorer();
		editor = new Editor();
		splitPane0_1_H = new SplitPane();
		splitPane0_1_H.setOrientation(Orientation.HORIZONTAL);
		splitPane1_2_V = new SplitPane();
		splitPane1_2_V.setOrientation(Orientation.VERTICAL);
		getChildren().add(splitPane0_1_H);

		AnchorPane.setBottomAnchor(splitPane0_1_H, 0.0);
		AnchorPane.setTopAnchor(splitPane0_1_H, 0.0);
		AnchorPane.setRightAnchor(splitPane0_1_H, 0.0);
		AnchorPane.setLeftAnchor(splitPane0_1_H, 0.0);
		splitPane0_1_H.setDividerPositions(0.2);

		splitPane0_1_H.getItems().addAll(explorer, splitPane1_2_V);

		splitPane1_2_V.getItems().add(editor);
	}
}
