import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class RegularExpressions {

    public static boolean determineWhetherTheyStartWithSameLetter(String fullname) {
        if (fullname == null) return false;
        String s = fullname.trim();
        if (s.isEmpty()) return false;
        return s.matches("(?iu)^([\\p{L}]).*\\s+\\1.*$");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegularExpressions processor = new RegularExpressions();
        System.out.println("впишите имя и фамилию: ");
        String fullname = scanner.nextLine();
        System.out.println(fullname + ": " + determineWhetherTheyStartWithSameLetter(fullname));
        scanner.nextLine();
        System.out.println("впишите строку из слов разделенную пробелами: ");
        String words = scanner.nextLine();
        System.out.println("перевернутая строка: " + processor.turnWordsAround(words));
        scanner.nextLine();
        System.out.println("впишите строку в виде lowerCaseName: ");
        String lower = scanner.nextLine();
        System.out.println("преобразованная в LOWER_CASE_NAME: " + processor.convertStringFromLowerCaseName(lower));
        scanner.nextLine();
        System.out.println("впишите строку в виде UPPER_CASE_NAME: ");
        String upper = scanner.nextLine();
        System.out.println("преобразованная в upperCaseName: " + processor.convertStringToUpperCaseName(upper));
        scanner.nextLine();
        System.out.println("впишите имена: ");
        String names = scanner.nextLine();
        String[] result_names = processor.findNamesThatStartAndEndWithA(names);
        System.out.println("имена начинающиеся и заканчивающиеся на А: ");
        for (String s : result_names) {
            System.out.println(s);
        }
        scanner.close();
    }

    public String turnWordsAround(String words) {
        if (words == null || words.isEmpty()) {
            return words;
        }
        String[] wordsarr = words.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : wordsarr) {
            StringBuilder temp = new StringBuilder(word);
            result.append(temp.reverse()).append(" ");
        }
        return result.toString().trim();
    }

    public String convertStringFromLowerCaseName(String lower) {
        if (lower == null || lower.isEmpty()) {
            return lower;
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lower.length(); i++) {
            char c = lower.charAt(i);
            if (Character.isUpperCase(c) && i > 0) {
                result.append('_');
            }
            result.append(c);
        }
        return result.toString().toUpperCase();
    }

    public String convertStringToUpperCaseName(String upper) {
        if (upper == null || upper.isEmpty()) {
            return upper;
        }
        String[] parts = upper.toLowerCase().split("_");
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < parts.length; i++) {
            String word = parts[i];
            if (word.isEmpty()) continue;
            if (i == 0) {
                result.append(word);
            } else {
                result.append(Character.toUpperCase(word.charAt(0)));
                result.append(word.substring(1));
            }
        }
        return result.toString();
    }

    public String[] findNamesThatStartAndEndWithA(String names){
        if (names == null || names.trim().isEmpty()) {
            return new String[]{"строка пуста"};
        }
        String[] allNames = names.split("\\s+");
        List<String> resultList = new ArrayList<>();
        for (String raw : allNames) {
            if (raw == null) continue;
            String name = raw.trim();
            if (name.isEmpty()) continue;
            Character firstLetter = null;
            Character lastLetter = null;
            for (int i = 0; i < name.length(); i++) {
                char c = name.charAt(i);
                if (Character.isLetter(c)) {
                    firstLetter = c;
                    break;
                }
            }
            for (int i = name.length() - 1; i >= 0; i--) {
                char c = name.charAt(i);
                if (Character.isLetter(c)) {
                    lastLetter = c;
                    break;
                }
            }
            if (firstLetter == null || lastLetter == null) continue;

            char fUp = Character.toUpperCase(firstLetter);
            char lUp = Character.toUpperCase(lastLetter);
            if ((fUp == 'A' || fUp == 'А') && (lUp == 'A' || lUp == 'А')) {
                resultList.add(name);
            }
        }
        if (resultList.isEmpty()) {
            return new String[]{"Имен на 'А' не найдено"};
        }

        return resultList.toArray(new String[0]);
    }
}
