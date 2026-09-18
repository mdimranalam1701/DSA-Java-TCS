public class transpose {

    //transpose the matrix mean row will become col and vice varse

    public static void swap(int[][] matrix,int i,int j){
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i];
        matrix[j][i] = temp;
    }
    public static void transpose(int[][] matrix,int n){
        
            for(int i =0;i<n;i++){
                for(int j=0;j<i;j++){
                    swap(matrix,i,j);
                }
            }
        }
    //clock wise 90 degree
    public static void clock(int[][] matrix){
        int n = matrix.length;
        //step 1 transpose the matrix
        transpose(matrix,n);
        //step 2: 
        for(int i=0;i<n;i++){
            for(int j=0;j<n/2;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n-1-j];
                matrix[i][n-1-j] = temp;
            }
        }
        
        
    }
    public static void main(String[] args) {
        int matrix[][] = {{1,2,3,4}, 
                          {5,6,7,8},
                         {9,10,11,12},
                         {13,14,15,16}};

        
        

    }
}
