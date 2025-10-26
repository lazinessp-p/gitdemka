import java.util.Scanner;

public class Calculator {public static void main(String[] args)
{
    Scanner scanner = new Scanner(System.in);

    System.out.println("Консольный калькулятор");
    System.out.println("Выберите операцию:");
    System.out.println("1. Сложение (+)");
    System.out.println("2. Вычитание (-)");
    System.out.println("3. Умножение (*)");
    System.out.println("4. Деление (/)");

    System.out.print("Введите номер операции: ");
    int c = scanner.nextInt();

    double result = 0;
    boolean error = false;

    System.out.print("Введите число A: ");
    double a = scanner.nextDouble();

    System.out.print("Введите число B: ");
    double b = scanner.nextDouble();

    switch (c) {
        case 1:
            result = a + b;
            break;
        case 2:
            result = a - b;
            break;
        case 3:
            result = a * b;
            break;
        case 4:
            if (b == 0) {
                System.out.println("Error: divide by zero");
                error = true;
            } else {
                result = a / b;
            }
            break;
        default:
            System.out.println("Error 404.");
            error = true;
            break;
    }

    if (!error) {
        System.out.println("Result = " + result);
    }

    scanner.close();
}
}
