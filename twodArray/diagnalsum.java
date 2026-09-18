import java.util.*;
public class diagnalsum {

    public static void diagnalsum(int[][] matrix){

        //time :0(n^2)
        int sum =0;
        for(int i=0;i<matrix.length;i++){
            for(int j =0;j<matrix[0].length;j++){
                if(i == j){
                    //primary diagonal i==j
                    sum+= matrix[i][i];
                }
                else if(i+j == matrix.length-1){
                    //seconday diagonal i+j == n -1
                    sum+= matrix[i][j];
                }
            }
        }
        System.out.println("sum: "+sum);
    }

    //optimize code 0(n)
    public static int optimizdiagonalsum(int[][] matrix){
        int sum =0;
        for(int i =0; i< matrix.length;i++){
            sum+= matrix[i][i];
            if(i != matrix.length-i-1){
            sum+= matrix[i][matrix.length-i-1];
            }
        }
        return sum;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[][] matrix = new int[n][n];

        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                matrix[i][j] = sc.nextInt();
            }            
        }

        for(int i =0;i<n;i++){
            for(int j =0;j<n;j++){
                System.out.print(matrix[i][j]+" ");
            }    
            System.out.println();        
        }

        System.out.println("sum of digonal");
        diagnalsum(matrix);
        System.out.println(optimizdiagonalsum(matrix));

        

    }
}
