public class Arrtest {
    public static void main(String[] args){
        int[] arr=new int[15];
        for(int i=0;i<arr.length;i++)
        {
            arr[i]=i+1;
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }
}

