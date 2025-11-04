import java.util.Scanner;

public class Calculator {
    public static double perform_operation(double a, double b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    return Double.NaN;
                } else {
                    return a / b;
                }
            default:
                return Double.NaN;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Консольный калькулятор");

        System.out.print("Введите первое число: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Error: Некорректный ввод. Ожидалось целое число.");
            scanner.close();
            return;
        }
        double a = scanner.nextDouble();

        System.out.print("Введите операцию (+, -, *, /): ");
        String operator = scanner.next();

        if (!operator.equals("+") && !operator.equals("-") &&
                !operator.equals("*") && !operator.equals("/")) {
            System.out.println("Error: Некорректная операция. Пожалуйста, введите один из символов: +, -, *, /.");
            scanner.close();
            return;
        }

        System.out.print("Введите второе число: ");
        if (!scanner.hasNextDouble()) {
            System.out.println("Error: Некорректный ввод. Ожидалось целое цисло.");
            scanner.close();
            return;
        }
        double b = scanner.nextDouble();

        double result = perform_operation(a, b, operator);

        if (Double.isNaN(result) && operator.equals("/") && b == 0) {
            System.out.println("Error: произошло деление на ноль");
        } else if (Double.isNaN(result)) {
            System.out.println("Error: Произошла непредвиденная ошибка вычисления.");
        } else {
            System.out.println("Result = " + result);
        }

        scanner.close();
    }
}
