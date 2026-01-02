package com.example.gifts;
import com.example.gifts.sweet.Sweet;
import java.util.ArrayList;
import java.util.List;
public class Gift {
    private Sweet[] sweets;
    public Gift(Sweet[] sweets){
        this.sweets = sweets;
    }
    public int calculate(){
        int total = 0;
        for(Sweet sweet : sweets){
            if(sweet != null){
                total += sweet.getWeight();
            }
        }
        return total;
    }
    public Sweet[] getSweets(){
        return sweets;
    }

    public List<Sweet> findSweetsInPriceRange(double minPrice, double maxPrice){
        List<Sweet> foundSweets = new ArrayList<>();
        for(Sweet sweet : sweets){
            if(sweet != null){
                double price = sweet.getPrice();
                if(price >= minPrice && price <= maxPrice){
                    foundSweets.add(sweet);
                }
            }
        }
        return foundSweets;
    }
}
