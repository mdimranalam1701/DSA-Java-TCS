public class reverse180digonalsum {

    public static int diagonalSum(int[][] matrix){
        int sum =0;
        for(int i =0; i<matrix.length;i++){
            sum+= matrix[i][i];
            if(i != matrix.length-1-i){
                sum+= matrix[i][matrix.length-1-i];
            }
        }
        return  sum;
    }

    public static int rotatediasum(int[][] matrix){
        int n = matrix.length;
        //step one reverse 90 
        for(int  i =0;i<n;i++){
            int st =0;
            int end = n-1;
            while(st < end){
            int temp = matrix[i][st];
            matrix[i][st] = matrix[i][end];
            matrix[i][end] = temp;
            st++;   
            end--;
            }
        }

        //2step 2 is to reverse the order 
        int top = 0;
        int bottom = n-1;
        while(top < bottom){
            int[] temp = matrix[top];
            matrix[top] = matrix[bottom];
            matrix[bottom] = temp;
            top++;
            bottom--;
        }
        int diagnalsum = diagonalSum(matrix);
        return diagnalsum;
    }

    public static void printMatrix(int[][] matrix) {

        for (int i = 0; i < matrix.length; i++) {

            for (int j = 0; j < matrix.length; j++) {
                System.out.print(matrix[i][j] + " ");
            }

            System.out.println();
        }
    }
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3,4}, 
                          {5,6,7,8},
                         {9,10,11,12},
                         {13,14,15,16}};

        System.out.println("original matrix");
        printMatrix(matrix);
                        
        
        int sum  = rotatediasum(matrix);
        System.out.println();
        System.out.println("180degree rotated matrix");
        printMatrix(matrix);
        System.out.println();
        System.out.println("digonal sum: "+sum);

    }
}
