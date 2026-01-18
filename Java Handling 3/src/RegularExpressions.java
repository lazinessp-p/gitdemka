import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
public class RegularExpressions {

    public static boolean determineWhetherTheyStartWithTheSameLetter(String fullname){
        return fullname.trim().matches("(?i)^([a-zа-я]).*\\s+\\1.*$");
    }

    public String turnTheWordsAround(String words){
        if (words == null || words.isEmpty()) {
            return words;
        }
        String[] words_arr = words.split("\\s+");
        StringBuilder result = new StringBuilder();

        for (String word : words_arr) {
            StringBuilder temp = new StringBuilder(word);
            result.append(temp.reverse()).append(" ");
        }
        return result.toString().trim();
    }

    public String convertStringFromLowerCaseNameToLOWER_CASE_NAME(String lower){
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

    public String convertStringFromUPPER_CASE_NAMEToUpperCaseName(String upper){
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
        if (names == null || names.isEmpty()) {
            return new String[]{"строка пуста"};
        }
        String[] allNames = names.split("\\s+");
        List<String> resultList = new ArrayList<>();
        String regex = "(?i)^[AА].*[AА]$";
        for (String name : allNames) {
            if (name.matches(regex)) {
                resultList.add(name);
            }
        }
        if (resultList.isEmpty()) {
            return new String[]{"Имен на 'А' не найдено"};
        }
        return resultList.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegularExpressions processor = new RegularExpressions();
        System.out.println("впишите имя и фамилию: ");
        String fullname = scanner.nextLine();
        System.out.println(fullname + ": " + determineWhetherTheyStartWithTheSameLetter(fullname));
        scanner.nextLine();
        System.out.println("впишите строку из слов разделенную пробелами: ");
        String words = scanner.nextLine();
        System.out.println("перевернутая строка: " + processor.turnTheWordsAround(words));
        scanner.nextLine();
        System.out.println("впишите строку в виде lowerCaseName: ");
        String lower = scanner.nextLine();
        System.out.println("преобразованная в LOWER_CASE_NAME: " + processor.convertStringFromLowerCaseNameToLOWER_CASE_NAME(lower));
        scanner.nextLine();
        System.out.println("впишите строку в виде UPPER_CASE_NAME: ");
        String upper = scanner.nextLine();
        System.out.println("преобразованная в upperCaseName: " + processor.convertStringFromUPPER_CASE_NAMEToUpperCaseName(upper));
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
}
