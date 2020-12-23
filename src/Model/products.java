package Model;

public class products {
    private String name;
    private String ID;
    private String price;
    private String category;
    private String stockedDate;
    private String quantity;
    private String brand;


    public products(String name, String ID, String price, String category, String stockedDate, String quantity, String brand) {
        setName(name);
        setID(ID);
        setPrice(price);
        setCategory(category);
        setStockedDate(stockedDate);
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getStockedDate() {
        return stockedDate;
    }

    public void setStockedDate(String stockedDate) {
        this.stockedDate = stockedDate;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
