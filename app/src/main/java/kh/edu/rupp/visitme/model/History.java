package kh.edu.rupp.visitme.model;

public class History {

    private int id;
    private String foodName;
    private String foodImage;
    private double price;  // Correct naming for the price property
    private String orderDate;

    public int getId() {
        return id;
    }

    public String getFoodName() {
        return foodName;
    }

    public String getFoodImage() {
        return foodImage;
    }

    public double getPrice() {  // Corrected getter method name
        return price;
    }

    public String getFoodDate() {
        return orderDate;
    }
}

