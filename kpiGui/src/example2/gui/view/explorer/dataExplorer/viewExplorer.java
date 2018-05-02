package example2.gui.view.explorer.dataExplorer;

import example2.core.template.KpiView;
import example2.gui.view.KpiPerspective;
import example2.gui.view.explorer.dataExplorer.util.Ticket;
import javafx.scene.control.TreeItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

public class viewExplorer extends TreeItem<Object> {

	private Ticket ticket;
	private boolean childrenLoaded = false;

	public viewExplorer(Object value) {
		super(value);
		ticket = new Ticket("View");
		setGraphic(ticket);
		ticket.addEventHandler(MouseEvent.ANY, event -> {
			if (event.getClickCount() == 2 && event.getButton().equals(MouseButton.PRIMARY)) {
				if (event.getEventType().equals(MouseEvent.MOUSE_CLICKED)) {
					if (!childrenLoaded) {
						childrenLoaded = true;
						KpiView kpiView = (KpiView) getValue();
						ticket.setTicketState("loading..");
						KpiPerspective.editor.createViewModel(kpiView, this::setChildrenLoaded,ticket::setTicketState);
					}
				}
				event.consume();
			}
		});
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
}
