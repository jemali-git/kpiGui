package example2.gui.view.editor.models.serialization;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import example2.gui.view.editor.models.ViewModel;

public class ViewModelSerialisation implements Serializable {
	String viewName;
	long updatePeriode;
	boolean saveOnly;
	Set<ColumnModelSerialisation> columnModelSerialisations;

	public ViewModelSerialisation(ViewModel viewModel) {
		viewName = viewModel.getViewName().get();
		updatePeriode = viewModel.getUpdatePeriode().get();
		saveOnly = viewModel.getSaveOnly().get();
		columnModelSerialisations=new HashSet<>();
		viewModel.getColumnModels().forEach(columnModel -> {
			columnModelSerialisations.add(new ColumnModelSerialisation(columnModel));
		});
	}
}