import java.time.Month;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamAPI {

    public static List<Integer> generateList(int x) {
        return IntStream.rangeClosed(1, x)
                .boxed()
                .collect(Collectors.toList());
    }

    public static <T> List<T> getElementsAtOddPositions(List<T> list) {
        return IntStream.range(0, list.size())
                .filter(i -> i % 2 != 0)
                .mapToObj(list::get)
                .collect(Collectors.toList());
    }

    public static <T> Set<T> removeDuplicates(List<T> list) {
        return list.stream()
                .collect(Collectors.toSet());
    }

    public static List<String> sortStringsByLengthDescending(List<String> list) {
        return list.stream()
                .sorted(Comparator.comparing(String::length).reversed())
                .collect(Collectors.toList());
    }

    public static List<Integer> checkForNegativeValues(List<Integer> list) {
        return list.stream()
                .filter(val -> val >= 0)
                .collect(Collectors.toList());
    }

    public static Map<Month, Integer> generatesMapByMonth(int numberOfMonth) {
        return Arrays.stream(Month.values())
                .limit(numberOfMonth)
                .collect(Collectors.toMap(
                        month -> month,
                        month -> month.name().length()
                ));

    }

    public static char findsTheMostFrequentCharacter(String line) {
        return line.chars()
                .mapToObj(c -> (char) c)
                .filter(c -> c != ' ')
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElseThrow(() -> new IllegalArgumentException("Строка пуста или состоит только из пробелов"));
    }

    public static List<String> transformsIntoListOfAllValues(List<Map<String, String>> doubleMap) {
        return doubleMap.stream()
                .flatMap(map -> map.values().stream())
                .sorted(Comparator
                        .comparingInt(String::length)
                        .thenComparing(Comparator.naturalOrder()))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Впишите x:");
        int x = scanner.nextInt();
        scanner.nextLine();
        List<Integer> myNumbers = generateList(x);
        if (x >= 3) {
            myNumbers.add(myNumbers.get(2));
            myNumbers.add(myNumbers.get(0));
        }
        System.out.println("Оригинальный список: " + myNumbers);
        List<Integer> oddPositions = getElementsAtOddPositions(myNumbers);
        System.out.println("Список с нечётными позициями: " + oddPositions);
        Set<Integer> uniqueNumbers = removeDuplicates(myNumbers);
        System.out.println("Список без дубликатов: " + uniqueNumbers);
        List<String> words = new ArrayList<String>();
        System.out.println("Заполните исходный List words: ");
        while (true) {
            System.out.print("Введите слово (или 'exit' для выхода): ");
            String input = scanner.nextLine();

            if ("exit".equalsIgnoreCase(input)) {
                break;
            }

            words.add(input);
            System.out.println("Успешно добавлено: [" + input + "]");
        }

        List<String> sortedWords = sortStringsByLengthDescending(words);
        System.out.println("Слова, отсортированные по длине (убывание): " + sortedWords);
        List<Integer> numbers = new ArrayList<Integer>();
        System.out.println("Заполните исходный List numbers: ");
        while (true) {
            System.out.print("Введите числовое значение(или 'exit' для выхода): ");
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Выходим из цикла...");
                break;
            }
            try {
                Integer number = Integer.parseInt(input);
                numbers.add(number);
                System.out.println("Успешно добавлено: [" + number + "]");
                System.out.println("---");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Число должно быть целым или 'exit'!");
            }
        }
        List<Integer> sortedNumbers = checkForNegativeValues(numbers);
        System.out.println("Числа, без отрицательных: " + sortedNumbers);
        System.out.println("Впишите количество месяцев, которые вы хотите вывести: ");
        int numberOfMonth = scanner.nextInt();
        Map<Month, Integer> monthLengths = generatesMapByMonth(numberOfMonth);
        System.out.println("\nРезультат (" + numberOfMonth + " месяца):");
        monthLengths.forEach((month, length) ->
                System.out.println(month + " = " + length)
        );
        scanner.nextLine();
        System.out.println("Впишите строку из символов: ");
        String line = scanner.nextLine();
        char result = findsTheMostFrequentCharacter(line);
        System.out.println("Самый частый символ: '" + result + "'");
        List<Map<String, String>> doubleMap = new ArrayList<Map<String, String>>();
        System.out.println("Введите элементы для Map-1: ");
        Map<String, String> map1 = new HashMap<String, String>();
        while (true) {
            System.out.print("Введите ключ (или 'exit' для выхода): ");
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Выходим из цикла...");
                break;
            }
            try {
                String key = input;
                System.out.print("Введите текстовое значение для ключа " + key + ": ");
                String valueMap = scanner.nextLine();
                map1.put(key, valueMap);
                System.out.println("Успешно добавлено: [" + key + " = " + valueMap + "]");
                System.out.println("---");
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: Введите ключ или 'exit'!");
            }
        }
        System.out.println("Введите элементы для Map-2: ");
        Map<String, String> map2 = new HashMap<String, String>();
        while (true) {
            System.out.print("Введите ключ (или 'exit' для выхода): ");
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Выходим из цикла...");
                break;
            }
            try {
                String key = input;
                System.out.print("Введите текстовое значение для ключа " + key + ": ");
                String valueMap = scanner.nextLine();
                map2.put(key, valueMap);
                System.out.println("Успешно добавлено: [" + key + " = " + valueMap + "]");
                System.out.println("---");
            } catch (IllegalArgumentException e) {
                System.out.println("Ошибка: Введите ключ или 'exit'!");
            }
        }
        doubleMap.add(map1);
        doubleMap.add(map2);
        List<String> inDoubleMap = transformsIntoListOfAllValues(doubleMap);
        System.out.println("Результат: " + inDoubleMap);
    }
}

