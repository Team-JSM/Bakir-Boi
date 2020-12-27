package Model;

public class Category {

    private String name;
    private String description;

    public Category(String name, String description) {
        setName(name);
        setDescription(description);
    }

    public Category(String name) {
        setName(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
