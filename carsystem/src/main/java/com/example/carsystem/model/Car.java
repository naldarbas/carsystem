package com.example.carsystem.model;

public class Car {
    private String id;
    private String model;
    private int yearOfMake;
    private String color;
    private double price;

    public Car(String id, String model, int yearOfMake, String color, double price) {
        this.id = id;
        this.model = model;
        this.yearOfMake = yearOfMake;
        this.color = color;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfMake() {
        return yearOfMake;
    }

    public void setYearOfMake(int yearOfMake) {
        this.yearOfMake = yearOfMake;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
