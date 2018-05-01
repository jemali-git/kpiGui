package example2.gui.view.operationProgress;

import example2.gui.view.editor.models.ViewModel;
import example2.gui.view.operationProgress.operation.Operation;
import javafx.geometry.Insets;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.VBox;

public class OperationProgress extends ScrollPane {
	VBox vBox;
	public OperationProgress() {
		vBox=new VBox();
		vBox.setPadding(new Insets(5,5,5,5));
		setContent(vBox);
		setHbarPolicy(ScrollBarPolicy.NEVER);
	}

	public void addOperation(ViewModel viewModel) {
		vBox.getChildren().add(new Operation(viewModel));
	}
}
