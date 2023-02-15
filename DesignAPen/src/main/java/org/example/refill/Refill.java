package org.example.refill;

public abstract class Refill {
    String name;

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
                '}';
    }
}
