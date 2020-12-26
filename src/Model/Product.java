package Model;

import java.sql.Date;

public class Product {
    private String name;
    private String ID;
    private Double price;
    private String category;
    private Date stockedDate;
    private int quantity;
    private String brand;


    public Product(String name, String ID, Double price, String category, Date stockedDate, int quantity, String brand) {
        setName(name);
        setID(ID);
        setPrice(price);
        setCategory(category);
        setStockedDate(stockedDate);
        setQuantity(quantity);
        setBrand(brand);
    }
    public Product(String name, Double price, String category, int quantity, String brand) {
        setName(name);
        setPrice(price);
        setCategory(category);
        setQuantity(quantity);
        setBrand(brand);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Date getStockedDate() {
        return stockedDate;
    }

    public void setStockedDate(Date stockedDate) {
        this.stockedDate = stockedDate;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
