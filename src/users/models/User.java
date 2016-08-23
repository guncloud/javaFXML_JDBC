package users.models;

import javafx.beans.property.SimpleStringProperty;

public class User {
    public SimpleStringProperty name;
    public SimpleStringProperty email;

    public User(String name, String email){
        this.name = new SimpleStringProperty(name);
        this.email = new SimpleStringProperty(email);
    }

    public SimpleStringProperty nameProperty()
    {
        return name;
    }

    public SimpleStringProperty emailProperty()
    {
        return email;
    }

}