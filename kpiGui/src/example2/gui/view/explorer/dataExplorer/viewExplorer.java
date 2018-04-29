package example2.gui.view.explorer.dataExplorer;

import example2.core.template.KpiView;
import example2.gui.view.explorer.dataExplorer.util.Ticket;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

public class viewExplorer extends TreeItem<Object> {
	private boolean childrenLoaded = false;
	private Ticket ticket;

	public viewExplorer(Object value) {
		super(value);
		ticket = new Ticket("View");
		setGraphic(ticket);
	}
	public void select() {
		ticket.selectionOn();
	}

	public void deselect() {
		ticket.selectOff();
	}
	public boolean isChildrenLoaded() {
		return childrenLoaded;
	}
	
	public Ticket getTicket() {
		return ticket;
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
		((KpiView) getValue()).getKpiColumn(this::addChild);
		return super.getChildren();
	}

	public Integer addChild(String value) {
		System.out.println("edit " + value);
		return null;
	}
}
