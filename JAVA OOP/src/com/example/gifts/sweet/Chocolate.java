package com.example.gifts.sweet;

public class Chocolate extends Sweet {
    private String type;
    public Chocolate(String name, int weight, double price, String type){
        super(name, weight, price);
        this.type = type;
    }

    public String getType(){
        return type;
    }

    @Override
    public String toString(){
        return "chocolate{" + "name=" + getName() + '\'' + getWeight() + "price=" + getPrice() + "type=" + type + "\'" + "}";
    }
}
