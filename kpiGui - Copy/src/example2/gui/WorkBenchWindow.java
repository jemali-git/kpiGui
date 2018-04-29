package example2.gui;

import java.util.concurrent.ThreadLocalRandom;

import application.MainApp;
import example2.gui.menuBar.KpiMenuBar;
import example2.gui.toolBar.KpiToolBar;
import example2.gui.view.KpiPerspective;
import example2.gui.view.explorer.Explorer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class WorkBenchWindow extends Application {
	public static KpiMenuBar kpiMenuBar;
	public static KpiToolBar kpiToolBar;
	public static KpiPerspective kpiPerspective;

	@Override
	public void start(Stage primaryStage) {
		kpiMenuBar = new KpiMenuBar();
		kpiToolBar = new KpiToolBar();
		kpiPerspective = new KpiPerspective();

		BorderPane borderPane = new BorderPane();
		borderPane.getStylesheets().add(getClass().getResource("style/DarkTheme.css").toExternalForm());
		
		borderPane.setTop(new VBox(kpiMenuBar, kpiToolBar));

		borderPane.setCenter(kpiPerspective);
		primaryStage.setScene(new Scene(borderPane, 500, 600));
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
