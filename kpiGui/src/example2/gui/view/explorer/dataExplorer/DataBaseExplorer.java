package example2.gui.view.explorer.dataExplorer;

import example2.core.template.KpiDataBase;
import example2.core.template.KpiView;
import example2.gui.view.explorer.dataExplorer.util.Ticket;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;
import javafx.scene.layout.Region;

public class DataBaseExplorer extends TreeItem<Object> {
	private boolean childrenLoaded = false;

	private Ticket ticket;


	public DataBaseExplorer(Object value) {
		super(value);
		ticket = new Ticket("DataBase");
		setGraphic(ticket);
	}
	
	public void select() {
		ticket.selectionOn();
	}

	public void deselect() {
		ticket.selectOff();
	}
	public Ticket getTicket() {
		return ticket;
	}



	public boolean isChildrenLoaded() {
		return childrenLoaded;
	}
	@Override
	public boolean isLeaf() {
		if (childrenLoaded) {
			return getChildren().isEmpty();
		}
		return false;
	}

	@Override
	public ObservableList<TreeItem<Object>> getChildren() {
		if (childrenLoaded) {
			return super.getChildren();
		}
		childrenLoaded = true;
		((KpiDataBase) getValue()).getKpiView(this::addChild);
		return super.getChildren();
	}

	public Integer addChild(KpiView value, Double progress) {
		ObservableList<TreeItem<Object>> objects = super.getChildren();

		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				objects.add(new viewExplorer(value));
			}
		});
		return null;
	}
}
