import java.time.Month;
import java.util.*;

public class ListAndMap {
    public static List<Integer> generateList(int x) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i <= x; i++) {
            result.add(i);
        }
        return result;
    }

    public static List<Integer> removeDuplicates(List<Integer> list) {
        Set<Integer> set = new LinkedHashSet<Integer>(list);
        return new ArrayList<Integer>(set);
    }

    public static List<Integer> getElementsAtOddPositions(List<Integer> list) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 1; i < list.size(); i += 2) {
            result.add(list.get(i));
        }
        return result;
    }


    private static boolean hasAllUniqueChars(String str) {
        Set<Character> chars = new HashSet<Character>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!chars.add(c)) {
                return false;
            }
        }
        return true;
    }

    public static int countTheNumberOfLines(List<String> list) {
        int count = 0;
        for (String s : list) {
            if (s == null || s.isEmpty()) {
                continue;
            }
            if (hasAllUniqueChars(s)) {
                count++;
            }
        }
        return (count);
    }

    public static List<String> sortsTheList(List<String> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                String n = list.get(j);
                String n1 = list.get(j + 1);
                if (n.length() < n1.length()) {
                    Collections.swap(list, j, j + 1);
                }
            }
        }
        return (list);
    }

    public static boolean checkForNegativeValues(List<Integer> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            int n = list.get(i);
            if (n < 0) {
                return true;
            }
        }
        return false;
    }

    public static boolean checksTheCorrectPlacementOfBrackets(String inputBrackets) {
        Map<Character, Character> bracketPairs = new HashMap<Character, Character>();
        bracketPairs.put(')', '(');
        bracketPairs.put(']', '[');
        bracketPairs.put('}', '{');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < inputBrackets.length(); i++) {
            char currentChar = inputBrackets.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.push(currentChar);
            } else if (bracketPairs.containsKey(currentChar)) {
                if (stack.isEmpty()) {
                    return false;
                }
                char topElement = stack.pop();
                if (topElement != bracketPairs.get(currentChar)) {
                    return false;
                }
            }
        }
        return (stack.isEmpty());
    }

    public static Map<Month, Integer> generatesMapByMonth(int m) {
        Map<Month, Integer> monthMeaning = new HashMap<Month, Integer>();
        for (int i = 1; i < m + 1; i++) {
            String month = String.valueOf(Month.of(i));
            monthMeaning.put(Month.of(i), month.length());
        }
        return (monthMeaning);
    }

    public static Map<String, Integer> swapsTheKeyAndValue(Map<Integer, String> original) {
        Map<String, Integer> invertedMap = new HashMap<>();
        try {
            for (Map.Entry<Integer, String> entry : original.entrySet()) {
                invertedMap.put(entry.getValue(), entry.getKey());
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: есть два одинаковых ключа! " + e.getMessage());
        }
        return (invertedMap);
    }

    public static List<String> transformsIntoListOfAllValues(List<Map<String, String>> doubleMap) {
        List<String> allValues = new ArrayList<String>();
        for (Map<String, String> map : doubleMap) {
            for (String value : map.values()) {
                allValues.add(value);
            }
        }
        allValues.sort(String.CASE_INSENSITIVE_ORDER);
        return (allValues);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Впишите x:");
        int x = scanner.nextInt();
        List<Integer> myNumbers = generateList(x);
        if (x >= 3) {
            myNumbers.add(myNumbers.get(2));
            myNumbers.add(myNumbers.get(0));
        }
        System.out.println("Оригинальный список (с дубликатами): " + myNumbers);
        List<Integer> uniqueNumbers = removeDuplicates(myNumbers);
        System.out.println("Список без дубликатов: " + uniqueNumbers);
        List<Integer> oddPositions = getElementsAtOddPositions(uniqueNumbers);
        System.out.println("Элементы на нечетных позициях: " + oddPositions);
        List<String> words = new ArrayList<String>();
        System.out.println("Впишите количество строк, которое вы хотите вписать: ");
        int x1 = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i < x1 + 1; i++) {
            System.out.println("Впишите строку " + i + ": ");
            words.add(scanner.nextLine());
        }
        System.out.println("Строки с уникальными символами игнорируя пустые строки: " + countTheNumberOfLines(words));
        System.out.println("Строки по убыванию:" + sortsTheList(words));
        List<Integer> number = new ArrayList<Integer>();
        System.out.println("Впишите количество значений в списке: ");
        int values = scanner.nextInt();
        scanner.nextLine();
        for (int i = 1; i < values + 1; i++) {
            System.out.println("Впишите число номер " + i + ": ");
            number.add(scanner.nextInt());
        }
        if (checkForNegativeValues(number)) {
            System.out.println("В списке есть отрицательные значения");
        }
        if (!checkForNegativeValues(number)) {
            System.out.println("В списке нет отрицательных значений");
        }
        scanner.nextLine();
        System.out.println("Впишите строку из скобок, которую вы хотите проверить: ");
        String brackets = scanner.nextLine();
        System.out.println(checksTheCorrectPlacementOfBrackets(brackets));
        System.out.println("введите количество месяцев, которые будут выводится: ");
        int numberOfMonth = scanner.nextInt();
        for (Map.Entry<Month, Integer> entry : generatesMapByMonth(numberOfMonth).entrySet()) {
            System.out.println(String.join(",", entry.getKey() + " = " + entry.getValue()));
        }
        Map<Integer, String> original = new HashMap<Integer, String>();
        scanner.nextLine();
        System.out.println("Заполните исходный Map: ");
        while (true) {
            System.out.print("Введите числовой ключ (или 'exit' для выхода): ");
            String input = scanner.nextLine();
            if ("exit".equalsIgnoreCase(input)) {
                System.out.println("Выходим из цикла...");
                break;
            }
            try {
                Integer key = Integer.parseInt(input);
                System.out.print("Введите текстовое значение для ключа " + key + ": ");
                String valueMap = scanner.nextLine();
                original.put(key, valueMap);
                System.out.println("Успешно добавлено: [" + key + " = " + valueMap + "]");
                System.out.println("---");
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Ключ должен быть целым числом или 'exit'!");
            }
        }
        System.out.println("Инвертированный Map: ");
        for (Map.Entry<String, Integer> entry : swapsTheKeyAndValue(original).entrySet()) {
            System.out.println(String.join(",", entry.getKey() + " = " + entry.getValue()));
        }
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
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Ключ должен быть целым числом или 'exit'!");
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
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: Ключ должен быть целым числом или 'exit'!");
            }
        }
        doubleMap.add(map1);
        doubleMap.add(map2);
        System.out.println("Отсортированный список: " + transformsIntoListOfAllValues(doubleMap));
    }
}
