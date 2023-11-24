import java.util.Random;
import java.util.Scanner;

public class TwodArr {
    public static void main(String[] args) {
        Random r = new Random();
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter row number");
        int row = sc.nextInt();
        System.out.println("Enter col number");
        int col = sc.nextInt();
        int[][] arr = new int[row][col];
        for (int i = 0; i < row; i++)
            for (int j = 0; j < col; j++) {
                arr[i][j] = r.nextInt(100);
            }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        sc.close();
    }
}