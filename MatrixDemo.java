import java.util.*;

class Matrix {
    int mat[][];

    Matrix(int row, int col) {
        mat = new int[row][col];
    }

    void read() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter " + mat.length + " rows and " + mat[0].length + " columns");
        for (int i = 0; i < mat.length; i++){
            for (int j = 0; j < mat[0].length; j++){
                mat[i][j] = sc.nextInt();
            }
        }
    }

    void display() {
        System.out.println("The matrix is:");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length - 1; j++){
                System.out.print(mat[i][j] + "\t");
            }
            System.out.println(mat[i][mat[0].length - 1]);
        }
    }

    Matrix prod(Matrix m){
        if(this.mat[0].length != m.mat.length){
            System.out.println("Matrix multiplication not possible");
            return null;
        }
        Matrix res = new Matrix(this.mat.length, m.mat[0].length);
        for(int i = 0; i < this.mat.length; i++){
            for(int j = 0; j < m.mat[i].length; j++){
                for(int k = 0; k < this.mat[i].length; k++){
                    res.mat[i][j] += this.mat[i][k] * m.mat[k][j];
                }
            }
        }
        // res.display();
        return res;
    }
}

public class MatrixDemo {
    public static void main(String[] args) {
        Scanner sc1 = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns of the first matrix");
        int row1 = sc1.nextInt();
        int col1 = sc1.nextInt();
        System.out.println("Enter the number of rows and columns of the second matrix");
        int row2 = sc1.nextInt();
        int col2 = sc1.nextInt();
        Matrix m1 = new Matrix(row1, col1);
        m1.read();
        // sc1.nextLine();
        Matrix m2 = new Matrix(row2, col2);
        m2.read();
        sc1.close();
        m1.display();
        m2.display();
        Matrix mres = m1.prod(m2);
        mres.display();
    }
}