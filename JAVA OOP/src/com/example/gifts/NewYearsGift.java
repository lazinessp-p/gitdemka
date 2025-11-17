package com.example.gifts;
import com.example.gifts.sweet.Sweet;
import com.example.gifts.utils.Data;

import java.util.Scanner;
import java.util.List;
public class NewYearsGift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Создание подарка");
        Sweet[] generatedSweets = Data.generate(10);
        Gift giftBox = new Gift(generatedSweets);
        System.out.println("\nСостав подарка:");
        for (Sweet sweet : giftBox.getSweets()) {
            System.out.println("  - " + sweet);
        }
        System.out.println("\nОбщий вес подарка: " + giftBox.calculate() + " грамм");
        System.out.println("Введите минимальный ценник для поиска конфет в данном ценовом диапазоне в вашем подарке");
        double minPrice = scanner.nextDouble();
        System.out.println("Введите максимальный ценник для поиска конфет в данном ценовом диапазоне в вашем подарке");
        double maxPrice = scanner.nextDouble();
        List<Sweet> foundSweets = giftBox.findSweetsInPriceRange(minPrice, maxPrice);
        System.out.printf("\nСладости в ценовом диапазоне от %.2f до %.2f:%n", minPrice, maxPrice);
        if (!foundSweets.isEmpty()) {
            for(Sweet sweet : foundSweets) {
                System.out.println("  - " + sweet.getName() + ", Цена: " + String.format("%.2f", sweet.getPrice()) + "р");
            }
        } else {
            System.out.println("Сладостей в заданном диапазоне цены не найдено.");
        }

        System.out.println("\nПрограмма завершена");
    }
}

