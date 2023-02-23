package com.priyajit.designAPen.pen;

import com.priyajit.designAPen.strategy.RefillStrategy;

public abstract class Pen {
    private String name;
    private String brand;
    private Integer price;

    RefillStrategy refillStrategy;

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

    public RefillStrategy getRefill() {
        return refillStrategy;
    }

    @Override
    public String toString() {
        return "Pen{" +
                "name='" + name + '\'' +
                ", brand='" + brand + '\'' +
                ", price=" + price +
                ", refillStrategy=" + refillStrategy +
                '}';
    }
}
