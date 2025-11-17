package com.example.gifts.sweet;
public abstract class Sweet {
    private String name;
    private int weight;
    private double price;

    public Sweet(String name, int weight, double price){
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public String getName(){
        return name;
    }

    public int getWeight(){
        return weight;
    }

    public double getPrice(){
        return price;
    }
    @Override
    public String toString(){
        return "sweet{" + "name=" + name + '\'' + weight + "price=" + price + "}";
    }
}
