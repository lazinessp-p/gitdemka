package com.example.gifts.utils;

import com.example.gifts.constant.CaramelTypes;
import com.example.gifts.constant.ChocolateTypes;
import com.example.gifts.constant.LollipopTypes;
import com.example.gifts.constant.SweetsNames;
import com.example.gifts.sweet.Caramel;
import com.example.gifts.sweet.Chocolate;
import com.example.gifts.sweet.Sweet;

import java.util.Random;

public class DataGenerator {

    public static Sweet[] generate(int count) {
        Sweet[] sweets = new Sweet[count];
        Random random = new Random();
        SweetsNames[] brandNames = SweetsNames.values();
        ChocolateTypes[] chocolateTypes = ChocolateTypes.values();
        CaramelTypes[] caramelTypes = CaramelTypes.values();
        LollipopTypes[] lollipopTypes = LollipopTypes.values();
        for (int i = 0; i < count; i++) {
            int type = random.nextInt(3);
            SweetsNames randomname = brandNames[random.nextInt(brandNames.length)];
            String name = randomname.getDisplayName();
            int weight = random.nextInt(50) + 20;
            double price = random.nextDouble() * 50 + 10;
            switch (type) {
                case 0:
                    ChocolateTypes randomChocolate = chocolateTypes[random.nextInt(chocolateTypes.length)];
                    sweets[i] = new Chocolate(name, weight, price, randomChocolate.getDisplayName());
                    break;
                case 1:
                    CaramelTypes randomCaramel = caramelTypes[random.nextInt(caramelTypes.length)];
                    sweets[i] = new Caramel(name, weight, price, randomCaramel.getDisplayName());
                    break;
                case 2:
                    LollipopTypes randomLollipop = lollipopTypes[random.nextInt(lollipopTypes.length)];
                    sweets[i] = new Caramel(name, weight, price, randomLollipop.getDisplayName());
                    break;
            }
        }
        return sweets;
    }
}
