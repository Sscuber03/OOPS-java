package program3;

import java.util.Random;

class Matrix {
    private int[][] matrix;
    private int rows;
    private int cols;

    public Matrix(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        matrix = new int[rows][cols];
    }

    public int getValue(int row, int col) {
        return matrix[row][col];
    }

    public void setValue(int row, int col, int value) {
        matrix[row][col] = value;
    }

    public void populateMatrixRandom() {
        Random rand = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0 ; j < cols; j++) {
                matrix[i][j] = rand.nextInt(100);
            }
        }
    }

    public void displayMatrix() {
        // System.out.println("The matrix is:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0 ; j < cols; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }

    public Matrix add(Matrix m) {
        if (this.rows != m.rows || this.cols != m.cols) {
            // System.out.println("Cannot add matrices of different dimensions");
            return null;
        }
        Matrix result = new Matrix(rows, cols);
        for (int i = 0; i < rows; i++) {
            for (int j = 0 ; j < cols; j++) {
                result.matrix[i][j] = matrix[i][j] + m.matrix[i][j];
            }
        }
        return result;
    }

    public Matrix multiply(Matrix m) {
        if (this.cols != m.rows) {
            // System.out.println("Cannot multiply matrices of incompatible dimensions");
            return null;
        }
        Matrix result = new Matrix(this.rows, m.cols);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0 ; j < m.cols; j++) {
                for (int k = 0; k < this.cols; k++) {
                    result.matrix[i][j] += this.matrix[i][k] * m.matrix[k][j];
                }
            }
        }
        return result;
    }

    public Matrix transpose() {
        Matrix result = new Matrix(this.cols, this.rows);
        for (int i = 0; i < this.rows; i++) {
            for (int j = 0 ; j < this.cols; j++) {
                result.matrix[j][i] = this.matrix[i][j];
            }
        }
        return result;
    }
}

public class MatDemo {
    public static void main(String[] args) {
        Matrix mat1 = new Matrix(3, 2);
        Matrix mat2 = new Matrix(2,3);
        Matrix mat3 = new Matrix(3, 2);

        mat1.populateMatrixRandom();
        mat2.populateMatrixRandom();
        mat3.populateMatrixRandom();

        System.out.println("Matrix 1:");
        mat1.displayMatrix();
        System.out.println("Matrix 2:");
        mat2.displayMatrix();
        System.out.println("Matrix 3:");
        mat3.displayMatrix();

        Matrix multires = mat1.multiply(mat2);
        Matrix addres1 = mat1.add(mat3);
        Matrix addres2 = mat1.add(mat2);
        Matrix transres = mat1.transpose();

        if(multires != null) {
            System.out.println("Matrix 1 * Matrix 2:");
            multires.displayMatrix();
        }
        else {
            System.out.println("Cannot multiply matrices of incompatible dimensions");
        }
        if(addres1 != null) {
            System.out.println("Matrix 1 + Matrix 3:");
            addres1.displayMatrix();
        }
        else {
            System.out.println("Cannot add matrices of different dimensions");
        }
        if(addres2 != null) {
            System.out.println("Matrix 1 + Matrix 2:");
            addres2.displayMatrix();
        }
        else {
            System.out.println("Cannot add matrices of different dimensions");
        }
        if(transres != null) {
            System.out.println("Transpose of Matrix 1:");
            transres.displayMatrix();
        }
    }
}
