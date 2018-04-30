package example2.gui;

import java.util.concurrent.ThreadLocalRandom;

import example2.gui.menuBar.KpiMenuBar;
import example2.gui.statusLine.KpiStatusLine;
import example2.gui.toolBar.KpiToolBar;
import example2.gui.view.KpiPerspective;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WorkBenchWindow extends Application {
	public static KpiMenuBar kpiMenuBar;
	public static KpiToolBar kpiToolBar;
	public static KpiPerspective kpiPerspective;
	public static KpiStatusLine kpiStatusLine;

	@Override
	public void start(Stage primaryStage) {
		kpiMenuBar = new KpiMenuBar();
		kpiToolBar = new KpiToolBar();
		kpiPerspective = new KpiPerspective();
		kpiStatusLine = new KpiStatusLine();

		BorderPane borderPane = new BorderPane();
		borderPane.getStylesheets().add(getClass().getResource("style/DarkTheme.css").toExternalForm());

		borderPane.setTop(new VBox(kpiMenuBar, kpiToolBar));

		borderPane.setCenter(kpiPerspective);

		borderPane.setBottom(kpiStatusLine);
		primaryStage.setScene(new Scene(borderPane, 700, 500));
		primaryStage.show();
	}

	public static void init(String[] args) {
		launch(args);
	}

	public static String getRN() {
		int length = ThreadLocalRandom.current().nextInt(5, 10);
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < length; i++) {
			int codeAC = ThreadLocalRandom.current().nextInt(32, 126);
			stringBuilder.append((char) codeAC);
		}
		return stringBuilder.toString();
	}
}
