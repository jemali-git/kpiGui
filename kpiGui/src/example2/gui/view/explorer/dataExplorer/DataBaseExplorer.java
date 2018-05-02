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
		ObservableList<TreeItem<Object>> children = super.getChildren();
		class CallBack {
			int addChild(KpiView kpiView) {
				Platform.runLater(new Runnable() {
					@Override
					public void run() {
						children.add(new viewExplorer(kpiView));
					}
				});
				return 0;
			}
		}
		CallBack callBack = new CallBack();
		ticket.setTicketState("loading..");
		((KpiDataBase) getValue()).getKpiView(callBack::addChild,ticket::setTicketState);
		return super.getChildren();
	}
}
