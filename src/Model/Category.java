package Model;

import javafx.beans.property.SimpleStringProperty;

public class Category {

    private final SimpleStringProperty name;
    private SimpleStringProperty description;

    public Category(String name, String description) {
        this.name = new SimpleStringProperty(name);
        this.description = new SimpleStringProperty(description);
    }

    public Category(String name) {
        this.name = new SimpleStringProperty(name);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getDescription() {
        return description.get();
    }
    public void setDescription(String description) {
        this.description.set(description);
    }



}
