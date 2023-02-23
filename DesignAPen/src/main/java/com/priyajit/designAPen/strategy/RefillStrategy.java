package com.priyajit.designAPen.strategy;

public abstract class RefillStrategy {
    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Refill{" + "name='" + name + '\'' + '}';
    }
}
