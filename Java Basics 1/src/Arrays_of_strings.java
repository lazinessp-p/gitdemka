import java.util.Arrays;
import java.util.Scanner;

public class Arrays_of_strings {private String[] strings;

    public Arrays_of_strings(String[] strings) {
        this.strings = strings;
    }

    public String fs() {
        String shortest = null;
        for (String str : strings) {
            if (str != null && !str.isEmpty()) {
                if (shortest == null || str.length() < shortest.length()) {
                    shortest = str;
                }
            }
        }
        if (shortest == null) {
            return "ne naideno ni odnoi pystoi stroki.";
        } else {
            return shortest;
        }
    }

    public String[] fl() {
        int total = 0;
        int count = 0;

        for (String str : strings) {
            if (str != null && !str.isEmpty()) {
                total += str.length();
                count++;
            }
        }

        double aver = (count > 0) ? (double) total / count : 0;

        String[] ls = new String[strings.length];
        int count2 = 0;

        for (String str : strings) {
            if (str != null && !str.isEmpty() && str.length() > aver) {
                ls[count2++] = str + " (length: " + str.length() + ")";
            }
        }

        return Arrays.copyOf(ls, count2);
    }

    public String fd() {
        String[] digit = new String[strings.length];
        int digitcount = 0;
        for (String str : strings) {
            if (str != null && isdigit(str)) {
                digit[digitcount++] = str;
            }
        }

        if (digitcount == 0) {
            return "ne naideno ni odnoi stroki sost tolko iz cifr.";
        } else if (digitcount > 1) {
            return digit[1];
        } else {
            return "naidena tolko odna stroka sost iz cifr.";
        }
    }

    private boolean isdigit(String str)
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
    public int countstr()
    {
        int count = 0;
        for (String str : strings)
        {
            if (str != null && !str.isEmpty())
            {
                if (isu(str))
                {
                    count++;
                }
            }
        }
        return count;
    }

    private boolean isu(String str)
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

        System.out.print("vvedite kol strok: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        String[] strings = new String[n];
        System.out.println("vvedite stroki:");
        for (int i = 0; i < n; i++)
        {
            strings[i] = scanner.nextLine();
        }

        Arrays_of_strings processor = new Arrays_of_strings(strings);

        System.out.println("\nsamaia korotkaia stroka: " + processor.fs());

        String[] longer = processor.fl();
        System.out.println("\nsamaia dlin stroka:");
        if (longer.length == 0)
        {
            System.out.println("net strok dlina kotoroi bolshe srednei.");
        } else
        {
            for (String str : longer)
            {
                System.out.println(str);
            }
        }

        System.out.println("\nvtoraia stroka cifr: " + processor.fd());

        System.out.println("\nkol strok s unik simvolami: " + processor.countstr());

        scanner.close();
    }
}
