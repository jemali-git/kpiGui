package example2.gui.view;

import example2.gui.view.editor.Editor;
import example2.gui.view.explorer.Explorer;
import example2.gui.view.operationProgress.OperationProgress;
import javafx.geometry.Orientation;
import javafx.scene.control.SplitPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class KpiPerspective extends AnchorPane {
	public static Explorer explorer;
	public static Editor editor;
	public static OperationProgress operationProgress;
	public static SplitPane splitPane0_1_H;
	public static SplitPane splitPane1_2_V;

	public KpiPerspective() {
		explorer = new Explorer();
		editor = new Editor();
		operationProgress = new OperationProgress();
		SplitPane splitPane = new SplitPane();
		AnchorPane.setBottomAnchor(splitPane, 0.0);
		AnchorPane.setTopAnchor(splitPane, 0.0);
		AnchorPane.setRightAnchor(splitPane, 0.0);
		AnchorPane.setLeftAnchor(splitPane, 0.0);
		splitPane.setDividerPositions(0.1,0.9);

		getChildren().add(splitPane);


		splitPane.getItems().addAll(explorer, editor,operationProgress);


	}
}
