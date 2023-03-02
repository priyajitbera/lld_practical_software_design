package com.priyajit.designAPen.pen;

import com.priyajit.designAPen.exceptions.EmptyRefillException;
import com.priyajit.designAPen.exceptions.NoRefillException;
import com.priyajit.designAPen.strategy.Refill;

public abstract class Pen {
    private String name;
    private String brand;
    private Integer price;
    Refill refill;

    public Pen(String name, String brand, Integer price, Refill refill) {
        this.name = name;
        this.brand = brand;
        this.price = price;
        this.refill = refill;
    }

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

    public void write(String toWrite) {
        if (refill == null) {
            throw new NoRefillException();
        }
        if (refill.getCapacity() == 0) {
            throw new EmptyRefillException();
        }
        int writableLength = Math.min(toWrite.length(), refill.getCapacity());
        System.out.println(toWrite.substring(0, writableLength));
        refill.setCapacity(refill.getCapacity() - writableLength);
    }

    public boolean canWrite(String toWrite) {
        return refill != null && refill.getCapacity() >= toWrite.length();
    }

    @Override
    public String toString() {
        return "Pen{" + "name='" + name + '\'' + ", brand='" + brand + '\'' + ", price=" + price + ", refill=" + refill + '}';
    }
}
