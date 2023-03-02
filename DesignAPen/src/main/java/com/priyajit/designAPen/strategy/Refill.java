package com.priyajit.designAPen.strategy;

public abstract class Refill {
    String name;
    Integer capacity;

    public Refill(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Refill{" +
                "name='" + name + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}
