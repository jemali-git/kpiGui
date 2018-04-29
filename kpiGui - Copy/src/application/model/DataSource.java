package application.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class DataSource {
	//
	private final StringProperty serverType;
	private final StringProperty serverName;
	private final StringProperty authentication;
	private final StringProperty userName;
	private final StringProperty password;

	public DataSource() {
		this(null, null);
	}

	public DataSource(String firstName, String lastName) {
		this.serverType = new SimpleStringProperty(firstName);
		this.serverName = new SimpleStringProperty(lastName);
		this.authentication = new SimpleStringProperty("some street");
		this.userName = null;
		this.password = null;
	}

	public String getFirstName() {
		return serverType.get();
	}

	public void setFirstName(String firstName) {
		this.serverType.set(firstName);
	}

	public StringProperty firstNameProperty() {
		return serverType;
	}

	public String getLastName() {
		return serverName.get();
	}

	public void setLastName(String lastName) {
		this.serverName.set(lastName);
	}

	public StringProperty lastNameProperty() {
		return serverName;
	}

	public String getStreet() {
		return authentication.get();
	}

	public void setStreet(String street) {
		this.authentication.set(street);
	}

	public StringProperty streetProperty() {
		return authentication;
	}
}