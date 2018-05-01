package example2.gui.view.editor.models;

import java.util.HashSet;
import java.util.Set;
import java.util.function.BiFunction;
import java.util.function.Function;

import example2.core.template.KpiColumn;
import example2.core.template.KpiView;
import example2.gui.view.editor.Table;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class ViewModel {
	KpiView kpiView;
	SimpleStringProperty viewName;
	SimpleLongProperty updatePeriode;
	SimpleBooleanProperty saveOnly;
	Set<ColumnModel> columnModels;

	public ViewModel(KpiView kpiView, Function<Table, ?> addViewModel) {
		this.kpiView = kpiView;
		viewName = new SimpleStringProperty(kpiView.getViewPath());
		saveOnly = new SimpleBooleanProperty(false);
		updatePeriode = new SimpleLongProperty(0);
		columnModels = new HashSet<>();

		ViewModel viewModel = this;
		class CallBack {
			int createColumns(Set<KpiColumn> kpiColumns) {
				kpiColumns.forEach(kpiColumn -> {
					columnModels.add(new ColumnModel(kpiColumn));
				});
				Table table = new Table(viewModel);
				addViewModel.apply(table);
				return 0;
			}
		}
		CallBack callBack = new CallBack();
		kpiView.getKpiColumn(callBack::createColumns);

	}

	public SimpleStringProperty getViewName() {
		return viewName;
	}

	public void setViewName(SimpleStringProperty viewName) {
		this.viewName = viewName;
	}

	public Set<ColumnModel> getColumnModels() {
		return columnModels;
	}

	public SimpleLongProperty getUpdatePeriode() {
		return updatePeriode;
	}

	public void setUpdatePeriode(long updatePeriode) {
		this.updatePeriode = new SimpleLongProperty(updatePeriode);
	}

	public SimpleBooleanProperty getSaveOnly() {
		return saveOnly;
	}

	public void setSaveOnly(SimpleBooleanProperty saveOnly) {
		this.saveOnly = saveOnly;
	}

}
