package Model;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;

import java.sql.Date;

public class Product {
    private int ID;
    private final SimpleStringProperty name;
    private final SimpleDoubleProperty price;
    private final SimpleStringProperty category;
    private SimpleObjectProperty<Date> stockedDate;
    private final SimpleIntegerProperty quantity;
    private final SimpleStringProperty brand;


    public Product(String name, int ID, Double price, String category, Date stockedDate, int quantity, String brand) {
        setID(ID);
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.category = new SimpleStringProperty(category);
        this.stockedDate = new SimpleObjectProperty<>(stockedDate);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.brand = new SimpleStringProperty(brand);

    }
    public Product(String name, Double price, String category, int quantity, String brand) {
        this.name = new SimpleStringProperty(name);
        this.price = new SimpleDoubleProperty(price);
        this.category = new SimpleStringProperty(category);
        this.quantity = new SimpleIntegerProperty(quantity);
        this.brand = new SimpleStringProperty(brand);
    }

    public String getName() {
        return name.get();
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public Double getPrice() {
        return price.get();
    }

    public void setPrice(Double price) {
        this.price.set(price);
    }

    public String getCategory() {
        return category.get();
    }

    public void setCategory(String category) {
        this.category.set(category);
    }

    public String getBrand() {
        return brand.get();
    }

    public void setBrand(String brand) {
        this.brand.set(brand);
    }

    public int getQuantity() {
        return quantity.get();
    }

    public void setQuantity(int quantity) {
        this.quantity.set(quantity);
    }

    public Date getStockedDate() {
        return stockedDate.get();
    }
    public void setStockedDate(Date stockedDate) {
        this.stockedDate.set(stockedDate);
    }

}
