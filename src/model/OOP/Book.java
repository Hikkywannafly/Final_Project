package model.OOP;

import java.io.Serializable;

public class Book implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String type;
    private String date_created;
    private int quantity;
    private int quantity_borrow;
    private float price;

    public Book(int id, String name, String type, String date_created, int quantity, int quantity_borrow, float price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.date_created = date_created;
        this.quantity = quantity;
        this.quantity_borrow = quantity_borrow;
        this.price = price;
    }
    public Book(String name, String type, int quantity, int quantity_borrow, float price){
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.quantity_borrow = quantity_borrow;
        this.price = price;
    }

    public Book(int id) {
        this.id = id;
    }

    public Book() {
    }

    public Book(int id, String name, String type, int quantity, int quantity_borrow, float price) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.quantity = quantity;
        this.quantity_borrow = quantity_borrow;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity_borrow() {
        return quantity_borrow;
    }

    public void setQuantity_borrow(int quantity_borrow) {
        this.quantity_borrow = quantity_borrow;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

}
