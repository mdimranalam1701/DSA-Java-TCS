import java.util.*;
public class subarrayprint {
    public static void printsubarr(int arr[]){
        int n= arr.length;
        int ts=0;
        
        for(int i=0;i<n;i++){
            int start =i;
            for(int j=i;j<n;j++){
                int end = j;
                int sum =0;
                for(int st=start;st<=end;st++){
                    System.out.println(arr[st]+" ");
                    sum +=arr[st];
                }
                ts++;
                System.out.println("sum of each sub array"+sum);
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("total sub array"+ts);
    }
    public static void main(String[] args) {
        int arr[] = { 2,4,6,8,10};
        printsubarr(arr);
    }
}
