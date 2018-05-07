package TaskSchedule;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import javafx.beans.property.SimpleStringProperty;

public class Task {

	SimpleStringProperty title;
	SimpleStringProperty description;
	Map<LocalDateTime, LocalDateTime> time = new TreeMap<>();

	Task(String title, String description) {
		this.title = new SimpleStringProperty(title);
		this.description = new SimpleStringProperty(description);
	}

	public String getTitle() {
		return title.get();
	}

	public void setTitle(String title) {
		this.title = new SimpleStringProperty(title);
	}

	public String getDescription() {
		return description.get();
	}

	public void setDescription(String description) {
		this.description = new SimpleStringProperty(description);
	}
}