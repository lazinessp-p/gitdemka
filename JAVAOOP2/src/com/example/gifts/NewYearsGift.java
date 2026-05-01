package com.example.gifts;

import com.example.gifts.exception.InvalidPriceRangeException;
import com.example.gifts.sweet.Sweet;
import com.example.gifts.utils.DataGenerator;

import java.util.List;
import java.util.Scanner;

public class NewYearsGift {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Создание подарка");
            System.out.println("Введите количество конфет в вашем подарке: ");
            int countSweets = scanner.nextInt();
            Sweet[] generatedSweets = DataGenerator.generate(countSweets);
            Gift giftBox = new Gift(generatedSweets);

            System.out.println("\nСостав подарка:");
            for (Sweet sweet : giftBox.getSweets()) {
                System.out.println("  - " + sweet);
            }

            System.out.println("\nОбщий вес подарка: " + giftBox.calculate() + " грамм");

            System.out.println("Введите минимальный ценник:");
            double minPrice = scanner.nextDouble();

            System.out.println("Введите максимальный ценник:");
            double maxPrice = scanner.nextDouble();

            List<Sweet> foundSweets = giftBox.findSweetsInPriceRange(minPrice, maxPrice);

            System.out.printf("\nСладости в ценовом диапазоне от %.2f до %.2f:%n", minPrice, maxPrice);
            if (!foundSweets.isEmpty()) {
                for (Sweet sweet : foundSweets) {
                    System.out.println("  - " + sweet.getName() + ", Цена: " + String.format("%.2f", sweet.getPrice()) + "р");
                }
            } else {
                System.out.println("Сладостей в заданном диапазоне цены не найдено.");
            }

        } catch (InvalidPriceRangeException e) {
            System.err.println(e.getMessage());
        } catch (java.util.InputMismatchException e) {
            System.err.println("Ошибка: Введено некорректное числовое значение!");
        } catch (Exception e) {
            System.err.println("Произошла непредвиденная ошибка: " + e.getMessage());
        } finally {
            System.out.println("\nПрограмма завершена");
            scanner.close();
        }
    }
}

