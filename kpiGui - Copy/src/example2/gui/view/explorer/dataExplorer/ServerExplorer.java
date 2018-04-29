package example2.gui.view.explorer.dataExplorer;

import example2.core.template.KpiDataBase;
import example2.core.template.KpiServer;
import example2.gui.view.explorer.dataExplorer.util.Ticket;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

public class ServerExplorer extends TreeItem<Object> {
	private boolean childrenLoaded = false;
	private Ticket ticket;

	public ServerExplorer(Object value) {
		super(value);
		ticket = new Ticket("Server");
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
		((KpiServer) getValue()).getKpiDataBases(this::addChild);
		return super.getChildren();
	}

	public int addChild(KpiDataBase kpiDataBase, Double progress) {
		ObservableList<TreeItem<Object>> objects = super.getChildren();
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				objects.add(new DataBaseExplorer(kpiDataBase));
			}
		});
		return 0;
	}
}
