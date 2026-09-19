package sorting;

import LinkList.creatLL;

public class insertionsort {
     public static void printarry(int[] arr){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }

    public static void insertionSort(int[] arr){//time o(n^2) wc // bc 0(n)
        for(int i =1;i<arr.length;i++){
            int curr = arr[i];
            int prev = i-1;
            while(prev >= 0 && arr[prev] > curr){
                arr[prev+1] = arr[prev];
                prev--;
            }
            arr[prev+1] = curr;
        }
    }
    public static void main(String[] args) {
        int[] arr = {2,6,7,1,5,3,4};
        insertionSort(arr);
        printarry(arr);

    }
}
