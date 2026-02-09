import java.util.Scanner;
public class StringProcessing {
    public String convertNumbersToBinaryCode(int n) {
     if(n == 0) return "0";
     String result = "";
     while (n > 0){
         int g = n % 2;
         result = g + result;
         n = n/2;
     }
     return result;
    }

    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     StringProcessing processor = new StringProcessing();
     System.out.println("впишите положительное число: ");
     if (scanner.hasNextInt()) {
         int n = scanner.nextInt();
         System.out.println("число в двоичном коде: " + processor.convertNumbersToBinaryCode(n));
     }
     else{
         System.out.println("404 введите другое число");
     }
     scanner.nextLine();
     System.out.println("впишите цвет в формате HEX: ");
     String hex = scanner.nextLine();
     System.out.println("rgb(" + processor.convertHEXToRGB(hex) + ")");
     scanner.nextLine();
     System.out.println("впишите строку: ");
     String opposite = scanner.nextLine();
        System.out.println("строка с противоположными регистрами: " + processor.changeCaseToOpposite(opposite));
     scanner.nextLine();
     System.out.println("впишите количество символов в одной строке: ");
     int x = scanner.nextInt();
     processor.printArrayElementsInPortions(x);
     scanner.close();
    }

    public String convertHEXToRGB(String hex){
        String hexdigit = hex.substring(1);
        if (hex == null || !hex.startsWith("#") || hex.length() != 7 || !hexdigit.matches("[0-9A-Fa-f]{6}")) {
            return "ошибка: неверный формат HEX (ожидается #RRGGBB)";
        }
        else {
            String rHex = hex.substring(1, 3);
            String gHex = hex.substring(3, 5);
            String bHex = hex.substring(5, 7);
            int r = Integer.parseInt(rHex, 16);
            int g = Integer.parseInt(gHex, 16);
            int b = Integer.parseInt(bHex, 16);
            return r + ", " + g + ", " + b;
        }
    }

    public void printArrayElementsInPortions(int x) {
        Scanner scanner1 = new Scanner(System.in);
        System.out.print("введите количество строк: ");
        int n1 = scanner1.nextInt();
        System.out.print("введите количество столбцов: ");
        int m1 = scanner1.nextInt();
        int[][] array = new int[n1][m1];
        System.out.println("введите элементы массива:");
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                array[i][j] = scanner1.nextInt();
            }
        }
        int count = 0;
        int totalElements = n1 * m1;
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < m1; j++) {
                System.out.print(array[i][j]);
                count++;
                if (count % x == 0) {
                    System.out.println();
                } else if (count < totalElements) {
                    System.out.print(", ");
                }
            }
        }
        scanner1.close();
    }

    public String changeCaseToOpposite(String opposite) {
        StringBuilder result = new StringBuilder();
        for(int i = 0; i < opposite.length(); i++){
            char c = opposite.charAt(i);
            if(Character.isUpperCase(c)){
                result.append(Character.toLowerCase(c));
            }
            else if(Character.isLowerCase(c)){
                result.append(Character.toUpperCase(c));
            }
            else{
                result.append(c);
            }
        }
        return result.toString();
    }
}