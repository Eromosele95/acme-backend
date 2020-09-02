package acme.inventoryservicepersistence.entities;

import java.util.Arrays;

public class ItemEntity {

    private static final long serialVersionUID = 1L;
    private double price;
    private String title;
    private byte[] image;
    private  int quantity;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ItemEntity{" +
                "price=" + price +
                ", title='" + title + '\'' +
                ", image=" + Arrays.toString(image) +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                '}';
    }

    // constructor, standard getters and setters
}
