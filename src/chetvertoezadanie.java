package com.example.gifts;
import java.util.Arrays;
import com.example.gifts.sweet.*;
import com.example.gifts.utils.data;
public class chetvertoezadanie {
    public static void main(String[] args) {
        NYgift gift = new NYgift();
        sweet[] sweets = data.generate(5);
        for (sweet sweet : sweets) {
            gift.addsweet(sweet);
        }
        sweet chocolate1 = new chocolate("AlpenGold", 100, 75, "Milk");
        sweet caramel1 = new caramel("Mentos", 50, 35, Strawberry);
        sweet lollipop1 = new lollipop("ChupaCHups", 20, 10, "Cola");
        gift.addsweet(chocolate1);
        gift.addsweet(caramel1);
        gift.addsweet(lollipop1);
        System.out.println("Общий вес подарка: " + gift.calcul() + "грамм");
        Arrays.sort(gift.getSweets(), (s1, s2) -> Integer.compare(s1.getwess(), s2.getwess()));
        System.out.println("\nСладости в подарке по весу:");
        for (sweet sweet : gift.getSweets()) {
            if (sweet != null) {
                System.out.println(sweet.getname() + " - " + sweet.getwess() + "грамм");
            }
        }
        double minprice = 10;
        double maxprice = 75;
        sweet founds = gift.pricerange(minprice, maxprice);
        if (founds != null) {
            System.out.println("\nКонфета в диапозоне цены от " + minprice + "до" + maxprice + ":" + founds.getname() + "цена: " + founds.getprice());
        } else {
            System.out.println("\nКонфтеа в заданном диапазоне цены нету");
        }
    }
}

package com.example.gifts.sweet;
public abstract class sweet{
    private String name_sweet;
    private int wess;
    private double price;

    public sweet(String name_sweet, int wess,  double price){
        this.name_sweet = name_sweet;
        this.wess = wess;
        this.price = price;
    }

    public String getname(){
        return name_sweet;
    }

    public int getwess(){
        return wess;
    }

    public double getprice(){
        return price;
    }
    @Override
    public String toString(){
        return "sweet{" + "name=" + name_sweet + '\'' + wess + "price=" + price + "}";
    }
}
package com.example.gifts.sweet;
public class chocolate extends sweet {
    private String type;
    public chocolate(String name, int wess, double price, String type){
        super(name, wess, price);
        this.type = type;
    }

    public String gettype(){
        return type;
    }

    @Override
    public String toString(){
        return "chocolate{" + "name=" + getname() + '\'' + getwess() + "price=" + getprice() + "type=" + type + "\'" + "}";
    }
}
package com.example.gifts.sweet;
public class caramel extends sweet{
    private String vkys;
    public caramel(String name, int wess, double price, String vkys){
        super(name, wess, price);
        this.vkys = vkys;
    }

    public String getvkys(){
        return vkys;
    }

    @Override
    public String toString(){
        return "caramel{" + "name=" + getname() + '\'' + getwess() + "price=" + getprice() + "vkys=" + vkys + "\'" + "}";
    }
}
package com.example.gifts.sweet;
public class lollipop extends sweet{
    private String vkys2;
    public lollipop(String name, int wess, double price, String vkys){
        super(name, wess, price);
        this.vkys2 = vkys;
    }

    public String getvkys(){
        return vkys2;
    }

    @Override
    public String toString(){
        return "lollipop{" + "name=" + getname() + '\'' + getwess() + "price=" + getprice() + "vkys=" + vkys2 + "\'" + "}";
    }
}
package com.example.gifts;
import com.example.gifts.sweet.sweet;
public class NYgift{
    private sweet[] sweets;
    private int scount;
    private final int MAXS = 20;
    public NYgift(){
        this.sweets = new sweet[MAXS];
        this.scount = 0;
    }

    public void addsweet(sweet sweet){
        if(scount < MAXS) {
            this.sweets[scount++] = sweet;
        }
        else{
           System.out.println("В подарке больше нет метса");
        }
    }

    public int calcul(){
        int total = 0;
        for(sweet sweet : sweets){
            if(sweet != null){
                total += sweet.getwess();
            }
        }
        return total;
    }
    public sweet[] getSweets(){
        return sweets;
    }

    public sweet pricerange(double minp, double maxp){
        for(sweet sweet : sweets){
            if(sweet != null){
                double price = sweet.getprice();
                if(price >= minp && price <= maxp){
                    return sweet;
                }
            }
        }
        return null;
    }
}
package com.example.gifts.utils;
import com.example.gifts.sweet.sweet.*;
import java.util.Random;
public class data{
    private static final String[] names = {"Snickers", "Milka", "AlpenGold", "KitKat", "Mars", "Bounty", "Twix"};
    private static final String[] chocolatet = {"Milk", "Dark", "White", "Air"};
    private static final String[] caramelt = {"Strawberry", "Vanilla"};
    private static final String[] lollipopt = {"Fruit", "Cola", "Cud"};
    public static sweet[] generate(int count){
        sweet[] sweets = new sweet[count];
        Random random = new Random();
        for(int i = 0; i < count; i++){
            int type = random.nextInt(3);
            String name = names[random.nextInt(name.length)];
            int wess = random.nextInt(50) + 20;
            double price = rendom.nextDouble() * 50 + 10;
            switch(type){
                case 0:
                    sweets[i] = new chocolate(name, wess, price, chocolatet[random.nextInt(chocolatet.length)]);
                    break;
                case 1:
                    sweets[i] = new caramel(name, wess, price, caramelt[random.nextInt(caramelt.length)]);
                    break;
                case 2:
                    sweets[i] = new lollipop(name, wess, price, lollipopt[random.nextInt(lollipopt.length)]);
                    break;
            }
        }
        return sweets;
    }
}
