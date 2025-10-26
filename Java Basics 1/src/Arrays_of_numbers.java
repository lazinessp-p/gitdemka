import java.util.Arrays;
import java.util.Random;

public class Arrays_of_numbers {
        private int[] num;
        public Arrays_of_numbers(int[] num){
            this.num = num;
        }
        public void ymnozh() {
            for(int i = 0; i < num.length - 1; i++)
            {
                if (num[i] > 0) {
                    if (num[i + 1] < 0) {
                        num[i] *= 3;
                    }
                }
            }
        }

        public void zamena() {
            for (int i = 0; i < num.length; i++) {
                if (num[i] < 0) {
                    num[i] = 0;
                }
            }
        }

        public int vich()
        {
            int count = 0;
            for(int i = 0; i < num.length; i++)
            {
                if (i % 2 == 0) {
                    count = count + num[i];
                }
            }
            return count;
        }
        public int[][] rotate(int[][] num2D)
        {
            int rows = num2D.length;
            int cols = num2D[0].length;
            int [][] Num = new int[rows][cols];
            for(int i = 0; i < rows; i++)
            {
                for(int j = 0; j < cols; j++)
                {
                    Num[j][rows - 1 - i] = num2D[i][j];
                }
            }
            return Num;
        }
        public void dupl(){
            System.out.print("elem vstrech bolee 1 raza:");
            for(int i = 1; i < num.length; i+=2){
                int count = 0;
                for(int j = 0; j < num.length; j++){
                    if(num[i] == num[j]) {
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
        public long factor(int x){
            if(x < 0){
                System.out.print("factorial ne opred dly otr chisel");
            }
            if(x> 20){
                System.out.print("factor slishkom bolshoi dly LONG");
            }
            long res = 1;
            for(int i = 1; i <= x; i++){
                res *= i;
            }
            return res;
        }
        public static void main(String[] args)
        {
            Random rand = new Random();
            int[] num = new int[20];
            for(int i = 0; i < num.length; i++)
            {
                num[i] = (-10 + (int) (Math.random() * ((10 - (-10)) + 1)));
            }
            System.out.println("isxodn massiv" + Arrays.toString(num));
            Arrays_of_numbers process = new Arrays_of_numbers(num);
            System.out.println("summa elem na chetn poz:" + process.vich());
            process.ymnozh();
            System.out.println("mass posle ymnozh:" + Arrays.toString(num));
            process.zamena();
            System.out.println("mass posle zameni: " + Arrays.toString(num));
            process.dupl();
            int[][] matr = {{1 , 2, 3}, {4, 5, 6}, {7, 8, 9}};
            System.out.println("isxodn matrica:");
            for (int[] row : matr){
                System.out.println(Arrays.toString(row));
            }
            int [][] rotatematr = process.rotate(matr);
            System.out.println("pvernytay matrica:");
            for (int[] row : rotatematr){
                System.out.println(Arrays.toString(row));
            }
            int x = 5;
            long fact = process.factor(x);
            System.out.println("fact chisla " + x + ": " + fact);
        }
    }
