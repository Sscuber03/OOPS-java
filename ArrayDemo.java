import java.util.*;

class Array {
    int arr[][];

    Array(int row, int col) {
        arr = new int[row][col];
    }

    public void rvalue() {
        Random r = new Random();
        for(int i = 0;i<arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                arr[i][j] = r.nextInt(25);
            }
        }
    }

    public void display() {
        for(int i = 0;i<arr.length; i++) {
            for(int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}

public class ArrayDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns of the 2D Array");
        int row = sc.nextInt();
        int col = sc.nextInt();
        Array a = new Array(row, col);
        a.rvalue();
        a.display();
        sc.close();
    }
}
