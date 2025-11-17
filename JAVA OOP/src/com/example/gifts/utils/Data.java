package com.example.gifts.utils;
import com.example.gifts.sweet.Chocolate;
import com.example.gifts.sweet.Caramel;
import com.example.gifts.sweet.Lollipop;
import com.example.gifts.sweet.Sweet;
import java.util.Random;
public class Data{
    private static final String[] NAMES = {"Snickers", "Milka", "AlpenGold", "KitKat", "Mars", "Bounty", "Twix"};
    private static final String[] CHOCOLATE_TYPES = {"Milk", "Dark", "White", "Air"};
    private static final String[] CARAMEL_TYPES = {"Strawberry", "Vanilla"};
    private static final String[] LOLLIPOP_TYPES = {"Fruit", "Cola", "Cud"};
    public static Sweet[] generate(int count){
        Sweet[] sweets = new Sweet[count];
        Random random = new Random();
        for(int i = 0; i < count; i++){
            int type = random.nextInt(3);
            String name = NAMES[random.nextInt(NAMES.length)];
            int weight = random.nextInt(50) + 20;
            double price = random.nextDouble() * 50 + 10;
            switch(type){
                case 0:
                    sweets[i] = new Chocolate(name, weight, price, CHOCOLATE_TYPES[random.nextInt(CHOCOLATE_TYPES.length)]);
                    break;
                case 1:
                    sweets[i] = new Caramel(name, weight, price, CARAMEL_TYPES[random.nextInt(CARAMEL_TYPES.length)]);
                    break;
                case 2:
                    sweets[i] = new Lollipop(name, weight, price, LOLLIPOP_TYPES[random.nextInt(LOLLIPOP_TYPES.length)]);
                    break;
            }
        }
        return sweets;
    }
}
