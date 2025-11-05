import java.util.Arrays;

public class Arrays_Of_Numbers {
        private int[] num;
        public Arrays_Of_Numbers(int[] num){
            this.num = num;
        }
        public void multiply_by_three() {
            for(int i = 0; i < num.length - 1; i++)
            {
                if (num[i] > 0 && num[i + 1] < 0) {
                        num[i] *= 3;
                }
            }
        }

        public void replace_with_zeros() {
            for (int i = 0; i < num.length; i++) {
                if (num[i] < 0) {
                    num[i] = 0;
                }
            }
        }

        public int calculate()
        {
            int sum_elem = 0;
            for(int i = 0; i < num.length; i+=2)
            {
                sum_elem = sum_elem + num[i];
            }
            return sum_elem;
        }
        public int[][] rotate(int[][] num2D)
        {
            int rows = num2D.length;
            int cols = num2D[0].length;
            int [][] num2d = new int[rows][cols];
            for(int i = 0; i < rows; i++)
            {
                for(int j = 0; j < cols; j++)
                {
                    num2d[j][rows - 1 - i] = num2D[i][j];
                }
            }
            return num2d;
        }
        public void find_elem_more_than_once(){
            System.out.print("элементы встречающиеся более 1 раза:");
            for(int i = 1; i < num.length; i+=2){
                int count = 0;
                for (int value : num) {
                    if (num[i] == value) {
                        count++;
                    }
                }
                if(count > 1){
                    boolean ap = false;
                    for(int k = 0; k < i; k++){
                        if(num[i] == num[k]){
                            ap = true;
                            break;
                        }
                    }
                    if(!ap){
                        System.out.print(num[i] + "");
                    }
                }
            }
            System.out.println();
        }
        public long calculate_the_factorial(int x){
            if(x < 0){
                System.out.print("факториал нельзя определить для отрицательного числа");
            }
            if(x> 20){
                System.out.print("факториал слишком большой для long");
            }
            long res = 1;
            for(int i = 1; i <= x; i++){
                res *= i;
            }
            return res;
        }
        public static void main(String[] args)
        {
            int[] num = new int[20];
            for(int i = 0; i < num.length; i++)
            {
                num[i] = (-10 + (int) (Math.random() * ((10 - (-10)) + 1)));
            }
            System.out.println("исходный массив" + Arrays.toString(num));
            Arrays_Of_Numbers process = new Arrays_Of_Numbers(num);
            System.out.println("сумма элементов на четных позициях:" + process.calculate());
            process.multiply_by_three();
            System.out.println("массив после умножения:" + Arrays.toString(num));
            process.replace_with_zeros();
            System.out.println("массив после замены: " + Arrays.toString(num));
            process.find_elem_more_than_once();
            int[][] matr = {{1 , 2, 3}, {4, 5, 6}, {7, 8, 9}};
            System.out.println("исходная матрица:");
            for (int[] row : matr){
                System.out.println(Arrays.toString(row));
            }
            int [][] rotatematr = process.rotate(matr);
            System.out.println("перевернутая матрица:");
            for (int[] row : rotatematr){
                System.out.println(Arrays.toString(row));
            }
            int x = 5;
            long fact = process.calculate_the_factorial(x);
            System.out.println("факториал числа " + x + ": " + fact);
        }
    }
