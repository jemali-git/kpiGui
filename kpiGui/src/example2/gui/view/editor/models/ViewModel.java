package example2.gui.view.editor.models;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import example2.core.template.KpiColumn;
import example2.core.template.KpiView;
import example2.gui.view.editor.EditorTab;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleLongProperty;
import javafx.beans.property.SimpleStringProperty;

public class ViewModel {
	KpiView kpiView;
	SimpleStringProperty viewName;
	SimpleLongProperty updatePeriode;
	SimpleBooleanProperty saveOnly;
	Set<ColumnModel> columnModels;

	public ViewModel(KpiView kpiView, Function<EditorTab, ?> addViewModel) {
		this.kpiView = kpiView;

		viewName = new SimpleStringProperty(kpiView.getViewPath());
		saveOnly = new SimpleBooleanProperty(false);
		updatePeriode = new SimpleLongProperty(0);// TODO
		columnModels = new HashSet<>();

		ViewModel viewModel = this;
		class CallBack {
			int createColumns(Set<KpiColumn> kpiColumns) {
				kpiColumns.forEach(kpiColumn -> {
					columnModels.add(new ColumnModel(kpiColumn));
				});
				EditorTab editorTab = new EditorTab(viewModel);
				addViewModel.apply(editorTab);
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

	public int setUpdatePeriode(long updatePeriode) {
		this.updatePeriode = new SimpleLongProperty(updatePeriode);
		return 0;
	}

	public SimpleBooleanProperty getSaveOnly() {
		return saveOnly;
	}

	public void setSaveOnly(SimpleBooleanProperty saveOnly) {
		this.saveOnly = saveOnly;
	}

	public KpiView getKpiView() {
		return kpiView;
	}

	public void setKpiView(KpiView kpiView) {
		this.kpiView = kpiView;
	}

	public Map serialize() {
		Map<String, Object> viewModelSerialization = new HashMap<>();
		viewModelSerialization.put("viewName", viewName.get());
		viewModelSerialization.put("updatePeriode", updatePeriode.get());
		viewModelSerialization.put("saveOnly", saveOnly.get());
		//viewModelSerialization.put("kpiView", value);
		
		Set<Map> columnModelsSerialization;
		//viewModelSerialization.put("columnModelsSerialization", value);
		return viewModelSerialization;
	}
}