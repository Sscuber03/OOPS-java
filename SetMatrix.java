import java.util.Random;
public class SetMatrix {
    int[][] matrix;
    public SetMatrix(int row, int col){
        this.matrix=new int[row][col];
    }
    int[][] getmatrix(){
        return this.matrix;
    }
    void setmat(){
        Random r=new Random();
        for(int i=0;i<matrix.length;i++)
            for(int j=0;j<matrix[i].length;j++){
                matrix[i][j]=r.nextInt(100);
            }
    }
    void print()
    {
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[i].length;j++){
                System.out.print(matrix[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        SetMatrix s=new SetMatrix(3,4);
        s.setmat();
        s.print();
    }
}

