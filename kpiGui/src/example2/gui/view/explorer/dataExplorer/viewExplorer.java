package example2.gui.view.explorer.dataExplorer;

import java.util.Set;

import example2.core.template.KpiColumn;
import example2.core.template.KpiView;
import example2.gui.view.KpiPerspective;
import example2.gui.view.explorer.dataExplorer.util.Ticket;
import javafx.collections.ObservableList;
import javafx.scene.control.TreeItem;

public class viewExplorer extends TreeItem<Object> {

	private Ticket ticket;
	private boolean childrenLoaded = false;

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

	public boolean setChildrenLoaded(boolean childrenLoaded) {
		this.childrenLoaded = childrenLoaded;
		return this.childrenLoaded;
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
		System.out.println("children");
		childrenLoaded = true;
		((KpiView) getValue()).getKpiColumn(this::editView);
		return super.getChildren();
	}

	public Boolean editView(Set<KpiColumn> columns) {

		KpiView kpiView = (KpiView) getValue();
		KpiPerspective.editor.addView(columns, kpiView, this::setChildrenLoaded);

		return null;
	}
}
