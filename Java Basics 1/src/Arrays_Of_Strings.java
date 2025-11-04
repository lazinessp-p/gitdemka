import java.util.Arrays;
import java.util.Scanner;

public class Arrays_Of_Strings {private String[] strings;

    public Arrays_Of_Strings(String[] strings) {
        this.strings = strings;
    }

    public String find_a_short_string() {
        String shortest = null;
        for (String str : strings) {
            if (str != null && !str.isEmpty()) {
                if (shortest == null || str.length() < shortest.length()) {
                    shortest = str;
                }
            }
        }
        if (shortest == null) {
            return "не найдено ни одной пустой строки.";
        } else {
            return shortest;
        }
    }

    public String[] find_rows_greater_than_average() {
        int totallength = 0;
        int count = 0;

        for (String str : strings) {
            if (str != null && !str.isEmpty()) {
                totallength += str.length();
                count++;
            }
        }

        double averagelength = (count > 0) ? (double) totallength / count : 0;

        String[] ls = new String[strings.length];
        int longercount = 0;

        for (String str : strings) {
            if (str != null && !str.isEmpty() && str.length() > averagelength) {
                ls[longercount++] = str + " (length: " + str.length() + ")";
            }
        }

        return Arrays.copyOf(ls, longercount);
    }

    public String find_a_string_of_numbers() {
        String[] digit = new String[strings.length];
        int digitcount = 0;
        for (String str : strings) {
            if (isdigitonly(str)) {
                digit[digitcount++] = str;
            }
        }

        if (digitcount == 0) {
            return "не найдено ни одной строки состоящей только из цифр.";
        } else if (digitcount > 1) {
            return digit[1];
        } else {
            return "найдна только одна строка состоящая только из цифр.";
        }
    }

    public int count_unique_string()
    {
        int count = 0;
        for (String str : strings)
        {
            if (str != null && !str.isEmpty())
            {
                if (is_unique_chars(str))
                {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isdigitonly(String str)
    {
        if (str == null || str.isEmpty())
        {
            return false;
        }
        for (int i = 0; i < str.length(); i++)
        {
            if (!Character.isDigit(str.charAt(i)))
            {
                return false;
            }
        }
        return true;
    }

    private boolean is_unique_chars(String str)
    {
        if (str == null || str.isEmpty())
        {
            return false;
        }
        for (int i = 0; i < str.length(); i++)
        {
            for (int j = i + 1; j < str.length(); j++)
            {
                if (str.charAt(i) == str.charAt(j))
                {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.print("введите количсевто строк: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strings = new String[n];
        System.out.println("введите строки:");
        for (int i = 0; i < n; i++)
        {
            strings[i] = scanner.nextLine();
        }
        scanner.close();
        Arrays_Of_Strings processor = new Arrays_Of_Strings(strings);

        System.out.println("\nсамая короткая строка: " + processor.find_a_short_string());

        String[] longer = processor.find_rows_greater_than_average();
        System.out.println("\nстроки длины которых больше средней:");
        if (longer.length == 0)
        {
            System.out.println("нет строки длина которой больше средней.");
        } else
        {
            for (String str : longer)
            {
                System.out.println(str);
            }
        }

        System.out.println("\nвторая строка цифр: " + processor.find_a_string_of_numbers());

        System.out.println("\nколичество строк с уникальными символами: " + processor.count_unique_string());

    }
}
