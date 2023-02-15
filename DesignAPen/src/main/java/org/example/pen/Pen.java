package org.example.pen;

import org.example.refill.Refill;

public abstract class Pen {
    private String name;
    private String brand;
    private Integer price;

    Refill refill;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Refill getRefill() {
        return refill;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", refill=" + refill +
                '}';
    }
}
