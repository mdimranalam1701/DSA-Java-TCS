import java.util.*;
public class Reversearray {
    public static void printArr(int arr[]){
        int st=0,last=arr.length-1;
        while (st <= last) {
            int temp = arr[last];
            arr[last] = arr[st];
            arr[st] = temp;
            st++;
            last--;
        }
    }
    public static void main(String[] args) {
        int arr[] = {2,4,6,8,10};
        printArr(arr);
        for(int i=0; i<arr.length;i++){
               System.out.println(arr[i]+" ");
        }
       System.out.println();
    }
}
