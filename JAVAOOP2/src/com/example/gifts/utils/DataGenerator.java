package com.example.gifts.utils;
import com.example.gifts.sweet.Chocolate;
import com.example.gifts.sweet.Caramel;
import com.example.gifts.sweet.Sweet;
import java.util.Random;
public class DataGenerator {
    private enum NAMES {SNICKERS("Snickers"), MILKA("Milka"), ALPEN_GOLD("Alpen Gold"), KITKAT("KitKat"), MARS("Mars"), BOUNTY("Bounty"), TWIX("Twix");
    private final String displayName;
    NAMES(String displayName) {
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }
}
    private enum CHOCOLATE_TYPES  {MILK("Молочный"), DARK("Темный"), WHITE("Белый"), AIR("Воздушный");
        private final String displayName;
        CHOCOLATE_TYPES(String displayName) {
            this.displayName = displayName;
        }
        public String getDisplayName() {
            return displayName;
        }
    }
    private enum CARAMEL_TYPES {STRAWBERRY("Клубничный"), VANILLA("Ванильный");
        private final String displayName;

        CARAMEL_TYPES(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
    private enum LOLLIPOP_TYPES {FRUIT("Фруктовый"), COLA("Кола"), CUD("Жевачка");
        private final String displayName;

        LOLLIPOP_TYPES(String displayName) {
            this.displayName = displayName;
        }

        public String getDisplayName() {
            return displayName;
        }
    }
    public static Sweet[] generate(int count){
        Sweet[] sweets = new Sweet[count];
        Random random = new Random();
        NAMES[] brandNames = NAMES.values();
        CHOCOLATE_TYPES[] chocolateTypes = CHOCOLATE_TYPES.values();
        CARAMEL_TYPES[] caramelTypes = CARAMEL_TYPES.values();
        LOLLIPOP_TYPES[] lollipopTypes = LOLLIPOP_TYPES.values();
        for(int i = 0; i < count; i++){
            int type = random.nextInt(3);
            NAMES randomname = brandNames[random.nextInt(brandNames.length)];
            String name = randomname.getDisplayName();
            int weight = random.nextInt(50) + 20;
            double price = random.nextDouble() * 50 + 10;
            switch(type){
                case 0:
                    CHOCOLATE_TYPES randomChocolate = chocolateTypes[random.nextInt(chocolateTypes.length)];
                    sweets[i] = new Chocolate(name, weight, price, randomChocolate.getDisplayName());
                    break;
                case 1:
                    CARAMEL_TYPES randomCaramel = caramelTypes[random.nextInt(caramelTypes.length)];
                    sweets[i] = new Caramel(name, weight, price, randomCaramel.getDisplayName());
                    break;
                case 2:
                    LOLLIPOP_TYPES randomLollipop = lollipopTypes[random.nextInt(lollipopTypes.length)];
                    sweets[i] = new Caramel(name, weight, price, randomLollipop.getDisplayName());
                    break;
            }
        }
        return sweets;
    }
}
