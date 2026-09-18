public class leetcode74 {
    
    public boolean searchrow(int[][] mat, int target, int row){
        int n = mat[0].length; // col length
        //here also apply binary search
        int st = 0;
        int end = n-1;
        while(st <= end){
            //mid
            int mid = st+(end-st)/2;
            if(target == mat[row][mid]){
                return true;
            }
            else if(target > mat[row][mid]){
                st = mid+1;
            }else{
                end = mid-1;
            }
        }
        return false;
    }
    public boolean searchMatrix(int[][] mat, int target) {
        if (mat == null || mat.length == 0 || mat[0].length == 0) return false;
        int m = mat.length;
        int n = mat[0].length;

        int startrow =0;
        int endrow = m-1;
        while(startrow <= endrow){
            int midrow = startrow + (endrow - startrow)/2;
            if(target >= mat[midrow][0] && target <= mat[midrow][n-1] ){
                //searchrow in that row so created a helper function
                return searchrow(mat,target,midrow);
            }else if (target < mat[midrow][0]){
                    endrow = midrow -1;
            }else{
                startrow = midrow+1;
            }
        }
        return false;
    }


public static void main(String[] args){

}
} 