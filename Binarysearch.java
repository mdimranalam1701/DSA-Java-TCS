import java.util.*;
public class Binarysearch {
    public static int biinaryseacrch(int arr[],int key) {
        int i=0,j=arr.length-1;
        while (i<=j) {
            int mid = (i+j)/2;
            if(arr[mid] == key){
                return mid;
            }
            else if(arr[mid] < key){
                //right
                i = mid+1;
            }else{
                j= mid-1;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int arr[] = {2,4,6,8,10,12,14};
        int key =10;
     System.out.println("index for key is:" + biinaryseacrch(arr, key)+"key is:"+key);
    }
}
