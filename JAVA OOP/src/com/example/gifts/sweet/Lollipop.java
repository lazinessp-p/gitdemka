package com.example.gifts.sweet;
public class Lollipop extends Sweet {
    private String lollipopType;
    public Lollipop(String name, int wess, double price, String lollipopType){
        super(name, wess, price);
        this.lollipopType = lollipopType;
    }
    public String getFlavorLollipop(){
        return lollipopType;
    }

    @Override
    public String toString(){
        return "lollipop{" + "name=" + getName() + '\'' + getWeight() + "price=" + getPrice() + "flavor=" + lollipopType + "\'" + "}";
    }
}
